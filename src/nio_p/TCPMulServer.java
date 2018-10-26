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
 //socketChannel�̶�� �ڷ����� list�� �������ش�.
 
 class TCPMulSeverReciever extends Thread{
  SocketChannel socket; //socket�̶�� SocketChannelŬ������ ����
  String name; //name�̶�� �̸��� String ����

  public TCPMulSeverReciever(SocketChannel socket) {//�޼ҵ� socket�̶�� SocketChannelŬ������ ������ �޾ƿ´�
   super();
   this.socket = socket; //this.socket= Ŭ�����ȿ��� ������ socket ; socket=�޾ƿ��� 
   /*����ó���� ���涧, ������ �߻��Ҷ� trycatch�� ���� ������ �� �ְ� ���ִ� ��
    *try: ������ �����ϴ� �κ� catch�κп��� ������ ������ ó��*/
   try {
    InetSocketAddress address = (InetSocketAddress)socket.getRemoteAddress();
    //InetSocketAddress: IP ���� �ּ� (IP �ּ� + ��Ʈ ��ȣ)�� ����
    //InetSocketAddress��� Ŭ������ ������ = address/ socket�� InetSocketAddress�� ����ȯ �����ش�.
    //.getRemoteAddress() �� ä���� ������ ���ӵǰ� �ִ� ����Ʈ���ּҸ� �����ݴϴ�.
    
    name = "["+address.getAddress().getHostAddress()+"]";
    //name���ٰ� address�� �ּҸ� �����ͼ� �װ��� ȣ��Ʈ �ּҸ� �޾ƿ��� ���� �����Ѵ�.
   } catch (IOException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
   }
   
  }
  
  
  @Override
  public void run() {
   // TODO Auto-generated method stub
   
   
   sendToAll(name+"����"); //sendToAll�޼ҵ尡 �����ϱ����� ������ ������ name+"����"��  �ѷ��ش�.
   
   list.add(socket); //socket�� ����Ʈ���ٰ� �־��ش�.
   sendToAll("�����ڼ�: "+list.size()); //snedToAll�޼ҵ带 ���� ����Ʈ�� ����� ������ ������ ���� �����ش�.
   System.out.println(name+"����: "+list.size());//���� �����ϰ� �������� ���ڸ� �������� �˷��ֱ����� system�� ���� �ѷ��ش�
   Charset charset = Charset.defaultCharset();//Charset�̶�� �ڷ����� ������ charset�� �����ؼ� 
   
    try {
     while(socket!=null) { //������ ���̾ƴҶ����� ������
     ByteBuffer buf = ByteBuffer.allocate(100);
     //ByteBuffer:ü���� �⺻ ����� ����
     //buf��� ������ ���� 100�̶�� ������ �Ҵ����ش�.
     socket.read(buf);
     //socket���� buf�� �д´�
     buf.flip(); //buf�� �����忡�� �б���� �ٲپ��ش�.
     String data = charset.decode(buf).toString();
     //charset�����ؼ� ������ ��ȣȭ�Ȱ��� decode�� ���ؼ� �ٽ� ����ȭ ��Ű�� �װ��� ���ڿ��� ������ش�.
     //�װ͵��� String ���� data������ �ִ´�.
     sendToAll(data);
     //�װ͵��� sendToAll�޼ҵ带 ���� �ѷ��ش�.
     }
    } catch (Exception e) {
     // TODO: handle exception
     
    }finally {
     list.remove(socket);//ä��â�� ������ �κ��� ������ ���� �ʰ� ���ֱ� ���ؼ� socket�� list���� �������ش�
     sendToAll(name+"����"); //sendToAll�޼ҵ带 ���ؼ� �����°� ���������� �˷��ָ鼭 �������� �˷��ش�.
     sendToAll("�����ڼ�: "+list.size()); //�����鼭 �������� ���� �˷��ش�.
    /*try: ���ܰ� �߻��� �� �ִ� �ڵ带 �־ ������ ����
     *catch: ������ ������ ó��
     *finally: ������ �߻��ϰų� ���ϰų� ������ ó���ϴ� �κ�*/
   }
   
   
   
  }

 
 }
 
 void sendToAll(String msg) { //�����ϴ� ��� ����鿡�� �޼����� �ѷ��ִ� �޼ҵ� msg��� string ������ �޴´�.
  
  
  
  for (SocketChannel channel : list) {
   //for each�� ���� ����Ʈ�� �ϳ��� �������. list�� SocketChannel�� ������� ������ ������ �͵� SocketChannel
   Charset charset = Charset.defaultCharset(); //�������� �������ִ�. Charset�� ���� ���ڵ��񽺹��� ���ش�.??
   ByteBuffer buf = charset.encode(msg); //ByteBuffer���� buf�� msg�� ��ȣȭ �Ѱ��� �־��ش�.
   
   try { //���ܰ� �߻��� �� �ִ� ���ǵ��� �־��ش�
    channel.write(buf);
    //write�޼ҵ�:��� ��Ʈ������ 1 byte�� ���� buf�� 1byte�� ������

   } catch (IOException e) { //���ܹ߻��� ó�����ش�
    // TODO Auto-generated catch block
    e.printStackTrace();
   }
  }
 }
 
 
 public TCPMulServer() {//TCPMulServer()����
  // TODO Auto-generated constructor stub
  
  try {
   ServerSocketChannel server = ServerSocketChannel.open();
   //ServerSocketChannel�̶�� �ڷ����� server�� ���� ServerSocketChannel�� ��� �־��ش�
   
   server.configureBlocking(true);//��ȣ�� ���ش�
   server.bind(new InetSocketAddress(7777)); 
   //bind:�Լ��� ��ü�� ���� �޼ҵ� ������ ��Ʈ��ȣ��7777�� �ּҿ� server�� �����ش�.
   //������ ��Ʈ��ȣ7777�� �������ش�
   
   while(true) {//true�϶����� ��� ���ư���.
    SocketChannel client = server.accept();
    //SocketChannel�� �ڷ����� client�� ������ server
    new TCPMulSeverReciever(client).start();
    //client�� �޴�TCPMulSeverReciever�� �����ؼ� �����Ѵ�
    
    System.out.println(client.getRemoteAddress()+"����:"+list.size());
    //System�� ���ؼ�client�� �ּҸ� �����ͼ� �ѷ��ش�/.
    
   }
   
   
  } catch (IOException e) { //����ó�� ���ִ� �κ�
   // TODO Auto-generated catch block
   e.printStackTrace();
  }
 }
 
 
 public static void main(String[] args) {
  // TODO Auto-generated method stub
  
  new TCPMulServer();
  //TCPMulServer�� ���ο��� �������ش�
 }

} 