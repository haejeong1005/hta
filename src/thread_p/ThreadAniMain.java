package thread_p;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class ThreadAniMain extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Parent root = 
				FXMLLoader.load(getClass().getResource("threadAni.fxml"));
			
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
			
			/*root.addEventHandler(KeyEvent.KEY_PRESSED, 
			new EventHandler<KeyEvent>() {

				@Override
				public void handle(KeyEvent key) {
					// TODO Auto-generated method stub
					System.out.println(key.getCode());
				}

			});*/
		}

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			launch(args);
		}

}
