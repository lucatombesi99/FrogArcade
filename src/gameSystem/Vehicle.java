package gameSystem;

import javafx.scene.image.Image;
import java.io.File;

public class Vehicle extends Entity {



    double speed;

    public Vehicle(String carImage, int  size, double xPos, double yPos, double speed){

        setImage(new Image(new File(carImage).toURI().toString(), size, size, true, true));
        setX(xPos);
        setY(yPos);
        this.speed= speed;


    }


    @Override
    public void movement(Long now) {
        move(speed , 0);
        if (getX() > 600 && speed>0)
            setX(-180);
        if (getX() < -50 && speed<0)
            setX(700);
    }
}

