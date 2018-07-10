package ru.academItSchool.gorbunov.main;

import ru.academItSchool.gorbunov.shapes.Sqare;

import java.util.Scanner;

public class realize {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите сторону квадрата.");

        double a = scanner.nextDouble();

        Sqare side = new Sqare(a);

        double per = side.getPerimeter();
    }
}
