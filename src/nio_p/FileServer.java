package nio_p;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			ServerSocketChannel server = ServerSocketChannel.open(); //����ü�� ����
			server.configureBlocking(true);
			server.bind(new InetSocketAddress(7777));
			
			Path path = Paths.get("ppp/merong.jpg"); //������ �ҷ��´� �뷮�� ������ �ѹ��� ����
			System.out.println("���� ���");
			System.out.println(Files.size(path));
			
			SocketChannel client = server.accept();//client�� ���鼭 server�� �޾ƿ´�.
			int num = 1024;
			ByteBuffer buf= ByteBuffer.allocate(num);// ��׸��� ������ش�.
			
			double aa = Files.size(path)/(double)num;

			int bb = (int) Math.ceil(aa);
			System.out.println(bb);
			buf.putInt(bb);
			FileChannel fc = FileChannel.open(path, StandardOpenOption.READ);//���Ϸ� �ҷ����� ���� ����
			buf.flip();
//			System.out.println(buf.getInt());
			client.write(buf);
			buf.clear();
			
			for(int i =0; i<bb; i++) {
				
			
				
				int cnt = fc.read(buf);//�о�帰���� ������ �ִ´�.
				buf.flip();//�ڿ��� ���� ������ �������� ���⶧���� �տ��� ���� ���� �� �հ� �����ش�.
				client.write(buf);
				buf.clear();//�����°� �����ϱ����ؼ� clear�� ���־���Ѵ�.
				
				System.out.println("server: " + cnt);
			}
			
			
			fc.close();//������ �ݾ��ش�

			client.close(); //������ ������ �ݾ�����ϰ��� ������
			server.close();//�ѹ��� ����ϰ� �״´�
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
