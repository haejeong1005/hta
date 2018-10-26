package nio_p;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.StandardProtocolFamily;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class UDPFileServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			DatagramChannel channel  =
					DatagramChannel.open(StandardProtocolFamily.INET);
			
			Path path = Paths.get("ppp/photo.png");
			FileChannel fc = FileChannel.open(path, StandardOpenOption.READ);
			int num = 1024;
			ByteBuffer buf = ByteBuffer.allocate(num);
			
			
			System.out.println("수신받음");
//			System.out.println(Files.size(path));
//			
//			double aa = Files.size(path)/(double)num;
//			int bb = (int)Math.ceil(aa);
//
//			buf.putInt(bb);
//			System.out.println(bb);
//			buf.flip();
//			channel.send(buf, new InetSocketAddress("192.168.0.39",7777));
//			buf.clear();
			

			while(true) {
//			for(int i =0; i<bb; i++) {
	
				int cc = fc.read(buf);
				if(cc==-1)
					break;
//				int cnt = fc.read(buf);//읽어드린것을 버프에 넣는다.
				buf.flip();//뒤에서 부터 읽으면 읽을것이 없기때무에 앞에서 부터 읽을 수 잇게 도와준다.
				int cnt = channel.send(buf, new InetSocketAddress("192.168.0.39",7777));
				buf.clear();//\덮어씌우는걸 방지하기위해서 clear를 해주어야한다.
				
				//System.out.println("server: " + i);
			}
			
			
			fc.close();//연것을 닫아준다
			channel.close();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
	}

}
