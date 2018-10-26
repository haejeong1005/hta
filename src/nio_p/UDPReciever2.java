package nio_p;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.StandardProtocolFamily;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class UDPReciever2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			DatagramChannel channel = 
					DatagramChannel.open(StandardProtocolFamily.INET);
			
			channel.bind(new InetSocketAddress(7777));
			
			Path path = Paths.get("nnn/rrr.jpg");
			FileChannel fc = FileChannel.open(path,
					StandardOpenOption.CREATE,
					StandardOpenOption.WRITE
			);
			
			
			ByteBuffer buf = ByteBuffer.allocate(1024);
			
			
			System.out.println("수신대기");
			
			while(true) {
				
				SocketAddress addr = channel.receive(buf);
				
				System.out.println("receiver:"+buf.position());
				if(buf.position()<=0)
					break;
				
				buf.flip();
				fc.write(buf);
				buf.clear();
			}
			
			fc.close();
			channel.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
