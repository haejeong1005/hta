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
 //SocketChannel의 변수이 socket을 생성한다. 
 @Override
 public void start(Stage primaryStage) throws Exception {
  // TODO Auto-generated method stub
  
  try {
   socket = SocketChannel.open();
   //SocketChannel을 열어서 socket에 저장한다.
   
   socket.configureBlocking(true);
   
   socket.connect(new InetSocketAddress("192.168.0.39", 7777));
   //InetSocketAddress
   //IP주소에 관한 정보를 다루는 클래스이다. 생성자가 따로 없으며 InetAddress클래스의 정적 메소드에서 정보를 받아오는 형식으로 사용한다.

   System.out.println("서버 연결 성공");
   //출력
   Parent root = FXMLLoader.load(
     getClass().getResource("singlegui.fxml"),//singlegui로 만든 gui를 연결시킨다.
     new ResourceBundle() {//ResourceBundle: properties 파일을 다루는 클래스 
      //설정이나 자원들에 대해 [ 키 = 값 ] 형태로 저장된 파일. 프로퍼티 파일은 문자열을 문자열을 통해 인덱스시킨 배열로 인식

      
      @Override
      protected Object handleGetObject(String key) {
       // TODO Auto-generated method stub
       HashMap<String, Object>map = new HashMap<>();
       map.put("title","클라이언트");
       map.put("socket",socket);
       return map.get(key);
      }
      
      @Override
      public Enumeration<String> getKeys() {
       // TODO Auto-generated method stub
       return null;
      }
     });
   Scene scene = new Scene(root); //scene이라는 Scene자료형 변수를 선언, root를 사용하는 Scene을 생성해서 넣어준다.
   
   primaryStage.setScene(scene); //sece을 가져온다.

   primaryStage.show();//스테이지를 보여준다
   
   
  } catch (IOException e) {
   // TODO Auto-generated catch block
   e.printStackTrace();
   try {
    socket.close();//소켓을 닫아준다 사용후 항상 닫아주어야 한다.
   } catch (IOException e1) {
    // TODO Auto-generated catch block
    e1.printStackTrace();
   }
  }
 }

 public static void main(String[] args) {
  // TODO Auto-generated method stub

  launch(args); //lunch를 통해 실행한다.
 }

} 