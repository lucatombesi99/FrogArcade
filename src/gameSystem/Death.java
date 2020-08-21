package gameSystem;

import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;
import sample.Main;
import sample.RankingTable;

import java.io.File;


public class Death {
    private final static String die= new File(Main.AUDIO_PATH + "frog_die.wav").toURI().toString();
    private static AudioClip frogDie = new AudioClip(die);

    private final static String waterSplashSound= new File(Main.AUDIO_PATH + "water-splash.wav").toURI().toString();
    private static AudioClip waterSplash= new AudioClip(waterSplashSound);

    static int carD = 0;
    static int watD = 0;

    public static boolean carDeath(Long now,Frog frog){

        boolean death= false;

        if((now% 12)==0)
            carD++;

        if(carD==1) {
            frog.setImage(new Image(new File(Main.IMAGE_PATH + "cardeath1.png").toURI().toString(), 30, 30, true, true));
            frogDie.play(20);
            GameScene.clock.animation.stop();

            //quando muore leva una vita
            if(GameScene.FROGGER_LIVES == 5)
                GameScene.backgroundScene.getChildren().remove(GameScene.life5);
            if(GameScene.FROGGER_LIVES == 4)
                GameScene.backgroundScene.getChildren().remove(GameScene.life4);
            if(GameScene.FROGGER_LIVES == 3)
                GameScene.backgroundScene.getChildren().remove(GameScene.life3);
            if(GameScene.FROGGER_LIVES == 2)
                GameScene.backgroundScene.getChildren().remove(GameScene.life2);
            if(GameScene.FROGGER_LIVES == 1) {
                GameScene.backgroundScene.getChildren().remove(GameScene.life1);
                RankingTable.scoreRecord();
            }

        }

        if(carD==2) {
            frog.setImage(new Image(new File(Main.IMAGE_PATH + "cardeath2.png").toURI().toString(), 30, 30, true, true));


        }
        if(carD==3) {
            frog.setImage(new Image(new File(Main.IMAGE_PATH + "cardeath3.png").toURI().toString(), 30, 30, true, true));

        }if (carD == 4) {
            frog.setImage(new Image(new File(Main.IMAGE_PATH + "froggerUp.png").toURI().toString(), 30, 30, true, true));
            carD = 0;
            frog.setX(135);
            frog.setY(475);
            death=true;
            GameScene.FROGGER_LIVES--;

        }
        return death;
    }


    public static boolean waterDeath(Long now,Frog frog) {

        boolean death=false;

        if((now%12)==0)
            watD++;

        if(watD==1) {
            frog.setImage(new Image(new File(Main.IMAGE_PATH + "waterdeath1.png").toURI().toString(), 30, 30, true, true));
            waterSplash.play(20);
            GameScene.clock.animation.stop();


            if(GameScene.FROGGER_LIVES == 5)
                GameScene.backgroundScene.getChildren().remove(GameScene.life5);
            if(GameScene.FROGGER_LIVES == 4)
                GameScene.backgroundScene.getChildren().remove(GameScene.life4);
            if(GameScene.FROGGER_LIVES == 3)
                GameScene.backgroundScene.getChildren().remove(GameScene.life3);
            if(GameScene.FROGGER_LIVES == 2)
                GameScene.backgroundScene.getChildren().remove(GameScene.life2);
            if(GameScene.FROGGER_LIVES == 1) {
                GameScene.backgroundScene.getChildren().remove(GameScene.life1);
                RankingTable.scoreRecord();
            }
        }

        if(watD==2) {
            frog.setImage(new Image(new File(Main.IMAGE_PATH + "waterdeath2.png").toURI().toString(), 30, 30, true, true));

        }
        if(watD==3) {
            frog.setImage(new Image(new File(Main.IMAGE_PATH + "waterdeath3.png").toURI().toString(), 30, 30, true, true));

        }if (watD == 4) {
            frog.setImage(new Image(new File(Main.IMAGE_PATH + "froggerUp.png").toURI().toString(), 30, 30, true, true));
            watD = 0;
            frog.setX(135);
            frog.setY(475);
            death=true;
            GameScene.FROGGER_LIVES--;

        }
        return death;
    }
}