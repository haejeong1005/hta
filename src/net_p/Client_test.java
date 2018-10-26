package net_p;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
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

public class Client_test extends Application implements Initializable {

	@FXML Button btn;
	@FXML TextField msg, ipr, por;
	@FXML Label label, ip, port;
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		ipr.getText();
		por.setText("7777");
		
		btn.setOnAction(ee->{

			try {
				Socket socket = new Socket(ipr.getText(), Integer.parseInt(por.getText()));
				
				InputStream is = socket.getInputStream();
				DataInputStream dis = new DataInputStream(is);
				//System.out.println("서버: "+dis.readUTF());
				msg.setText("서버 연결");
				msg.setText(dis.readUTF());
				msg.getText();
				dis.close();
				is.close();
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Parent root = FXMLLoader.load(
				getClass().getResource("cli_test.fxml"));
		
		Scene scene = new Scene(root);
		
		primaryStage.setScene(scene);
		
		primaryStage.show();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}



}
