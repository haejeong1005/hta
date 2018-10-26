package page;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class SubController implements Initializable{

	
	
	@FXML Button subBtn;
	
	String data;
	
	@FXML Label label;
	
	@FXML TextField msg;

	
	public void mainGo() {
		
		try {
			
			
			Stage oldStage =  (Stage)subBtn.getScene().getWindow();

			Parent root = FXMLLoader.load(
			getClass().getResource("main.fxml"),new ResourceBundle() {
				
				@Override
				protected Object handleGetObject(String key) {
					// TODO Auto-generated method stub
					
					return msg.getText();  
				}
				
				@Override
				public Enumeration<String> getKeys() {
					// TODO Auto-generated method stub
					return null;
				}
	});
			
			Scene scene = new Scene(root);
			
			oldStage.setScene(scene);
			
			oldStage.show();
  
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		System.out.println(resources.getObject("hi"));
		data = resources.getObject("data").toString();
		
		System.out.println(data);
		
		label.setText("From Main :"+data);
		
	}

}
