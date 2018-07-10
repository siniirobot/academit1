package ru.academItSchool.gorbunov.shapes;

import ru.academItSchool.gorbunov.interfaces.shapes;

public class Sqare implements shapes {
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

}
