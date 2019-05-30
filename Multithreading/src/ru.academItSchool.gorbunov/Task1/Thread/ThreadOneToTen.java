package ru.academItSchool.gorbunov.Task1.Thread;

public class ThreadOneToTen implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i <= 10;i++) {
            System.out.println(i);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException ignored) {
            }
        }
    }
}
