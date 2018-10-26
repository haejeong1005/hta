package nio_p;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.StandardProtocolFamily;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.charset.Charset;

public class UDPSender {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			DatagramChannel channel  =
					DatagramChannel.open(StandardProtocolFamily.INET);
			//StandardProtocolFamily.INET:ipv4 사용한다는 의미.
			
			System.out.println("data 전송시작");
			
			Charset charset = Charset.defaultCharset();
			ByteBuffer buf = charset.encode("난 선생이에요");
			
			String ip = "192.168.0.2";//unicast
			ip = "192.168.0.39";//broadcast
			
			int cnt = channel.send(buf, new InetSocketAddress(ip,7777));
			//7777:udp용 7777이다 tcp와 udp의 포트가 다르니깐 여태까지 썼던 7777은 tcp포트
			System.out.println("data 전송완료"+cnt);

			channel.close();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
