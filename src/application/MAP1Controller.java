package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


public class MAP1Controller implements Initializable{

	@FXML
	private Text item1Level;
	
	@FXML
	private Text item2Level;
	
	@FXML
	private Text item3Level;
	
	@FXML
	private ImageView item1Inv;
	
	@FXML
	private ImageView item2Inv;
	
	@FXML
	private ImageView item3Inv;
	
    @FXML
    private ProgressBar healthBar;
    
    @FXML
    private ProgressBar expBar;

    @FXML
    private Pane MapPane;

    @FXML
    private Button item1But;

    @FXML
    private Text item1Desc;

    @FXML
    private ImageView item1Img;

    @FXML
    private Button item2But;

    @FXML
    private Text item2Desc;

    @FXML
    private ImageView item2Img;

    @FXML
    private Button item3But;

    @FXML
    private Text item3Desc;

    @FXML
    private ImageView item3Img;

    @FXML
    private Pane itemPane;

    @FXML
    private ImageView river1;

    @FXML
    private ImageView river2;

    @FXML
    private ImageView river3;

    @FXML
    private ImageView river4;

    @FXML
    private ImageView river5;

    @FXML
    private ImageView river6;

    @FXML
    private ImageView river7;
    
    @FXML
    private ImageView river8;

    @FXML
    private Label timerLabel;
    
	public static String timeText = "";
	private int frame = 0;
	private Player p1;
	private AnimationTimer Animationtimer;
	private Item[] rewardOptions = {null, null, null};
	private Spawner spawner;
	@Override

	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		Font font = Font.loadFont(getClass().getResourceAsStream("SlimeFont.ttf"), 24);
		ArrayList<ImageView> env = new ArrayList<ImageView>(Arrays.asList(river1,river2,river3,river4,river5,river6,river7,river8));
		Image p1Image = new Image("file:sprites/clyde-pixilart.png");
		p1 = new Player(400, 500, 1, p1Image, MapPane);
		MapPane.getChildren().add(p1);
		itemPane.setVisible(false);
		itemPane.setViewOrder(-1);
		lvlUpMenu();		
	    spawner = new Spawner(MapPane, p1);
	    KeyHandler controller = new KeyHandler();
	    spawner.changeNumOfEnemies(5);
	    Animationtimer = new AnimationTimer() {
			@Override
			public void handle(long now) {
					if(frame == 60) {
						updateTime(p1, font);
						p1.setHealth(p1.getHealth() + 1);
						frame = 0;
					}
					if(frame % 2 == 0) {
					}
					p1.attack(spawner.EnemyList);
					frame++;
					
					double[] contInput = controller.listen(viewSwitcher.scene);
					p1.changeX(contInput[0], env);
					p1.changeY(contInput[1], env);
					
					p1.animateItems();
					p1.attack(spawner.EnemyList);
					
					healthBar.setProgress((double)p1.getHealth()/p1.MAX_HEALTH);
					expBar.setProgress((double) p1.getExp()/p1.getNeededExp());
					spawner.spawnEnemy(env);
					if(p1.getHealth()<=0) {
						this.stop();
						updateHS();
						viewSwitcher.switchTo(View.MAP1ENDSCREEN);
					}
					if(p1.levelUp) {
						this.stop();
						lvlUpMenu();
					}
				}
		};
	}
	
	private void lvlUpMenu() {
		itemPane.setVisible(true);
		rewardOptions = p1.lvlUp(p1.getExp() - p1.getNeededExp());
		
		item1Img.setImage(rewardOptions[0].getImage());
		item2Img.setImage(rewardOptions[1].getImage());
		item3Img.setImage(rewardOptions[2].getImage());
		
		item1Desc.setText(rewardOptions[0].getDescription());
		item2Desc.setText(rewardOptions[1].getDescription());
		item3Desc.setText(rewardOptions[2].getDescription());
	}
	
	public void updateTime(Player p, Font f) {
		timeText = "WAVE" + Integer.toString(spawner.getWave());
		timerLabel.setFont(f);
		timerLabel.setText(timeText);
		p.setHealth(p.getHealth()+1);
	}
	private void updateHS() {
		int HS = 0;
		File file = new File("map1HS.txt");
		Scanner fileReader = null;
		try {
			fileReader = new Scanner(file);
			HS = fileReader.nextInt();
			if(HS < spawner.getWave()) {
				try {
					PrintWriter fileWriter = new PrintWriter(file);
					fileWriter.print(spawner.getWave());
					fileWriter.close();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

    @FXML
    void selectItem1(ActionEvent event) {
    	itemPane.setVisible(false);
    	p1.levelUp = false;
    	p1.getItem(rewardOptions[0], item1Inv, item2Inv, item3Inv, item1Level, item2Level, item3Level);
    	Animationtimer.start();
    }

    @FXML
    void selectItem2(ActionEvent event) {
    	itemPane.setVisible(false);
    	p1.levelUp = false;
    	p1.getItem(rewardOptions[1], item1Inv, item2Inv, item3Inv, item1Level, item2Level, item3Level);
    	Animationtimer.start();
    }

    @FXML
    void selectItem3(ActionEvent event) {
    	itemPane.setVisible(false);
    	p1.levelUp = false;
    	p1.getItem(rewardOptions[2], item1Inv, item2Inv, item3Inv, item1Level, item2Level, item3Level);
    	Animationtimer.start();

    }
}


