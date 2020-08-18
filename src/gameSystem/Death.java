package gameSystem;

import javafx.scene.image.Image;

import java.io.File;

import static gameSystem.gameScene.IMAGES_PATH;

public class Death {

    public static void carDeath(Long now,Frog frog){
        int carD=0;
        if((now%12)==1)
            carD++;

        if(carD==1)
            frog.setImage(new Image(new File(IMAGES_PATH+"cardeath1.png").toURI().toString(),30,30,true,true));

        if(carD==2)
            frog.setImage(new Image(new File(IMAGES_PATH+"cardeath2.png").toURI().toString(),30,30,true,true));

        if(carD==3)
            frog.setImage(new Image(new File(IMAGES_PATH+"cardeath3.png").toURI().toString(),30,30,true,true));



    }
    public static void waterDeath(Long now,Frog frog) {
        int watD=0;
        if((now%12)==1)
            watD++;

        if(watD==1)
            frog.setImage(new Image(new File(IMAGES_PATH+"waterdeath1.png").toURI().toString(),30,30,true,true));

        if(watD==2)
            frog.setImage(new Image(new File(IMAGES_PATH+"waterdeath2.png").toURI().toString(),30,30,true,true));

        if(watD==3)
            frog.setImage(new Image(new File(IMAGES_PATH+"waterdeath3.png").toURI().toString(),30,30,true,true));


    }
}
