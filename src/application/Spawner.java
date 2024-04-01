package application;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.util.Random;

public class Spawner {

	Pane pane;
	public int numOfEnemies = 5;
	Spawner(Pane mapPane){
		this.pane = mapPane;
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
	public Enemy spawnEnemy(int id){
		Image e = new Image("file:sprites/red-slime-pixilart.png");
		if(getRandomNumber(1, 3) == 1) {
			Enemy en = new Enemy(randomXHor(), randomYHor(), id, e, 100, 0);
			return en;
		}else {
			Enemy en = new Enemy(randomXVer(), randomYVer(), id, e, 100, 0);
			return en;
		}
		
	}
}
