package nio_p;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.NetworkInterface;
import java.net.StandardSocketOptions;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.charset.Charset;

public class MulticastSender {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		DatagramChannel channel = DatagramChannel.open();
		
		NetworkInterface inter = NetworkInterface.getByName("eth1");

		channel.setOption(StandardSocketOptions.IP_MULTICAST_IF, inter);
		//멀티캐스트 그룹에게 쏘겠다
		
		Charset charset = Charset.defaultCharset();
		ByteBuffer buf =  charset.encode("우리 그룹이에요");
		
		InetSocketAddress group = new InetSocketAddress("230.0.0.1", 7777);
		
		channel.send(buf, group);
		
		System.out.println("송신성공");
		
				
		

	}

}
