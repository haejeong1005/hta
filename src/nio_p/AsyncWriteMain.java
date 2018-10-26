package nio_p;
//파일 비동기 채널
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.EnumSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class AttachGoGo{
	Path path;
	AsynchronousFileChannel channel;
	
	public AttachGoGo(Path path, AsynchronousFileChannel channel) {
		super();
		this.path = path;
		this.channel = channel;
	}
	
}

public class AsyncWriteMain {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		
		ExecutorService executorService = Executors.newFixedThreadPool(
				Runtime.getRuntime().availableProcessors());
		
		System.out.println(executorService);
		
		for (int i = 0; i < 10; i++) {
			
			
		
		Path pp = Paths.get("nnn/aaa_"+i+".txt");
		
		Charset chSet = Charset.defaultCharset();
		ByteBuffer buf = chSet.encode("시간탐험대 지니");
		
		/*AsynchronousFileChannel channel = AsynchronousFileChannel.open(pp,
				
				EnumSet.of(StandardOpenOption.CREATE,
						   StandardOpenOption.WRITE),
									executorService
				); //스레드 풀을 사용할 수 있게된다.*/	
		
		AsynchronousFileChannel channel = AsynchronousFileChannel.open(pp,
				
						   StandardOpenOption.CREATE,
						   StandardOpenOption.WRITE
					
				); //스레드 풀을 사용할 수 있게된다.
		
		
		//competionhandler로 작동시키기위해 path와 channel 을 맴버로 묶어 처리할 클래스로 생성
		AttachGoGo gogo  = new AttachGoGo(pp, channel);
		
		//쓰레도로 작동 ---> 특정작업을 마치고 나면 자동으로 completed가 실행됨
		CompletionHandler<Integer, AttachGoGo> completionHandler = 
				
				new CompletionHandler<Integer, AttachGoGo>() {
			
			@Override //channel.write()  정상종료시 진입
			public void completed(Integer result, AttachGoGo attachment) {
				// TODO Auto-generated method stub
				//파일 작성후 log 남김
				//Thread.currentThread().getName() 여러개의 쓰레드가 나누어서 비동기 식으로 처리함
				System.out.println(Thread.currentThread().getName()+
						"->"+attachment.path.getFileName()+":"+result+"byte");
				try {
					attachment.channel.close(); //다썼으면 닫기
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			@Override //channel.write() 처리실패시 진입
			public void failed(Throwable exc, AttachGoGo attachment) {
				// TODO Auto-generated method stub
				
			}
		};
		
		//channel 에 작성시 묶고:gogo, write진행후 결과처리: completionHandler
		channel.write(buf, 0, gogo, completionHandler);
		
		//channel.close(); 정상작동되었을때 completionHandler의 completed()에서 닫기함.
		
		}
				

	}

}
