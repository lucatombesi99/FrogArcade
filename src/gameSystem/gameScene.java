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




        backgroundScene.getChildren().addAll(pauseButton,timeLabel,difficultyLabel, backgroundImage);

        //tronchi
        Log firstLog1= new Log(IMAGES_PATH + "log3.png", 70, 300, 138, 1.5);
        Log firstLog2 = new Log(IMAGES_PATH + "log2.png", 90, 250, 170, -1.5);
        Log firstLog3 = new Log(IMAGES_PATH + "log3.png", 70, 200, 202, 2.5);
        Log firstLog4 = new Log(IMAGES_PATH + "log2.png", 90, 150, 234, -2.5);
        Log firstLog5 = new Log(IMAGES_PATH + "log3.png", 70, 100, 266, 2.5);
        backgroundScene.getChildren().addAll(firstLog1,firstLog2,firstLog3,firstLog4);

        //macchine

        Vehicle car1 = new Vehicle(IMAGES_PATH + "car1Left.png", 30, 300, 323, -1.7);
        Vehicle truck1 = new Vehicle(IMAGES_PATH + "truck1Left.png", 60, 210,349, -1.3);
        Vehicle car2 = new Vehicle(IMAGES_PATH + "car1Left.png", 30, 150, 381, -1.5);
        Vehicle bigTruck1 = new Vehicle(IMAGES_PATH + "truck2Right.png", 100, 75,413, 1.3);
        Vehicle car3 = new Vehicle(IMAGES_PATH + "car1Left.png", 30, 250, 442, -1.5);


        backgroundScene.getChildren().addAll(car1,car2,car3,truck1,bigTruck1);

        //end
        Burrow bur1=new Burrow(9,102);
        Burrow bur2=new Burrow(83,102);
        Burrow bur3=new Burrow(158,102);
        Burrow bur4=new Burrow(233,102);
        Burrow bur5=new Burrow(308,102);
        Bonus b=new Bonus();


        backgroundScene.getChildren().addAll(bur1,bur2,bur3,bur5,bur4,b);

        startMoving();
        timer.start();

        //tartarughe   tur2 pos 170
        Turtle tur1=new Turtle(50,138,2,70);
        Turtle tur2=new Turtle(200,170,-1.5,70);
        Turtle tur3=new Turtle(90,202,1.2,70);
        Turtle tur4=new Turtle(110,234,-1.3,70);
        Turtle tur5=new Turtle(130,258,2.0,70);


        //serpente  et cocco
        Snake snake=new Snake(15,285,130,1.2);
        Crocodile croc1=new Crocodile(100,138,40,1.5);
        Crocodile croc2=new Crocodile(100,170,40,-1.5);


        List<Entity> interceptable=getEntity(Entity.class);

        //rana
        Frog f=new Frog(IMAGES_PATH+"froggerUp.png",scene,interceptable);


        backgroundScene.getChildren().addAll(tur1,tur2,tur3,tur5,tur4);
        backgroundScene.getChildren().addAll(f);




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
