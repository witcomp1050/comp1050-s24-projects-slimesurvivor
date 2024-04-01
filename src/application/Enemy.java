package application;

import java.util.ArrayList;

import javafx.scene.image.Image;

public class Enemy extends Character{
	public Enemy(int x, int y, int ID, Image png, int health, int moveSpeed) {
		// TODO Auto-generated constructor stub
		super(x, y, ID, png, health, moveSpeed);
	}
	public void follow(Player p, ArrayList<Enemy> targets) {
		if(this.hasCollisionWith(targets) == -1) {
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
		//get target it has collision with and move it closer to player.
		else {
			targets.get(this.hasCollisionWith(targets)).follow(p);
		}
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
