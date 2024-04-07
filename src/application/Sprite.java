package application;

import java.util.ArrayList;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class Sprite extends ImageView{

	private int ID;
	protected double x;
	protected double y;
	protected double height;
	protected double width;
  
	//Constructors
  
	Sprite(){
		setX(0);
		setY(0);
		this.ID = 0;
	}
	
	Sprite(int ID, Image png){
		setImage(png);
		setX(0);
		setY(0);
		this.ID = ID;
		width = getImage().getWidth();
		height = getImage().getHeight();
	}
  
	Sprite(int x, int y, int ID, Image png){
		this.x = x;
		this.y = y;
		setImage(png);
		setX(x);
		setY(y);
		this.ID = ID;
		width = getImage().getWidth();
		height = getImage().getHeight();
	}
	
//	getters
	int getID() {
		return ID;
	}
	
//	Setters
	void changeX(double x) {
		setX(getX() + x);
	}
	void changeY(double y) {
		setY(getY() + y);
	}
	void setID(int id) {
		ID = id;
	}
	
//	Other methods
	boolean hasCollisionWithSprite(Sprite target) {
		if(this.getBoundsInParent().intersects(target.getBoundsInParent())){
			return true;
		}
		else {
			return false;
		}
	}
	boolean hasCollisionWithEnvObj(ImageView target) {
		if(this.getBoundsInParent().intersects(target.getBoundsInParent())){
			return true;
		}
		else {
			return false;
		}
	}
	
	@Override
	public String toString() {
		return Integer.toString(ID);
  }
  
	int hasCollisionWithEnemies(ArrayList<Enemy> targets) {
		for(int i=0; i<targets.size(); i++) {
			if(this.getBoundsInParent().intersects(targets.get(i).getBoundsInParent())){
				return i;
			}
		}
		return -1;
	}
}