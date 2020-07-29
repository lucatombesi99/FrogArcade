package gameSystem;


import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.scene.control.*;
import java.io.File;


public class gameScene {
    Media media;
    Button pauseButton;

public  void startGame(Stage primaryStage,int difficulty){
    String path ="src\\gameSystem\\theme.mp3";
    media=new Media(new File(path).toURI().toString());
    pauseButton=new Button("Pause");

    MediaPlayer mediaPlayer=new MediaPlayer(media);
    mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
    mediaPlayer.play();

    BorderPane layout = new BorderPane();

    ImageView img = new ImageView();
    img.setImage(new Image(getClass().getResource("media\\iKogsKW.png").toExternalForm(),600, 800, true, true));

    layout.getChildren().addAll(img);
    layout.setTop(pauseButton);
    layout.getStylesheets().add(getClass().getResource("Back.css").toExternalForm());


    Scene scene = new Scene(layout,500,500);


    primaryStage.setScene(scene);

    pauseButton.setOnAction(e->{
        pauseClass.pause(mediaPlayer);


    });


}






}
