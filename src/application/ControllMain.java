package application;

import java.net.URL;
import java.util.Observable;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.stage.Stage;

public class ControllMain extends Application implements Initializable {
	@FXML CheckBox checkBox;
	@FXML RadioButton genM;
	@FXML RadioButton genF;
	@FXML ComboBox email;
	@FXML Slider zoom;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		
		// checkBox ----------------------------------------------
		checkBox.setSelected(false);
		checkBox.setOnAction(ee->{	
			CheckBox box = (CheckBox)ee.getSource();
			
			System.out.println("checkbox: " + checkBox.isSelected() + "," + box.getText());
		});

		// Radio button ===================================================
		EventHandler handler = ee->{	
			RadioButton rb = (RadioButton)ee.getSource();
			
			System.out.println("성별: " + rb.getText());
		};
		
		genM.setOnAction(handler);
		genF.setOnAction(handler);
		
		// comboBox ----------------------------------
		
		ObservableList<String> emailData = 
				FXCollections.observableArrayList("구글","네이버","다음","줌");
		email.setItems(emailData);
		
		email.setValue(emailData.get(1)); //초기값을 지정해준다.
		
//		email.setOnAction(ee->{
//			 ComboBox box = ( ComboBox)ee.getSource();
//			System.out.println("email: " + box.getValue());
//		});
		
//		email.getSelectionModel().
//		selectedItemProperty().addListener(new ChangeListener<String>(){
//
//			@Override
//			public void changed(
//					ObservableValue<? extends String> observable, 
//					String oldValue, 
//					String newValue) {
//				// TODO Auto-generated method stub
//				System.out.println(oldValue+"->"+newValue);
//				
//			}
//		});
		
		email.getSelectionModel().
		selectedItemProperty().addListener((
				observable, 
				oldValue, 
			    newValue)->{
			    	System.out.println("email: " + oldValue+"->"+newValue);
			    });
		
		//slider--------------------------------
		zoom.valueProperty().addListener((
				observable, 
				oldValue, 
			    newValue)->{
			    	System.out.println("zoom: " + oldValue+"->"+newValue);
			    });
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
		Parent parent = FXMLLoader.load(getClass().getResource("control.fxml")); //fxml불러옴.
		Scene scene = new Scene(parent);
	
		primaryStage.setScene(scene);
		primaryStage.show();


	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);

	}



}
