package gameSystem;

import javafx.scene.Node;

import java.util.ArrayList;
import java.util.List;

public class collision {
    

    public static <T extends Entity> boolean specificCollision(List<Entity> interceptable,Frog f,Class<T> cls){
        boolean collides=false;
        List<T> sameEntities=getSpecificEntity(interceptable,cls);
        for(T entity: sameEntities)
            if(entity.intersects(f.getBoundsInLocal()))
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

    public static <T extends Entity> T getOne(List<Entity> interceptable,Frog f,Class<T> cls){
        T theOne=null;
        List<T> sameOnes=getSpecificEntity(interceptable,cls);
        for(T one: sameOnes)
            if(one.intersects(f.getBoundsInLocal()))
                theOne=one;



            return theOne;

    }


}
