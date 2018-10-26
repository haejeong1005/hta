package application;

import java.net.URL;
import java.util.Enumeration;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class loginTest extends Application implements Initializable {

	 @FXML TextField get_id;
	 @FXML TextField get_pw ;
	 @FXML TextField get_name ;
	 @FXML TextField get_birth ;
	 @FXML TextField get_gender ;
	 @FXML TextField get_message ;
	 @FXML TextField get_post ;
	 @FXML TextField get_phone ;
	 @FXML TextField get_email ;
	 @FXML TextField get_get ;
	 
	 JMember jmem;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		JMember jmem = (JMember)resources.getObject("");
    	
	
        get_id.setText(jmem.id);
        get_pw.setText(jmem.pwchk);
        get_name.setText(jmem.name);
        get_birth.setText(jmem.birth);
        get_message.setText(jmem.message);
        get_post.setText(jmem.post);
        get_phone.setText(jmem.phone);
        get_email.setText(jmem.maile);
        get_get.setText(jmem.get);
		
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub

        Parent parent = FXMLLoader.load(getClass().getResource("log.fxml"),
        		new ResourceBundle() {
			
			@Override
			protected Object handleGetObject(String key) {
				
				// TODO Auto-generated method stub
				return jmem;
			}
			
			@Override
			public Enumeration<String> getKeys() {
				// TODO Auto-generated method stub
				return null;
			}
		}
        		); 
        Scene scene = new Scene(parent);
    
        primaryStage.setScene(scene);
        primaryStage.show();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		launch(args);

	}



}
