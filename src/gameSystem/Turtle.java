package gameSystem;

import javafx.scene.image.Image;
import sample.Main;

import java.io.File;


public class Turtle extends Entity {

    private final double speed;
    Image turtle1;
    Image turtle2;
    Image turtle3;
    Image turtleWet1;
    Image turtleWet2;
    Image turtleWet3;

    boolean sink = false;



    public Turtle(int xPos, int yPos, double speed, int size) {
        turtle1 = new Image(new File(Main.IMAGE_PATH+ "TurtleAnimation1.png").toURI().toString(), size, 30, true, true);
        turtle2 = new Image(new File(Main.IMAGE_PATH + "TurtleAnimation2.png").toURI().toString(), size, 30,true, true);
        turtle3 = new Image(new File(Main.IMAGE_PATH+ "TurtleAnimation3.png").toURI().toString(), size, 30,true, true);
        turtleWet1 = new Image(new File(Main.IMAGE_PATH + "TurtleAnimation2Wet.png").toURI().toString(), size, 30,true, true);
        turtleWet2 = new Image(new File(Main.IMAGE_PATH + "TurtleAnimation3Wet.png").toURI().toString(), size, 30,true, true);
        turtleWet3 = new Image(new File(Main.IMAGE_PATH + "TurtleAnimation4Wet.png").toURI().toString(),size, 30,true, true);
        setX(xPos);
        setY(yPos);
        this.speed = speed;
        setImage(turtle2);


    }
    public boolean isWet() {

        return sink;
    }
    public double getSpeed(){
        return this.speed;
    }

    @Override
    public void movement (Long now){
        move(speed, 0);
        if (getX() > 500 && speed > 0)
            setX(-180);
        if (getX() < -50 && speed < 0)
            setX(700);

        if ((now /3)/ 900000000 % 4 == 1) {
            setImage(turtleWet1);
            sink = true;
        } else if ((now /3) / 900000000 % 4 == 2) {
            setImage(turtleWet2);
            sink = true;
        } else if ((now /3) / 900000000 % 4 == 3) {
            setImage(turtleWet3);
            sink = true;
        } else if ((now /3)/ 900000000 % 3 == 0) {
            setImage(turtle2);
            sink=false;

        } else if ((now /3)/ 900000000 % 3 == 1) {
            setImage(turtle1);
            sink=false;
        } else if ((now /3)/ 900000000 % 3 == 2) {
            setImage(turtle3);
            sink=false;

        }

    }

}