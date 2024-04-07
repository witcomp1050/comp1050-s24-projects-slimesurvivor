package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Map1endScreenController  implements Initializable{


    @FXML
    private Text scoreLabel;

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
		Font font = Font.loadFont(getClass().getResourceAsStream("SlimeFont.ttf"), 36);
		scoreLabel.setFont(font);
		topScoreText.setFont(font);
		File file = new File("map1HS.txt");
		String topScore = "";
		try (Scanner scoreReader = new Scanner(file)) {
			topScore += scoreReader.nextLine();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		topScoreText.setText("WAVE"+topScore);
		
	}
    

}
