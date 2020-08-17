package gameSystem;

import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;

import java.io.File;


public class Log extends Entity {

    private double speed;

    public Log(String logImage, int size, int x, int y, double speed) {

        setImage(new Image(new File(logImage).toURI().toString(), size, size, true, true));
        setX(x);
        setY(y);
        this.speed = speed;



    }

    @Override
    public void movement(Long now) {
        move(speed , 0);
        if (getX()>500 && speed>0)
            setX(-180);
        if (getX()<-50 && speed<0)
            setX(700);
    }
}

