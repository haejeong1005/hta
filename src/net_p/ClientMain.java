package net_p;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class ClientMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			Socket socket = new Socket("192.168.0.39",7777);
			
			InputStream is = socket.getInputStream();
			DataInputStream dis = new DataInputStream(is);
			System.out.println("¼­¹ö: "+dis.readUTF());
			
			dis.close();
			is.close();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
