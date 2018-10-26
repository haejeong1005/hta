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
		
		
		
		
		for(Path path: ds) { //�ȿ��ִ� �͵��� �� �� �� �ִ�.
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
		System.out.println(Files.isHidden(pp)); //������ �����̳�
		System.out.println(Files.isReadable(pp)); //������ �ֳ�
		System.out.println(Files.isWritable(pp)); //��������
		System.out.println("���ϸ�: " +pp.getFileName()); //�����̸�
		System.out.println("���� ���丮��: " +pp.getParent().getFileName()); //���� �����մ°��� �̸�
		System.out.println("���丮 ��μ�: " +pp.getNameCount()); //��ø�Ǿ� �ִ� ����
		
		for (int i = 0; i < pp.getNameCount(); i++) {
			System.out.println(pp.getName(i)); // �ܰ躰 �̵�
		}
		
		
		
		
		
	}

}
