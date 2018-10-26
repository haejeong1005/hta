package application;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
 
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

class JMember{
	
	String id;
    String paw;
    String pwchk;
    String name;
    String birth;
    String gender;
    String message;
    String post;
    String phone;
    String maile;
    String get;
    
    
	public JMember(String id, String paw, String pwchk, String name, String birth, String gender, String message,
			String post, String phone, String maile, String get) {
		super();
		this.id = id;
		this.paw = paw;
		this.pwchk = pwchk;
		this.name = name;
		this.birth = birth;
		this.gender = gender;
		this.message = message;
		this.post = post;
		this.phone = phone;
		this.maile = maile;
		this.get = get;
	}
    
    
    
    
	
}
 
public class JoinTest extends Application implements Initializable{
 
    List<String> list = new ArrayList<>();
    
    
    @FXML RadioButton genMM;
    @FXML RadioButton genFF;
    @FXML ComboBox num;
    @FXML ComboBox r_email;
    @FXML TextField c_id;
    @FXML TextField c_name;
    @FXML TextField l_num;
    @FXML TextField r_num;
    @FXML TextField l_email;
    @FXML TextField address;
    @FXML Button r_id;
    @FXML Button find;
    @FXML Button right;
    @FXML Button cancel;
    @FXML PasswordField r_pw;
    @FXML PasswordField r_rpw;
    @FXML CheckBox l_alarm;
    @FXML CheckBox r_alarm;
    @FXML DatePicker date;
    @FXML ToggleGroup gg;
 
    String id;
    String paw;
    String pwchk;
    String name;
    String birth;
    String gender;
    String message;
    String post;
    String phone;
    String maile;
    String get;
    
 
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub
        
        Alert warning = new Alert(AlertType.CONFIRMATION);
        warning.setTitle("경고");
        warning.setContentText("값이 없습니다.."); //내용
        warning.setHeaderText("값을 입력해 주세요.");
        
        Alert idalert = new Alert(AlertType.CONFIRMATION);
        idalert.setTitle("알림창");
        idalert.setContentText("다시입력해주세요."); //내용
        idalert.setHeaderText("존재하는 아이디입니다.");
        
        Alert iddalert = new Alert(AlertType.CONFIRMATION);
        iddalert.setTitle("알림창");
        iddalert.setContentText("사용가능합니다."); //내용
        iddalert.setHeaderText("사용가능한  아이디입니다.");
        
        Alert pwalert = new Alert(AlertType.CONFIRMATION);
        pwalert.setTitle("알림창");
        pwalert.setContentText("다시입력해주세요."); //내용
        pwalert.setHeaderText("비밀번호가 일치하지 않습니다.");
  
            c_id.textProperty().addListener((observable, oldValue, newValue)->{
                 r_id.setOnAction(ee->{
                        // System.out.println(c_id.getText());
                     if(list.size()==0) {
                     c_id.setText(newValue);
                          c_id.getText();
                          iddalert.show();
                         list.add(c_id.getText());
                         
                        
                      }
                     else {
                         if(list.contains(c_id.getText())) {
                             idalert.show();
                         }
                         else {
                             c_id.setText(newValue);
                             c_id.getText();
                             iddalert.show();
                             list.add(c_id.getText());
                            
                            
                         }
                     }
                    
                 });
 
 
              });
            
           
            
            EventHandler nn = ee->{    
                TextField rb = (TextField)ee.getSource();
                rb.getText();
                
            };
            
                c_name.setOnAction(nn);
               
                		
            
        
             
            EventHandler pw = ee->{    
                PasswordField rb = (PasswordField)ee.getSource();
                rb.getText();
                
            };
            r_pw.setOnAction(pw);
            
            
            EventHandler rpw = ee->{
                PasswordField rb = (PasswordField)ee.getSource();
            };
            r_rpw.setOnAction(ee->{
                if(r_pw.getText().equals(r_rpw.getText()))
                    r_rpw.getText();
                    
                else
                    pwalert.show();
                
            });
           
            
            
            date.setOnAction(ee->{
                date.getValue();
                
            });
           
 
    
 
        EventHandler handler = ee->{    
            RadioButton rb = (RadioButton)ee.getSource();
            rb.getText();
            
            
        };
        
