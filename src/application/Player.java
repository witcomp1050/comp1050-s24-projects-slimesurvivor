package application;

import javafx.scene.image.Image;

public class Player extends Character{
	
<<<<<<< Updated upstream
	final int MAX_ITEMS = 4;
	final int REWARD_NUM = 3;
	
	private boolean maxItems = false;
	private Items[] items = new Items[MAX_ITEMS];
	private int exp = 0;
	private int expNeeded = 30;
	
	//Getters
	
	//Setters
		
	//Other methods	
=======
	Item[] items = new Item[4];
	int exp = 0;
	int expNeeded = 30;
	
	
	public Player(int x, int y, String ID, Image png, int health, int moveSpeed, int exp, int expNeeded) {
		super(x, y, ID, png, health, moveSpeed);
		this.exp = exp;
		this.expNeeded = expNeeded;
	}
>>>>>>> Stashed changes
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
			setReward();
		}
	}
	
	public void getItem(Items i) {
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
		Items[] rewardOptions = new Items[REWARD_NUM];
		for(int i)
	}
	
	private void setReward() {
		Items[] rewardOptions = new Items[REWARD_NUM];
		for(int i = 0; i < items.length; i++) {
			rewardOptions[i] = items[(int)(MAX_ITEMS * Math.Random())]
		}
	}
}
