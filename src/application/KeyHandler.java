package application;

import java.util.*;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;


public class KeyHandler {
	KeyCode up = KeyCode.W;
	KeyCode down = KeyCode.S;
	KeyCode left = KeyCode.A;
	KeyCode right = KeyCode.D;
	private List<KeyCode> controlCodes = Arrays.asList(up, down, left, right);
	private Set<KeyCode> codes = new HashSet<>();
	double x = 0;
	double y = 0;
	public KeyHandler(KeyCode up, KeyCode down, KeyCode left, KeyCode right) {
		this.up = up;
		this.down = down;
		this.left = left;
		this.right = right;
	}
	public KeyHandler() {
		
	}
	
	public double[] listen(Scene scene) {
		scene.setOnKeyPressed(keyEvent ->{
			codes.add(keyEvent.getCode());
			if (codes.contains(up)) {
				System.out.println("up");
				y = -5;
			} else if (codes.contains(down)) {
				System.out.println("down");
				y = 5;
			}
			else {
				y = 0;
			}
			if (codes.contains(left)) {
				System.out.println("left");
				x = -5;
			}else if (codes.contains(right)) {
				System.out.println("right");
				x = 5;
			}else {
				x = 0;
			}
			System.out.println("X = "+this.x);
			System.out.println("Y = "+this.y);
		});
		scene.setOnKeyReleased(keyEvent -> {
			codes.clear();
			this.x = 0;
			this.y = 0;
			System.out.println("stopped");
			System.out.println("X = "+this.x);
			System.out.println("Y = "+this.y);
		});
		double[] pos = new double[] {this.x,this.y};
		
		return pos;
	}
}
