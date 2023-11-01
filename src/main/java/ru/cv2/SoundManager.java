package ru.cv2;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class SoundManager {

    public synchronized void playSound(String state) {
        new Thread(() -> {
            try {
                String filepath = "";
                Clip clip = AudioSystem.getClip();
                switch (state){
                    case "Liquid" -> filepath = "src/main/java/ru/cv2/sounds/bottle.wav";
                    case "Coil" -> filepath = "src/main/java/ru/cv2/sounds/coils.wav";
                    case "Charger" -> filepath = "src/main/java/ru/cv2/sounds/charger.wav";
                    case "Free" -> filepath = "src/main/java/ru/cv2/sounds/free.wav";
                    case "Vape" -> filepath = "src/main/java/ru/cv2/sounds/vape.wav";
                }
                AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File(filepath));
                clip.open(inputStream);
                clip.start();
            } catch (Exception ex) {
                System.out.println("Where are my sounds? Why is this like that i hate java so much help me");
            }

        }).start();
    }
}
