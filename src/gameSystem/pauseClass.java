package gameSystem;


import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class pauseClass {

    private static boolean autoPlay=true;


    public static void  pause(MediaPlayer mediaPlayer) {
        Stage pauseStage = new Stage();
        pauseStage.setTitle("Pause Menu");

        VBox vbox = new VBox(10);
        Button volumeButton = new Button("audio on/off");
        Button resumeButton = new Button("resume");
        

        vbox.setPadding(new Insets(20,20,20,20));
        vbox.getChildren().addAll(volumeButton, resumeButton);

        Scene pauseScene = new Scene(vbox, 200, 200);
        pauseStage.setScene(pauseScene);
        pauseStage.initStyle(StageStyle.TRANSPARENT);
        pauseStage.setOpacity(0.7);
        pauseStage.show();

        volumeButton.setOnAction(e->{

            if(autoPlay) {
                autoPlay=false;
                mediaPlayer.pause();
            } else {
                autoPlay=true;
                mediaPlayer.play();
            }
        });
        resumeButton.setOnAction(e->{
            pauseStage.close();

        });



    }
}
