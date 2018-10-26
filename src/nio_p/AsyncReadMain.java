package nio_p;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.Charset;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

class AttachGoGo2{
	Path path;
	AsynchronousFileChannel channel;
	ByteBuffer buf;
	
	AttachGoGo2(Path path, AsynchronousFileChannel channel,ByteBuffer buf) {
		super();
		this.path = path;
		this.channel = channel;
		this.buf = buf;
	}
	
	
}

public class AsyncReadMain {

	
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		Path pp = Paths.get("ppp");
		
		DirectoryStream<Path> ds = Files.newDirectoryStream(pp);
		
		for (Path path : ds) {
			
			if(path.getFileName().toString().endsWith(".txt")) {
				
				AsynchronousFileChannel channel = 
						AsynchronousFileChannel.open(path, StandardOpenOption.READ);
				

				ByteBuffer buf = ByteBuffer.allocate((int)channel.size());
				
				AttachGoGo2 attach = new AttachGoGo2(path, channel, buf);
				
				CompletionHandler<Integer, AttachGoGo2> handler = new CompletionHandler<Integer, AttachGoGo2>() {

					////buf에 담는 것이 성공한 이후 진입
					@Override
					public void completed(Integer result, AttachGoGo2 attachment) {
						// TODO Auto-generated method stub
						attachment.buf.flip();
						
						Charset charset = Charset.defaultCharset();
						///내용 가져오기
						String data = charset.decode(buf).toString();
						
						
						
						////Thread가 비동기식으로 진행하여 파일의 내용을 가져옴
						System.out.println(
								Thread.currentThread().getName()+"->"+
								attachment.path.getFileName()+":"+data	
							);
						
						try {
							channel.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}

					@Override
					public void failed(Throwable exc, AttachGoGo2 attachment) {
						// TODO Auto-generated method stub
						
					}
				};
				channel.read(buf, 0,attach,handler);
			}
			}
		
			
			

/*		
		for(int i=0; i<10; i++) {
			Path path = Paths.get("nnn/aaa_"+i+".txt");
			
			AsynchronousFileChannel channel = 
					AsynchronousFileChannel.open(path, StandardOpenOption.READ);
			
			
			//파일크기를 받아 buf 공간 생성
			ByteBuffer buf = ByteBuffer.allocate((int)channel.size());
			
			AttachGoGo2 attach = new AttachGoGo2(path, channel, buf);
			
			CompletionHandler<Integer, AttachGoGo2> handler = new CompletionHandler<Integer, AttachGoGo2>() {

				////buf에 담는 것이 성공한 이후 진입
				@Override
				public void completed(Integer result, AttachGoGo2 attachment) {
					// TODO Auto-generated method stub
					attachment.buf.flip();
					
					Charset charset = Charset.defaultCharset();
					///내용 가져오기
					String data = charset.decode(buf).toString();
					
					
					
					////Thread가 비동기식으로 진행하여 파일의 내용을 가져옴
					System.out.println(
							Thread.currentThread().getName()+"->"+
							attachment.path.getFileName()+":"+data	
						);
					
					try {
						channel.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}

				@Override
				public void failed(Throwable exc, AttachGoGo2 attachment) {
					// TODO Auto-generated method stub
					
				}
			};
			
			////채널에서 buf에 담기 ---> 이후 작업은 handler completed()에서 실행
			channel.read(buf, 0,attach,handler);
		}*/
		
		
		
	}

}
