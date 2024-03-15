package application;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;


public class KeyHandler {
	KeyCode forwards = KeyCode.W;
	KeyCode backwards = KeyCode.S;
	KeyCode left = KeyCode.A;
	KeyCode right = KeyCode.D;
	
	public KeyHandler(KeyCode forwards, KeyCode backwards, KeyCode left, KeyCode right) {
		this.forwards = forwards;
		this.backwards = backwards;
		this.left = left;
		this.right = right;
	}
	public KeyHandler() {
		
	}
	public int isForwards(Scene scene) {
		scene.addEventFilter(KeyEvent.ANY, keyEvent -> {
			if(keyEvent.getCode() == forwards) {
				//System.out.println("");
				return;
			}
		});
		return 0;
	}
	
	public int isLeft(Scene scene) {
		scene.setOnKeyPressed(event -> {
			if(event.getCode() == left) {
				return;
			}
		});
		return 0;
	}
	public int isRight(Scene scene) {
		scene.setOnKeyPressed(event -> {
			if(event.getCode() == right) {
				return;
			}
		});
		return 0;
	}
	public int isBackwards(Scene scene) {
		scene.setOnKeyPressed(event -> {
			if(event.getCode() == backwards) {
				return;
			}
		});
		return 0;
	}
	public int[] listen(Scene scene) {
		int[] pos = new int[]{0,0};
		
		return pos;
	}
}
