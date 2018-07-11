package ru.academItSchool.gorbunov.shapes;

import ru.academItSchool.gorbunov.interfaces.Shapes;

public class Circle implements Shapes {
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

    public String toString() {
        return ("круг" + System.lineSeparator() + "Его высота равна - " + getHeight() + System.lineSeparator() + "Его длина равна - " + getHeight()
                + System.lineSeparator() + "Его периметр равен  - " + getPerimeter() + System.lineSeparator() + "Его площадь равна - "
                + getArea());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        return prime * result + (int)r;
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

        Circle circle = (Circle) obj;

        if (r != circle.r) {
            return false;
        }
        return r != circle.r;
    }
}
