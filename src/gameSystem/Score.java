package gameSystem;


import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;



public class Score extends Pane {

    int score = 0;
    Label scoreLabel = new Label("Score: " + score);



    public Score() {
        scoreLabel.setFont(new Font("Calibri", 20));
        scoreLabel.setTranslateX(50.0);
        scoreLabel.setTranslateY(10.0);

        getChildren().add(scoreLabel);

    }


    public void addPoints(int score) {
        this.score += score;
        scoreLabel.setText("Score: " + score);

    }

}