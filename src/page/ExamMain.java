package page;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ExamMain extends Application {

	ArrayList<Exam>data = new ArrayList<>();
	
	
	
	public ExamMain() {
		
		data.add(new Exam("국어", 
				"1을 한글로 부르면_일",
				"2을 한글로 부르면_이",
				"3을 한글로 부르면_귀요미",
				"4을 한글로 부르면_사"));
		
		data.add(new Exam("영어", 
				"1은 영어로?_one",
				"2은 영어로?_cuty",
				"3은 영어로?_three",
				"4은 영어로?_four"
				));
		data.add(new Exam("수학", 
				"1+1은?_2",
				"2+2은?_4",
				"3+3은?_6",
				"4+4은?_귀요미"
				));
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		
		
		Parent root = FXMLLoader.load(
				getClass().getResource("exam.fxml"),
				new ResourceBundle() {
					
					@Override
					protected Object handleGetObject(String key) {
						// TODO Auto-generated method stub
						
						HashMap<String, Object>map = new HashMap<>();
						map.put("data", data);
						map.put("no", 0);
						return map.get(key);
					}
					
					@Override
					public Enumeration<String> getKeys() {
						// TODO Auto-generated method stub
						return null;
					}
				});
		
		Scene scene = new Scene(root);
		
		primaryStage.setScene(scene);
		
		primaryStage.show();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
