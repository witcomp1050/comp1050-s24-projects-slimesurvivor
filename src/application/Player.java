package application;

import java.util.HashSet;
import java.util.Set;

import javafx.scene.image.Image;

public class Player extends Character{
	
	final int MAX_ITEMS = 4;
	final int REWARD_NUM = 3;
	
	private boolean maxItems = false;
	private Item[] heldItems = new Item[MAX_ITEMS];
	private int exp = 0;
	private int expNeeded = 30;
	
	//Create all items/weapons
	Item sword;
	Item hammer;
	Item axe;
	Item staff;
	Item glove;
	Item mace;
	
	Item[] ALL_ITEMS = {sword, hammer, axe, staff, glove, mace};
	
	//Constructors
	public Player(int xPos, int yPos, String id, Image img) {
		setX(xPos);
		setY(yPos);
		setID(id);
		setImage(img);
	}
	
	public Player() {
		this(0, 0, null, null);
	}
	
	//Getters
	
	//Setters
	  
  
	//Other methods		
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
			HashSet<Item> reward = randReward();
		}
		else {
			HashSet<Item> reward = setReward();
		}
		//Call method to bring up menu with the "reward"
		//hashset of items as reward options
		
		//When the item in the menu is clicked, the below
		//"getItem" method should be called with the chosen item
		//as the input parameter
	}
	
	public void getItem(Item i) {
		if(!maxItems) {
			for(int j = 0; j < heldItems.length; j++) {
				if(heldItems[j].equals(null)) {
					heldItems[j] = i;
					break;
				}
			}
		}
	}
	
	private HashSet<Item> randReward() {
		HashSet<Item> rewardOptions = new HashSet<Item>();
		while(rewardOptions.size() < REWARD_NUM) {
			rewardOptions.add(ALL_ITEMS[(int)((ALL_ITEMS.length - 1) * Math.random())]);
		}
		return rewardOptions;
	}
	
	private HashSet<Item> setReward() {
		HashSet<Item> rewardOptions = new HashSet<Item>();
		while(rewardOptions.size() < REWARD_NUM) {
			rewardOptions.add(heldItems[(int)((MAX_ITEMS - 1) * Math.random())]);
		}
		return rewardOptions;
	}
}