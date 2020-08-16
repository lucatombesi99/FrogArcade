package gameSystem;


import javafx.scene.image.Image;

import java.io.File;

public class Vehicle extends entity {


    double speed;

    public Vehicle(String carImage, int  size, double xPos, double yPos, double speed){

        setImage(new Image(new File(carImage).toURI().toString(), size, size, true, true));
        setX(xPos);
        setY(yPos);
        this.speed= speed;
    }


}