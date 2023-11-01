package ru.cv2;

public class Index {
    private int ix;

    public synchronized int getIx(){
        return ix;
    }

    public synchronized void setIx(int ix){
        this.ix = ix;
    }
}
