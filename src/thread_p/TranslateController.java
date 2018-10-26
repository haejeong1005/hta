package thread_p;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.shape.Arc;
import javafx.util.Duration;

public class TranslateController implements Initializable {

	@FXML Arc arc;
	@FXML Button start, pause, stop;
	
	TranslateTransition transition;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		transition = new TranslateTransition();
		
		///position
		transition.setFromX(500);	//도착x위치
		transition.setFromY(100);	//도착x위치
		transition.setToX(100);	//도착x위치
		transition.setToY(400);	//도착x위치
		
		transition.setDuration(new Duration(3000));//진행시간
		transition.setCycleCount(5);	//반복횟수
		transition.setAutoReverse(true);
		
		transition.setNode(arc);		//적용할 node
		transition.play();
		
		pause.setOnAction(ee->{
			transition.pause();
			System.out.println(transition.getStatus());
		});
		start.setOnAction(ee->{
			transition.play();
			System.out.println(transition.getStatus());
		});
		stop.setOnAction(ee->{
			transition.stop();
			System.out.println(transition.getStatus());
		});
	}

}
