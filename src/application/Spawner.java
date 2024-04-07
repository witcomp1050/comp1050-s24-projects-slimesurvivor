package application;

import java.util.ArrayList;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Spawner {
	public ArrayList<Enemy> EnemyList;
	Pane pane;
	Player player;
	public int numOfEnemies = 5;
	private int wave = 0;
	private int health = 100;
	
	Spawner(Pane mapPane, Player p){
		this.pane = mapPane;
		this.player =p;
		this.EnemyList = new ArrayList<Enemy>();
	}
	
	
	public int getNumOfEnemies() {
		return numOfEnemies;
	}
	
	
	public void changeNumOfEnemies(int num) {
		this.numOfEnemies = num;
	}
	
	
	private int randomXHor() {
		if(getRandomNumber(1,3) ==1) {
			return getRandomNumber(-100, 0);
		}
		return (int) (pane.getWidth()+100);
	}
	
	
	private int randomYVer() {
		if(getRandomNumber(1,3) ==1) {
			return getRandomNumber(-100, 0);
		}
		return (int) (pane.getHeight()+100);
	}
	
	
	private int randomYHor() {
		return getRandomNumber(-100, (int) pane.getHeight()+100);
	}
	
	
	private int randomXVer() {
		return getRandomNumber(-100, (int) pane.getWidth()+100);
	}
	
	
	private int getRandomNumber(int min, int max) {
		return (int) (Math.random() * (max-min) +min);
	}

	public void spawnEnemy(ArrayList<ImageView> env){
		Image e = new Image("file:sprites/red-slime-pixilart.png");
		if(EnemyList.isEmpty()) {
			for(int i=0; i<numOfEnemies;i++) {
				Enemy en;
				if(getRandomNumber(1, 3) == 1) {
					en = new Enemy(randomXHor(), randomYHor(), i, e, health, 0);
				}else {
					en = new Enemy(randomXVer(), randomYVer(), i, e, health, 0);
				}
				pane.getChildren().add(en);
				health*=1.2;
				EnemyList.add(en);
			}
			this.changeNumOfEnemies((int) (this.getNumOfEnemies() * 1.2));
			this.setWave(this.getWave() + 1);
		}
		for(int j=0; j<EnemyList.size();j++) {
			Enemy currentEnemy = EnemyList.get(j);
			currentEnemy.follow(player, EnemyList, env);
			if(currentEnemy.hasCollisionWithSprite(player)) {
				player.takeDmg(1);
			}
			if(currentEnemy.getHealth()<=0) {
				pane.getChildren().remove(currentEnemy);
				player.addExp(5);
				EnemyList.remove(currentEnemy);
			}
		}
	}
	
	
	public int getWave() {
		return wave;
	}
	
	
	public void setWave(int wave) {
		this.wave = wave;
	}
}

