package myGame.View;

import javafx.scene.Scene;

public interface  IView {

       int getDifficulty();

       void ViewMovement(long now);

      int getNumberOfEntites();

       double[] getEntity(int index);

      Scene getScene();

      boolean getLifeLost();

      boolean getTimerActive();

      boolean updateIsStarted();


}
