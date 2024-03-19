package application;

public abstract class Character extends Sprite {
	
	private int health = 10;
	private int damage = 1;
	private int moveSpeed = 5;
	
	
	//Getters
	public int getHealth(){
		return health;
	}
	
	public int getDamage(){
		return damage;
	}
	
	public int getMoveSpeed(){
		return moveSpeed;
	}
	
	//Setters
	public void setHealth(int h) {
		health = h;
	}
	
	public void setDamage(int d) {
		damage = d;
	}
	
	public void setMoveSpeed(int m) {
		moveSpeed = m;
	}
}
