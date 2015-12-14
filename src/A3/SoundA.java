package A3;

/**
 * Created by School on 11/22/15.
 */

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.net.MalformedURLException;

public class SoundA {
    private static SoundA gameSounds;

    private AudioClip catCollision;
    private AudioClip fightCollision;
    private AudioClip scoopNet;
    private AudioClip backGround;

    private SoundA(){
        String soundFolder = "."+ File.separator + "src" + File.separator + "Audio" + File.separator;
        ///Users/School/Documents/CSC133/Projects/Dog_Catcher/src
        String fileName, filePath;

        File file;

        fileName = "Cat.wav";
        filePath = soundFolder + fileName;
        try{
            file = new File(filePath);
            if(file.exists()){
                catCollision = Applet.newAudioClip(new File(filePath).toURI().toURL() );
            }else{
                throw new RuntimeException("Sound: File not found: " + filePath);
            }
        } catch(MalformedURLException e){
            throw new RuntimeException("Sound: malformed URL: " + e);
        }

        fileName = "Dog.wav";
        filePath = soundFolder + fileName;
        try{
            file = new File(filePath);
            if(file.exists()){
                fightCollision = Applet.newAudioClip(new File(filePath).toURI().toURL() );
            }else{
                throw new RuntimeException("Sound: File not found: " + filePath);
            }
        } catch(MalformedURLException e){
            throw new RuntimeException("Sound: malformed URL: " + e);
        }

        fileName = "Scoop.wav";
        filePath = soundFolder + fileName;
        try{
            file = new File(filePath);
            if(file.exists()){
                scoopNet = Applet.newAudioClip(new File(filePath).toURI().toURL() );
            }else{
                throw new RuntimeException("Sound: File not found: " + filePath);
            }
        } catch(MalformedURLException e){
            throw new RuntimeException("Sound: malformed URL: " + e);
        }

        fileName = "Background.wav";
        filePath = soundFolder + fileName;
        try{
            file = new File(filePath);
            if(file.exists()){
                backGround = Applet.newAudioClip(new File(filePath).toURI().toURL() );
            }else{
                throw new RuntimeException("Sound: File not found: " + filePath);
            }
        } catch(MalformedURLException e){
            throw new RuntimeException("Sound: malformed URL: " + e);
        }

    }
    public static SoundA getInstance(){
        if(gameSounds == null)
            gameSounds = new SoundA();
        return gameSounds;
    }
    public void playCatCollisionClip(){
        catCollision.play();
    }
    public void playFightCollisionClip(){
        fightCollision.play();
    }
    public void playScoopNetClip(){
        scoopNet.play();
    }
    public void playBackGroundClip(){
        backGround.loop();
    }
    public void stopBackGroundClip(){
        backGround.stop();
    }

}
