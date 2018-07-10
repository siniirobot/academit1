package ru.academItSchool.gorbunov.shapes;

import ru.academItSchool.gorbunov.interfaces.shapes;

public class Circle implements shapes {
    public double r;
    private final double PI = 3.1415;

    public Circle(double r) {
        this.r = r;
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    @Override
    public double getHeight() {
        return this.r * 2;
    }

    @Override
    public double getWidth() {
        return this.r * 2;
    }

    @Override
    public double getPerimeter() {
        return 2 * PI * this.r;
    }

    @Override
    public double getArea() {
        return PI * (this.r * this.r);
    }
}
