package nio_p;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FIleClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			SocketChannel channel = SocketChannel.open(); //������ ����. server�� �����ϱ� ���ؼ�
			channel.configureBlocking(true);
			
			channel.connect(new InetSocketAddress("192.168.0.39",7777)); //127.0.0.1->�ڱ��ڽ��ѵ� ����ȴ�

			ByteBuffer buf = ByteBuffer.allocate(1024); //�������� 1024�� �����⶧���� �����ش�.
			channel.read(buf); //����ä���� byte�� ��� ������ ���� ���־�� �ϳ�.
			buf.flip();
			int size =buf.getInt();
			buf.clear(); //���ιޱ����ؼ� ������ clear���־�� �Ѵ�.
			System.out.println(size);

			Path path = Paths.get("nnn/tt.jpg");     //nnn�� ������� ���� ���Ϸ� ������ �ϰڴ�. ccvb.txt�� ����ڴ�
			
			FileChannel fc = FileChannel.open(path, //�������� �ְ� ������������ �����ϱ� �����մ� ��η� ���ڴ�(path ���)
													//������ ������ create, �����ϰ� �ִ� �۾��� ���ڴ�.
					StandardOpenOption.CREATE,
					StandardOpenOption.WRITE);
			
			
			for(int i =0; i<size; i++) {
				int cnt = channel.read(buf); //ü�η�(����)���� ���� �ڷḦ buf�� �ְٵ� ���� �ڷḦ ���Ͽ� ���ڵ�
				
				buf.flip();//�� ���ʺ��� �а� ��ġ�� �ٲپ��ش�.
				fc.write(buf);
				buf.clear();
			
				System.out.println("client: " + cnt);
			}
			fc.close();
			channel.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
