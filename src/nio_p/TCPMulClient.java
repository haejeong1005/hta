package nio_p;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Scanner;

class TCPMulSender extends Thread{

	SocketChannel socket;
	String name;
	public TCPMulSender(SocketChannel socket) {
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

class TCPMulReciever extends Thread{
	SocketChannel socket;

	public TCPMulReciever(SocketChannel socket) {
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



public class TCPMulClient {

	public static void main(String[] args) {
		SocketChannel socket = null;
		
		try {
			socket = SocketChannel.open();
			socket.configureBlocking(true);
			
			socket.connect(new InetSocketAddress("192.168.0.39", 7777));
			System.out.println("서버 연결 성공");
			
			new TCPMulSender(socket).start();
			new TCPMulReciever(socket).start();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				socket.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}
}
