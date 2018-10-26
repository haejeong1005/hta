package application;
 
import java.net.URL;
import java.util.Enumeration;
import java.util.ResourceBundle;
 
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
 
public class JoinView extends Application implements Initializable{
 
    @FXML TextField id_Text;
    @FXML TextField name_Text;
    @FXML TextField email_Text;
    @FXML TextField phn_Text;
    @FXML TextField birth_Text;
    @FXML TextField gen_Text;
    
    
    Member mem;
   
 
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub
    	
    	Member mem = (Member)resources.getObject("");
    	
        id_Text.setText(mem.id);
        name_Text.setText(mem.name);
        email_Text.setText(mem.email);
        phn_Text.setText(mem.phone);
        birth_Text.setText(mem.birth);
        gen_Text.setText(mem.gen);
        
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        // TODO Auto-generated method stub
        Parent parent = 
        		FXMLLoader.load(
        			getClass().getResource("joinv.fxml"),
        			new ResourceBundle() {
						
						@Override
						protected Object handleGetObject(String key) {
							// TODO Auto-generated method stub
							return mem;
						}
						
						@Override
						public Enumeration<String> getKeys() {
							// TODO Auto-generated method stub
							return null;
						}
					}
        		); 
        Scene scene = new Scene(parent);
    
        primaryStage.setScene(scene);
        primaryStage.setTitle("회원가입 확인");
        primaryStage.show();
    }
 
    
}
 