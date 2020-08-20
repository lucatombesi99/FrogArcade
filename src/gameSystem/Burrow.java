package gameSystem;

import javafx.scene.image.Image;

import java.io.File;

import static gameSystem.gameScene.IMAGES_PATH;

public class Burrow extends Entity {

    private boolean full=false;

    public Burrow(int x,int y){
        setImage(new Image(new File(IMAGES_PATH+"End.png").toURI().toString(), 31, 31, true, true));
        setX(x);
        setY(y);
    }

    public void setFrogEnd(){
        setImage(new Image(new File(IMAGES_PATH+"FrogEnd.png").toURI().toString(), 31, 31, true, true));
        full=true;
    }
    public void setNormalEnd(){
        setImage(new Image(new File(IMAGES_PATH+"End.png").toURI().toString(), 31, 31, true, true));
    }
    public boolean isFull(){return full;}

    @Override
    public void movement(Long now) {

    }
}
