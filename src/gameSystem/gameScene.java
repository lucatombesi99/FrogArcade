package gameSystem;

import javafx.animation.AnimationTimer;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.control.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;


public class gameScene {

    final static String AUDIO_PATH = "Resources\\Audio\\";
    final static String IMAGES_PATH = "Resources\\Images\\";
    private AnimationTimer timer;

    Media media;
    Button pauseButton;
    Label timeLabel;
    Label difficultyLabel;
    AnchorPane backgroundScene;
    ImageView backgroundImage;
    String level = "";

    public  void startGame(Stage primaryStage, int difficulty){

        //MUSICA di SOTTOFONDO
        media = new Media(new File(AUDIO_PATH + "theme.mp3").toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.play();

        //Label level
        if (difficulty == 0)
            level += "EASY";
        else if(difficulty ==1)
            level += "MEDIUM";
        else
            level += "HARD";

        //SCRITTA IN ALTO
        pauseButton = new Button("||");
        timeLabel = new Label("Time:");
        timeLabel.setFont(new Font("Calibri", 20));
        difficultyLabel= new Label("Difficulty:" + level);
        difficultyLabel.setFont(new Font("Calibri", 20));

        backgroundScene = new AnchorPane();
        backgroundScene.maxHeight(400);
        backgroundScene.maxWidth(800);
        backgroundScene.setPrefSize(400,800);

        //pos Bottone Pausa
        AnchorPane.setTopAnchor(pauseButton,10.0);
        AnchorPane.setLeftAnchor(pauseButton,20.0);

        //pos Etichetta Time
        AnchorPane.setTopAnchor(timeLabel,10.0);
        AnchorPane.setLeftAnchor(timeLabel,100.0);

        //pos Etiichetta Difficoltà
        AnchorPane.setTopAnchor(difficultyLabel,10.0);
        AnchorPane.setLeftAnchor(difficultyLabel,200.0);


        Image backgroundImageURL= new Image(new File(IMAGES_PATH + "iKogsKW.png").toURI().toString(),350,500,true,true,false);
        backgroundImage = new ImageView(backgroundImageURL);

        Scene scene=new Scene(backgroundScene, 350,500);

        //pos Image
        AnchorPane.setTopAnchor(backgroundImage, 40.0);

        Frog f=new Frog(IMAGES_PATH+"froggerUp.png",scene);

    Image im = new Image(new File(IMAGES_PATH+"end_bonus.png").toURI().toString(), 31, 31, true, true);
ImageView im1=new ImageView();
im1.setX(308);
im1.setY(102);
im1.setImage(im);
        backgroundScene.getChildren().addAll(pauseButton,timeLabel,difficultyLabel, backgroundImage,im1,f);

        //tronchi
        Log firstLog1= new Log(IMAGES_PATH + "log3.png", 70, 300, 138, 1.5);
        Log firstLog2 = new Log(IMAGES_PATH + "log2.png", 90, 250, 170, -1.5);
        Log firstLog3 = new Log(IMAGES_PATH + "log3.png", 70, 200, 202, 2.5);
        Log firstLog4 = new Log(IMAGES_PATH + "log2.png", 90, 150, 234, -2.5);
        Log firstLog5 = new Log(IMAGES_PATH + "log3.png", 70, 100, 266, 2.5);
        backgroundScene.getChildren().addAll(firstLog1,firstLog2,firstLog3,firstLog4,firstLog5);

        //macchine

        Vehicle car1 = new Vehicle(IMAGES_PATH + "car1Left.png", 30, 300, 319, -1.7);
        Vehicle truck1 = new Vehicle(IMAGES_PATH + "truck1Left.png", 60, 210,349, -1.3);
        Vehicle car2 = new Vehicle(IMAGES_PATH + "car1Left.png", 30, 150, 381, -1.5);
        Vehicle bigTruck1 = new Vehicle(IMAGES_PATH + "truck2Right.png", 100, 75,413, 1.3);
        Vehicle car3 = new Vehicle(IMAGES_PATH + "car1Left.png", 30, 250, 445, -1.5);


        backgroundScene.getChildren().addAll(car1,car2,car3,truck1,bigTruck1);

        //end
        Burrow bur1=new Burrow(9,102);
        Burrow bur2=new Burrow(83,102);
        Burrow bur3=new Burrow(158,102);
        Burrow bur4=new Burrow(233,102);
        Burrow bur5=new Burrow(308,102);
        bur2.setFrogEnd();

        backgroundScene.getChildren().addAll(bur1,bur2,bur3,bur5);

        startMoving();
        timer.start();

        //bonus


        primaryStage.setScene(scene);


        pauseButton.setOnAction(e->{
            PauseClass.pause(mediaPlayer);
        });

    }
    public void startMoving(){
        timer=new AnimationTimer() {
            @Override
            public void handle(long now) {
                List<Entity> objects=getEntity(Entity.class);
                for(Entity object: objects){
                   object.movement(now);
                }

            }
        };
    }
    public <T extends Entity> List<T> getEntity(Class<T> cls) {
        ArrayList<T> someArray = new ArrayList<T>();
        for(Node n: backgroundScene.getChildren())
            if (cls.isInstance(n)) {
                someArray.add((T)n);
            }

        return someArray;
    }

}
