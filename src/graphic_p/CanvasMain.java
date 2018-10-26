package graphic_p;


import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;

public class CanvasMain extends Application implements Initializable {
	
	@FXML Canvas canvas;
	GraphicsContext gc; //�׸��� �׸��� �ְ� �����ִ� ����.

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
		Parent root = FXMLLoader.load(getClass().getResource("canvas.fxml"));
		
		Scene scene =new Scene(root);
		primaryStage.setScene(scene);

		primaryStage.show();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		launch(args);

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		Image img;
		
		
		
		gc=canvas.getGraphicsContext2D();
		gc.setStroke(Color.GREEN); //�׵θ���
		gc.strokeRect(100, 20, 130, 100);
		gc.setStroke(new Color(0, 0, 1, 0.5));
		////                  r   g  b  opacity 0~1��wl
		gc.setFill(Color.BLUE);//����
		gc.fillRect(50, 10, 200, 50);
		gc.setStroke(Color.RED);
		gc.strokeOval(50, 70, 100, 100);
		
		gc.setFill(Color.PINK);
		gc.fillRoundRect(50, 180, 200, 200, 150,200);
		
		gc.setFill(Color.GRAY);
		gc.fillArc(400,20,100,100,0,90,ArcType.CHORD); //�ȼ��� ���ݴ� �β���
		gc.fillArc(500,20,100,100,0,90,ArcType.OPEN);
		gc.fillArc(600,20,100,100,0,90,ArcType.ROUND);
		
		gc.fillArc(400,150,100,100,45,90,ArcType.ROUND); //���۰���45�� �����ִ°����� 90��
		
		gc.setStroke(Color.AQUA);
		gc.strokeArc(400,220,100,100,0,90,ArcType.CHORD); //�ȼ��� ���ݴ� �β��� ���� �������ִ� ������ �ִ�
		gc.strokeArc(500,220,100,100,0,90,ArcType.OPEN);
		gc.strokeArc(600,220,100,100,0,90,ArcType.ROUND);
		
		gc.strokeArc(400,320,100,100,45,90,ArcType.ROUND); 
		
		gc.fillPolygon
		(new double[] {450,570,650,520},
		 new double[] {470,400,560,540}, 4);
		gc.strokePolygon
		(new double[] {450,570,650,520},
		 new double[] {470,400,560,540}, 4);
		
		
		img = new Image("file:ppp/photo.png",100,200,true,true);
		gc.drawImage(img, 50, 500);
	
	}

}
