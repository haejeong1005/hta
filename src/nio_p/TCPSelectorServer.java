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
			
			server.register(selector, SelectionKey.OP_ACCEPT); //접근하는애들을 저장하겠다
			//셀렉터에 일감이 들어가져있다.
			
			while(true) {
				int cnt = selector.select();
				
				if(cnt ==0) continue;
				//서버한테 작업을 요청하는것은 셀렉터가 기억하고 있다 누군가가 들어온다면 list에 넣어주고 서버에게 누군가가 읽으라고 알려주고
				//서버는 그걸 읽어서 다른사람한테 보내주거나 자기스스로 사용할때면 읽는다.
				
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
					it.remove();//작업이 끝나면 빼준다.
				}
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void accept(SelectionKey key) { //접속시 실행
		ServerSocketChannel server = (ServerSocketChannel) key.channel();
		try {
			SocketChannel socket = server.accept(); //실제 서버로 접ㄱ근한 클라이언트 가져옴
			Client client = new Client(socket);
			list.add(client);
			String msg = socket.getRemoteAddress()+"연결:"+list.size();
			System.out.println(msg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
	class Client{
		SocketChannel socket;
		Charset charset = Charset.defaultCharset();
		String msg;//send시 사용할 변수
		public Client(SocketChannel socket) {
			super();
			this.socket = socket;
			try {
				socket.configureBlocking(false);
				SelectionKey key =socket.register(selector, SelectionKey.OP_READ);
				//소켓에서 읽어라 하는것이 들어오면 셀렉터에 등록, 작업을 하는 키에 
				key.attach(this); //메소드에 적용되기 위해서
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
				//socket 이 소멸 되었을 경우 삭제 및 종료
				
			}
		}
		
		void send(SelectionKey key) {
			System.out.println("send:"+msg);
			ByteBuffer buf = charset.encode(msg);
			try {
				socket.write(buf);
				
				key.interestOps(SelectionKey.OP_READ);
				//intersetOps()
				//Selectionkey의 작업을 op_read로 변경
				selector.wakeup();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	void sendToAll(String msg) { //전체에게 보내기 위한 메소드
		for (Client client : list) {
			client.msg = msg;
			SelectionKey key = client.socket.keyFor(selector);
			//selector로 부터 socket에 해당하는 selectionkey를 리턴받는다.
			//keyfor:셀렉터를 등록하면 체널의 keyfor메소드로 selectionkey를 언제든지 얻을수 있다
			key.interestOps(SelectionKey.OP_WRITE);
			//intersetOps()
			//Selectionkey의 작업을 op_write로 변경->client 클래스에서 했던read를 write로 바꿔치기
		}
		selector.wakeup();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new TCPSelectorServer();

	}

}
