package ru.academItSchool.gorbunov.shapes;

import ru.academItSchool.gorbunov.interfaces.Shape;

public class Triangle implements Shape {
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

    private double[] getSide() {
        double side = Math.sqrt(Math.pow((this.x1 - this.x2), 2) + Math.pow((this.y1 - this.y2), 2));
        double side1 = Math.sqrt(Math.pow((this.x1 - this.x3), 2) + Math.pow((this.y1 - this.y3), 2));
        double side2 = Math.sqrt(Math.pow((this.x2 - this.x3), 2) + Math.pow((this.y2 - this.y3), 2));
        return new double[] {side,side1,side2};
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
        double[] sides = getSide();
        return sides[0] + sides[1] + sides[2];
    }

    @Override
    public double getArea() {
        double[] sides = getSide();
        double halfPerimeter = (sides[0] + sides[1] + sides[2]) / 2;
        return Math.sqrt(halfPerimeter * (halfPerimeter - sides[0]) * (halfPerimeter - sides[1]) * (halfPerimeter - sides[2]));
    }

    public String toString() {
        return ("треугольник" + System.lineSeparator() + "Его высота равна - " + getHeight() + System.lineSeparator() + "Его ширина равна - " + getHeight()
                + System.lineSeparator() + "Его периметр равен  - " + getPerimeter() + System.lineSeparator() + "Его площадь равна - "
                + getArea());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) x1;
        result = prime * result + (int) x2;
        result = prime * result + (int) x3;
        result = prime * result + (int) y1;
        result = prime * result + (int) y2;
        result = prime * result + (int) y3;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() == obj.getClass()) {
            return false;
        }

        Triangle triangle = (Triangle) obj;

        if (x1 == triangle.x1) {
            return true;
        }

        if (x2 == triangle.x2) {
            return true;
        }

        if (x3 == triangle.x3) {
            return true;
        }

        if (y1 == triangle.y1) {
            return true;
        }

        if (y2 == triangle.y2) {
            return true;
        }

        return y3 == triangle.y3;
    }
}
