package gameSystem;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

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
    double movementV=13.3333333*2;
    double movementH=10.666666*2;
    int size=40;//serve a fare lo scaling della rana

    public frog(String link,Scene scene){
        setImage(new Image(link,size,size,true,true));
        imgW1 = new Image(IMAGES_PATH+"froggerUp",size,size,true,true);
        imgA1 = new Image(IMAGES_PATH+"froggerLeft",size,size,true,true);
        imgS1 = new Image(IMAGES_PATH+"froggerDown",size,size,true,true);
        imgD1 = new Image(IMAGES_PATH+"froggerRight",size,size,true,true);
        imgW2 = new Image(IMAGES_PATH+"froggerUpJump",size,size,true,true);
        imgA2 = new Image(IMAGES_PATH+"froggerLeftJump",size,size,true,true);
        imgS2 = new Image(IMAGES_PATH+"froggerRightJump",size,size,true,true);
        imgD2 = new Image(IMAGES_PATH+"froggerDownJump",size,size,true,true);

        //movimento
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent event){
                if (event.getCode() == KeyCode.W){
                    move(0, -movementV);
                    setImage(imgW2);
                }
                else if(event.getCode() == KeyCode.A){
                    move(-movementH, 0);
                    setImage(imgA2);
                }
                else if(event.getCode() == KeyCode.S){
                    move(0, movementV);
                    setImage(imgS2);
                }
                else if(event.getCode() == KeyCode.D){
                    move(movementH, 0);
                    setImage(imgD2);
                }

            }
        });

        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent event){
                if (event.getCode() == KeyCode.W){
                    setImage(imgW1);
                }
                else if(event.getCode() == KeyCode.A){
                    setImage(imgA1);
                }
                else if(event.getCode() == KeyCode.S){
                    setImage(imgS1);
                }
                else if(event.getCode() == KeyCode.D){
                    setImage(imgD1);
                }

            }
        });


    }
}
