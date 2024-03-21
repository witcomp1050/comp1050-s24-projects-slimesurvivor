package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent scene = FXMLLoader.load(getClass().getResource("slime.fxml"));
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			KeyHandler controller = new KeyHandler();
			controller.listen(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
