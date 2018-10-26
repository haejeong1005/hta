package graphic_p;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class GraphicFxmlMain extends Application implements Initializable{

	@FXML Rectangle rec;
	@FXML Button btnRec;
	@FXML Button move;
	@FXML Arc icon;
	int i=15;
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Parent root = 
				FXMLLoader.load(getClass().getResource("graphicFxml.fxml"));
		
		Scene scene = new Scene(root);
		
		primaryStage.setScene(scene);
		
		primaryStage.show();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub		
		
		btnRec.setOnAction(ee->{
			rec.setRotate(rec.getRotate()*-1);
		});
		
		//btnRec.setVisible(false);
		move.setOnAction(ee->{
			if(icon.getStartAngle()==0||icon.getStartAngle()>45) {
				 i *= -1;
			}
			icon.setStartAngle(icon.getStartAngle()-i);
			icon.setLength(icon.getLength()+i*2);
			icon.setLayoutX(icon.getLayoutX()+40);
			if(icon.getLayoutX()>=600) {
				icon.setRotate(180);
				System.out.println(icon.getLayoutX());
				icon.setLayoutX(icon.getLayoutX()-100);
						}
		});
		
	}

}
