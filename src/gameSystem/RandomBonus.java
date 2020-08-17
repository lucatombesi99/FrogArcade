package gameSystem;

import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class RandomBonus  {
    private static List<Integer> visible = Arrays.asList(9,83,158,233,308);
    private static List<Integer> notVisible = Arrays.asList(-100,-200,-50,300,350);


    public static int visiblePos() {

        Random rand = new Random();
        return visible.get(rand.nextInt(visible.size()));
    }
    public static int notVisiblePos() {

        Random rand = new Random();
        return notVisible.get(rand.nextInt(notVisible.size()));
    }

    public static void removePos(int x){
        visible.remove(x);
    }


}
