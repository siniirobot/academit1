package ru.academItSchool.gorbunov.Task1.Thread;

public class ThreadOneToTen implements Runnable {
    private int i = 0;

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    @Override
    public void run() {
        for (; i <= 10;i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ignored) {
            }
        }
    }
}
