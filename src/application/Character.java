package application;

import java.util.ArrayList;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Character extends Sprite {
	
	protected int health;
	protected double moveSpeed;
	
	//Constructors
	public Character() {
		health = 10;
		moveSpeed = 5;
	}
	public Character(int x, int y, int ID, Image png, int health, double moveSpeed) {
		super(x, y, ID, png);
		this.health = health;
		this.moveSpeed = moveSpeed;
		
	}
	
	//Getters
	public int getHealth(){
		return health;
	}
	
	public double getMoveSpeed(){
		return moveSpeed;
	}
	
	//Setters
	public void setHealth(int h) {
		health = h;
	}
	
	public void setMoveSpeed(int m) {
		moveSpeed = m;
	}
	
	public boolean hasCollisionWithEnv(ArrayList<ImageView> envObj) {
		for(int i=0; i<envObj.size(); i++) {
			if(this.hasCollisionWithEnvObj(envObj.get(i))) {
				return true;
			}
		}
		return false;
	}
}
