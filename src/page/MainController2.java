package page;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MainController2 {

	Stage primaryStage;
	
	@FXML Button btn;
	@FXML Button btn2;
	
	public Stage getPrimaryStage() {
		return primaryStage;
	}



	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}



	public void subGo() {
		
		try {
			
			//Popup ppp = new Popup(); 	//새로운 창 생성
			Stage newStage = new Stage(StageStyle.DECORATED); 	
			
			Parent root = FXMLLoader.load(
					getClass().getResource("sub.fxml"));
			
			Scene scene = new Scene(root);
			
			newStage.setScene(scene);
			
			newStage.show();
			
			
			
			Stage oldStage =  (Stage)btn.getScene().getWindow();
			oldStage.close();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	public void subBac() {

		try {
			Stage bbb = new Stage(StageStyle.DECORATED); 
			//Parent root= FXMLLoader.load(getClass().getResource("main.fxml"));
			
			
			Parent root = FXMLLoader.load(
					getClass().getResource("main.fxml"));
			
			Scene scene = new Scene(root);
			
			bbb.setScene(scene);
			bbb.show();
			Stage oldStage =  (Stage)btn2.getScene().getWindow();
			oldStage.close(); //기존의 창을 꺼준다.
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
