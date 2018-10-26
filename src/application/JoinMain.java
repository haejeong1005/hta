package application;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;


class Member{
	
	String id;
	String name;
	String pw;
	String email;
	String phone;
	String birth;
	String gen;
	
	
	
	
	public Member(String id, String name, String pw, String email, String phone, String birth, String gen) {
		super();
		this.id = id;
		this.name = name;
		this.pw = pw;
		this.email = email;
		this.phone = phone;
		this.birth = birth;
		this.gen = gen;
	}


	@Override
	public String toString() {
		return "Member [id=" + id + ", name=" + name + ", pw=" + pw + ", email=" + email + ", phone=" + phone
				+ ", birth=" + birth + ", gen=" + gen + "]";
	}

}

class Mem_Data{
	
	ArrayList<Member> mem_list = new ArrayList<>();//중복검사용

	public Mem_Data() {
		super();
		mem_list.add(new Member("mem1", "멤버1", "1234", "email@naver.com", "010-1212-1234", "2000-01-05", "남자"));
		mem_list.add(new Member("mem2", "멤버2", "1234", "email@naver.com", "010-1212-1234", "2000-01-05", "남자"));
		mem_list.add(new Member("mem3", "멤버3", "1234", "email@naver.com", "010-1212-1234", "2000-01-05", "남자"));
	}	
	
}

class Join_Init extends Application implements Initializable{

	@FXML TextField id_Text;
	@FXML TextField name_Text;
	@FXML TextField email_Id;
	@FXML TextField phn_Text1;
	@FXML TextField phn_Text2;
	@FXML Button id_Chk;
	@FXML Button join_Bt;
	@FXML Button cancel_Bt;
	@FXML PasswordField pw_Text;
	@FXML PasswordField pw_Chk_Text;
	@FXML ComboBox<String> email_Box;
	@FXML DatePicker birth_Picker;
	@FXML ComboBox<String> phn_Box;
	@FXML ToggleGroup gender;
	@FXML Label pw_Chk_Label;
	
	String id;
	String name;
	String pw;
	String email = "";
	String phone = "";
	String birth = "";
	String gen = "";
	
	boolean chk;			//id중복여부
	boolean hasChk;			//중복체크 실행 여부
	Member mem;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		Alert alert = new Alert(AlertType.CONFIRMATION);
	      alert.setTitle("알림창");
	     
		
		ObservableList<String> emailData =
				FXCollections.observableArrayList("없음","google.com","naver.com","daum.net","직접입력");
		ObservableList<String> phnData =
				FXCollections.observableArrayList("없음","02","031","010");
		
		email_Box.setItems(emailData);
		phn_Box.setItems(phnData);
		

		
		
		id_Chk.setOnAction(ee->{							//중복검사
			if(!id_Text.getText().equals("")) {
				chk = false;
				hasChk = false;
				id = id_Text.getText();
				Mem_Data md = new Mem_Data();
				
				md.mem_list.forEach(a->{if(a.id.equals(id)) {
					chk = true;
					return;
				}});
				
				if(chk) {
					alert.setHeaderText("존재하는 아이디입니다");
					alert.setContentText("다시입력해주세요");
					alert.show();
					id_Text.requestFocus();
				}else {
					alert.setHeaderText("사용 가능한 아이디입니다");
					alert.show();
					hasChk = true;
				}
				
			}else {
			    alert.setHeaderText("아이디를 입력해주세요");
				alert.show();
				id_Text.requestFocus();
			}
			
		});
			
		join_Bt.setOnAction(ee->{
			if(!hasChk) {
				alert.setHeaderText("아이디 중복체크를 하세요");
				alert.show();
				id_Chk.requestFocus();
				return;
			}
			
			
			if(!pw_Text.getText().equals("") && !pw_Chk_Text.getText().equals("")) {
				if(pw_Chk_Text.getText().equals(pw_Text.getText())) {
					if(Pattern.matches("[a-zA-Z].*[0-9].*", pw_Text.getText())) {
						pw = pw_Text.getText();
						
					}else {
						alert.setHeaderText("비밀번호는 영문과 숫자조합으로 입력하세요");
						alert.show();
						pw_Text.requestFocus();

						return;
					}
					
				}else {
					pw_Chk_Text.requestFocus();
					pw_Chk_Label.setText("입력한 비밀번호와 다릅니다");
					return;
				}				
			}else {
				if(pw_Text.getText().equals("")) {
					alert.setHeaderText("비밀번호를 입력하세요");
					alert.show();
					pw_Text.requestFocus();
				}else {
					alert.setHeaderText("비밀번호확인 입력하세요");
					alert.show();
					pw_Chk_Text.requestFocus();
				}
				return;								
			}
			
			
			name = name_Text.getText();
			
			if(email_Id.getText() != null && email_Box.getValue() != null) {
				
				email = email_Id.getText() + "@" + email_Box.getValue();
			}
			if(phn_Box.getValue() != null && phn_Text1.getText() != null && phn_Text2.getText() != null) {
				phone = phn_Box.getValue() + "-" + phn_Text1.getText() + "-" + phn_Text2.getText();				
			}
			
			if(birth_Picker.getValue() != null) {
				birth = birth_Picker.getValue().toString();				
			}
			
			gen = ((RadioButton)gender.getSelectedToggle()).getText();

			
			JoinView jv = new JoinView();
			
			jv.mem = new Member(id, name, pw, email, phone, birth, gen);
			
			
			try {
				jv.start(new Stage());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		});
		
		cancel_Bt.setOnAction(ee->{
			///창닫기
			
			//System.exit(0);
			((Stage)((Node)ee.getSource()).getScene().getWindow()).close();
			
		});

	}
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
		Parent parent = FXMLLoader.load(getClass().getResource("par2.fxml")); 
		Scene scene = new Scene(parent);
	
		primaryStage.setScene(scene);
		primaryStage.setTitle("회원가입");
		primaryStage.show();
		
		
	}
}

public class JoinMain extends Join_Init {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		launch(args);
	}



	
}
