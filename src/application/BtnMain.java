package application;



import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class BtnMain extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
		VBox vBox = new VBox();
		vBox.setPrefWidth(700);
		vBox.setPrefHeight(400);
		vBox.setAlignment(Pos.CENTER); //버튼 위치
		
		Button button = new Button("눌러봐");
		
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("알림창");
		alert.setContentText("java Fx이다."); //내용
		alert.setHeaderText("메시지");
		//alert.show();
		
		
		
		button.setOnAction(ee->{
			System.out.println("눌렀습니다.");
			alert.show();
		});
		
//		button.setOnAction(new EventHandler<ActionEvent>() { //리스너이다.
//			
//			@Override
//			public void handle(ActionEvent event) {
//				// TODO Auto-generated method stub
//				System.out.println("눌렀습니다.");
//				
//				
//			}
//		}); //이벤트 핸들러라고 한다.
		
		
		vBox.getChildren().add(button);
		
		Label lb = new Label("라벨이당");
		Font font = new Font(40);
		lb.setFont(font);
		Slider slider  = new Slider();
		vBox.getChildren().add(lb);
		vBox.getChildren().add(slider);
		
		slider.valueProperty().addListener(  
				//이벤트가 작동하기 위해선 3가지가 필요하다. 누구한테 걸껀가(이벤트소스),대기한다(listener), 이벤트가 실행된다.
				(ObservableValue<? extends Number> observable, 
				Number oldValue, 
				Number newValue)->{
					lb.setText(newValue+"");
					lb.setFont(new Font(newValue.doubleValue())); /*매우 중요하다. 숫자가 커질수록 글씨 크기도 커진다.*/
					
					//System.out.println(newValue);
				});
		
//		slider.valueProperty().addListener(new ChangeListener<Number>() {
//			@Override
//			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
//				// TODO Auto-generated method stub
//				System.out.println(newValue);
//			}
//			
//		});
		Scene scene = new Scene(vBox);
		//button.setFont(font);
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		launch(args);
	}

}
