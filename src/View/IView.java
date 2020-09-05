package View;

import javafx.scene.Scene;

public abstract class IView {

    public  abstract int getDifficulty();

    public abstract  void ViewMovement(long now);

    public abstract int getNumberOfEntites();

    public abstract  double[] getEntity(int index);

    public abstract Scene getScene();

    public abstract boolean getLifeLost();

    public abstract boolean getTimerActive();

    public abstract boolean updateIsStarted();
}
