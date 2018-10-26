package thread_p;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class TimelineController implements Initializable {

	@FXML Arc arc;
	@FXML Button btn1, btn2;
	@FXML Circle ball;
	@FXML AnchorPane total;
	TranslateTransition transition;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		btn1.setOnAction(ee->{
			Timeline t1 = new Timeline();
			
			KeyFrame x_0 = new KeyFrame(
					new Duration(0), 
					new KeyValue(arc.layoutXProperty(), 50));
			KeyFrame y_0 = new KeyFrame(
					new Duration(0), 
					new KeyValue(arc.layoutXProperty(), 50));
			
			KeyFrame x_1 = new KeyFrame(
					new Duration(1000), 
					new KeyValue(arc.layoutXProperty(), 100));
			KeyFrame y_1 = new KeyFrame(
					new Duration(1000), 
					new KeyValue(arc.layoutYProperty(), 50));
			
			KeyFrame y_2 = new KeyFrame(
					new Duration(2000),  //duration 시간이 매우 중요
					new KeyValue(arc.layoutYProperty(), 200)); //상태값으로 처리
			
			t1.getKeyFrames().add(x_0); //add순서 keyframe 순서무관
			t1.getKeyFrames().add(x_1);
			t1.getKeyFrames().add(y_0);
			t1.getKeyFrames().add(y_1);
			t1.getKeyFrames().add(y_2);
		
//			t1.setCycleCount(5);
			t1.setCycleCount(-1); ///무한반복
			t1.setAutoReverse(true);
			
			
			t1.play();
		});
		
		btn2.setOnAction(ee->{
			
			Timeline t2 = new Timeline();
			ScaleTransition transition = new ScaleTransition();
			
			KeyFrame y_1 = new KeyFrame(
					new Duration(2000), 
					new KeyValue(ball.layoutYProperty(), 500));
			
			t2.getKeyFrames().add(y_1);
			t2.setCycleCount(-1);
			t2.setAutoReverse(true);
			
			if(total.getPrefHeight()>  ball.getLayoutY()) {
				transition.setFromX(1);
				transition.setToX(2);
				transition.setFromY(2);
				transition.setToY(0.5);
				transition.setNode(ball);
				transition.setAutoReverse(true);
				transition.setCycleCount(-1);
				transition.setDuration(new Duration(1000));
				
				
				
			}//바닥이 공보다 클때 점프
			

			transition.play();
			t2.play();
		});
	

	}

}
