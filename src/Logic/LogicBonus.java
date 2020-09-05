package Logic;



import javafx.scene.paint.Color;


public class LogicBonus extends LogicEntities{
    private double xPos = -100;
    public static double newPos;

    public LogicBonus(){
        setX(500);
        setY(107);
        setWidth(25);
        setHeight(16.21);
        setFill(Color.BLACK);
    }


    @Override
    public void movement(Long now) {
        if (now/900000000 % 4 == 1)
            xPos = RandomBonus.visiblePos();
        if (now/900000000 %4 == 2) {
            setX(xPos + 2);
            newPos=xPos+2;
        }
        if (now/900000000 %4 == 3) {
            setX(-100);
            newPos=-100;
        }
    }
}