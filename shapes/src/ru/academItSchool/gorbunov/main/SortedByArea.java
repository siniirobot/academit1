package ru.academItSchool.gorbunov.main;

import ru.academItSchool.gorbunov.interfaces.Shape;

import java.util.Comparator;

public class SortedByArea implements Comparator<Shape> {
    public int compare(Shape shape, Shape shape1) {
        return Double.compare(shape.getArea(), shape1.getArea());
    }
}
