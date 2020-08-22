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
import sample.Main;
import sample.RankingTable;

import java.io.File;
import java.io.IOException;
import java.util.*;


public class GameScene { //modificato qualcosa


    public AnimationTimer timer;

    //si può mettere privato e final
    public static Image lifeURL = new Image(new File(Main.IMAGE_PATH + "cuore.png").toURI().toString(), 25,25, true,true);
    public static int FROGGER_LIVES = 5;
    public boolean noMoreLives=false;
    Media media;
    public static Button pauseButton;
    Label difficultyLabel;
    Label timeLabel;
    static double  timeLeft=60;
    private long lastUpdate = 0 ;
    public static int points=0;
    public static AnchorPane backgroundScene;
    public static ImageView life1,life2,life3,life4,life5;
    ImageView backgroundImage;
    String level = "";

    public static MediaPlayer mediaPlayer;


  //  static Time clock;
    static Score score;


    public  void startGame(Stage primaryStage, int difficulty) {


        //MUSICA di SOTTOFONDO
        media = new Media(new File(Main.AUDIO_PATH + "theme.mp3").toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.play();


        //Label level
        if (difficulty == 0)
            level += "E";
        else if (difficulty == 1)
            level += "M";
        else
            level += "H";

        //SCRITTA IN ALTO
        pauseButton = new Button("||");
        timeLabel=new Label("Time: "+timeLeft);
        timeLabel.setFont(new Font("Calibri", 20));
        difficultyLabel = new Label("Difficulty:" + level);
        difficultyLabel.setFont(new Font("Calibri", 20));
        //scoreLabel = new Label("Score: "+ points);
        //scoreLabel.setFont(new Font("Calibri", 20));


        backgroundScene = new AnchorPane();
        backgroundScene.maxHeight(400);
        backgroundScene.maxWidth(800);
        backgroundScene.setPrefSize(400, 800);




        //pos Etiichetta Difficoltà
        AnchorPane.setTopAnchor(difficultyLabel, 10.0);
        AnchorPane.setLeftAnchor(difficultyLabel, 250.0);
        AnchorPane.setTopAnchor(timeLabel, 10.0);
        AnchorPane.setLeftAnchor(timeLabel, 150.0);

        //pos Etichetta Punteggio
        //AnchorPane.setTopAnchor(scoreLabel, 10.0);
        //AnchorPane.setLeftAnchor(scoreLabel, 50.0);



        Image backgroundImageURL = new Image(new File(Main.IMAGE_PATH + "iKogsKW.png").toURI().toString(), 350, 500, true, true, false);
        backgroundImage = new ImageView(backgroundImageURL);

      //  clock = new Time();
        score= new Score();


        Scene scene = new Scene(backgroundScene, 350, 505);



        //pos Image
        AnchorPane.setTopAnchor(backgroundImage, 40.0);

        backgroundScene.getChildren().addAll(difficultyLabel, score,timeLabel, backgroundImage,pauseButton);



        //Vite
        life1 = new ImageView(lifeURL);
        life1.setX(230);
        life1.setY(50);

        life2 = new ImageView(lifeURL);
        life2.setX(250);
        life2.setY(50);

        life3 = new ImageView(lifeURL);
        life3.setX(270);
        life3.setY(50);

        life4 = new ImageView(lifeURL);
        life4.setX(290);
        life4.setY(50);

        life5 = new ImageView(lifeURL);
        life5.setX(310);
        life5.setY(50);

        backgroundScene.getChildren().addAll(life1,life2,life3, life4, life5);


        //tronchi
        Log firstLog1 = new Log(Main.IMAGE_PATH + "log3.png", 70, 230, 138, 1.0);
        Log firstLog2 = new Log(Main.IMAGE_PATH + "log2.png", 90, 200, 170, -1.0);
        Log firstLog3 = new Log(Main.IMAGE_PATH + "log3.png", 70, 170, 200, 1.0);
        Log firstLog4 = new Log(Main.IMAGE_PATH + "log2.png", 90, 140, 229, -1.0);
        Log firstLog5 = new Log(Main.IMAGE_PATH + "log3.png", 70, 110, 258, 1.0);





        backgroundScene.getChildren().addAll(firstLog1, firstLog2, firstLog3, firstLog4, firstLog5);


        //macchine
        Vehicle car1 = new Vehicle(Main.IMAGE_PATH + "car1Left.png", 30, 300, 321, -1.7);
        Vehicle truck1 = new Vehicle(Main.IMAGE_PATH + "truck1Left.png", 60, 210,351, -1.3);
        Vehicle car2 = new Vehicle(Main.IMAGE_PATH+ "car1Left.png", 30, 150, 382, -1.5);
        Vehicle bigTruck1 = new Vehicle(Main.IMAGE_PATH + "truck2Right.png", 100, 75,413, 1.3);
        Vehicle car3 = new Vehicle(Main.IMAGE_PATH + "car1Left.png", 30, 250, 444, -1.5);

        backgroundScene.getChildren().addAll(car1, car2, car3, truck1, bigTruck1);

        //end
        Burrow bur1 = new Burrow(9, 102);
        Burrow bur2 = new Burrow(83, 102);
        Burrow bur3 = new Burrow(158, 102);
        Burrow bur4 = new Burrow(233, 102);
        Burrow bur5 = new Burrow(308, 102);

        Bonus b = new Bonus();

        backgroundScene.getChildren().addAll(bur1, bur2, bur3, bur4, bur5, b);


        //tartarughe   tur2 pos 170
        Turtle tur1=new Turtle(150,138,1.0,70);
        Turtle tur2=new Turtle(120,168,-1.0,70);
        Turtle tur3=new Turtle(90,198,1.0,70);
        Turtle tur4=new Turtle(60,229,-1.0,70);
        Turtle tur5=new Turtle(30,258,1.0,70);

        //serpente  et cocco
        Snake snake=new Snake(12,287,90,1.2);
        Crocodile croc1=new Crocodile(50,164,90,1.5);
        Crocodile croc2=new Crocodile(50,258,90,-1.5);

        Test test=new Test(30,50,100);


        backgroundScene.getChildren().addAll(tur1,tur2,tur3,tur5,tur4,snake,croc1,croc2, test);



        //score

        //score.setScoreLabel(f,b,bur2, difficulty);
        //score.setScoreLabel(f,b,bur3, difficulty);
        //score.setScoreLabel(f,b,bur4, difficulty);
        // score.setScoreLabel(f,b,bur5, difficulty);

        startMoving();
        timer.start();


        List<Entity> interceptable=getEntity(Entity.class);

        //rana
        Frog f = new Frog(Main.IMAGE_PATH +"froggerUp.png",scene,interceptable, test);
        backgroundScene.getChildren().addAll(f);


        primaryStage.setScene(scene);


        pauseButton.setOnAction(e -> PauseClass.pause(timer));

    }

    public void startMoving(){
        timer=new AnimationTimer() {
            @Override
            public void handle(long now) {
                List<Entity> objects=getEntity(Entity.class);
                for(Entity object: objects) {
                    object.movement(now);
                }
                if(now - lastUpdate >= 1_000_000_000) {
                    timeLeft--;
                    timeLabel.setText("Time: "+timeLeft);
                    lastUpdate=now;
                }

                if(GameScene.FROGGER_LIVES == 5)
                    GameScene.backgroundScene.getChildren().remove(GameScene.life5);
                if(GameScene.FROGGER_LIVES == 4)
                    GameScene.backgroundScene.getChildren().remove(GameScene.life4);
                if(GameScene.FROGGER_LIVES == 3)
                    GameScene.backgroundScene.getChildren().remove(GameScene.life3);
                if(GameScene.FROGGER_LIVES == 2)
                    GameScene.backgroundScene.getChildren().remove(GameScene.life2);
                if(GameScene.FROGGER_LIVES == 1 && !noMoreLives) {
                    GameScene.backgroundScene.getChildren().remove(GameScene.life1);
                    noMoreLives=true;
                    try {
                        RankingTable.scoreRecord();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    timer.stop();
                }
            }
        };

    }
    @SuppressWarnings("unchecked")//per togliere il warning del cast,infatti ogni nodo che passa il controllo è sicuramente un'entità
    public <T extends Entity> List<T> getEntity(Class<T> cls) {
        ArrayList<T> someArray = new ArrayList<>();
        for(Node n: backgroundScene.getChildren())
            if (cls.isInstance(n)) {
                someArray.add((T)n);
            }
        return someArray;
    }




}