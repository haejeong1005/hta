package page;

import java.util.ArrayList;

import javafx.scene.control.TextField;

class ExamUnit{
	String qq;
	String ans;
	public ExamUnit(String qq, String ans) {
		super();
		this.qq = qq;
		this.ans = ans;
	}
	
	
}

public class Exam {

	String title;
	
	ArrayList<ExamUnit>map;
	
	int cnt;
	
	void finish(TextField [] tf) {
		cnt=0;
		
		for (int i =0;i<tf.length; i++) {
			if(tf[i].getText().equals(map.get(i).ans))
				cnt+=25;
		}
		
		System.out.println(title+":"+cnt);
	}

	public Exam(String title, String ...str) {
		super();
		this.title = title;
		this.map = new ArrayList<>();
		
		for (String string : str) {
			String [] arr = string.split("_");
			
			map.add(new ExamUnit(arr[0], arr[1]));
		}
		
	}
	
	
}
