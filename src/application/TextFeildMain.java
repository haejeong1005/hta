package application;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TextFeildMain extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
		
		VBox vBox = new VBox();
		vBox.setPrefWidth(700);
		vBox.setPrefHeight(400);
		vBox.setAlignment(Pos.CENTER); //버튼 위치
		
		
		Scene scene = new Scene(vBox);
	
		TextField tf1 = new TextField("내가 윗글이지");
		TextField tf2 = new TextField("내가 아랫글이지");
		

		vBox.getChildren().add(tf1);
		vBox.getChildren().add(tf2);
		


//		tf1.textProperty().addListener(new ChangeListener<String>() {
//
//			@Override
//			public void changed(ObservableValue<? extends String> observable, 
//					String oldValue, 
//					String newValue) {
//				// TODO Auto-generated method stub
//				System.out.println("글자내용 변경");
//				
//			}
//		});
		
//----------------------------------------------------------------------------------------------------------		
//		tf1.textProperty().addListener((ObservableValue<? extends String> observable, 
//		String oldValue, 
//		String newValue)-> {System.out.println(newValue);
//		tf2.setText(newValue);
//		}
//	);
//------------------------------------------------------------------------------------------------------------
		
		
		tf2.textProperty().bind(tf1.textProperty()); //tf2의 글자속성을 tf1의 글자 속성으로 묶어주겠다.
		
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		launch(args);

	}

}
