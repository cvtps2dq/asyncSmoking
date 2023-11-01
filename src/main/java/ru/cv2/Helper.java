package ru.cv2;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Helper extends Thread{
    private final Semaphore semaphore;
    private final Index curIx;

    private int[] ix = {0, 1, 2};
    private Random random = new Random();

    public Helper(Semaphore semaphore, Index curIx) {
        this.semaphore = semaphore;
        this.curIx = curIx;
    }

    @Override
    public void run(){
        while (!isInterrupted()){
            try{
                semaphore.acquire(2);
                curIx.setIx(ix[random.nextInt(ix.length)]);
                System.out.println("Helper chose index number " + curIx.getIx() + ".");
                System.out.println("Helper brought ingredients");
            } catch (InterruptedException ex){
                System.out.println("Oh no, they broke everything! Look at this:");
                ex.printStackTrace();
            }
        }
    }
}
