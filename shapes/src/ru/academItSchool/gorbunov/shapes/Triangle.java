package ru.academItSchool.gorbunov.shapes;

import ru.academItSchool.gorbunov.interfaces.Shapes;

public class Triangle implements Shapes {
    public double x1;
    public double x2;
    public double x3;
    public double y1;
    public double y2;
    public double y3;

    public Triangle(double x1, double x2, double x3, double y1, double y2, double y3) {
        this.x1 = x1;
        this.x2 = x2;
        this.x3 = x3;
        this.y1 = y1;
        this.y2 = y2;
        this.y3 = y3;
    }

    public double getX1() {
        return x1;
    }

    public void setX1(double x1) {
        this.x1 = x1;
    }

    public double getX2() {
        return x2;
    }

    public void setX2(double x2) {
        this.x2 = x2;
    }

    public double getX3() {
        return x3;
    }

    public void setX3(double x3) {
        this.x3 = x3;
    }

    public double getY1() {
        return y1;
    }

    public void setY1(double y1) {
        this.y1 = y1;
    }

    public double getY2() {
        return y2;
    }

    public void setY2(double y2) {
        this.y2 = y2;
    }

    public double getY3() {
        return y3;
    }

    public void setY3(double y3) {
        this.y3 = y3;
    }

    private double[] getSides() {
        double a = Math.sqrt(Math.pow((this.x1 - this.x2), 2) + Math.pow((this.y1 - this.y2), 2));
        double b = Math.sqrt(Math.pow((this.x1 - this.x3), 2) + Math.pow((this.y1 - this.y3), 2));
        double c = Math.sqrt(Math.pow((this.x2 - this.x3), 2) + Math.pow((this.y2 - this.y3), 2));
        return new double[]{a, b, c};
    }

    @Override
    public double getHeight() {
        return Math.max(this.y1, Math.max(this.y2, this.y3)) - Math.min(this.y1, Math.min(this.y2, this.y3));
    }

    @Override
    public double getWidth() {
        return Math.max(this.x1, Math.max(this.x2, this.x3)) - Math.min(this.x1, Math.min(this.x2, this.x3));
    }

    @Override
    public double getPerimeter() {
        double[] sides = getSides();
        return sides[0] + sides[1] + sides[2];
    }

    @Override
    public double getArea() {
        double halfPerimeter = getPerimeter() / 2;
        double[] sides = getSides();
        return Math.sqrt(halfPerimeter * (halfPerimeter - sides[0]) * (halfPerimeter - sides[1]) * (halfPerimeter - sides[2]));
    }

    public String toString() {
        return ("триугольник" + System.lineSeparator() + "Его высота равна - " + getHeight() + System.lineSeparator() + "Его длина равна - " + getHeight()
                + System.lineSeparator() + "Его перемитр равен  - " + getPerimeter() + System.lineSeparator() + "Его площадь равна - "
                + getArea());
    }
}
