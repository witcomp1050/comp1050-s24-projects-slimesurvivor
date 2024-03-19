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
	int x = 0;
	int y = 0;
	public KeyHandler(KeyCode up, KeyCode down, KeyCode left, KeyCode right) {
		this.up = up;
		this.down = down;
		this.left = left;
		this.right = right;
	}
	public KeyHandler() {
		
	}
	
	public int[] listen(Scene scene) {
		scene.setOnKeyReleased(keyEvent -> {
			codes.clear();
			x = 0;
			y = 0;
			System.out.println("X = "+this.x);
			System.out.println("Y = "+this.y);
		});
		scene.setOnKeyPressed(keyEvent ->{
			codes.add(keyEvent.getCode());
			if (codes.contains(up)) {
				System.out.println("up");
				y = -1;
			} else if (codes.contains(down)) {
				System.out.println("down");
				y = 1;
			}
			else {
				y = 0;
			}
			if (codes.contains(left)) {
				System.out.println("left");
				x = -1;
			}else if (codes.contains(right)) {
				System.out.println("right");
				x = 1;
			}else {
				x = 0;
			}
			System.out.println("X = "+this.x);
			System.out.println("Y = "+this.y);
		});
		
		System.out.println("");
		int[] pos = new int[] {this.x,this.y};
		scene.setOnKeyReleased(e -> codes.clear());
		
		return pos;
	}
}
