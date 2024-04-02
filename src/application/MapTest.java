package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class MapTest implements Initializable{

	 @FXML
	 private ImageView MapImage;

	 @FXML
	 private Pane MapPane;
    
	 @FXML
	 private ImageView MapImage1;
	 
	 @FXML
	 private Label timerLabel;
	 
	 private int sec =0;
	 private int min =0;
	 public static String time = "";
	 private int frame = 0;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		Image p1Image = new Image("file:sprites/clyde-pixilart.png");
	    Player p1 = new Player(500, 500, 1, p1Image);
	    MapPane.getChildren().add(p1);
	    Spawner spawner = new Spawner(MapPane);
	    KeyHandler controller = new KeyHandler();
	    ArrayList<Enemy> listOfEnemies = new ArrayList<Enemy>();
	    spawner.changeNumOfEnemies(10);
	    AnimationTimer Animationtimer = new AnimationTimer() {
			@Override
			public void handle(long now) {
				if(frame == 60) {
					updateTime(p1);
					frame = 0;
				}
				frame++;
				double[] contInput = controller.listen(viewSwitcher.scene);
				p1.changeX(contInput[0], MapPane);
				p1.changeY(contInput[1], MapPane);
				if(listOfEnemies.isEmpty()) {
					for(int i=0; i<spawner.getNumOfEnemies();i++) {
						listOfEnemies.add(spawner.spawnEnemy(i));
						MapPane.getChildren().add(listOfEnemies.get(i));
					}
					spawner.changeNumOfEnemies((int) (spawner.getNumOfEnemies()*2));
				}
				for(int j=0; j<listOfEnemies.size();j++) {
					Enemy currentEnemy = listOfEnemies.get(j);
					if(currentEnemy.getHealth()<0) {
						listOfEnemies.remove(j);
					}
					currentEnemy.follow(p1,listOfEnemies);
					if(currentEnemy.hasCollisionWith(p1)) {
						p1.setHealth(p1.getHealth()-1);
						if(p1.getHealth()<=0) {
							this.stop();
							viewSwitcher.switchTo(View.ENDSCREEN);
						}
					}
				}
			}
		};
		Animationtimer.start();
	}
	public void updateTime(Player p) {
		sec++;
		if(sec == 60) {
			min++;
			sec = 0;
			if(min == 60) {
				min =0;
			}
		}
		String minStr = "";
		String secStr = "";
		if(min > 10) {
			minStr+=min;
		}else {
			minStr ="0"+min;
		}
		if(sec > 10) {
			secStr+=sec;
		}else {
			secStr ="0"+sec;
		}
		time = minStr+":"+secStr;
		timerLabel.setText(time);
		p.setHealth(p.getHealth()+1);
	}
	public static String getTimeStr() {
		return time;
	}
}

