package slime_Survivor;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Slime Survivor");
		final Button btn = new Button();
		btn.setText("something ig");
		final StackPane root = new StackPane();
		root.getChildren().add(btn);
		primaryStage.setScene(new Scene(root, 1280, 800));
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
