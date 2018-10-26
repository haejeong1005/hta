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

public class MainControllerme {

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
			Popup ppp = new Popup(); 	//货肺款 Stage 积己
			//Stage ppp = new Stage();
			FXMLLoader loader = new FXMLLoader(
					getClass().getResource("sub.fxml"));
			
			Parent root = loader.load();
		
			ppp.getContent().add(root);
//			MainController controller = loader.getController();
//			
//			controller.setPrimaryStage(primaryStage);
//			Stage stage =  (Stage)btn.getScene().getWindow();
			ppp.show(btn.getScene().getWindow());
			
//			ppp.show(primaryStage);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	public void subBac() {

		try {
			Popup bbb= new Popup();
			//Parent root= FXMLLoader.load(getClass().getResource("main.fxml"));
			FXMLLoader loader = new FXMLLoader(
					getClass().getResource("main.fxml"));
			
			Parent root = loader.load();
//			MainController controller = loader.getController();
//			controller.setPrimaryStage(primaryStage);
			bbb.getContent().add(root);
//			Stage stage = (Stage)btn.getScene().getWindow();
			bbb.show(btn2.getScene().getWindow());
			
//			bbb.show(primaryStage);
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
