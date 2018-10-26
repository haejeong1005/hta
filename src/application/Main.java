package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;



public class Main extends Application {
	
	//순서 볼꾸야
	public Main() {
		// TODO Auto-generated constructor stub
		System.out.println("생성자"); //두번째 실행받을때 많이사용
	}
	@Override
	public void init() throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("init다"); //세번째 데이터를 받을때 많이사용
	}
	@Override
	public void stop() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("죽는다."); //x눌르면 실행 죽으면서 다른데이터를 실행할때 많이사용
		Sub.main(new String[] {});
	}
	@Override
	public void start(Stage primaryStage) {
		try {
			
			//primaryStage > scene > root 가 들어가있다
			System.out.println("start다"); //4번째
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("와 제목이다!"); //제목이야
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		System.out.println("main이다"); //가장먼저 실행
		launch(args); //여기서 실행해준다.

		
	}
}
