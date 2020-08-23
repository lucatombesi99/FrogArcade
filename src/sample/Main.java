package sample;


import gameSystem.GameScene;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;


public class Main extends Application {

    public final static String AUDIO_PATH = "Resources\\Audio\\";
    public final static String IMAGE_PATH = "Resources\\Images\\";
    final static int SCREEN_MENU_WIDTH = 460;
    final static int SCREEN_MENU_HEIGHT= 280;
    public static Scene scene;
    public static Stage primaryStage;
    Button playButton;
    Button exitButton;
    Button audioButton;
    Button rankingButton;
    static ChoiceBox<String> difficultyChoiceBox;
    AnchorPane menuPane;
    BackgroundImage backgroundImage;
    String green = IMAGE_PATH +"green.jpg";
    Image greenImage;
    Image redImage;
    String red = IMAGE_PATH + "red.jpg";


    @Override
    public void start(Stage primaryStage) throws Exception{
        Main.primaryStage =primaryStage;
        primaryStage.setTitle("FROGGER THE GAME ");
        MenuActions.play();

        //BUTTON PLAY Settings
        playButton = new Button("PLAY");
        playButton.setPrefSize(202.0,72.0);
        playButton.setFont(new Font(30));
        greenImage = new Image(new File(green).toURI().toString());
        BackgroundImage greenBack = new BackgroundImage(greenImage, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);
        playButton.setBackground(new Background(greenBack));


        //BUTTON EXIT Settings
        exitButton = new Button("EXIT");
        exitButton.setPrefSize(96.0,37.0);
        redImage = new Image(new File(red).toURI().toString());
        BackgroundImage redBack = new BackgroundImage(redImage,BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);
        exitButton.setBackground(new Background(redBack));


        //PULSANTE AUDIO Settings
        audioButton = new Button("AUDIO ON/OFF");
        audioButton.setPrefSize(96.0,37.0);


        //CHOICEBOX DIFFICULTY Settings
        difficultyChoiceBox = new ChoiceBox<>();
        difficultyChoiceBox.setPrefSize(96.0,37.0);
        difficultyChoiceBox.getItems().addAll("EASY", "MEDIUM", "HARD");
        difficultyChoiceBox.setValue("MEDIUM");


        //PULSANTE AUDIO Settings
        rankingButton = new Button("RANKING");
        rankingButton.setPrefSize(96.0,37.0);

        //PANE
        menuPane = new AnchorPane();


        //POSITION EACH BUTTON
        AnchorPane.setTopAnchor(playButton, 101.0);
        AnchorPane.setLeftAnchor(playButton,152.0);

        AnchorPane.setTopAnchor(exitButton,227.0);
        AnchorPane.setLeftAnchor(exitButton,258.0);

        AnchorPane.setTopAnchor(difficultyChoiceBox,181.0);
        AnchorPane.setLeftAnchor(difficultyChoiceBox,258.0);

        AnchorPane.setTopAnchor(rankingButton,227.0);
        AnchorPane.setLeftAnchor(rankingButton,152.0);

        AnchorPane.setTopAnchor(audioButton,181.0);
        AnchorPane.setLeftAnchor(audioButton,152.0);


        //BACKGROUND IMAGE
        Image bkimage = new Image(new File(IMAGE_PATH + "menu..png").toURI().toString(), 498,300,false, true);
        backgroundImage = new BackgroundImage(bkimage,BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,BackgroundSize.DEFAULT);
        menuPane.setBackground(new Background(backgroundImage));

        //INSERT IN PANE
        menuPane.getChildren().addAll(playButton,difficultyChoiceBox,exitButton,audioButton,rankingButton);
        scene= new Scene(menuPane, SCREEN_MENU_WIDTH, SCREEN_MENU_HEIGHT);



        //ACTION ON BUTTON PLAY
        playButton.setOnAction(e->{
            MenuActions.stop();
            GameScene g= new GameScene();

            int difficulty;
            if(difficultyChoiceBox.getValue().equals("EASY"))
                difficulty=0;
            else if(difficultyChoiceBox.getValue().equals("MEDIUM"))
                difficulty=1;
            else
                difficulty=2;

            g.startGame(difficulty);


        });

        //ACTION ON BUTTON AUDIO
        audioButton.setOnAction(e->{

            if(MenuActions.autoPlay) {
                MenuActions.autoPlay=false;
                MenuActions.mediaPlayer.pause();
            } else {
                MenuActions.autoPlay=true;
                MenuActions.mediaPlayer.play();
            }
        });


        //ACTION ON BUTTON EXIT
        exitButton.setOnAction(e->
                primaryStage.close()
        );

        //ACTION ON BUTTON RANKING
        rankingButton.setOnAction(e-> {
            try {
                RankingTable.scoreRecord();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

            if (MenuActions.autoPlay)
                MenuActions.mediaPlayer.pause();
        });




        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }



    public static void main(String[] args) {
        launch(args);
    }
}