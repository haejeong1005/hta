package nio_p;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class TCPMulServer {

 ArrayList<SocketChannel> list = new ArrayList<>();
 //socketChannel이라는 자료형인 list를 생성해준다.
 
 class TCPMulSeverReciever extends Thread{
  SocketChannel socket; //socket이라는 SocketChannel클래스의 변수
  String name; //name이라는 이름의 String 변수

  public TCPMulSeverReciever(SocketChannel socket) {//메소드 socket이라는 SocketChannel클래스의 변수를 받아온다
   super();
   this.socket = socket; //this.socket= 클래스안에서 선언한 socket ; socket=받아오는 
   /*예외처리가 생길때, 오류가 발생할때 trycatch를 통해 방지할 수 있게 해주는 것
    *try: 에러를 감지하는 부분 catch부분에서 감지한 에러를 처리*/
   try {
    InetSocketAddress address = (InetSocketAddress)socket.getRemoteAddress();
    //InetSocketAddress: IP 소켓 주소 (IP 주소 + 포트 번호)를 구현
    //InetSocketAddress라는 클래스의 변수명 = address/ socket을 InetSocketAddress로 형변환 시켜준다.
    //.getRemoteAddress() 이 채널의 소켓이 접속되고 있는 리모트·주소를 돌려줍니다.
    
    name = "["+address.getAddress().getHostAddress()+"]";
    //name에다가 address의 주소를 가져와서 그곳의 호스트 주소를 받아오는 것을 저장한다.
   } catch (IOException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
   }
   
  }
  
  
  @Override
  public void run() {
   // TODO Auto-generated method stub
   
   
   sendToAll(name+"입장"); //sendToAll메소드가 시작하기전에 위에서 정의한 name+"입장"을  뿌려준다.
   
   list.add(socket); //socket을 리스트에다가 넣어준다.
   sendToAll("접속자수: "+list.size()); //snedToAll메소드를 통해 리스트의 사이즈를 가지고 접속자 수를 보여준다.
   System.out.println(name+"연결: "+list.size());//누가 접속하고 접속자의 숫자를 서버에서 알려주기위해 system을 통해 뿌려준다
   Charset charset = Charset.defaultCharset();//Charset이라는 자료형의 변수인 charset을 생성해서 
   
    try {
     while(socket!=null) { //소켓이 널이아닐때까지 돌린다
     ByteBuffer buf = ByteBuffer.allocate(100);
     //ByteBuffer:체널의 기본 입출력 버퍼
     //buf라는 변수를 생성 100이라는 공간을 할당해준다.
     socket.read(buf);
     //socket에서 buf를 읽는다
     buf.flip(); //buf를 쓰기모드에서 읽기모드로 바꾸어준다.
     String data = charset.decode(buf).toString();
     //charset을통해서 정보가 부호화된것을 decode를 통해서 다시 정보화 시키고 그것을 문자열로 만들어준다.
     //그것들을 String 형의 data변수에 넣는다.
     sendToAll(data);
     //그것들을 sendToAll메소드를 통해 뿌려준다.
     }
    } catch (Exception e) {
     // TODO: handle exception
     
    }finally {
     list.remove(socket);//채팅창을 나갈때 부분을 오류가 나지 않게 해주기 위해서 socket을 list에서 제거해준다
     sendToAll(name+"퇴장"); //sendToAll메소드를 통해서 나가는게 누구인지를 알려주면서 나갔음을 알려준다.
     sendToAll("접속자수: "+list.size()); //나가면서 나머지의 수를 알려준다.
    /*try: 예외가 발생할 수 있는 코드를 넣어서 에러를 감지
     *catch: 감지한 에러를 처리
     *finally: 에러가 발생하거나 안하거나 무조건 처리하는 부분*/
   }
   
   
   
  }

 
 }
 
 void sendToAll(String msg) { //접속하는 모든 사람들에게 메세지를 뿌려주는 메소드 msg라는 string 변수를 받는다.
  
  
  
  for (SocketChannel channel : list) {
   //for each를 통해 리스트를 하나씩 까버린다. list를 SocketChannel로 만들었기 때문에 까지는 것도 SocketChannel
   Charset charset = Charset.defaultCharset(); //문자형을 지정해주는. Charset을 통해 인코딩비스무리 해준다.??
   ByteBuffer buf = charset.encode(msg); //ByteBuffer형인 buf에 msg를 암호화 한것을 넣어준다.
   
   try { //예외가 발생할 수 있는 조건들을 넣어준다
    channel.write(buf);
    //write메소드:출력 스트림으로 1 byte를 보냄 buf를 1byte씩 보낸다

   } catch (IOException e) { //예외발생시 처리해준다
    // TODO Auto-generated catch block
    e.printStackTrace();
   }
  }
 }
 
 
 public TCPMulServer() {//TCPMulServer()생성
  // TODO Auto-generated constructor stub
  
  try {
   ServerSocketChannel server = ServerSocketChannel.open();
   //ServerSocketChannel이라는 자료형의 server를 만들어서 ServerSocketChannel을 열어서 넣어준다
   
   server.configureBlocking(true);//보호막 쳐준다
   server.bind(new InetSocketAddress(7777)); 
   //bind:함수와 객체를 묶는 메소드 가상의 포트번호인7777의 주소와 server를 합쳐준다.
   //가상의 포트번호7777을 지정해준다
   
   while(true) {//true일때까지 계속 돌아간다.
    SocketChannel client = server.accept();
    //SocketChannel의 자료형인 client의 변수에 server
    new TCPMulSeverReciever(client).start();
    //client를 받는TCPMulSeverReciever를 생성해서 시작한다
    
    System.out.println(client.getRemoteAddress()+"연결:"+list.size());
    //System을 통해서client의 주소를 가져와서 뿌려준다/.
    
   }
   
   
  } catch (IOException e) { //예외처리 해주는 부분
   // TODO Auto-generated catch block
   e.printStackTrace();
  }
 }
 
 
 public static void main(String[] args) {
  // TODO Auto-generated method stub
  
  new TCPMulServer();
  //TCPMulServer를 메인에서 생성해준다
 }

} 