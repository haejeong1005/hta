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
			SocketChannel channel = SocketChannel.open(); //서버를 연다. server와 연결하기 위해서
			channel.configureBlocking(true);
			
			channel.connect(new InetSocketAddress("192.168.0.39",7777)); //127.0.0.1->자기자신한데 연결된다

			ByteBuffer buf = ByteBuffer.allocate(1024); //서버에서 1024로 보내기때문에 맞춰준다.
			channel.read(buf); //파일채널의 byte를 잡기 때문에 위에 써주어야 하낟.
			buf.flip();
			int size =buf.getInt();
			buf.clear(); //새로받기위해서 버프를 clear해주어야 한다.
			System.out.println(size);

			Path path = Paths.get("nnn/tt.jpg");     //nnn에 내맘대로 정한 파일로 접근을 하겠다. ccvb.txt로 만들겠다
			
			FileChannel fc = FileChannel.open(path, //있을수도 있고 ㅇ벗ㅇ르수도 있으니깐 위에잇는 경로로 열겠다(path 사용)
													//파일이 없으면 create, 지금하고 있는 작업을 쓰겠다.
					StandardOpenOption.CREATE,
					StandardOpenOption.WRITE);
			
			
			for(int i =0; i<size; i++) {
				int cnt = channel.read(buf); //체널로(서버)부터 받은 자료를 buf에 넣겟따 넣은 자료를 파일에 쓰겠따
				
				buf.flip();//맨 앞쪽부터 읽게 위치를 바꾸어준다.
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
