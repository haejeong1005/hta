package nio_p;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.StandardProtocolFamily;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class UDPSender2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			DatagramChannel channel = 
					DatagramChannel.open(StandardProtocolFamily.INET);
										//IPV4 사용-StandardProtocolFamily.INET
			
			System.out.println("data 전송시작");
			
			
			
			
			String ip = "192.168.0.2";  //UniCast
			ip = "192.168.0.255";   	//BroadCast
			
			Path path = Paths.get("ppp/son.jpg");
			FileChannel fc = FileChannel.open(path, StandardOpenOption.READ);
			
			ByteBuffer buf = ByteBuffer.allocate(1024);
			
			int cnt=0;
			while(true) {
			
				cnt = fc.read(buf);
				if(cnt==-1)
					break;
				
				buf.flip();
				int sss = channel.send(buf,new InetSocketAddress(ip,7777));
				
				System.out.println("sender:"+sss);
				buf.clear();
			
			}
			buf = ByteBuffer.allocate(0);
			
			int sss = channel.send(buf,new InetSocketAddress(ip,7777));
			
			System.out.println("sender:"+sss);
			
			System.out.println("data 전송완료:");
			
			fc.close();
			channel.close();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
