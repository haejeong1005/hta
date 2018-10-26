package page;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class PageMainme1 extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		FXMLLoader loader = new FXMLLoader(
				getClass().getResource("main.fxml"));
		
		Parent root = loader.load();
		
		MainController2 controller = loader.getController();
//	
		Scene scene = new Scene(root);
		
		primaryStage.setScene(scene);
		
		primaryStage.show();
		
		controller.setPrimaryStage(primaryStage);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
