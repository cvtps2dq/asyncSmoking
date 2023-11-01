package ru.cv2;

import ru.cv2.UI.UIPanel;
import ru.cv2.UI.UIWindow;

import java.util.concurrent.Semaphore;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        UIWindow window = new UIWindow();
        UIPanel[] images = window.getImages();

        Index currentIndex = new Index();

        Semaphore tableSemaphore = new Semaphore(2);
        SoundManager soundManager1 = new SoundManager();
        SoundManager soundManager2 = new SoundManager();
        SoundManager soundManager3 = new SoundManager();
        Smoker smoker1 = new Smoker("Liquid", tableSemaphore, 0, images[0], currentIndex, soundManager1);
        Smoker smoker2 = new Smoker("Coil", tableSemaphore,1, images[1], currentIndex, soundManager2);
        Smoker smoker3 = new Smoker("Charger", tableSemaphore,2, images[2], currentIndex, soundManager3);
        Helper helper = new Helper(tableSemaphore, currentIndex);

        helper.start();
        smoker1.start();
        smoker2.start();
        smoker3.start();
    }
}
