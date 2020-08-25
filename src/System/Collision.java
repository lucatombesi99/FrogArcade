package System;



import java.util.ArrayList;
import java.util.List;

public class Collision {
    

    public static <T extends Entity> boolean specificCollision(List<Entity> interceptable, Frog f, Class<T> cls){
        boolean collides=false;
        List<T> sameEntities=getSpecificEntity(interceptable,cls);
        for(T entity: sameEntities)
            if(entity.intersects(f.getBoundsInLocal()))
                collides=true;



        return collides;
    }

    @SuppressWarnings("unchecked")
    public static <T extends Entity> List<T> getSpecificEntity(List<Entity> interceptable, Class<T> cls) {
        ArrayList<T> entityArray = new ArrayList<>();
        for (Entity entity : interceptable)
            if (cls.isInstance(entity))
                entityArray.add((T) entity);

        return entityArray;
    }

    public static <T extends Entity> T getOne(List<Entity> interceptable, Frog f, Class<T> cls){
        T theOne=null;
        List<T> sameOnes=getSpecificEntity(interceptable,cls);
        for(T one: sameOnes)
            if(one.intersects(f.getBoundsInLocal()))
                theOne=one;

            return theOne;

    }


}
