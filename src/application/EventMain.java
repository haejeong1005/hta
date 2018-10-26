package application;



import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

//xml을 자바에 어떡해 끌고 들어오느냐가 키 포인트
public class EventMain extends Application implements Initializable {
	@FXML Label label1; //컨트롤 하기 위해서 반드시 필요하다
	@FXML TextField tf1; //컨트롤 하기 위해서 반드시 필요하다
	@FXML Button btn;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		btn.setOnAction(ee->{
			System.out.println("들오오냐?");
			String str = tf1.getText();
			label1.setText("입력내용: "+str);
			tf1.setText("");
			tf1.requestFocus();
		});
	}
	
//	@FXML
//	protected void btnClk(ActionEvent ee){
//		System.out.println("들오오냐?");
//		String str = tf1.getText();
//		label1.setText("입력내용: "+str);
//		tf1.setText("");
//		tf1.requestFocus();
//	}
	

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Parent parent = FXMLLoader.load(getClass().getResource("event.fxml")); //fxml불러옴.
		Scene scene = new Scene(parent);
	
		primaryStage.setScene(scene);
		primaryStage.show();


	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);

	}

}
