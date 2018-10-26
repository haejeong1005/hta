package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Sub extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception { //start가 없으면 애러난다.
		// TODO Auto-generated method stub
		BorderPane root = new BorderPane();
		Scene scene = new Scene(root,700,700);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.setTitle("와 서브다!"); //제목이야	
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sub.launch(args); //여기서 실행해준다.
	}
	
	
}


