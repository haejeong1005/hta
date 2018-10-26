package nio_p;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;

public class FileMain {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		Path pp = Paths.get("ppp");
		
		System.out.println(pp);
		System.out.println(Files.isDirectory(pp));
		System.out.println(Files.isRegularFile(pp));
		//System.out.println(Files.newDirectoryStream(pp));
		System.out.println("-----------------------------------");
		DirectoryStream<Path> ds = Files.newDirectoryStream(pp);
		
		
		
		
		for(Path path: ds) { //안에있는 것들을 다 알 수 있다.
			System.out.print(Files.getLastModifiedTime(path)+"\t");
		if(Files.isDirectory(path))
				System.out.print("<DIR>\t");
		else
			System.out.print("\t");
			System.out.print(Files.size(path)+"\t");
			System.out.println(path.getFileName());
		}
		
		System.out.println("---------------------------------");		
		
		pp = Paths.get("ppp/photo.png");
		System.out.println(pp);
		System.out.println(Files.isDirectory(pp));
		System.out.println(Files.isRegularFile(pp));
		System.out.println(Files.getLastModifiedTime(pp));
		System.out.println(Files.size(pp));
		System.out.println(Files.getOwner(pp));
		System.out.println(Files.isHidden(pp)); //숨겨진 파일이냐
		System.out.println(Files.isReadable(pp)); //읽을수 있냐
		System.out.println(Files.isWritable(pp)); //수정가능
		System.out.println("파일명: " +pp.getFileName()); //파일이름
		System.out.println("현재 디렉토리명: " +pp.getParent().getFileName()); //내가 속해잇는곳의 이름
		System.out.println("디랙토리 경로수: " +pp.getNameCount()); //중첩되어 있는 숫자
		
		for (int i = 0; i < pp.getNameCount(); i++) {
			System.out.println(pp.getName(i)); // 단계별 이동
		}
		
		
		
		
		
	}

}
