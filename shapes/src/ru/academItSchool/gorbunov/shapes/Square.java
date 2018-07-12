package ru.academItSchool.gorbunov.shapes;

import ru.academItSchool.gorbunov.interfaces.Shape;

public class Square implements Shape {
    public double side;

    public Square(double side) {
        this.side = side;
    }

    public double getSide() {
        return this.side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    @Override
    public double getWidth() {
        return this.side;
    }

    @Override
    public double getHeight() {
        return this.side;
    }

    @Override
    public double getArea() {
        return this.side * this.side;
    }

    @Override
    public double getPerimeter() {
        return this.side * 4;
    }

    public String toString() {
        return ("квадрат" + System.lineSeparator() + "Его высота равна - " + getHeight() + System.lineSeparator() + "Его ширина равна - " + getHeight()
                + System.lineSeparator() + "Его периметр равен  - " + getPerimeter() + System.lineSeparator() + "Его площадь равна - "
                + getArea());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        return prime * result + (int) side;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() == obj.getClass()) {
            return false;
        }

        Square square = (Square) obj;

        return side == square.side;
    }
}
