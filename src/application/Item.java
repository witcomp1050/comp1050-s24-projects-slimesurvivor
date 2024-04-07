package application;

import javafx.scene.image.Image;

import java.util.ArrayList;


public class Item extends Sprite {
	
	private String name;
	private String description;
	private int damage;
	private int moveSpeed;
	private int[][] movement;
	private int moveStep = 0;
	private Player player;
	private int level = 1;
	
	private final double UPGRADE_RATE = 1.4;
	
	Item(String name, String description, int damage, int moveSpeed, int[][] movement, Image img, Player p) {
		this.name = name;
		this.description = description;
		this.damage = damage;
		this.moveSpeed = moveSpeed;
		this.movement = movement;
		setImage(img);
		player = p;
		width = getImage().getWidth();
		height = getImage().getHeight();
	}
	
	//Getters
	public String getName() {
		return name;
	}

	public String getDescription() {
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
	public int getLevel() {
		return level;
	}
	
	//Setters
	public void setValue(int damage) {
		this.damage = damage;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setMoveSpeed(int moveSpeed) {
		this.moveSpeed = moveSpeed;
	}
	
	//Other methods
	public void upgrade() {
		damage = (int)(damage * UPGRADE_RATE);
		level++;
	}
	
	public void hitEnemies(ArrayList<Enemy> enemyList) {
		for(int i=0; i<enemyList.size(); i++) {
			if(this.hasCollisionWithSprite(enemyList.get(i))) {
				enemyList.get(i).setHealth(enemyList.get(i).getHealth() - damage);
			}
		}
	}
	
	public void move() {
		
		int[] playerPos = {(int)player.getX() + (int)(0.3 * player.width), (int)player.getY() + (int)(0.3 * player.height)};
		int[] currentPos = {(int) getX(), (int) getY()};
		int[] nextPos = {playerPos[0] + getPair((moveStep + 1) % getMoveSequenceLength())[0], playerPos[1] + getPair((moveStep + 1) % getMoveSequenceLength())[1]};
			
		for(int i = 0; i < 2; i++) {
			if(currentPos[i] < nextPos[i]) {
				currentPos[i] += moveSpeed;
			}
			else if(currentPos[i] > nextPos[i]) {
				currentPos[i] -= moveSpeed;
			}
		}
		
		boolean xAligned = (currentPos[0] > nextPos[0] - (moveSpeed / 2 + 1) && currentPos[0] < nextPos[0] + (moveSpeed / 2 + 1));
		boolean yAligned = (currentPos[1] > nextPos[1] - (moveSpeed / 2 + 1) && currentPos[1] < nextPos[1] + (moveSpeed / 2 + 1));
		
		if(xAligned && yAligned) {
			if(moveStep == getMoveSequenceLength() - 1) {
				moveStep = 0;
			}
			else {
				moveStep++;
			}
		}
				
		setX(currentPos[0]);
		setY(currentPos[1]);
	}

}