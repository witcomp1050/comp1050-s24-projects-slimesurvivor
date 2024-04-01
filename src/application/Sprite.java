package application;

import java.util.ArrayList;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class Sprite extends ImageView{

	private int ID;
	private Image png;
	protected double x;
	protected double y;
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
		this.setPng(png);
	}
	Sprite(int x, int y, int ID, Image png){
		this.setPng(png);
		this.x = x;
		this.y = y;
		setImage(png);
		setX(x);
		setY(y);
		this.ID = ID;
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
	double getHeight() {
		double i = getViewport().getHeight();
		return i;
	}
	double getWidth() {
		double i = getViewport().getWidth();
		return i;
	}
	boolean hasCollisionWith(Sprite target) {
		if(this.getBoundsInParent().intersects(target.getBoundsInParent())){
			return true;
		}
		else {
			return false;
		}
	}
	int hasCollisionWith(ArrayList<Enemy> targets) {
		for(int i=0; i<targets.size(); i++) {
			if(this.getBoundsInParent().intersects(targets.get(i).getBoundsInParent())){
				return i;
			}
		}
		return -1;
	}

	public Image getPng() {
		return png;
	}

	public void setPng(Image png) {
		this.png = png;
	}

}
