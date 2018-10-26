package nio_p;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;

public class TCPSingleClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SocketChannel socket = null;
		
		try {
			socket = SocketChannel.open();
			socket.configureBlocking(true);
			
			socket.connect(new InetSocketAddress("192.168.0.39", 7777));
			System.out.println("서버 연결 성공");
			
			new TCPSingleSender(socket).start();
			new TCPSingleReciever(socket).start();
			
			
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
