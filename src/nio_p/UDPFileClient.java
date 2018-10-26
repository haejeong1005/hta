package nio_p;

import java.io.IOException;
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

public class UDPFileClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			DatagramChannel channel = 
					DatagramChannel.open(StandardProtocolFamily.INET);
			
				
			channel.bind(new InetSocketAddress(7777));
			System.out.println("���Ŵ��");
			
	
				
			ByteBuffer buf  = ByteBuffer.allocate(1024);
//			channel.receive(buf);
//			//ü�ο��� ���ú긦�ϸ�, �ŰԺ����� �־���� ������ �����͸� ��´�. 
//			//System.out.println(addr);
//			buf.flip();
//			int size = buf.getInt();
//			System.out.println("size"+size);
//			buf.clear();
//			System.out.println(size);
		
			
			Path path = Paths.get("nnn/phopng");
			
			FileChannel fc = FileChannel.open(path, 
					StandardOpenOption.CREATE,
					StandardOpenOption.WRITE);
			
			while(true) {
//			for(int i =0; i<size; i++) {
				channel.receive(buf);
				
				if(buf.position()<=0)
					break;
				
				buf.flip();//�� ���ʺ��� �а� ��ġ�� �ٲپ��ش�.
				fc.write(buf);
				buf.clear();
				//System.out.println(i);
			
			}
			fc.close();
			channel.close();
			

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
	}

}
