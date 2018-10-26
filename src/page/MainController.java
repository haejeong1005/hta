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
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MainController implements Initializable {

	
	
	@FXML Button mainBtn;
	
	@FXML TextField msg;
	
	@FXML Label label;


	public void subGo() {
		
		try {
			
			Stage oldStage =  (Stage)mainBtn.getScene().getWindow(); //기존stage사용
		
			
			Parent root = FXMLLoader.load(
					getClass().getResource("sub.fxml"),
					new ResourceBundle() {
						
						@Override
						protected Object handleGetObject(String key) {
							// TODO Auto-generated method stub
							
							HashMap<String, Object>map = new HashMap<>();
							map.put("data", msg.getText());
							map.put("hi", "석태진 확 그냥");
							
							return map.get(key);  ///key에 해당하는 value return
						}
						
						@Override
						public Enumeration<String> getKeys() {
							// TODO Auto-generated method stub
							return null;
						}
			});
			
			Scene scene = new Scene(root);
			
			oldStage.setScene(scene);
			
			//oldStage.show();//사용안해
			//기존stage사용
			
			//oldStage.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

		if(resources!=null)
			label.setText("From Sub :"+resources.getObject("").toString());
	}

}
