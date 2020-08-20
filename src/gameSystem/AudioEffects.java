package gameSystem;

import javafx.scene.media.AudioClip;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import static gameSystem.GameScene.AUDIO_PATH;


public class AudioEffects {





    public Random rand = new Random(System.currentTimeMillis());

    //GAME AUDIOCLIP
    public static AudioClip frogJump = new AudioClip(AUDIO_PATH + "jump.wav");
    public static AudioClip frogDie = new AudioClip(AUDIO_PATH + "frog_die.ogg");
    public static AudioClip frogGoal = new AudioClip(AUDIO_PATH + "goal.ogg");
    public static AudioClip levelGoal = new AudioClip(AUDIO_PATH + "level_goal.ogg");
    public static AudioClip bonus = new AudioClip(AUDIO_PATH + "bonus.ogg");

    //WATER EFFECTS
    public static AudioClip splash= new AudioClip(AUDIO_PATH + "splash.ogg");
    public static AudioClip waterSplash= new AudioClip(AUDIO_PATH + "water-splash.ogg");

    //ROAD EFFECTS
    public static AudioClip siren = new AudioClip(AUDIO_PATH + "siren.ogg");
    public static AudioClip carPass = new AudioClip(AUDIO_PATH + "car-pass.ogg");
    public static AudioClip horn = new AudioClip(AUDIO_PATH + "long-horn.ogg");

    // 1 effect is randomly picked from road_effects or water_effects every couple of seconds
    private List<AudioClip> road_effects = new LinkedList<AudioClip>();
    private List<AudioClip> water_effects = new LinkedList<AudioClip>();

    //TIME BETWEEN 2 EFFECTS
    private int effectsDelay= 3000;
    private int deltaT=0;


    public  AudioEffects(){
        road_effects.add(siren);
        road_effects.add(carPass);
        road_effects.add(horn);

        water_effects.add(splash);
        water_effects.add(waterSplash);

    }

    //mi servono dei booleani sulla posizione della rana, cioè se la rana è sulla strada o sull' acqua
    public void playRandomAmbientSound(final long deltaMilliseconds ){

        deltaT += deltaMilliseconds;

       /* //ACQUA
        if(deltaT > effectsDelay && frog.isOnRoad()){
            deltaT = 0;
            road_effects.get(rand.nextInt(road_effects.size())).play(0.2);
        }
        //STRADA
        if(deltaT > effectsDelay && frog.isInWater()){
            deltaT = 0;
            water_effects.get(rand.nextInt(road_effects.size())).play(0.2);
        }*/
    }

    //quando la rana muore si deve stoppare la musica

    public void update(final long deltaMilliseconds){
        playRandomAmbientSound(deltaMilliseconds);


    }

}