package layout_p;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class PaddingMargin5 extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub

		Parent parent = FXMLLoader.load(getClass().getResource("PaddingMargin5.fxml"));
		Scene scene = new Scene(parent);
		
		//scene.getStylesheets().add(getClass().getResource("PM5.css").toString());
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		launch(args);

	}

}
