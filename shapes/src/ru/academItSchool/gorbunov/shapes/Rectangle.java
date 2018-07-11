package ru.academItSchool.gorbunov.shapes;

import ru.academItSchool.gorbunov.interfaces.Shapes;

public class Rectangle implements Shapes {
    public double a;
    public double b;

    public Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    @Override
    public double getWidth() {
        return this.a;
    }

    @Override
    public double getHeight() {
        return this.b;
    }

    @Override
    public double getPerimeter() {
        return (this.a + this.b) * 2;
    }

    @Override
    public double getArea() {
        return this.a * this.b;
    }

    public String toString() {
        return ("прямоугольник" + System.lineSeparator() + "Его высота равна - " + getHeight() + System.lineSeparator() + "Его длина равна - " + getHeight()
                + System.lineSeparator() + "Его перемитр равен  - " + getPerimeter() + System.lineSeparator() + "Его площадь равна - "
                + getArea());
    }
}
