package ru.academItSchool.gorbunov.shapes;

import ru.academItSchool.gorbunov.interfaces.Shape;

import java.util.Scanner;

public class Square implements Shape {
    private double side;

    public Square(double side) {
        /*if (side <= 0) {
            throw new RuntimeException("Файл не может быть меньше нуля.");
        }
        this.side = side;*/

        while (side <= 0) {
            try {
                throw new RuntimeException("Файл не может быть меньше нуля.");
            }catch (RuntimeException e) {
                System.out.println("Попробуйте ввести значение больше нуля.");
                Scanner scanner = new Scanner(System.in);
                side = scanner.nextDouble();
            }finally {
                this.side = side;
            }
        }



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
        result = prime * result + Double.hashCode(side);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Square square = (Square) obj;

        return side == square.side;
    }
}
