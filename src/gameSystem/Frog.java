package gameSystem;


import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.io.File;
import java.util.List;




public class Frog extends Entity {
    final static String IMAGES_PATH = "Resources\\Images\\";
    private List<Entity> entities;
    Image imgW1;
    Image imgA1;
    Image imgS1;
    Image imgD1;
    Image imgW2;
    Image imgA2;
    Image imgS2;
    Image imgD2;
    Test test;

    double movementV=31;
    double movementH=15;
    boolean isDeath=true;//per evitare che i key pressed/realesed in eccesso spostino l'animazione della morte
    boolean noMove=false;//per evitare che la rana continui a spostarsi se morta
    boolean carDeath=false;//per continuare a rimanere nell' if anche se finisce collisione
    private boolean singleClick=true;
    private static boolean death=false;




    int size=30;//serve a fare lo scaling della rana



    public Frog(String link, Scene scene, List<Entity> interceptable,Test test){
        setImage(new Image(new File(link).toURI().toString(),size,size,true,true));
        setX(135);
        setY(475);
        this.test=test;
        this.entities=interceptable;
        imgW1 = new Image(new File(IMAGES_PATH + "froggerUp.png").toURI().toString(),size,size,true,true);
        imgA1 = new Image(new File(IMAGES_PATH + "froggerLeft.png").toURI().toString(),size,size,true,true);
        imgS1 = new Image(new File(IMAGES_PATH + "froggerDown.png").toURI().toString(),size,size,true,true);
        imgD1 = new Image(new File(IMAGES_PATH + "froggerRight.png").toURI().toString(),size,size,true,true);
        imgW2 = new Image(new File(IMAGES_PATH + "froggerUpJump.png").toURI().toString(),size,size,true,true);
        imgA2 = new Image(new File(IMAGES_PATH + "froggerLeftJump.png").toURI().toString(),size,size,true,true);
        imgS2 = new Image(new File(IMAGES_PATH + "froggerDownJump.png").toURI().toString(),size,size,true,true);
        imgD2 = new Image(new File(IMAGES_PATH + "froggerRightJump.png").toURI().toString(),size,size,true,true);

        //movimento
        if(death){

        }else {
            scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
                public void handle(KeyEvent event) {


                    if (event.getCode() == KeyCode.W && singleClick && getY() > 120) {
                        singleClick = false;
                        if(isDeath){
                        move(0, -movementV);
                        setImage(imgW2);

                        }

                    } else if (event.getCode() == KeyCode.A && singleClick && getX() > 10) {
                        singleClick = false;
                        if(isDeath) {
                            move(-movementH, 0);
                            setImage(imgA2);
                        }

                    } else if (event.getCode() == KeyCode.S && singleClick && getY() < 475) {
                        singleClick = false;
                        if(isDeath) {
                            move(0, movementV);
                            setImage(imgS2);
                        }

                    } else if (event.getCode() == KeyCode.D && singleClick && getX() < 330) {
                        singleClick = false;
                        if(isDeath) {
                            move(movementH, 0);
                            setImage(imgD2);
                        }

                    }


                }


            });
        }
        if (death) {

        } else {
            scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
                public void handle(KeyEvent event) {

                    if (event.getCode() == KeyCode.W) {
                        if(isDeath) {
                            setImage(imgW1);
                            singleClick = true;
                        }
                    } else if (event.getCode() == KeyCode.A) {
                        if(isDeath) {
                            setImage(imgA1);
                            singleClick = true;
                        }
                    } else if (event.getCode() == KeyCode.S) {
                        setImage(imgS1);
                        singleClick = true;
                    } else if (event.getCode() == KeyCode.D) {
                        setImage(imgD1);
                        singleClick = true;
                    }

                }

            });
        }



    }

    @Override
    public void movement(Long now) {

        if(getX()<0 || getX()>350 || getY()<0){
            death = true;
            setX(135);
            setY(475);
        }



        if(getY()==475 && getX()==135){
            death=false;
            noMove=false;
            carDeath=false;
        }


        if (collision.specificCollision(entities, this, Vehicle.class) || collision.specificCollision(entities, this, Snake.class) || carDeath) {

             carDeath=true;
            death = true;
            isDeath = false;
            isDeath = Death.carDeath(now, this);

        }

        if (getY() < 260 && getY() > 107) {
            if(collision.specificCollision(entities, this, Turtle.class) && !noMove) {

                Turtle turtle = collision.getOne(entities, this, Turtle.class);
               if(!turtle.isWet())
                   this.move(turtle.getSpeed(), 0);
               else{
                   death = true;
                   isDeath = false;
                   noMove=true;
                   isDeath = Death.waterDeath(now, this);
               }

            }else if (collision.specificCollision(entities, this, Log.class) && !noMove) {
                Log log = collision.getOne(entities, this, Log.class);
                this.move(log.getSpeed(), 0);

            }else if(collision.specificCollision(entities, this, Crocodile.class) && !noMove){
                Crocodile croc=collision.getOne(entities, this, Crocodile.class);
                    if(croc.isHungry())

                        if(this.getX()>=(croc.getX()+65)){
                            death = true;
                            isDeath = false;
                            noMove=true;
                            isDeath = Death.waterDeath(now, this);
                        }else
                            this.move(croc.getSpeed(),0);

            }else {
                 death = true;
                 isDeath = false;
                 noMove=true;
                 isDeath = Death.waterDeath(now, this);

             }

        }

        if (getY() < 107) {
            if (collision.specificCollision(entities, this, Burrow.class)) {
                Burrow b = collision.getOne(entities, this, Burrow.class);
                if (!b.isFull()) {
                    if (collision.specificCollision(entities, this, Bonus.class))
                        System.out.println("bonus");

                    b.setFrogEnd();
                    RandomBonus.removePos((int)b.getX());
                    RandomBonus.print();
                } else {
                    death = true;
                    isDeath = false;
                    isDeath = Death.waterDeath(now, this);

                }


            }
        }
    }

}









   /* perchè non funge?
       if (collision.specificCollision(entities, this, Log.class) && !noMove) {

                Log log = collision.getOne(entities, this, Log.class);
                this.move(log.getSpeed(), 0);

            }else if(collision.specificCollision(entities, this, Turtle.class) && !noMove) {
                test.setTwo();
                Turtle turtle = collision.getOne(entities, this, Turtle.class);
              //  if(turtle!=null)
                //    test.setThree();

                this.move(turtle.getSpeed(), 0);

*/
