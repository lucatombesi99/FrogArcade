package sample;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;

public class MenuActions {
   static String path ="src\\sample\\menuTheme.mp3";
   static Media media= new Media(new File(path).toURI().toString());
   static MediaPlayer mediaPlayer=new MediaPlayer(media);

    public static void play(){
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.play();
    }
    public static void pause(){

        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.pause();


    }
    public static void stop(){
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.stop();
    }

    public static void scoreRecord(){
        Stage scoreStage = new Stage();
        scoreStage.setTitle("Ranking");
        Text score = new Text("             Ranking:\n");
        VBox vbox = new VBox(10);
        Button resumeButton = new Button("EXIT");
        vbox.getChildren().addAll(score,resumeButton);
        Scene scene=new Scene(vbox,300,300);
        scoreStage.setScene(scene);
        scoreStage.show();

        resumeButton.setOnAction(e->scoreStage.close());
    }
}
