package application;

import java.util.*;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;


public class KeyHandler {
	private KeyCode Player1_up = KeyCode.W;
	private KeyCode Player1_down = KeyCode.S;
	private KeyCode Player1_left = KeyCode.A;
	private KeyCode Player1_right = KeyCode.D;
	private Set<KeyCode> codes = new HashSet<>();
	private double Player1_x = 0;
	private double Player1_y = 0;
	public KeyHandler(KeyCode Player1_up, KeyCode Player1_down, KeyCode Player1_left, KeyCode Player1_right) {
		this.Player1_up = Player1_up;
		this.Player1_down =Player1_down;
		this.Player1_left = Player1_left;
		this.Player1_right = Player1_right;
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
		});
		scene1.setOnKeyReleased(keyEvent -> {
			codes.remove(keyEvent.getCode());
			if(keyEvent.getCode() == Player1_up || keyEvent.getCode() == Player1_down) {
				this.Player1_y = 0;
			}
			if(keyEvent.getCode() == Player1_left || keyEvent.getCode() == Player1_right) {
				this.Player1_x = 0;
			}
			System.out.println("stopped");
			System.out.println("Player1_X = "+this.Player1_x);
			System.out.println("Player1_Y = "+this.Player1_y);
			System.out.println("stopped");

		});
		double[] pos = new double[] {this.Player1_x,this.Player1_y};
		
		return pos;
	}
}
