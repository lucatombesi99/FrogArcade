package sample;

import gameSystem.gameScene;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;


import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

//ricorda di dare gli ID alle componenti

public class Controller {
    private static boolean autoPlay=true;

    ObservableList<String> difficultyList= FXCollections.observableArrayList("easy","medium","hard");

    @FXML
    private ChoiceBox<String> difficultyBox;

    public static boolean isAutoPlay() {
        return autoPlay;
    }

   @FXML
   private void initialize() {
       difficultyBox.setValue("easy");
       difficultyBox.setItems(difficultyList);

   }


    public void exitButtonClicked(ActionEvent event){

    }
    public void audioButtonClicked(ActionEvent event) throws IOException{
        if(autoPlay) {
            autoPlay=false;
            menuActions.pause();
        } else {
            autoPlay=true;
            menuActions.play();
        }

    }
    public void scoreButtonClicked(ActionEvent event){
        menuActions.scoreRecord();

    }


    public void newGameButtonClicked(ActionEvent event) throws IOException {

        menuActions.stop();
        gameScene g= new gameScene();
      String choiceBoxValue= difficultyBox.getValue().toString();
   //selectedRadioButton = (RadioMenuItem) difficulty.getSelectedToggle();

        int difficulty;
        if(choiceBoxValue.equals("easy"))
            difficulty=0;
        else if(choiceBoxValue.equals("medium"))
            difficulty=1;
        else
            difficulty=2;


        Stage window= (Stage)((Node)event.getSource()).getScene().getWindow();
        g.startGame(window,difficulty);

    }


}
/*

 onAction="#newGameButtonClicked"

 */
