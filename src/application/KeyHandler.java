package application;

import java.util.Arrays;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;


public class KeyHandler {
	KeyCode forwards = KeyCode.W;
	KeyCode backwards = KeyCode.S;
	KeyCode left = KeyCode.A;
	KeyCode right = KeyCode.D;
	int x = 0;
	int y = 0;
	public KeyHandler(KeyCode forwards, KeyCode backwards, KeyCode left, KeyCode right) {
		this.forwards = forwards;
		this.backwards = backwards;
		this.left = left;
		this.right = right;
	}
	public KeyHandler() {
		
	}
	
	public int[] listen(Scene scene) {
		scene.setOnKeyPressed(keyEvent ->{
			if(keyEvent.getCode() == forwards) {
				y = 1;
			}
			else if(keyEvent.getCode() == backwards) {
				y = -1;
			}
			else if(keyEvent.getCode() == right) {
				x = 1;
			}
			else if(keyEvent.getCode() == left) {
				x = -1;
			}
		});
		scene.setOnKeyReleased(keyEvent ->{
			if(keyEvent.getCode() == forwards) {
				y = 0;
			}
			else if(keyEvent.getCode() == backwards) {
				y = 0;
			}
			else if(keyEvent.getCode() == right) {
				x = 0;
			}
			else if(keyEvent.getCode() == left) {
				x = 0;
			}
		});
		int[] pos = new int[] {this.x,this.y};
		return pos;
	}
}
