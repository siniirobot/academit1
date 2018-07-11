package ru.academItSchool.gorbunov.shapes;

import ru.academItSchool.gorbunov.interfaces.Shapes;

public class Square implements Shapes {
    public double a;

    public Square(double a) {
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
        return ("квадрат" + System.lineSeparator() + "Его высота равна - " + getHeight() + System.lineSeparator() + "Его ширина равна - " + getHeight()
                + System.lineSeparator() + "Его периметр равен  - " + getPerimeter() + System.lineSeparator() + "Его площадь равна - "
                + getArea());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        return prime * result + (int) a;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }

        Square square = (Square) obj;

        return a != square.a;
    }
}
