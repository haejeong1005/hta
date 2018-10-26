package nio_p;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Scanner;

class TCPSingleSender extends Thread{

	SocketChannel socket;
	String name;
	public TCPSingleSender(SocketChannel socket) {
		super();
		this.socket = socket;
		try {
			name = "["+InetAddress.getLocalHost().getHostAddress()+"]";
			///현재 보내는 컴퓨터의 ip로 이름 설정
			
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		Charset charset = Charset.defaultCharset();
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			ByteBuffer buf = charset.encode(name+sc.nextLine());
			try {
				socket.write(buf);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				break;
			}
		}
		
	}
	
	
}

class TCPSingleReciever extends Thread{
	SocketChannel socket;

	public TCPSingleReciever(SocketChannel socket) {
		super();
		this.socket = socket;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		Charset charset = Charset.defaultCharset();
		while(true) {
			try {
				ByteBuffer buf = ByteBuffer.allocate(100);
				socket.read(buf);
				buf.flip();
				String data = charset.decode(buf).toString();
				System.out.println(data);
			} catch (Exception e) {
				// TODO: handle exception
				break;
			}
			
		}
	}
	
}




public class TCPSingleServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ServerSocketChannel server =null;
		try {
			server = ServerSocketChannel.open();
			server.configureBlocking(true);
			server.bind(new InetSocketAddress(7777));
			
			System.out.println("서버대기");
			
			SocketChannel client = server.accept();
			System.out.println("클라이언트 접속");
			
			new TCPSingleSender(client).start();
			new TCPSingleReciever(client).start();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				server.close();//에러발생시 서버 닫기
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}

}
