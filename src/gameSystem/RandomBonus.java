package gameSystem;

import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class RandomBonus  {
    private List<Integer> visible = Arrays.asList(9,83,158,233,308);
    private List<Integer> notVisible = Arrays.asList(-100,-200,-50,300,350);
    private Bonus bonus=new Bonus();

    public int visiblePos() {

        Random rand = new Random();
        return visible.get(rand.nextInt(visible.size()));
    }
    public int notVisiblePos() {

        Random rand = new Random();
        return notVisible.get(rand.nextInt(notVisible.size()));
    }

    public void changePos(int x){
        this.visible.remove(x);
    }


}
