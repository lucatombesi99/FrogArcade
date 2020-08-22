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


    Media media;
    static double  timeLeft=61;//da modificare con le scene
    private long lastUpdate = 0 ;
    public static int points=0;


    public static int FROGGER_LIVES = 5; //da modificare con le scene
    public static boolean lifelost=false;
    EasyScene easy=new EasyScene();
    MediumScene medium=new MediumScene();
    HardScene hard=new HardScene();


    public static Button pauseButton;

    Label timeLabel;
    Label scoreLabel;
    static AnchorPane root;

    public static MediaPlayer mediaPlayer;





    public  void startGame(Stage primaryStage, int difficulty) {

        FROGGER_LIVES=FROGGER_LIVES-difficulty;
        timeLeft=timeLeft-(difficulty*15);

        //MUSICA di SOTTOFONDO
        media = new Media(new File(Main.AUDIO_PATH + "theme.mp3").toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.play();


        if(difficulty==0)
        root=easy.setScene();
        else if(difficulty==1)
            root=medium.setScene();
        else
            root=hard.setScene();


        //Bottone
        pauseButton = new Button("||");
        AnchorPane.setTopAnchor(pauseButton, 7.0);
        AnchorPane.setLeftAnchor(pauseButton, 0.0);
        //Etiichetta tempo
        timeLabel=new Label("Time: "+timeLeft);
        timeLabel.setFont(new Font("Calibri", 20));
        AnchorPane.setTopAnchor(timeLabel, 10.0);
        AnchorPane.setLeftAnchor(timeLabel, 185.0);

        //Etichetta Punteggio
        scoreLabel = new Label("Score: "+ points);
        scoreLabel.setFont(new Font("Calibri", 20));
        AnchorPane.setTopAnchor(scoreLabel, 10.0);
        AnchorPane.setLeftAnchor(scoreLabel, 30.0);

        root.getChildren().addAll(timeLabel,pauseButton,scoreLabel);

        Scene scene = new Scene(root, 350, 505);
        primaryStage.setScene(scene);

       startMoving();
       timer.start();


        List<Entity> interceptable=getEntity(Entity.class);
        System.out.println(interceptable);

        //rana
        Frog f = new Frog(Main.IMAGE_PATH +"froggerUp.png",scene,interceptable);
        root.getChildren().addAll(f);


        primaryStage.setScene(scene);


       pauseButton.setOnAction(e ->{
           pauseButton.setDisable(true);
           PauseClass.pause(timer,pauseButton);});

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

                if(lifelost)
                    root.getChildren().remove(root.getChildren().size()-6);

                if(FROGGER_LIVES==0){
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
        for(Node n: root.getChildren())
            if (cls.isInstance(n)) {
                someArray.add((T)n);
            }
        return someArray;
    }




}
