package ru.academItSchool.gorbunov.main;

import ru.academItSchool.gorbunov.interfaces.Shape;

import java.util.Comparator;

public class SortedByPerimeterComparator implements Comparator<Shape> {
    public int compare(Shape shape1, Shape shape2) {
        return Double.compare(shape1.getPerimeter(), shape2.getPerimeter());
    }
}