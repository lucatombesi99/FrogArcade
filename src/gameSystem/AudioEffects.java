package gameSystem;

import com.sun.prism.ResourceFactory;
import javafx.scene.media.AudioClip;
import sample.Main;

import java.io.File;
import java.util.*;


public class AudioEffects {






    public Random rand = new Random(System.currentTimeMillis());

    public final static String jump= new File (Main.AUDIO_PATH+ "jump.wav").toURI().toString();
    public final static String carPassSound= new File(Main.AUDIO_PATH + "car-pass.wav").toURI().toString();
    public final static String die= new File(Main.AUDIO_PATH + "frog_die.wav").toURI().toString();
    public final static String goal= new File(Main.AUDIO_PATH + "goal.wav").toURI().toString();
    public final static String lvGoal= new File(Main.AUDIO_PATH + "level_goal.wav").toURI().toString();
    public final static String bonusSound= new File(Main.AUDIO_PATH + "bonus.wav").toURI().toString();
    public final static String splashSound= new File(Main.AUDIO_PATH + "splash.wav").toURI().toString();
    public final static String waterSplashSound= new File(Main.AUDIO_PATH + "water-splash.wav").toURI().toString();
    public final static String sirenSound= new File(Main.AUDIO_PATH + "siren.wav").toURI().toString();
    public final static String hornSound= new File(Main.AUDIO_PATH + "long-horn.wav").toURI().toString();


    //GAME AUDIOCLIP
    public static AudioClip frogJump = new AudioClip(jump);
    public static AudioClip frogDie = new AudioClip(die);
    public static AudioClip frogGoal = new AudioClip(goal);
    public static AudioClip levelGoal = new AudioClip(lvGoal);
    public static AudioClip bonus = new AudioClip(bonusSound);

    //WATER EFFECTS
    public static AudioClip splash= new AudioClip(splashSound);
    public static AudioClip waterSplash= new AudioClip(waterSplashSound);

    //ROAD EFFECTS
    public static AudioClip siren = new AudioClip(sirenSound);
    public static AudioClip carPass = new AudioClip(carPassSound);
    public static AudioClip horn = new AudioClip(hornSound);

    // 1 effect is randomly picked from road_effects or water_effects every couple of seconds
    public static LinkedList<AudioClip> road_effects;
    public static LinkedList<AudioClip> water_effects;


    //TIME BETWEEN 2 EFFECTS
    private final int effectsDelay= 3000;
    private int deltaT=0;


    public  AudioEffects(){

        road_effects = new LinkedList<>();
        road_effects.add(siren);
        road_effects.add(carPass);
        road_effects.add(horn);

        water_effects = new LinkedList<>();
        water_effects.add(splash);
        water_effects.add(waterSplash);


    }

    public void play(AudioClip audioClip){
        audioClip.play(0.2);
    }

    //mi servono dei booleani sulla posizione della rana, cioè se la rana è sulla strada o sull' acqua
    public void playRandomAmbientSound(final long deltaMilliseconds ){


        deltaT += deltaMilliseconds;
        //ACQUA
        if(deltaT> effectsDelay ){
            deltaT = 0;
            road_effects.get(rand.nextInt(road_effects.size())).play(0.2);
        }
/*
        //STRADA
        if(deltaT > effectsDelay){
            deltaT = 0;
            water_effects.get(rand.nextInt(road_effects.size())).play(0.2);
        }*/
    }
    public void update(final long deltaMs) {
        playRandomAmbientSound(deltaMs);

    }

    //quando la rana muore si deve stoppare la musica

}