package ru.academItSchool.gorbunov.Task1.main;

import ru.academItSchool.gorbunov.Task1.Thread.ThreadOneToTen;

public class main {
    public static void main(String[] args) throws InterruptedException {
        Thread threadOneToTen = new Thread(new ThreadOneToTen());
        threadOneToTen.start();
        threadOneToTen.join();
        System.out.println("Исполнение продолжено");
    }
}
