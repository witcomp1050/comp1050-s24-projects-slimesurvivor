package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class SettingsController {

    @FXML
    private Button backButton;

    @FXML
    private Button musicButton;

    @FXML
    private Button muteButton;

    @FXML
    void Back(ActionEvent event) {
    	viewSwitcher.switchTo(View.TITLE);
    }

    @FXML
    void music(ActionEvent event) {

    }

    @FXML
    void mute(ActionEvent event) {

    }

}
