package ru.academItSchool.gorbunov.Task1.Main;

import ru.academItSchool.gorbunov.Task1.Thread.ThreadOneToTen;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread threadOneToTen = new Thread(new ThreadOneToTen());
        threadOneToTen.start();
        threadOneToTen.join();
        System.out.println("Исполнение продолжено");
    }
}
