package nio_p;

import java.io.IOException;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import nio_p.TCPSingleController.GuiReciever;
import nio_p.TCPSingleController.GuiSender;

public class TCPMulController implements Initializable {
	@FXML Button btn;
	@FXML TextField msg, ipr, por;
	@FXML Label label, ip, port;
	
	class TCPMulSender extends Thread{

		SocketChannel socket;
		String name;
		public TCPMulSender(SocketChannel socket) {
			super();
			this.socket = socket;
			try {
				name = "["+InetAddress.getLocalHost().getHostAddress()+"]";
				///현재 보내는 컴퓨터의 ip로 이름 설정
				
				
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			Charset charset = Charset.defaultCharset();
			
			tf.setOnAction(ee->{
				ByteBuffer buf = charset.encode(name+tf.getText());
				try {
					socket.write(buf);
					tf.setText("");
					tf.requestFocus();
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
		}
		
		
	}

	class TCPMulReciever extends Thread{
		SocketChannel socket;

		public TCPMulReciever(SocketChannel socket) {
			super();
			this.socket = socket;
		}
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			Charset charset = Charset.defaultCharset();
			while(true) {
				try {
					ByteBuffer buf = ByteBuffer.allocate(100);
					socket.read(buf);
					buf.flip();
					String data = charset.decode(buf).toString();
					System.out.println(data);
				} catch (Exception e) {
					// TODO: handle exception
					break;
				}
				
			}
		}
		
	}
	@FXML TextArea ta;
	@FXML TextField tf;
	@FXML Label title;
	
	SocketChannel socket;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		 socket = (SocketChannel)resources.getObject("socket");
		 title.setText((String)resources.getObject("title"));

		
		
		new  TCPMulSender(socket).start();
		new TCPMulReciever(socket).start();

	}

}
