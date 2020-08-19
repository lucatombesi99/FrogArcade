package gameSystem;

import javafx.scene.image.Image;

import java.io.File;

import static gameSystem.gameScene.IMAGES_PATH;

public class Crocodile extends Entity {

    private final double speed;
    Image crocodile1Right;
    Image crocodile2Right;
    Image crocodile1Left;
    Image crocodile2Left;

    public Crocodile(int xPos,int yPos,int size,double speed){
        this.speed=speed;
        crocodile1Right = new Image(new File(IMAGES_PATH + "crocodile1Right.png").toURI().toString(), size, 30, true, true);
        crocodile2Right = new Image(new File(IMAGES_PATH + "crocodile2Right.png").toURI().toString(), size, 30,true, true);
        crocodile1Left = new Image(new File(IMAGES_PATH + "crocodile1Left.png").toURI().toString(), size, 30,true, true);
        crocodile2Left = new Image(new File(IMAGES_PATH + "crocodile2Left.png").toURI().toString(), size, 30,true, true);
        setX(xPos);
        setY(yPos);
        setImage(crocodile1Right);
    }

    @Override
    public void movement(Long now) {
        move(speed,0);
        if(speed>0){
            if (now / 900000000 % 2 == 1)
                setImage(crocodile1Right);
            else if (now / 900000000 % 2 == 0)
                setImage(crocodile2Right);


        }else{
            if (now / 900000000 % 2 == 1)
                setImage(crocodile1Left);
            else if (now / 900000000 % 2 == 0)
                setImage(crocodile2Left);

        }
        if (getX()>500 && speed>0)
            setX(-180);
        if (getX()<-50 && speed<0)
            setX(700);

    }
}
