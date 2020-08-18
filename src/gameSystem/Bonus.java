package gameSystem;

import javafx.scene.image.Image;

import java.io.File;

import static gameSystem.gameScene.IMAGES_PATH;

public class Bonus extends Entity{

    public Bonus(){
        setImage(new Image(new File(IMAGES_PATH +"fly.png").toURI().toString(),25,25,true,true));
        setX(500);
        setY(107);
    }
    @Override
    public void movement(Long now) {

    }
}
