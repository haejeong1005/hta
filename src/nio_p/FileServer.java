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
			ServerSocketChannel server = ServerSocketChannel.open(); //서버체널 연다
			server.configureBlocking(true);
			server.bind(new InetSocketAddress(7777));
			
			Path path = Paths.get("ppp/merong.jpg"); //파일을 불러온다 용량이 작으면 한번에 간다
			System.out.println("서버 대기");
			System.out.println(Files.size(path));
			
			SocketChannel client = server.accept();//client를 열면서 server를 받아온다.
			int num = 1024;
			ByteBuffer buf= ByteBuffer.allocate(num);// 밥그릇을 만들어준다.
			
			double aa = Files.size(path)/(double)num;

			int bb = (int) Math.ceil(aa);
			System.out.println(bb);
			buf.putInt(bb);
			FileChannel fc = FileChannel.open(path, StandardOpenOption.READ);//파일로 불러오기 위해 연다
			buf.flip();
//			System.out.println(buf.getInt());
			client.write(buf);
			buf.clear();
			
			for(int i =0; i<bb; i++) {
				
			
				
				int cnt = fc.read(buf);//읽어드린것을 버프에 넣는다.
				buf.flip();//뒤에서 부터 읽으면 읽을것이 없기때무에 앞에서 부터 읽을 수 잇게 도와준다.
				client.write(buf);
				buf.clear();//덮어씌우는걸 방지하기위해서 clear를 해주어야한다.
				
				System.out.println("server: " + cnt);
			}
			
			
			fc.close();//연것을 닫아준다

			client.close(); //파일을 보내면 닫아줘야하가ㅣ 때문에
			server.close();//한번만 사용하고 죽는다
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
