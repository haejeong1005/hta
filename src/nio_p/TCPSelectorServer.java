package nio_p;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

public class TCPSelectorServer {
	
	Selector selector;
	ArrayList<Client> list;

	public TCPSelectorServer() {
		// TODO Auto-generated constructor stub
		
		try {
			
			selector = Selector.open();
			list = new ArrayList<>();
			
			ServerSocketChannel server = ServerSocketChannel.open();
			server.configureBlocking(false);
			server.bind(new InetSocketAddress(7777));
			
			server.register(selector, SelectionKey.OP_ACCEPT); //�����ϴ¾ֵ��� �����ϰڴ�
			//�����Ϳ� �ϰ��� �����ִ�.
			
			while(true) {
				int cnt = selector.select();
				
				if(cnt ==0) continue;
				//�������� �۾��� ��û�ϴ°��� �����Ͱ� ����ϰ� �ִ� �������� ���´ٸ� list�� �־��ְ� �������� �������� ������� �˷��ְ�
				//������ �װ� �о �ٸ�������� �����ְų� �ڱ⽺���� ����Ҷ��� �д´�.
				
				Set<SelectionKey> keys = selector.selectedKeys();
				Iterator<SelectionKey>it = keys.iterator();
				
				while(it.hasNext()) {
					SelectionKey key = it.next();
					
					if (key.isAcceptable()) {
						accept(key);
					}else if (key.isReadable()) {
						//System.out.println("isReadable");
						Client client = (Client)key.attachment();
						client.recieve(key);
					}
					else if (key.isWritable()) {
						//System.out.println("isWritable");
						Client client = (Client)key.attachment();
						client.send(key);
					}
					it.remove();//�۾��� ������ ���ش�.
				}
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void accept(SelectionKey key) { //���ӽ� ����
		ServerSocketChannel server = (ServerSocketChannel) key.channel();
		try {
			SocketChannel socket = server.accept(); //���� ������ �������� Ŭ���̾�Ʈ ������
			Client client = new Client(socket);
			list.add(client);
			String msg = socket.getRemoteAddress()+"����:"+list.size();
			System.out.println(msg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
	class Client{
		SocketChannel socket;
		Charset charset = Charset.defaultCharset();
		String msg;//send�� ����� ����
		public Client(SocketChannel socket) {
			super();
			this.socket = socket;
			try {
				socket.configureBlocking(false);
				SelectionKey key =socket.register(selector, SelectionKey.OP_READ);
				//���Ͽ��� �о�� �ϴ°��� ������ �����Ϳ� ���, �۾��� �ϴ� Ű�� 
				key.attach(this); //�޼ҵ忡 ����Ǳ� ���ؼ�
				//
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		void recieve(SelectionKey key) {
			
			
			try {
				ByteBuffer buf = ByteBuffer.allocate(1024);
				int cnt = socket.read(buf);
				
				buf.flip();
				
				String data = charset.decode(buf).toString();
				System.out.println("isReadabel:"+data);
				sendToAll(data);
				
//				System.out.println(data);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				//socket �� �Ҹ� �Ǿ��� ��� ���� �� ����
				
			}
		}
		
		void send(SelectionKey key) {
			System.out.println("send:"+msg);
			ByteBuffer buf = charset.encode(msg);
			try {
				socket.write(buf);
				
				key.interestOps(SelectionKey.OP_READ);
				//intersetOps()
				//Selectionkey�� �۾��� op_read�� ����
				selector.wakeup();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	void sendToAll(String msg) { //��ü���� ������ ���� �޼ҵ�
		for (Client client : list) {
			client.msg = msg;
			SelectionKey key = client.socket.keyFor(selector);
			//selector�� ���� socket�� �ش��ϴ� selectionkey�� ���Ϲ޴´�.
			//keyfor:�����͸� ����ϸ� ü���� keyfor�޼ҵ�� selectionkey�� �������� ������ �ִ�
			key.interestOps(SelectionKey.OP_WRITE);
			//intersetOps()
			//Selectionkey�� �۾��� op_write�� ����->client Ŭ�������� �ߴ�read�� write�� �ٲ�ġ��
		}
		selector.wakeup();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new TCPSelectorServer();

	}

}
