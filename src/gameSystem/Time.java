package gameSystem;


import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.util.Duration;

import javax.swing.text.html.ImageView;

public class Time extends Pane{


    public  Timeline animation;
    Label timeLabel = new Label("Time: "+ "60");
    int time = 60;
    private String s="Time: ";

    public Time(){
        timeLabel.setFont(new Font("Calibri", 20));
        timeLabel.setTranslateX(150.0);
        timeLabel.setTranslateY(10.0);

        getChildren().add(timeLabel);

        animation = new Timeline(new KeyFrame(Duration.seconds(1), e-> timeLabel()));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();

    }

    private void timeLabel(){
        if(time> 0){
            time--;
        }else if(time== 0 ){
            time=60;
            animation.setDelay(Duration.seconds(2));
        }
        s = time + "";
        timeLabel.setText("Time: " + s);
    }

    private void stopTime(){
        animation.stop();
    }

    private void restartTime(){
        animation.playFromStart();
    }

    private void finishTime(Pane pane, ImageView im){
        if(time==0 && GameScene.FROGGER_LIVES>0){
            animation.stop();
            pane.getChildren().remove(im);
        }
    }

}