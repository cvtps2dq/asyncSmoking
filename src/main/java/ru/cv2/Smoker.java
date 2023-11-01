package ru.cv2;

import ru.cv2.UI.UIPanel;

import javax.swing.*;
import java.io.IOException;
import java.util.concurrent.Semaphore;

public class Smoker extends Thread {
    private final String ing;
    private final Semaphore semaphore;
    private final int ix;
    private final UIPanel panel;
    private final Index curIx;
    private final SoundManager soundManager;

    private void exeptionHandler(IOException ex){
        System.out.println("Exception in Smoker class. Damn.");
        System.out.println("Learn to handle images for God's sake...");
        ex.printStackTrace();
    }
    private void wrappedSleep(int sleepTime){
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }
    }

    public Smoker(String ing, Semaphore semaphore, int ix, UIPanel panel, Index curIx, SoundManager soundManager) {
        this.ing = ing;
        this.semaphore = semaphore;
        this.ix = ix;
        this.panel = panel;
        this.curIx = curIx;
        this.soundManager = soundManager;
    }

    @Override
    public void run() {
        System.out.println("Thread is created");
        while (!isInterrupted()) {
            if (this.ix == curIx.getIx()){
                System.out.println("Vaper " + ix + " is freeing the table.");
                semaphore.release(2);
                SwingUtilities.invokeLater(()->{
                    try {
                        soundManager.playSound("Free");
                        panel.setImg("Free");
                        panel.repaint();
                    } catch (IOException ex) {
                        exeptionHandler(ex);
                    }
                });

                System.out.println("Vaper " + ix + " is preparing his vape... " + ing);
                wrappedSleep(1000);
                SwingUtilities.invokeLater(()->{
                    try {
                        soundManager.playSound(ing);
                        panel.setImg(ing);
                        panel.repaint();
                    } catch (IOException ex) {
                        exeptionHandler(ex);
                    }
                });
                System.out.println("Vaper " + ix + "had enough " + ing);
            }
            else {
                Thread.yield();
            }
        }
    }
}

