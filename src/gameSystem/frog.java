package gameSystem;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.io.File;

import static java.lang.Thread.sleep;

public class frog extends entity{
    final static String IMAGES_PATH = "Resources\\Images\\";
    Image imgW1;
    Image imgA1;
    Image imgS1;
    Image imgD1;
    Image imgW2;
    Image imgA2;
    Image imgS2;
    Image imgD2;
    double movementV=23;
    double movementH=10.666666;
    boolean goUp,goLeft,goDown,goRight;
    private boolean singleClick=true;
    int size=30;//serve a fare lo scaling della rana

    public frog(String link,Scene scene){
        setImage(new Image(new File(link).toURI().toString(),size,size,true,true));
        setX(140);
        setY(470);
        imgW1 = new Image(new File(IMAGES_PATH + "froggerUp.png").toURI().toString(),size,size,true,true);
        imgA1 = new Image(new File(IMAGES_PATH + "froggerLeft.png").toURI().toString(),size,size,true,true);
        imgS1 = new Image(new File(IMAGES_PATH + "froggerDown.png").toURI().toString(),size,size,true,true);
        imgD1 = new Image(new File(IMAGES_PATH + "froggerRight.png").toURI().toString(),size,size,true,true);
        imgW2 = new Image(new File(IMAGES_PATH + "froggerUpJump.png").toURI().toString(),size,size,true,true);
        imgA2 = new Image(new File(IMAGES_PATH + "froggerLeftJump.png").toURI().toString(),size,size,true,true);
        imgS2 = new Image(new File(IMAGES_PATH + "froggerDownJump.png").toURI().toString(),size,size,true,true);
        imgD2 = new Image(new File(IMAGES_PATH + "froggerRightJump.png").toURI().toString(),size,size,true,true);

        //movimento
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent event){

                if (event.getCode() == KeyCode.W && singleClick){
                    singleClick=false;
                    move(0, -movementV);
                    setImage(imgW2);

                }
                else if(event.getCode() == KeyCode.A && singleClick ){
                    singleClick=false;
                    move(-movementH, 0);
                    setImage(imgA2);

                }
                else if(event.getCode() == KeyCode.S && singleClick ){
                    singleClick=false;
                    move(0, movementV);
                    setImage(imgS2);

                }
                else if(event.getCode() == KeyCode.D && singleClick) {
                    singleClick=false;
                    move(movementH, 0);
                    setImage(imgD2);

                }


            }
        });

        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent event){
                if (event.getCode() == KeyCode.W){
                    setImage(imgW1);
                    singleClick=true;
                }
                else if(event.getCode() == KeyCode.A){
                    setImage(imgA1);
                    singleClick=true;
                }
                else if(event.getCode() == KeyCode.S){
                    setImage(imgS1);
                    singleClick=true;
                }
                else if(event.getCode() == KeyCode.D){
                    setImage(imgD1);
                    singleClick=true;
                }

            }
        });



        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {

            }



        };
        timer.start();
    }

    }

/*
         public void handle(KeyEvent event){
                if (event.getCode() == KeyCode.W){
                    goUp=true;
                    setImage(imgW2);
                }
                else if(event.getCode() == KeyCode.A){
                    goLeft=true;
                    setImage(imgA2);
                }
                else if(event.getCode() == KeyCode.S){
                    goDown=true;
                    setImage(imgS2);
                }
                else if(event.getCode() == KeyCode.D){
                    goRight=true;
                    setImage(imgD2);
                }

            }
        });

        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent event){
                if (event.getCode() == KeyCode.W){
                    goUp=false;
                    setImage(imgW1);
                }
                else if(event.getCode() == KeyCode.A){
                    goLeft=false;
                    setImage(imgA1);
                }
                else if(event.getCode() == KeyCode.S){
                    goDown=false;
                    setImage(imgS1);
                }
                else if(event.getCode() == KeyCode.D){
                    goRight=false;
                    setImage(imgD1);
                }

            }
        });

 */