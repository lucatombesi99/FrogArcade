package gameSystem;

import javafx.scene.image.Image;
import sample.Main;

import java.io.File;

public class Burrow extends Entity {

    private boolean full=false;

    public Burrow(int x,int y){
        setImage(new Image(new File(Main.IMAGE_PATH+"End.png").toURI().toString(), 31, 31, true, true));
        setX(x);
        setY(y);
    }

    public void setFrogEnd(){
        setImage(new Image(new File(Main.IMAGE_PATH+"FrogEnd.png").toURI().toString(), 31, 31, true, true));
        full= true;
    }
    public void setNormalEnd(){
        setImage(new Image(new File(Main.IMAGE_PATH+"End.png").toURI().toString(), 31, 31, true, true));
    }

    public boolean isFull(){
        return full;
    }


    @Override
    public void movement(Long now) {

    }
}