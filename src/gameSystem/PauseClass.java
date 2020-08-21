package gameSystem;


import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sample.Main;
import sample.MenuActions;

import java.io.File;

public class PauseClass extends Pane {

    private Button pauseButton = new Button("||");


    public PauseClass(){
        //position PAUSE button
        pauseButton.setTranslateX(10.0);
        pauseButton.setTranslateY(10.0);

        getChildren().add(pauseButton);
        pauseButton.setOnAction(e-> pause());
    }





    private void  pause() {

        //Fermo il tempo
        GameScene.clock.animation.stop();

        Stage pauseStage = new Stage();
        pauseStage.setTitle("Pause Menu");


        AnchorPane pauseAncPane = new AnchorPane();






        //Immagine di sfondo della finestra di pausa
        Image bkimage = new Image(new File(Main.IMAGE_PATH + "sfondoPauseClass.png").toURI().toString(), 291,300,false, true);
        BackgroundImage backgroundImage = new BackgroundImage(bkimage, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        pauseAncPane.setBackground(new Background(backgroundImage));

        Button volumeButton = new Button("AUDIO ON/OFF");
        volumeButton.setPrefSize(120.0,37.0);
        AnchorPane.setTopAnchor(volumeButton,90.0);
        AnchorPane.setLeftAnchor(volumeButton, 85.0);



        Button resumeButton = new Button("RESUME");
        resumeButton.setPrefSize(120.0,37.0);
        AnchorPane.setTopAnchor(resumeButton,142.0);
        AnchorPane.setLeftAnchor(resumeButton, 85.0);



        pauseAncPane.getChildren().addAll(volumeButton, resumeButton);

        Scene pauseScene = new Scene(pauseAncPane, 290, 290);
        pauseStage.setScene(pauseScene);
        pauseStage.initStyle(StageStyle.DECORATED);
        pauseStage.show();

        volumeButton.setOnAction(e -> {

            if (MenuActions.autoPlay) {
                MenuActions.autoPlay = false;
                GameScene.mediaPlayer.pause();

            } else {
                MenuActions.autoPlay = true;
                GameScene.mediaPlayer.play();
            }
        });

        resumeButton.setOnAction(e -> {
            pauseStage.close();
            GameScene.clock.animation.play();
        });
    }
}
