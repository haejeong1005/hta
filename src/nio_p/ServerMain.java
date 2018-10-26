package nio_p;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

public class ServerMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			ServerSocketChannel server = ServerSocketChannel.open();
			server.configureBlocking(true);//블록킹
			server.bind(new InetSocketAddress(7777));
			
			while(true) {
				System.out.println("서버 대기");
				
				SocketChannel client= server.accept();
				
				InetSocketAddress addr = (InetSocketAddress)client.getRemoteAddress();
				
				String clientAddr = "["+addr.getAddress().getHostAddress()+"]";
				
				System.out.println(clientAddr+" 접속");
				
				//Charset charset= Charset.forName("UTF-8"); 
				//둘다같은데 이클립스로 보는게 utf-8아니므로 아래거 사용
				Charset charset= Charset.defaultCharset();
				
				ByteBuffer buf = charset.encode("서버가 보내는 메시지");
				client.write(buf);
				System.out.println(clientAddr+" 데이터 전송");
				
				
				buf = ByteBuffer.allocate(100);
				int cnt= client.read(buf);
				buf.flip();
				
				String data =charset.decode(buf).toString();
				System.out.println(clientAddr+data);
				System.out.println(clientAddr+" 접속종료");
				
				
				System.out.println(clientAddr+" 접속종료");
				
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
