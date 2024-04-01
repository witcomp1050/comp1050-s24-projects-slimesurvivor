package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
			Scene scene = new Scene(new Pane());
			viewSwitcher.setScene(scene);
			viewSwitcher.switchTo(View.TITLE);
			primaryStage.setScene(scene);
			primaryStage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}
