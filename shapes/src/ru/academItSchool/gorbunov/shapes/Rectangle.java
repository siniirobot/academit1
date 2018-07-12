package ru.academItSchool.gorbunov.shapes;

import ru.academItSchool.gorbunov.interfaces.Shape;

public class Rectangle implements Shape {
    public double side;
    public double side1;

    public Rectangle(double side, double side1) {
        this.side = side;
        this.side1 = side1;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public double getSide1() {
        return side1;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
    }

    @Override
    public double getWidth() {
        return this.side;
    }

    @Override
    public double getHeight() {
        return this.side1;
    }

    @Override
    public double getPerimeter() {
        return (this.side + this.side1) * 2;
    }

    @Override
    public double getArea() {
        return this.side * this.side1;
    }

    public String toString() {
        return ("прямоугольник" + System.lineSeparator() + "Его высота равна - " + getHeight() + System.lineSeparator() + "Его ширина равна - " + getHeight()
                + System.lineSeparator() + "Его периметр равен  - " + getPerimeter() + System.lineSeparator() + "Его площадь равна - "
                + getArea());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) side;
        result = prime * result + (int) side1;
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

        Rectangle rectangle = (Rectangle) obj;

        if (side == rectangle.side) {
            return true;
        }

        return side1 == rectangle.side1;
    }
}
