package ru.academItSchool.gorbunov.main;

import ru.academItSchool.gorbunov.interfaces.Shape;
import ru.academItSchool.gorbunov.shapes.Circle;
import ru.academItSchool.gorbunov.shapes.Rectangle;
import ru.academItSchool.gorbunov.shapes.Square;
import ru.academItSchool.gorbunov.shapes.Triangle;

import java.util.Arrays;


public class Realization {
    public static void main(String[] args) {
        Square square1 = new Square(-5.4);
        Square square2 = new Square(88080);

        Triangle triangle1 = new Triangle(2.4, 98.6, -5.1, 33, 47, 66.6);
        Triangle triangle2 = new Triangle(1, 558, 124, 35, 74, 66);
        Triangle triangle3 = new Triangle(1, 558, 124, 35, 74, 66);

        Rectangle rectangle1 = new Rectangle(4.4, 33.7);
        Rectangle rectangle2 = new Rectangle(24, 22);

        Circle circle1 = new Circle(41.1);
        Circle circle2 = new Circle(45);
        Circle circle3 = new Circle(45);

        Shape[] shape = {square1, square2, triangle1, triangle2, triangle3, rectangle1, rectangle2, circle1, circle2, circle3};

        System.out.println("Фигура с максимальной площадью это " + getMaxArea(shape).toString());
        System.out.println("Фигура со вторым по величине периметром это " + getSecondMaxPerimeter(shape).toString());
    }

    private static Shape getMaxArea(Shape[] shape) {
        Arrays.sort(shape, new SortedByAreaComparator());
        return shape[shape.length - 1];
    }

    private static Shape getSecondMaxPerimeter(Shape[] shape) {
        Arrays.sort(shape, new SortedByPerimeterComparator());
        return shape[shape.length - 2];
    }
}
