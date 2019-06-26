package ru.academItSchool.gorbunov.Minesweeper.Model;

public class Timer implements Runnable {
    private int time = 0;
    private boolean stop = false;

    public int getTime() {
        return time;
    }

    public void stop() {
        stop = true;
    }

    @Override
    public void run() {
        for (; time <= 9999 && !stop; time++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ignored) {
            }
        }
    }
}
