package application;

import java.util.ArrayList;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Enemy extends Character{
	public Enemy(int x, int y, int ID, Image png, int health, int moveSpeed) {
		// TODO Auto-generated constructor stub
		super(x, y, ID, png, health, moveSpeed);
	}
	public void follow(Player p, ArrayList<Enemy> targets, ArrayList<ImageView> env) {
		int x = 0;
		int y = 0;
		if(this.hasCollisionWithEnemies(targets) == -1) {
			if(this.getX()>p.getX()) {
				x = -1;
			}
			else if(this.getX()<p.getX()){
				x = 1;
			}
			if(this.getY()>p.getY()) {
				y = -1;
			}
			else if(this.getY()<p.getY()){
				y = 1;
			}
			
			this.changeX(x);
			if(this.hasCollisionWithEnv(env)) {
				this.changeX(-x);
			}
			if(this.hasCollisionWithEnemies(targets)>-1 && this.hasCollisionWithEnv(env)) {
				this.changeX(-20*x);
			}
			
			this.changeY(y);
			if(this.hasCollisionWithEnv(env)) {
				this.changeY(-y);
			}
			if(this.hasCollisionWithEnemies(targets)>-1 && this.hasCollisionWithEnv(env)) {
				this.changeY(-20*y);
			}
			
			
		}
		//get target it has collision with and move it closer to player.
		else {
			targets.get(this.hasCollisionWithEnemies(targets)).follow(p, env);
		}
	}
	
	
	public void follow(Player p, ArrayList<ImageView> env) {
		if(this.getX() > p.getX()) {
			this.changeX(-1);
			if(hasCollisionWithEnv(env)) {
				this.changeX(1);
			}
		}else {
			this.changeX(1);
			if(hasCollisionWithEnv(env)) {
				this.changeX(-1);
			}
		}
		if(this.getY() > p.getY()) {
			this.changeY(-1);
			if(hasCollisionWithEnv(env)) {
				this.changeY(1);
			}
		}else {
			this.changeY(1);
			if(hasCollisionWithEnv(env)) {
				this.changeY(-1);
			}
		}
	}
	

}