        //System.out.println(((RadioButton)gg.getSelectedToggle()).getText());
        ObservableList<String> numData =
                FXCollections.observableArrayList("02","031","032","033","041","042","043","044",
                        "051","052","053","054","055","061","062","063","064");
        num.setItems(numData);
        num.setValue(numData.get(0));
        num.getSelectionModel().selectedItemProperty().addListener((
                observable,
                oldValue,
                newValue)->{
                    num.getValue();
            
                });
       
        
        EventHandler n1 = ee->{
            TextField rb = (TextField)ee.getSource();
            
        };
        l_num.setOnAction(n1);
        
       
        
        EventHandler n2 = ee->{
            TextField rb = (TextField)ee.getSource();
            System.out.print(rb.getText()+"\n");
        };
        r_num.setOnAction(n2);
       
        EventHandler e1 = ee->{
            TextField rb = (TextField)ee.getSource();
            //System.out.print(rb.getText());
        };
        
        l_email.setOnAction(e1);
        
       
        
        ObservableList<String> emailData = 
                FXCollections.observableArrayList("직접입력","google.co.kr","naver.com","daum.net","zoom.co.kr");
        r_email.setItems(emailData);
        
        r_email.setValue(emailData.get(0));
        
        r_email.getSelectionModel().selectedItemProperty().addListener((
                observable,
                oldValue,
                newValue)->{
                    r_email.getValue();
                
                });
        
        // l_alarm.setSelected(true);
         //r_alarm.setSelected(true);
        
        EventHandler al1 = ee->{
        
                 CheckBox box = (CheckBox)ee.getSource();
                 if(box.isSelected()) {
        
                     box.getText();
                 }
                 else
                     box.setText("이메일 수신 거부");
                    //System.out.println("이메일 수신 거부");
        };
        
         l_alarm.setOnAction(al1);
        
        
        EventHandler al2 = ee->{
             CheckBox box = (CheckBox)ee.getSource();
             if(box.isSelected()) {
                box.getText();
             }
             else
                 box.setText("문자메세지 수신 거부");
                //System.out.println("문자메세지 수신 거부");
        };
        
         r_alarm.setOnAction(al2);
         
         
         
//        EventHandler aa = ee->{    
//            TextField rb = (TextField)ee.getSource();
//            rb.getText();
//            
//        };
        
        
        right.setOnAction(ee->{
        	 id= c_id.getText();
             name= c_name.getText();
             paw = r_pw.getText();
             pwchk = r_rpw.getText();  
             birth = date.getValue().toString();
             phone = (String) num.getValue()+" - ";
             phone += l_num.getText()+" - ";
             phone += r_num.getText();
             maile = l_email.getText();
             maile += " @ "+ r_email.getValue();
             get = l_alarm.getText()+"\t\t";
             get += r_alarm.getText();
            post = address.getText();
           
            loginTest lt= new loginTest();
            lt.jmem = new JMember(id,paw,pwchk,name,birth,gender,message,post,phone,maile,get);
            try {
				lt.start(new Stage());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
  
//             System.out.println(c_id.getText());
//             System.out.println("이름: " + c_name.getText());
//             System.out.println("PW: " + r_pw.getText());
//             System.out.println("PW_Check: "+r_rpw.getText());
//             System.out.println(date.getValue());
//             //System.out.println( genMM.getText());
//            // System.out.println( genFF.getText());
//            
//            //genFF.setOnAction(handler);
//             System.out.print(num.getValue()+" - ");
//             System.out.print(l_num.getText()+" - ");
//             System.out.println(r_num.getText());
//             System.out.print(l_email.getText());
//             System.out.println(" @ "+ r_email.getValue());
//             System.out.println(l_alarm.getText());
//             System.out.println(r_alarm.getText());
//             System.out.println("주소: " + address.getText());
        });
    
        
        
    }
    
    
 
    @Override
    public void start(Stage primaryStage) throws Exception {
        // TODO Auto-generated method stub
 
        Parent parent = FXMLLoader.load(getClass().getResource("par.fxml")); 
        Scene scene = new Scene(parent);
    
        primaryStage.setScene(scene);
        primaryStage.show();
 
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        launch(args);
    }
 
 
}