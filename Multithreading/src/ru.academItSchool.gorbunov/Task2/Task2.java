package ru.academItSchool.gorbunov.Task2;

import java.util.LinkedList;

public class Task2 {
    public static void main(String[] args) throws InterruptedException {
        final LinkedList<Integer> numbers = new LinkedList<>();
        final Object lock = new Object();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock){
                    for (int i = 0; i <= 100; i++) {
                        numbers.add(i, numbers.size());
                    }
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock){
                    for (int i = 0; i <= 100; i++) {
                        numbers.add(i, numbers.size());
                    }
                }
            }
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(numbers.size());
    }
}
