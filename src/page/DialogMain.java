package page;



import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.security.cert.Extension;
import java.util.Optional;

import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class DialogMain extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub

		Alert info  = new Alert(AlertType.INFORMATION);
		info.setTitle("알림창");
		info.setHeaderText("알림창 제목");
		info.setContentText("알림창 내용");
		info.show();
		
		Alert error  = new Alert(AlertType.ERROR);
		error.setTitle("error창");
		error.setHeaderText("error 제목");
		error.setContentText("error내용");
		error.show();

		
		Alert warning  = new Alert(AlertType.WARNING);
		warning.setTitle("warning창");
		warning.setHeaderText("warning 제목");
		warning.setContentText("warning 내용");
		warning.show();
		
		Alert custom  = new Alert(AlertType.WARNING);
		custom.setTitle("warning창");
		custom.setHeaderText("warning 제목");
		custom.setContentText("warning 내용");
		custom.show();
		Label label = new Label("구체적 경고 내용");
		TextArea textArea = new TextArea("경고 경고 내용 블라블라블라");
		textArea.setEditable(false);
		textArea.setWrapText(true);
		textArea.setMaxHeight(Double.MAX_VALUE);
		textArea.setMaxWidth(Double.MAX_VALUE);
		
		GridPane.setVgrow(textArea, Priority.ALWAYS);
		GridPane.setHgrow(textArea, Priority.ALWAYS);
		
		GridPane gridPane =new GridPane();
		gridPane.setMaxWidth(Double.MAX_VALUE);
		gridPane.add(label, 0,0);
		gridPane.add(textArea, 0,1);
		
		custom.getDialogPane().setExpandableContent(gridPane);
		custom.show();
		
		
		Alert confirmation  = new Alert(AlertType.CONFIRMATION);
		confirmation.setTitle("선택창");
		confirmation.setHeaderText("선택 제목");
		confirmation.setContentText("선택내용");
		
		Optional<ButtonType> res = confirmation.showAndWait();
		//System.out.println(res.get());
		if(res.get()==ButtonType.OK) {
			System.out.println("확인 클릭창");
		}else {
			System.out.println("취소 클릭창");
			
		}
		
		//confirmation.show(); show 하지 말것
		TextInputDialog textD = new TextInputDialog();
		textD.setTitle("입력창");
		textD.setHeaderText("입력창 제목");
		textD.setContentText("입력: ");
		Optional<String> res2 = textD.showAndWait();
		res2.ifPresent(str->System.out.println("입력창 내용: "+str));
		
		//파일선택
		FileChooser fc = new FileChooser();
		 //파일을 업로드할때나 가져올때 경로를 미리 지정해줄 수 있다.
		fc.getExtensionFilters().addAll(
				new FileChooser.ExtensionFilter("img","*.jpg","*.png","*.gif","*.jpeg")
				);
		
		fc.setInitialDirectory(new File("\\leehyejeong\\study\\guiProj\\ppp"));
		File res3 = fc.showOpenDialog(primaryStage);
		if(res3 != null)
			System.out.println(res3.getName());
		
		//폴더선택 운영체제에 상관없이 자바에서 지원해주는것이므로 맥북에서도 사용이 가능하다.
		DirectoryChooser dc = new DirectoryChooser();  
	
		///현재 프로젝트가 위치한 드라이브가 root임 ex)E:\
		dc.setInitialDirectory(new File("\\leehyejeong\\study\\guiProj\\ppp"));
		File res4 = dc.showDialog(primaryStage);
		if(res4 != null) 
			System.out.println(res4.getPath());
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		launch(args);
	}

}
