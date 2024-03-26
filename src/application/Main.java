package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.animation.AnimationTimer;
public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent scene = FXMLLoader.load(getClass().getResource("slime.fxml"));
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			BorderPane root = new BorderPane();
			Image p1Image = new Image("file:sprites/clyde-pixilart.png");
			Image p2Image = new Image("file:sprites/clyde-hurt-pixilart.png");
			Player p1 = new Player(200, 200, "Player 1", p1Image, 100, 1, 0, 10);
			Player p2 = new Player(200, 200, "Player 2", p2Image, 100, 1, 0, 10);
			root.getChildren().add(p1);
			root.getChildren().add(p2);
			Scene scene1 = new Scene(root,400,400);
			KeyHandler controller1 = new KeyHandler(KeyCode.W, KeyCode.S, KeyCode.A, KeyCode.D);
			KeyHandler controller2 = new KeyHandler(KeyCode.UP, KeyCode.DOWN, KeyCode.LEFT, KeyCode.RIGHT);
			primaryStage.setScene(scene1);
			primaryStage.show();
			AnimationTimer timer = new AnimationTimer() {
				@Override
				public void handle(long now) {
					double[] p1Controller = controller1.listen(scene1);
					double[] p2Controller = controller2.listen(scene1);
					p1.changeX(p1Controller[0]);
					p1.changeY(p1Controller[1]);
					p2.changeX(p2Controller[0]);
					p2.changeY(p2Controller[1]);
				}
			};
			timer.start();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
