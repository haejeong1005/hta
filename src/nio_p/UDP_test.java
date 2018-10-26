package nio_p;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class UDP_test extends Application implements Initializable {

	@FXML Label ipname, portname;
	@FXML TextField ip, port, msg;
	@FXML Button btn;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Parent root = FXMLLoader.load(
				getClass().getResource("udp.fxml"));
		
		Scene scene = new Scene(root);
		
		primaryStage.setScene(scene);
		
		primaryStage.show();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		launch(args);

	}

}
