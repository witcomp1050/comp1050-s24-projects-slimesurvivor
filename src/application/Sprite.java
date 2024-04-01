package application;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class Sprite extends ImageView{

	private String ID;
	
	//Constructors
	Sprite(){
		setX(0);
		setY(0);
		this.ID = null;
	}
	
	Sprite(String ID, Image png){
		setImage(png);
		setX(0);
		setY(0);
		this.ID = ID;
	}
	Sprite(int x, int y, String ID, Image png){
		setImage(png);
		setX(x);
		setY(y);
		this.ID = ID;
	}
	
//	getters
	String getID() {
		return ID;
	}
	
//	Setters
	void changeX(double x) {
		setX(getX() + x);
	}
	void changeY(double y) {
		setY(getY() + y);
	}
	void setID(String id) {
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
	
	@Override
	public String toString() {
		return ID;
	}

}
