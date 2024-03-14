package slime_Survivor;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;


public class KeyHandler {
	KeyCode forwards = KeyCode.W;
	KeyCode backwards = KeyCode.S;
	KeyCode left = KeyCode.A;
	KeyCode right = KeyCode.D;
	boolean rightIsPressed = false;
	boolean leftIsPressed = false;
	boolean forwardsIsPressed = false;
	boolean backwardsIsPressed = false;
	public KeyHandler(KeyCode forwards, KeyCode backwards, KeyCode left, KeyCode right) {
		this.forwards = forwards;
		this.backwards = backwards;
		this.left = left;
		this.right = right;
	}
	public KeyHandler() {
		
	}
	public boolean isForwards(Scene scene) {
		scene.addEventFilter(KeyEvent.ANY, keyEvent -> {
			if(keyEvent.getCode() == forwards) {
				this.forwardsIsPressed = true;
				System.out.println(forwardsIsPressed);
			}
		});
		return this.forwardsIsPressed;
	}
	
	public boolean isLeft(Scene scene) {
		scene.setOnKeyPressed(event -> {
			if(event.getCode() == left) {
				leftIsPressed = true;
			}
		});
		return leftIsPressed;
	}
	public boolean isRight(Scene scene) {
		scene.setOnKeyPressed(event -> {
			if(event.getCode() == right) {
				rightIsPressed = true;
			}
		});
		return rightIsPressed;
	}
	public boolean isBackwards(Scene scene) {
		scene.setOnKeyPressed(event -> {
			if(event.getCode() == backwards) {
				backwardsIsPressed = true;
			}
		});
		return backwardsIsPressed;
	}
	public int[] listen(Scene scene) {
		int[] pos = new int[]{0,0};
		if(isForwards(scene)) {
			pos[1]=1;
			System.out.println("forwards");
		}
		else if(isBackwards(scene)) {
			pos[1]=-1;
			System.out.println("backwards");
		}
		else if(isLeft(scene)) {
			pos[0]=-1;
			System.out.println("left");
		}
		else if(isRight(scene)) {
			pos[0]=1;
			System.out.println("right");
		}
		return pos;
	}
}
