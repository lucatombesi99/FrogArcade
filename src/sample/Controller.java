package sample;

import gameSystem.gameScene;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;


import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;


import java.io.IOException;

//ricorda di dare gli ID alle componenti

public class Controller {



    @FXML
    private ToggleGroup difficulty;


    private static boolean autoPlay=true;

    @FXML
    private void volumeClicked(ActionEvent event){
        if(autoPlay) {
            autoPlay=false;
            menuActions.pause();
        } else {
            autoPlay=true;
            menuActions.play();
        }

    }

    @FXML
    private void showScore(ActionEvent event){

        menuActions.scoreRecord();
    }



    public void newGameButtonClicked(ActionEvent event) throws IOException {

        menuActions.stop();
        gameScene g= new gameScene();
        RadioMenuItem selectedRadioButton;
        selectedRadioButton = (RadioMenuItem) difficulty.getSelectedToggle();
        String toggleGroupValue = selectedRadioButton.getText();
        int difficulty;
        if(toggleGroupValue.equals("Easy"))
            difficulty=0;
        else if(toggleGroupValue.equals("Medium"))
            difficulty=1;
        else
            difficulty=2;


        Stage window= (Stage)((Node)event.getSource()).getScene().getWindow();
        g.startGame(window,difficulty);

    }


}
