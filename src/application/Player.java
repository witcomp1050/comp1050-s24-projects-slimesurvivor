package application;

import java.util.ArrayList;
import java.util.HashSet;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class Player extends Character{
	
	final int MAX_ITEMS = 3;
	final int REWARD_NUM = 3;
	final int WEAPON_RANGE = 60;
	public final int MAX_HEALTH = 120;
	
	private boolean maxItems = false;
	private Item[] heldItems = new Item[MAX_ITEMS];
	private int exp = 30;
	private int expNeeded = 30;
	private Pane pane;
	boolean levelUp = false;
	
	//Create all items/weapons
	Item sword = new Item("Sword", "A sword that swings left and right.", 20, 4, new int[][] {{-WEAPON_RANGE,0},{WEAPON_RANGE,0}}, new Image("file:sprites/sword.png"), this);
	Item hammer = new Item("Hammer", "A hammer that swings in an arc above the player.", 30, 2, new int[][] {{-WEAPON_RANGE,(int)-(0.2*WEAPON_RANGE)},{0,(int) -(1.2*WEAPON_RANGE)},{WEAPON_RANGE,(int) -(0.2*WEAPON_RANGE)},{0,(int) -(1.2*WEAPON_RANGE)}}, new Image("file:sprites/hammer.png"), this);
	Item axe = new Item("Axe", "An axe that attacks vertically.", 20, 2, new int[][] {{0,-WEAPON_RANGE},{0,WEAPON_RANGE}}, new Image("file:sprites/axe.png"), this);
	Item mace = new Item("Mace", "A mace that swings counterclockwise around the player.", 10, 4, new int[][] {{(int) (0.5*WEAPON_RANGE),WEAPON_RANGE},{(int) (-0.5*WEAPON_RANGE),WEAPON_RANGE},{-WEAPON_RANGE,(int) (0.5*WEAPON_RANGE)},{-WEAPON_RANGE,(int) (-0.5*WEAPON_RANGE)},{(int) (-0.5*WEAPON_RANGE),-WEAPON_RANGE},{(int) (0.5*WEAPON_RANGE),-WEAPON_RANGE},{WEAPON_RANGE,(int) (-0.5*WEAPON_RANGE)},{WEAPON_RANGE,(int) (0.5*WEAPON_RANGE)}}, new Image("file:sprites/mace.png"), this);
	Item staff = new Item("Staff", "A staff that swings clockwise around the player.", 10, 4, new int[][] {{WEAPON_RANGE,(int) (0.5*WEAPON_RANGE)},{WEAPON_RANGE,(int) (-0.5*WEAPON_RANGE)},{(int) (0.5*WEAPON_RANGE),-WEAPON_RANGE},{(int) (-0.5*WEAPON_RANGE),-WEAPON_RANGE},{-WEAPON_RANGE,(int) (-0.5*WEAPON_RANGE)},{-WEAPON_RANGE,(int) (0.5*WEAPON_RANGE)},{(int) (-0.5*WEAPON_RANGE),WEAPON_RANGE},{(int) (0.5*WEAPON_RANGE),WEAPON_RANGE}}, new Image("file:sprites/staff.png"), this);

	
	
	public final Item[] ALL_ITEMS = {sword, hammer, axe, mace, staff};
	
	//Constructors
	public Player(int xPos, int yPos, int id, Image img, Pane p) {
		setX(xPos);
		setY(yPos);
		setID(id);
		setImage(img);
		this.pane = p;
		width = getImage().getWidth();
		height = getImage().getHeight();
		setHealth(MAX_HEALTH);
		setHealth(120);
	}
	
	//Getters
	public int getExp() {
		return this.exp;
	}
	
	public int getNeededExp() {
		return this.expNeeded;
	}
	//Setters
	
	//Other methods		
	void changeX(double x, ArrayList<ImageView> envObj) {
		if(!(getX()+x < 0)&&!(getX()+x > pane.getWidth()-width)) {
			changeX(x);
			for(int i = 0; i < heldItems.length; i++) {
				if(this.heldItems[i] != null && x != 0) {
					heldItems[i].changeX(x);
				}
			}
			if(this.hasCollisionWithEnv(envObj)){
				changeX(-x);
				for(int i = 0; i < heldItems.length; i++) {
					if(this.heldItems[i] != null && x != 0) {
						heldItems[i].changeX(- x);
					}
				}
			}
		}
	}
	
	void changeY(double y, ArrayList<ImageView> envObj) {
		if(!(getY()+y < 0)&&!(getY()+y > pane.getHeight()-height)) {
			changeY(y);
			for(int i = 0; i < heldItems.length; i++) {
				if(this.heldItems[i] != null && y != 0) {
					heldItems[i].changeY(y);
				}
			}
			if(hasCollisionWithEnv(envObj)) {
				changeY(-y);
				for(int i = 0; i < heldItems.length; i++) {
					if(this.heldItems[i] != null && y != 0) {
						heldItems[i].changeY(-y);
					}
				}
			}
		}
	}
	
  
	public void takeDmg(int dmg){
		setHealth(getHealth() - dmg);
	}
	
	public void addExp(int amt) {
		exp += amt;
		if(exp >= expNeeded) {
			levelUp = true;
		}
	}
	
	public Item[] lvlUp(int extra) {
		exp = extra;
		expNeeded = (int) (1.2 * expNeeded);
		
		HashSet<Item> reward = new HashSet<Item>();
		
		if(!maxItems) {
			reward = randReward();
		}
		else {
			reward = setReward();
		}
		levelUp = false;
		
		Item[] arr = new Item[reward.size()];
        int i = 0;
        for (Item item : reward) {
            arr[i++] = item;
        }
		
		return arr;
	}

	public void getItem(Item i, ImageView i1, ImageView i2, ImageView i3, Text t1, Text t2, Text t3) {
		for(int j = 0; j < heldItems.length; j++) {
			if(heldItems[j] != null) {
				if(heldItems[j].equals(i)) {
					heldItems[j].upgrade();
					
					if(j == 0) {
						t1.setText(Integer.toString(i.getLevel()));
						break;
					}
					if(j == 1) {
						t2.setText(Integer.toString(i.getLevel()));
						break;
					}
					if(j == 2) {
						t3.setText(Integer.toString(i.getLevel()));
						break;
					}
				}
			}
			if(heldItems[j] == null) {
				heldItems[j] = i;
				pane.getChildren().add(i);
				heldItems[j].setX(getX());
				heldItems[j].setY(getY());				
				
				if(j == 0) {
					i1.setImage(i.getImage());
					t1.setText(Integer.toString(i.getLevel()));
					break;
				}
				if(j == 1) {
					i2.setImage(i.getImage());
					t2.setText(Integer.toString(i.getLevel()));
					break;
				}
				if(j == 2) {
					i3.setImage(i.getImage());
					t3.setText(Integer.toString(i.getLevel()));
					break;
				}
			}
		}
	}
	
	public void animateItems() {
		for(int j = 0; j < heldItems.length; j++) {
			if(this.heldItems[j] != null) {
				heldItems[j].move();
			}
		}
	}
	
	public void attack(ArrayList<Enemy> enemyList) {
		for(int j = 0; j < heldItems.length; j++) {
			if(this.heldItems[j] != null) {
				heldItems[j].hitEnemies(enemyList);
			}
		}
	}
	private HashSet<Item> randReward() {
		HashSet<Item> rewardOptions = new HashSet<Item>();
		while(rewardOptions.size() < REWARD_NUM) {
			rewardOptions.add(ALL_ITEMS[(int)(ALL_ITEMS.length * Math.random())]);
		}
		return rewardOptions;
	}
	
	private HashSet<Item> setReward() {
		HashSet<Item> rewardOptions = new HashSet<Item>();
		while(rewardOptions.size() < REWARD_NUM) {
			rewardOptions.add(heldItems[(int)(MAX_ITEMS * Math.random())]);
		}
		return rewardOptions;
	}
}