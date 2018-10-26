package layout_p;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
 
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
 
public class CalCulTest extends Application implements Initializable{
    @FXML TextField answer;
    @FXML Button mc;
    @FXML Button mr;
    @FXML Button ms;
    @FXML Button mplus;
    @FXML Button mmi;
    @FXML Button arrow;
    @FXML Button ce;
    @FXML Button c;
    @FXML Button plusmi;
    @FXML Button root;
    
    @FXML Button osx;
    
    @FXML Button one;
    @FXML Button two;
    @FXML Button three;
    @FXML Button four;
    @FXML Button five;
    @FXML Button six;
    @FXML Button seven;
    @FXML Button eight;
    @FXML Button nine;
    @FXML Button zero;
    
    @FXML Button dot;
    @FXML Button percent;
    @FXML Button slash;
    @FXML Button multiply;
    @FXML Button plus;
    @FXML Button minus;
    @FXML Button equalsign;
    
    List<Button> num = new ArrayList();
    List<Button> calcu = new ArrayList<>();
 
    String num1="";
    String buf ="";
    
    List<Integer> aa = new ArrayList<>();
    //List<String> bb = new ArrayList<>();
 
    @Override
    public void initialize(URL location, ResourceBundle resources) {
            
        // TODO Auto-generated method stub
 
        num.add(one); num.add(two); num.add(three);
        num.add(four); num.add(five); num.add(six);
        num.add(seven); num.add(eight); num.add(nine); num.add(zero);
        
        calcu.add(percent); calcu.add(slash); calcu.add(multiply);
        calcu.add(plus); calcu.add(minus);
 
        
        for (Button bb : num) {
            bb.setOnAction(ee->{
                num1 += bb.getText();
                answer.setText(num1);
                System.out.println(num1);
            });
        }
        
        equalsign.setOnAction(ee->{
        	
        	String aa = num1;
        
        });

 
        plus.setOnAction(ee->{
            int res = 0;
            if(buf.equals("")) {
                
                res = Integer.parseInt(num1);
                
            }
            else {
                res = Integer.parseInt(buf)+Integer.parseInt(num1);
            }
            buf = res+"";
            
            System.out.println(res);
            answer.setText(""+res+plus.getText());
            num1="";
            aa.add(res);
            //System.out.println(aa.size());
        });
        
        minus.setOnAction(ee->{
            int res=0;
            if(buf.equals("")) {
                res = Integer.parseInt(num1);
            }
            else {
                res = Integer.parseInt(buf) - Integer.parseInt(num1);
            }
            buf = res+"";
            System.out.println(res);
            answer.setText(""+res+minus.getText());
            num1="";
            aa.add(res);
            //System.out.println(aa.size());
        });
        
        
        multiply.setOnAction(ee->{
            int res = 0;
            if(buf.equals("")) {
                res = Integer.parseInt(num1);
            }
            else {
                res = Integer.parseInt(buf)*Integer.parseInt(num1);
            }
            buf= res+"";
            System.out.println(res);
            answer.setText(""+res+multiply.getText());
            num1="";
            aa.add(res);
            //System.out.println(aa.size());
        });
        
        slash.setOnAction(ee->{
            int res= 0;
            if(buf.equals("")) {
                res = Integer.parseInt(num1);
            }
            else {
                res = Integer.parseInt(buf)/Integer.parseInt(num1);
            }
            buf=res+"";
            System.out.println(res);
            answer.setText(""+res+slash.getText());
            num1="";
            aa.add(res);
           // System.out.println(aa.size());
        });
        
        percent.setOnAction(ee->{
            int res= 0;
            if(buf.equals("")) {
                res = Integer.parseInt(num1);
            }
            else {
                res = Integer.parseInt(buf)%Integer.parseInt(num1);
            }
            buf=res+"";
            System.out.println(res);
            answer.setText(""+res+percent.getText());
            num1="";
            aa.add(res);
            //System.out.println(aa.size());
        });
       
        
        c.setOnAction(ee->{
            num1="";
            buf="";
            answer.setText(num1);
            aa.clear();
            //System.out.println(aa.size());
        });
        
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        // TODO Auto-generated method stub
        Parent parent = FXMLLoader.load(getClass().getResource("CalCul.fxml"));
        Scene scene = new Scene(parent);
        
        
        
        primaryStage.setScene(scene);
        primaryStage.show();
    }
 
    public static void main(String[] args) {
        // TODO Auto-generated method stub
 
        launch(args);
    }
 
    
 
}
