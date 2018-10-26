package nio_p;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TCPSingleGuiServer extends Application{

	SocketChannel socket = null;
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		ServerSocketChannel server =null;
		try {
			
			server = ServerSocketChannel.open();
			server.configureBlocking(true);
			server.bind(new InetSocketAddress(7777));
			
			System.out.println("서버대기");
			
			SocketChannel socket = server.accept();
			System.out.println("클라이언트 접속");
			
			Parent root = FXMLLoader.load(
					getClass().getResource("singlegui.fxml"),
					new ResourceBundle() {
						
						@Override
						protected Object handleGetObject(String key) {
							// TODO Auto-generated method stub
							HashMap<String, Object>map = new HashMap<>();
							map.put("title","서버");
							map.put("socket",socket);
							return map.get(key);
						}
						
						@Override
						public Enumeration<String> getKeys() {
							// TODO Auto-generated method stub
							return null;
						}
					});
			Scene scene = new Scene(root);
			
			primaryStage.setScene(scene);

			primaryStage.show();
			
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				socket.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		launch(args);

	}

	

}
