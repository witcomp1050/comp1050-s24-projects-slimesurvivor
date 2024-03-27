package application;

import javafx.scene.image.Image;

public class Enemy extends Character{
	public Enemy(int x, int y, String ID, Image png, int health, int moveSpeed) {
		// TODO Auto-generated constructor stub
		super(x, y, ID, png, health, moveSpeed);
	}
	public void follow(Player p) {
		if(this.getX() > p.getX()) {
			this.changeX(-1);
		}else {
			this.changeX(1);
		}
		if(this.getY() > p.getY()) {
			this.changeY(-1);
		}else {
			this.changeY(1);
		}
	}
	

}
