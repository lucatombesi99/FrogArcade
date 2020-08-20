package gameSystem;

import javafx.scene.image.Image;

import java.io.File;

import static gameSystem.gameScene.IMAGES_PATH;

public class Death {
    static int carD = 0;
    static int watD = 0;

    public static boolean carDeath(Long now, Frog frog) {

        boolean death=false;
        if (now  % 12 == 0)
            carD++;

        if (carD == 1) {
            frog.setImage(new Image(new File(IMAGES_PATH + "cardeath1.png").toURI().toString(), 30, 30, true, true));

        }if (carD == 2) {
            frog.setImage(new Image(new File(IMAGES_PATH + "cardeath2.png").toURI().toString(), 30, 30, true, true));

        }if (carD == 3) {
            frog.setImage(new Image(new File(IMAGES_PATH + "cardeath3.png").toURI().toString(), 30, 30, true, true));

        }if (carD == 4) {
            frog.setImage(new Image(new File(IMAGES_PATH + "froggerUp.png").toURI().toString(), 30, 30, true, true));
            carD = 0;
            frog.setX(135);
            frog.setY(475);
            death=true;

        }
        return death;

    }

    public static boolean waterDeath(Long now, Frog frog) {

        boolean death=false;
        if (now % 12 == 0)
            watD++;

        if (watD == 1) {
            frog.setImage(new Image(new File(IMAGES_PATH + "waterdeath1.png").toURI().toString(), 30, 30, true, true));
        }if (watD == 2) {
            frog.setImage(new Image(new File(IMAGES_PATH + "waterdeath2.png").toURI().toString(), 30, 30, true, true));
        }if (watD == 3) {
            frog.setImage(new Image(new File(IMAGES_PATH + "waterdeath3.png").toURI().toString(), 30, 30, true, true));
        }if (watD == 4) {
            frog.setImage(new Image(new File(IMAGES_PATH + "froggerUp.png").toURI().toString(), 30, 30, true, true));
            watD = 0;
            frog.setX(135);
            frog.setY(475);
            death=true;

        }
        return death;

    }

}
/*


 */