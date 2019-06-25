package ru.academItSchool.gorbunov.Minesweeper.Model;

public class Timer implements Runnable {
    private int time = 0;

    public int getTime() {
        return time;
    }

    @Override
    public void run() {
        for (; time <= 9999; time++) {
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("fake");
                System.exit(-1);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ignored) {
            }

        }
    }
}
