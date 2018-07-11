package ru.academItSchool.gorbunov.main;

import ru.academItSchool.gorbunov.interfaces.Shapes;

import java.util.Comparator;

public class SortedByPerimetr implements Comparator<Shapes> {

    public int compare(Shapes shape, Shapes shapes1) {
        return Double.compare(shape.getPerimeter(), shapes1.getPerimeter());
    }
}