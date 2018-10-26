package net_p;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ServerSocket server = new ServerSocket(7777);
			
			while(true) {
				System.out.println("연결대기");
				Socket client = server.accept();
				
				OutputStream os = client.getOutputStream();
				DataOutputStream dos = new DataOutputStream(os);
				
				dos.writeUTF("서버 연결됨");
				
				dos.close();
				os.close();
				client.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
