package gameSystem;

import javafx.scene.Node;

import java.util.ArrayList;
import java.util.List;

public class collision {
    
    public static boolean carCollision(List<Entity> interceptable,Frog f){
        boolean collides=false;
        List<Vehicle> vehicles=getSpecificEntity(interceptable,Vehicle.class);
        for(Vehicle vehicle: vehicles)
            if(vehicle.intersects(f.getBoundsInLocal()))
                collides=true;

        
        
        return collides;
    }
    public static boolean logCollision(List<Entity> interceptable,Frog f){
        boolean collides=false;
        List<Log> logs=getSpecificEntity(interceptable,Log.class);
        for(Log log: logs)
            if(log.intersects(f.getBoundsInLocal()))
                collides=true;



        return collides;
    }
    public static boolean snakeCollision(List<Entity> interceptable,Frog f){
        boolean collides=false;
        List<Snake> snakes=getSpecificEntity(interceptable,Snake.class);
        for(Snake snake: snakes)
            if(snake.intersects(f.getBoundsInLocal()))
                collides=true;



        return collides;
    }
    public static boolean burrowCollision(List<Entity> interceptable,Frog f){
        boolean collides=false;
        List<Burrow> burrows=getSpecificEntity(interceptable,Burrow.class);
        for(Burrow burrow: burrows)
            if(burrow.intersects(f.getBoundsInLocal()))
                collides=true;



        return collides;
    }
    public static boolean bonusCollision(List<Entity> interceptable,Frog f){
        boolean collides=false;
        List<Bonus> bonusses=getSpecificEntity(interceptable,Bonus.class);
        for(Bonus bonus: bonusses)
            if(bonus.intersects(f.getBoundsInLocal()))
                collides=true;



        return collides;
    }
    public static boolean turtleCollision(List<Entity> interceptable,Frog f){
        boolean collides=false;
        List<Turtle> turtles=getSpecificEntity(interceptable,Turtle.class);
        for(Turtle turtle: turtles)
            if(turtle.intersects(f.getBoundsInLocal()))
                collides=true;



        return collides;
    }
    public static boolean crocodileCollision(List<Entity> interceptable,Frog f){
        boolean collides=false;
        List<Crocodile> crocodiles=getSpecificEntity(interceptable,Crocodile.class);
        for(Crocodile crocodile: crocodiles)
            if(crocodile.intersects(f.getBoundsInLocal()))
                collides=true;



        return collides;
    }



    public static <T extends Entity> List<T> getSpecificEntity(List<Entity> interceptable,Class<T> cls) {
        ArrayList<T> entityArray = new ArrayList<T>();
        for(int i=0;i<interceptable.size();i++)
            if (cls.isInstance(interceptable.get(i)))
                entityArray.add((T)interceptable.get(i));

        return entityArray;
    }

    public static boolean inWater(Frog f){
        boolean b=false;
        if(f.getY()<260 && f.getY()>103)
            b=true;

        return b;
    }

    public static boolean inGrass(Frog f){
        boolean b=false;
        if(f.getY()<108 )
            b=true;

        return b;
    }

    public static Log getLog(List<Entity> interceptable,Frog f){
        Log theOne=null;
        List<Log> logs=getSpecificEntity(interceptable,Log.class);
        for(Log log: logs)
            if(log.intersects(f.getBoundsInLocal()))
                theOne=log;



            return theOne;

    }
    public static Turtle getTurtle(List<Entity> interceptable,Frog f){
        Turtle theOne=null;
        List<Turtle> turtles=getSpecificEntity(interceptable,Turtle.class);
        for(Turtle turtle: turtles)
            if(turtle.intersects(f.getBoundsInLocal()))
                theOne=turtle;



        return theOne;

    }

}
