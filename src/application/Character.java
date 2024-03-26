package application;

import javafx.scene.image.Image;

public class Character extends Sprite {
	
	private int health;
	private int moveSpeed;
	
	//Constructors
	public Character() {
		health = 10;
		moveSpeed = 5;
	}
	public Character(int x, int y, String ID, Image png, int health, int moveSpeed) {
		super(x, y, ID, png);
		this.health = health;
		this.moveSpeed = moveSpeed;
		
	}
	
	//Getters
	public int getHealth(){
		return health;
	}
	
	public int getMoveSpeed(){
		return moveSpeed;
	}
	
	//Setters
	public void setHealth(int h) {
		health = h;
	}
	
	public void setMoveSpeed(int m) {
		moveSpeed = m;
	}
}
