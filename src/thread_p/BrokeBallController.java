package thread_p;


import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class BrokeBallController implements Initializable {
	
	@FXML AnchorPane totalP;
	@FXML Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15;
	@FXML Pane pp,ba,bb,oo;
	@FXML Rectangle bar;
	@FXML Circle ball;

	List<Button> list= new ArrayList<>();
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		Timer timer = new Timer();
		timer.setDaemon(true);
		timer.start();
		list.add(b1); 	list.add(b2);	list.add(b3);	list.add(b4); 	list.add(b5);
		list.add(b6); 	list.add(b7);	list.add(b8);	list.add(b9); 	list.add(b10);
		list.add(b11); 	list.add(b12);	list.add(b13);	list.add(b14); 	list.add(b15);
		
		totalP.addEventHandler(KeyEvent.KEY_PRESSED, 
				new EventHandler<KeyEvent>() {

					@Override
					public void handle(KeyEvent key) {
						// TODO Auto-generated method stub
						//System.out.println(key.getCode());
						
						
						if(key.getCode()==KeyCode.LEFT) {
							double xx = ba.getLayoutX()-6;
							
							if(xx<0) xx=0;

							ba.setLayoutX(xx);
						}
						
						if(key.getCode()==KeyCode.RIGHT) {
							double xx = ba.getLayoutX()+6;
							
							if(totalP.getPrefWidth()<xx+ba.getPrefWidth()) 
								xx=totalP.getPrefWidth()-ba.getPrefWidth();
							
							
							ba.setLayoutX(xx);
						}
						
						
					}

			});
	}
	
	class Timer extends Thread{
		@Override
		public void run() {
			// TODO Auto-generated method stub
			super.run();
			while (true) {
				try {
					Platform.runLater(()->init());
					sleep(30);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
		
		int disX = 5,  disY = 5;
		void init() {
			double xx = pp.getLayoutX()+disX;
			
			if(bb.getPrefWidth()<xx+pp.getPrefWidth() ||
			    xx<0) {
				disX*=-1;
			}

			pp.setLayoutX(xx);
			
			double yy = pp.getLayoutY()+disY;
			//double max = totalP.getLayoutY()+ba.getLayoutY();
//			System.out.println("!!"+(yy+pp.getHeight()));
//			System.out.println("!"+ba.getLayoutY());
			if(yy<0||yy+pp.getHeight()>ba.getLayoutY()  &&
			ba.getLayoutX()+ba.getWidth()>pp.getWidth()+xx &&
			ba.getLayoutX()< pp.getWidth()+xx) {
				
					disY*=-1;
				
			}else {
				return ;
			}
			
			for (Button btn : list) {
				if(btn.getLayoutY()+btn.getHeight()>pp.getHeight()+yy &&
				btn.getLayoutX()+btn.getWidth()>pp.getWidth()+xx &&
				btn.getLayoutX()<pp.getWidth()+xx) {
					
					btn.setVisible(false);
					disY*=-1;
					
				}
				if(btn.isVisible()==false) {
					
					list.remove(btn);
					System.out.println(list.size());
				}
				
				if(list.size()==0) {
					disX*=0;
					disY*=0;
				}
		
			}
			


			pp.setLayoutY(yy);
		}


	

}
