package thread_p;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.FadeTransition;
import javafx.animation.FillTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.StrokeTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.util.Duration;

public class TranslateController2 implements Initializable {

	@FXML Arc rotateArc,scaleArc,fillArc,strokeArc,fadeArc;
	@FXML Button rotate,scale,fill,stroke,fade;
	
	
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		rotate.setOnAction(ee->{
			RotateTransition transition = new RotateTransition();
			transition.setFromAngle(0);
			transition.setToAngle(359);
			transition.setNode(rotateArc);
			transition.setDuration(new Duration(1000));
			//transition.setAutoReverse(true);
			transition.setCycleCount(-1);//-1 무한 반복
			transition.play();
		});
		
		scale.setOnAction(ee->{
			ScaleTransition transition = new ScaleTransition();
			transition.setFromX(1);
			transition.setToX(2);
			transition.setFromY(2);
			transition.setToY(0.5);
			transition.setNode(scaleArc);
			transition.setDuration(new Duration(1000));
			transition.setAutoReverse(true);
			transition.setCycleCount(-1);
			transition.play();
		});
		
		fill.setOnAction(ee->{
			FillTransition transition = new FillTransition();
			transition.setFromValue(new Color(1, 0,0,1));
			transition.setToValue(new Color(0,0,1,1));
			transition.setShape(fillArc);
			transition.setDuration(new Duration(1000));
			transition.setAutoReverse(true);
			transition.play();
		});
		
		stroke.setOnAction(ee->{
			StrokeTransition transition = new StrokeTransition();
			transition.setFromValue(new Color(1, 0,0,1));
			transition.setToValue(new Color(0,0,1,1));
			transition.setShape(strokeArc);
			transition.setDuration(new Duration(1000));
			transition.setAutoReverse(true);
			transition.play();
		});
		
		fade.setOnAction(ee->{
			FadeTransition transition = new FadeTransition();
			transition.setFromValue(1);
			transition.setToValue(0.3);
			transition.setNode(fadeArc);
			transition.setDuration(new Duration(1000));
			transition.setAutoReverse(true);
			transition.play();
		});
	}

}
