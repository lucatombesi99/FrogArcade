package gameSystem;

import javafx.scene.image.Image;

import java.io.File;

import static gameSystem.GameScene.IMAGES_PATH;

public class Bonus extends Entity{

    private int xPos=-100;

    public Bonus(){
        setImage(new Image(new File(IMAGES_PATH +"fly.png").toURI().toString(),25,25,true,true));
        setX(500);
        setY(107);
    }
    @Override
    public void movement(Long now) {
        if (now/900000000 % 4 == 1)
            xPos = RandomBonus.visiblePos();
        if (now/900000000 %4 == 2)
            setX(xPos+2);
        if (now/900000000 %4 == 3)
            setX(-100);

    }
}
