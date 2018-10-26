package nio_p;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TCPMulGuiClient extends Application {

 SocketChannel socket = null;
 //SocketChannel�� ������ socket�� �����Ѵ�. 
 @Override
 public void start(Stage primaryStage) throws Exception {
  // TODO Auto-generated method stub
  
  try {
   socket = SocketChannel.open();
   //SocketChannel�� ��� socket�� �����Ѵ�.
   
   socket.configureBlocking(true);
   
   socket.connect(new InetSocketAddress("192.168.0.39", 7777));
   //InetSocketAddress
   //IP�ּҿ� ���� ������ �ٷ�� Ŭ�����̴�. �����ڰ� ���� ������ InetAddressŬ������ ���� �޼ҵ忡�� ������ �޾ƿ��� �������� ����Ѵ�.

   System.out.println("���� ���� ����");
   //���
   Parent root = FXMLLoader.load(
     getClass().getResource("singlegui.fxml"),//singlegui�� ���� gui�� �����Ų��.
     new ResourceBundle() {//ResourceBundle: properties ������ �ٷ�� Ŭ���� 
      //�����̳� �ڿ��鿡 ���� [ Ű = �� ] ���·� ����� ����. ������Ƽ ������ ���ڿ��� ���ڿ��� ���� �ε�����Ų �迭�� �ν�

      
      @Override
      protected Object handleGetObject(String key) {
       // TODO Auto-generated method stub
       HashMap<String, Object>map = new HashMap<>();
       map.put("title","Ŭ���̾�Ʈ");
       map.put("socket",socket);
       return map.get(key);
      }
      
      @Override
      public Enumeration<String> getKeys() {
       // TODO Auto-generated method stub
       return null;
      }
     });
   Scene scene = new Scene(root); //scene�̶�� Scene�ڷ��� ������ ����, root�� ����ϴ� Scene�� �����ؼ� �־��ش�.
   
   primaryStage.setScene(scene); //sece�� �����´�.

   primaryStage.show();//���������� �����ش�
   
   
  } catch (IOException e) {
   // TODO Auto-generated catch block
   e.printStackTrace();
   try {
    socket.close();//������ �ݾ��ش� ����� �׻� �ݾ��־�� �Ѵ�.
   } catch (IOException e1) {
    // TODO Auto-generated catch block
    e1.printStackTrace();
   }
  }
 }

 public static void main(String[] args) {
  // TODO Auto-generated method stub

  launch(args); //lunch�� ���� �����Ѵ�.
 }

} 