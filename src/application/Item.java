package application;

public class Item extends Sprite {
	
	private String name;
	private String description;
	private int damage;
	private int moveSpeed;
	private int[][] movement;
	private int moveStep = 0;
	
	private final double UPGRADE_RATE = 1.4;
	
	Item(String name, String description, int damage, int moveSpeed, int[][] movement) {
		this.name = name;
		this.description = description;
		this.damage = damage;
		this.moveSpeed = moveSpeed;
		this.movement = movement;
	}
	
	//Getters
	public String getname() {
		return name;
	}

	public String getdescription() {
		return description;
	}

	public int getDamage() {
		return damage;
	}

	public int getMoveSpeed() {
		return moveSpeed;
	}
	public int[] getPair(int index)throws ArrayIndexOutOfBoundsException {
		return movement[index];
	}
	public int getMoveSequenceLength() {
		return movement.length;
	}
	
	//Setters
	public void setValue(int damage) {
		this.damage = damage;
	}

	public void setdescription(String description) {
		this.description = description;
	}

	public void setname(String name) {
		this.name = name;
	}

	public void setMoveSpeed(int moveSpeed) {
		this.moveSpeed = moveSpeed;
	}
	
	//Other methods
	public void upgrade() {
		damage = (int)(damage * UPGRADE_RATE);
	}
	
	public void move() {
		
	}

}