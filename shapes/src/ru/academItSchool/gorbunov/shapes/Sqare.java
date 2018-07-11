package ru.academItSchool.gorbunov.shapes;

import ru.academItSchool.gorbunov.interfaces.Shapes;

public class Sqare implements Shapes {
    private double a;

    public Sqare(double a) {
        this.a = a;
    }

    public double getA() {
        return this.a;
    }

    public void setA(double a) {
        this.a = a;
    }

    @Override
    public double getWidth() {
        return this.a;
    }

    @Override
    public double getHeight() {
        return this.a;
    }

    @Override
    public double getArea() {
        return this.a * this.a;
    }

    @Override
    public double getPerimeter() {
        return this.a * 4;
    }

    public String toString() {
        return ("квадрат" + System.lineSeparator() + "Его высота равна - " + getHeight() + System.lineSeparator() + "Его длина равна - " + getHeight()
                + System.lineSeparator() + "Его перемитр равен  - " + getPerimeter() + System.lineSeparator() + "Его площадь равна - "
        + getArea());
    }

}
