package layout_p;

import java.net.URL;
import java.util.Observable;
import java.util.ResourceBundle;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;

public class ListViewController implements Initializable{
	ObservableList<String>items; //선택항목
	@FXML Label label;
	@FXML Button btn;
	@FXML ListView<String> list;
	@FXML ListView<String> price;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		//list.setItems(FXCollections.observableArrayList());
		    //새로 할 경우 ---> 생략 하면 기존정보에 추가
		
		list.getItems().add("냉면");
		list.getItems().add("칭따오");
		list.getItems().add("마파두부");
		
		price.getItems().add("7000");
		price.getItems().add("8000");
		price.getItems().add("9000");
		
		
		//shipt누르면 여러게 동시 선택이 가능하다
		//single처리
		//list.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		
		
//		list.setOnMouseClicked(mm->{
//			Object obj = list.getSelectionModel().getSelectedItem();
//			label.setText(obj.toString());
//		});
		
//		list.getSelectionModel().selectedItemProperty().addListener(
//				(obb, oldV, newV)->{label.setText(oldV +"->"+newV);
//		});
		
		
		//MULTIPLE처리
		list.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		list.setOnMouseClicked(mm->{
			items = list.getSelectionModel().getSelectedItems();
			for (String str : items) {
				System.out.println(str);
				price.getItems().add(str);
			}
			list.getItems().removeAll(items); //선택삭제
		});
		
		
		price.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		price.setOnMouseClicked(mm->{
			items = price.getSelectionModel().getSelectedItems();
			for (String str : items) {
				list.getItems().add(str);
			}
			price.getItems().removeAll(items);
		});
		
		
		
		//삭제
		btn.setOnAction(ee->{
			if(items !=null) {
				for (String str : items) {
					
					list.getItems().remove(str); //선택삭제
					}				
			}
			
		});
	}

}
