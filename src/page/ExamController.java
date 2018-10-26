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

public class ExamController implements Initializable {

	
	
	@FXML Button next;
	
	@FXML TextField answer0,answer1,answer2,answer3;
	
	@FXML Label qq0,qq1,qq2,qq3, title;
	
	TextField [] tf;
	Label [] lb;
	
	ArrayList<Exam>data;
	Exam exam;

	int no;
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		tf = new TextField[] {answer0,answer1,answer2,answer3};
		lb = new Label [] {qq0,qq1,qq2,qq3};
		
		init((ArrayList<Exam>)resources.getObject("data"),
				(int)resources.getObject("no"));
		
		
		next.setOnAction(ee->{
			exam.finish(tf);
			
			String xml = "exam.fxml";
			if(data.size()<=no+1) {
				xml = "examRes.fxml";
			}
			
			try {
				Parent root = FXMLLoader.load(
						getClass().getResource(xml),
						new ResourceBundle() {
							
							@Override
							protected Object handleGetObject(String key) {
								// TODO Auto-generated method stub
								
								HashMap<String, Object>map = new HashMap<>();
								map.put("data", data);
								map.put("no", no+1);
								return map.get(key);
							}
							
							@Override
							public Enumeration<String> getKeys() {
								// TODO Auto-generated method stub
								return null;
							}
						});
				
				Stage stage = (Stage)title.getScene().getWindow();
				
				Scene scene = new Scene(root);
				
				stage.setScene(scene);
				
				stage.show();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			
			
		});
	}
	
	public void init(ArrayList<Exam>data, int no) {
		this.no= no;
		this.data = data;
		exam = data.get(no);
		title.setText(exam.title);
		
		for (int i =0; i<exam.map.size(); i++) {
			lb[i].setText(exam.map.get(i).qq);
			
		}
		
	}

}
