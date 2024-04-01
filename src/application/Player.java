package application;

import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

public class Player extends Character{
	
	final int MAX_ITEMS = 4;
	final int REWARD_NUM = 3;
	private Image png;
	private boolean maxItems = false;
	private Item[] items = new Item[MAX_ITEMS];
	private int exp = 0;
	private int expNeeded = 30;
	
	//Getters
	
	//Setters
		
	void changeX(double x, Pane pane) {
		if(!(getX()+x < 0)&&!(getX()+x > pane.getWidth()-png.getWidth())) {
			setX(getX() + x);
		}
	}
	
	void changeY(double y, Pane pane) {
		if(!(getY()+y < 0)&&!(getY()+y > pane.getHeight()-png.getHeight())) {
			setY(getY() + y);
		}
	}
	
	public Player(int x, int y, int ID, Image png, int health, int moveSpeed, int exp, int expNeeded) {
		super(x, y, ID, png, health, moveSpeed);
		this.exp = exp;
		this.expNeeded = expNeeded;
		this.png = png;
	}
	public void addExp(int amt) {
		exp += amt;
		if(exp >= expNeeded) {
			lvlUp(exp - expNeeded);
		}
	}
	
	public void lvlUp(int extra) {
		exp = extra;
		expNeeded = (int) 1.2 * expNeeded;
		
		if(!maxItems) {
			randReward();
		}
		else {
			//setReward();
		}
	}
	
	public void getItem(Item i) {
		if(!maxItems) {
			for(int j = 0; j < items.length; j++) {
				if(items[j].equals(null)) {
					items[j] = i;
					break;
				}
			}
		}
	}
	
	private void randReward() {
		Item[] rewardOptions = new Item[REWARD_NUM];
	}
	
}
