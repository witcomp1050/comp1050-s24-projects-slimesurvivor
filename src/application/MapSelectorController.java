package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class MapSelectorController {

    @FXML
    private Button map1Button;

    @FXML
    private Pane mapSelectPane;

    @FXML
    private Button toTitleButton;

    @FXML
    void map1(ActionEvent event) {
    	viewSwitcher.switchTo(View.MAP1);
    }

    @FXML
    void map2(ActionEvent event) {
    	viewSwitcher.switchTo(View.MAP2);
    }
    @FXML
    void map3(ActionEvent event) {
    	viewSwitcher.switchTo(View.MAP3);
    }
    
    @FXML
    void toTitle(ActionEvent event) {
    	viewSwitcher.switchTo(View.TITLE);
    }

}
