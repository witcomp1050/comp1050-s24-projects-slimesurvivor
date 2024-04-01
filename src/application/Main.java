package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
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
			Image p1Hurt = new Image("file:sprites/clyde-hurt-pixilart.png");
			Image e = new Image("file:sprites/red-slime-pixilart.png");
			Enemy en = new Enemy(0, 0, "enemieA", e, 100, 0);
			Image p2Image = new Image("file:sprites/clyde-hurt-pixilart.png");
			Player p1 = new Player(200, 200, "Player 1", p1Image);
			Player p2 = new Player(200, 200, "Player 2", p2Image);
			root.getChildren().add(p1);
			root.getChildren().add(en);
			Scene scene1 = new Scene(root,400,400);
			KeyHandler controller1 = new KeyHandler();
			primaryStage.setScene(scene1);
			primaryStage.show();
			AnimationTimer timer = new AnimationTimer() {
				@Override
				public void handle(long now) {
					double[] p1Controller = controller1.listen(scene1);
					p1.changeX(p1Controller[0]);
					p1.changeY(p1Controller[1]);
					en.follow(p1);
					if(p1.hasCollisionWith(en)) {
						System.out.println("YOU HAVE TAKE DMG");
						p1.setHealth(p1.getHealth()-1);
						if(p1.getHealth()<=0) {
							System.out.println("You are deadds");
							System.exit(0);
						}
					}
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
