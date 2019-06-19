package ru.academItSchool.gorbunov.Task1.Main;

import ru.academItSchool.gorbunov.Task1.Thread.ThreadOneToTen;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ThreadOneToTen one = new ThreadOneToTen();
        Thread threadOneToTen = new Thread(one);
        threadOneToTen.start();

        System.out.println("Исполнение продолжено");

        System.out.println(one.getI());
    }
}
