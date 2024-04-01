package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class titleScreen {

    @FXML
    private Button playButton;
    @FXML
    private Button quitButton;

    @FXML
    private Button settingsButton;
    @FXML
    void onPlay(ActionEvent event) {
    	viewSwitcher.switchTo(View.MAPTEST);
    }
    @FXML
    void onSettings(ActionEvent event) {
    	viewSwitcher.switchTo(View.SETTINGS);
    }
    @FXML
    void Quit(ActionEvent event) {
    	System.exit(0);
    }

}
