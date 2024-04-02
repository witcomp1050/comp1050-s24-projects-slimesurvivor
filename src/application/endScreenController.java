package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

public class endScreenController  implements Initializable{

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

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		playerTimeLabel.setText(MapTest.getTimeStr());
		ScoreBoard sb = new ScoreBoard();
		sb.addScore(MapTest.getTimeStr());
		topScoreText.setText(sb.getScoreBoard());
	}
    

}
