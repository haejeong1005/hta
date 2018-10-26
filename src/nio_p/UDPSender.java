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
			//StandardProtocolFamily.INET:ipv4 ����Ѵٴ� �ǹ�.
			
			System.out.println("data ���۽���");
			
			Charset charset = Charset.defaultCharset();
			ByteBuffer buf = charset.encode("�� �����̿���");
			
			String ip = "192.168.0.2";//unicast
			ip = "192.168.0.39";//broadcast
			
			int cnt = channel.send(buf, new InetSocketAddress(ip,7777));
			//7777:udp�� 7777�̴� tcp�� udp�� ��Ʈ�� �ٸ��ϱ� ���±��� ��� 7777�� tcp��Ʈ
			System.out.println("data ���ۿϷ�"+cnt);

			channel.close();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
