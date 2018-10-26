package nio_p;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileChannelWriteMain {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		
		//파일 채널 열기
		FileChannel channel = FileChannel.open(
				Paths.get("ppp/ccc.txt"), //ccc.txt를 여기서 새로 만든다.
				StandardOpenOption.CREATE,
				StandardOpenOption.WRITE);
		
		//버퍼생성
		Charset charset = Charset.defaultCharset();
		ByteBuffer buf = charset.encode("아기상어 뚜루루 뚜루 귀여운 asdf");
		//한글2byte 띄어쓰기,영어는 1byte
		
		//파일에 쓰기1
		int cnt=channel.write(buf);
		System.out.println(cnt);
		
		
		buf = charset.encode("최강 전사 미니 특공대");
		//한글2byte 띄어쓰기,영어는 1byte
		
		// close를 하기전까진 계속 누적이 된다.
		//파일에 쓰기2
		cnt=channel.write(buf);
		System.out.println(cnt);
		
		//파일에 쓰기3
		cnt=channel.write(buf);//한번 작성한 buffer의 내용은 다시 사용 못함.
		System.out.println(cnt);
		
		//파일채널 닫기		
		channel.close(); //사용했음 무조건 닫아야해

	}                   

}
