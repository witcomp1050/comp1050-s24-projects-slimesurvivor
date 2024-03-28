package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.animation.AnimationTimer;
public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Pane pane = FXMLLoader.load(getClass().getResource("slime.fxml"));
			Image p1Image = new Image("file:sprites/clyde-pixilart.png");
			Player p1 = new Player(200, 200, "Player 1", p1Image, 100, 50, 0, 10);
			Image p2Image = new Image("file:sprites/clyde-pixilart.png");
			Player p2 = new Player(200, 200, "Player 1", p2Image, 100, 50, 0, 10);
			pane.getChildren().add(p1);
			pane.getChildren().add(p2);
			Scene scene1 = new Scene(pane,1680,800);
			primaryStage.setScene(scene1);
			KeyHandler controller = new KeyHandler();
			AnimationTimer timer = new AnimationTimer() {
				@Override
				public void handle(long now) {
					double[] Controller = controller.listen(pane);
					p1.changeX(Controller[0], pane);
					p1.changeY(Controller[1], pane);
					p2.changeX(Controller[2], pane);
					p2.changeX(Controller[3], pane);
				}
			};
			timer.start();
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
