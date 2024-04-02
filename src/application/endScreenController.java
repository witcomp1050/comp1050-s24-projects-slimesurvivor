package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

public class endScreenController {

    @FXML
    private Label playerTimeLabel;

    @FXML
    private Button titleButton;

    @FXML
    private Text topScoreText;

    @FXML
    void backToTitle(ActionEvent event) {
    	viewSwitcher.switchTo(View.TITLE);
    }

}
