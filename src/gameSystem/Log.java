package gameSystem;

import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;

import java.io.File;

import static gameSystem.gameScene.IMAGES_PATH;

public class Log extends entity {

    private double speed;

    public Log(String logImage, int size, int xPos, int yPos, double speed) {

        setImage(new Image(new File(logImage).toURI().toString(), size, size, true, true));
        setX(xPos);
        setY(yPos);
        this.speed = speed;


        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                move(speed , 0);
                if (getX()>500 && speed>0)
                    setX(-180);
                if (getX()<-50 && speed<0)
                    setX(700);

            }


        };
        timer.start();
    }
}

