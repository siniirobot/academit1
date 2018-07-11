package ru.academItSchool.gorbunov.main;

import ru.academItSchool.gorbunov.interfaces.Shapes;
import ru.academItSchool.gorbunov.shapes.Circle;
import ru.academItSchool.gorbunov.shapes.Rectangle;
import ru.academItSchool.gorbunov.shapes.Sqare;
import ru.academItSchool.gorbunov.shapes.Triangle;

import java.util.Arrays;


public class Realize {
    public static void main(String[] args) {
        Sqare sqare1 = new Sqare(5.4);
        Sqare sqare2 = new Sqare(88080);

        Triangle triangle1 = new Triangle(2.4, 98.6, -5.1, 33, 47, 66.6);
        Triangle triangle2 = new Triangle(1, 558, 124, 35, 74, 66);
        Triangle triangle3 = new Triangle(1, 558, 124, 35, 74, 66);

        Rectangle rectangle1 = new Rectangle(4.4, 33.7);
        Rectangle rectangle2 = new Rectangle(24, 22);

        Circle circle1 = new Circle(41.1);
        Circle circle2 = new Circle(45);
        Circle circle3 = new Circle(45);

        Shapes[] shape = {sqare1, sqare2, triangle1, triangle2, triangle3, rectangle1, rectangle2, circle1, circle2, circle3};

        System.out.println("Фигура с максимальной площадью это " + getMaxArea(shape).toString());
        System.out.println("Фигура со вторым по величине периметром это " + getSecondMaxPerimeter(shape).toString());
    }

    private static Shapes getMaxArea(Shapes[] shape) {
        Arrays.sort(shape, new SortedByArea());
        return shape[shape.length - 1];
    }

    private static Shapes getSecondMaxPerimeter(Shapes[] shape) {
        Arrays.sort(shape, new SortedByPerimeter());
        return shape[shape.length - 2];
    }
}
