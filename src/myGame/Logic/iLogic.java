package myGame.Logic;

public interface  iLogic {

     void LogicMovement(long now);

     double[] getVariables();

     boolean updateLifeLost();

     double updateBonus();

     double getXBurrow();


}
