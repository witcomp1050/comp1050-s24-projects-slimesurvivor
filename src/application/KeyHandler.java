package application;

import java.util.*;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;


public class KeyHandler {
	KeyCode Player1_up = KeyCode.W;
	KeyCode Player1_down = KeyCode.S;
	KeyCode Player1_left = KeyCode.A;
	KeyCode Player1_right = KeyCode.D;
	KeyCode Player2_up = KeyCode.UP;
	KeyCode Player2_down = KeyCode.DOWN;
	KeyCode Player2_left = KeyCode.LEFT;
	KeyCode Player2_right = KeyCode.RIGHT;
	private Set<KeyCode> codes = new HashSet<>();
	double Player1_x = 0;
	double Player1_y = 0;
	double Player2_x = 0;
	double Player2_y = 0;
	public KeyHandler(KeyCode Player1_up, KeyCode Player1_down, KeyCode Player1_left, KeyCode Player1_right, KeyCode Player2_up, KeyCode Player2_down, KeyCode Player2_left, KeyCode Player2_right) {
		this.Player1_up = Player1_up;
		this.Player1_down =Player1_down;
		this.Player1_left = Player1_left;
		this.Player1_right = Player1_right;
		this.Player2_up = Player2_up;
		this.Player2_down = Player2_down;
		this.Player2_left = Player2_left;
		this.Player2_right =Player2_right;
	}
	public KeyHandler() {
		
	}
	
	
	public double[] listen(Scene scene1) {
		scene1.setOnKeyPressed(keyEvent ->{
			codes.add(keyEvent.getCode());
			if (codes.contains(Player1_up)) {
				System.out.println("Player1_up");
				Player1_y = -5;
			} else if (codes.contains(Player1_down)) {
				System.out.println("Player1_down");
				Player1_y = 5;
			}
			else {
				Player1_y = 0;
			}
			if (codes.contains(Player1_left)) {
				System.out.println("Player1_left");
				Player1_x = -5;
			}else if (codes.contains(Player1_right)) {
				System.out.println("Player1_right");
				Player1_x = 5;
			}else {
				Player1_x = 0;
			}
			if (codes.contains(Player2_up)) {
				System.out.println("Player2_up");
				Player2_y = -5;
			} else if (codes.contains(Player2_down)) {
				System.out.println("Player2_down");
				Player2_y = 5;
			}
			else {
				Player2_y = 0;
			}
			if (codes.contains(Player2_left)) {
				System.out.println("Player2_left");
				Player2_x = -5;
			}else if (codes.contains(Player2_right)) {
				System.out.println("Player2_right");
				Player2_x = 5;
			}else {
				Player2_x = 0;
			}
			System.out.println("Player2_X = "+this.Player2_x);
			System.out.println("Player2_Y = "+this.Player2_y);
		});
		scene1.setOnKeyReleased(keyEvent -> {
			codes.remove(keyEvent.getCode());
			if(keyEvent.getCode() == Player1_up || keyEvent.getCode() == Player1_down) {
				this.Player1_y = 0;
			}
			if(keyEvent.getCode() == Player1_left || keyEvent.getCode() == Player1_right) {
				this.Player1_x = 0;
			}
			if(keyEvent.getCode() == Player2_up || keyEvent.getCode() == Player2_down) {
				this.Player2_y = 0;
			}
			if(keyEvent.getCode() == Player2_left || keyEvent.getCode() == Player2_right) {
				this.Player2_x = 0;
			}
			System.out.println("stopped");
			System.out.println("Player1_X = "+this.Player1_x);
			System.out.println("Player1_Y = "+this.Player1_y);
			System.out.println("stopped");
			System.out.println("Player2_X = "+this.Player2_x);
			System.out.println("Player2_Y = "+this.Player2_y);
		});
		double[] pos = new double[] {this.Player1_x,this.Player1_y, this.Player2_x, this.Player2_y};
		
		return pos;
	}
}
