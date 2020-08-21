package gameSystem;


import javafx.scene.image.ImageView;


public abstract class Entity extends ImageView {


    public void move(double dx, double dy) {
        setX(getX() + dx);
        setY(getY() + dy);
    }

    //se non le usiamo possiamo anche toglierle
    public double getWidth() {
        return this.getBoundsInLocal().getWidth();
    }

    public double getHeight() {
        return this.getBoundsInLocal().getHeight();
    }


    public abstract void movement(Long now);

}
