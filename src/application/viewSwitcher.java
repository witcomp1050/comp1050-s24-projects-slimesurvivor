package application;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;

import java.io.IOException;

import javafx.fxml.FXMLLoader;

public class viewSwitcher {
	
	public static Scene scene;
	public static Pane pane;
	public static void setScene(Scene scene) {
		viewSwitcher.scene = scene;
	}
	
	public static void switchTo(View view) {
		if(scene == null) {
			System.out.println("No scene was set");
			return;
		}
		try {
			 pane = FXMLLoader.load(
					viewSwitcher.class.getResource(view.getFileName())
					);
			scene.setRoot(pane);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
