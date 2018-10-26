package layout_p;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class PaddingMargin extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		HBox hbox = new HBox();
		
		hbox.setPadding(new Insets(50,10,100,200));
		
		
		Button btn1 = new Button();
		btn1.setPrefSize(100, 100);
		
		Button btn2 = new Button();
		btn2.setPrefSize(100, 100);

		hbox.setMargin(btn1, new Insets(20,20,20,20));
		hbox.getChildren().add(btn1);
		hbox.getChildren().add(btn2);
		
		Scene scene =new Scene(hbox);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		launch(args);

	}

}
