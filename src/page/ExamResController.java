package page;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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

public class ExamResController implements Initializable {

	
	
	@FXML Button next;
	
	
	
	@FXML Label kor, eng, mat, total;
	
	
	Label [] lb;
	
	ArrayList<Exam>data;
	
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		lb = new Label [] {kor, eng, mat};
		
		data = (ArrayList<Exam>)resources.getObject("data");
		
		int tot=0;
		
		for (int i = 0; i < lb.length; i++) {
			lb[i].setText(data.get(i).title+":"+data.get(i).cnt);
			tot+=data.get(i).cnt;
		}
		
		total.setText("รัมก:"+tot);
	}
	


}
