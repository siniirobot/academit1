package ru.academItSchool.gorbunov.vector;

import java.util.Arrays;

public class Vector {
    private double[] components;

    public Vector(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Меньше нуля вектор быть не может");
        }
        this.components = new double[n];
    }

    public Vector(Vector vector) {
        this.components = Arrays.copyOf(vector.components, vector.components.length);
    }

    public Vector(double[] components) {
        if (components.length <= 0) {
            throw new IllegalArgumentException("Меньше нуля вектор быть не может");
        }
        this.components = Arrays.copyOf(components, components.length);
    }

    public Vector(int n, double[] components) {
        if (n <= 0) {
            throw new IllegalArgumentException("Меньше нуля вектор быть не может");
        }
        this.components = Arrays.copyOf(components, n);
    }

    public int getSize() {
        return this.components.length;
    }

    public void sum(Vector vector) {
        changeVectorLength(vector);
        for (int i = 0; i < vector.getSize(); i++) {
            this.components[i] += vector.components[i];
        }
    }

    private void changeVectorLength(Vector vector) {
        if (this.components.length < vector.components.length) {
            this.components = Arrays.copyOf(this.components, vector.components.length);
        }
    }

    public void subtraction(Vector vector) {
        changeVectorLength(vector);
        for (int i = 0; i < vector.getSize(); i++) {
            this.components[i] -= vector.components[i];
        }
    }

    public void multiplicationByScalar(double scalar) {
        for (int i = 0; i < this.components.length; ++i) {
            this.components[i] *= scalar;
        }
    }

    public void turn() {
        multiplicationByScalar(-1);
    }

    public double getLength() {
        double vectorModule = 0;
        for (double e : this.components) {
            vectorModule += e * e;
        }
        return Math.sqrt(vectorModule);
    }

    public double getElementByIndex(int index) {
        return this.components[index];
    }

    public void setElementByIndex(int index, double element) {
        this.components[index] = element;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        for (double e : components) {
            stringBuilder.append(e).append(", ");
        }
        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
        return stringBuilder.append("}").toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Vector vector = (Vector) obj;
        return Arrays.equals(this.components, vector.components);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(components);
    }

    public static Vector getSum(Vector vector1, Vector vector2) {
        Vector newVector = new Vector(vector1);
        newVector.sum(vector2);
        return newVector;
    }

    public static Vector getSubtraction(Vector vector1, Vector vector2) {
        Vector newVector = new Vector(vector1);
        newVector.subtraction(vector2);
        return newVector;
    }

    public static double getScalarMultiplication(Vector vector1, Vector vector2) {
        int result = 0;
        int minLength = Math.min(vector1.components.length, vector2.components.length);
        for (int i = 0; i < minLength; ++i) {
            result += vector1.components[i] * vector2.components[i];
        }
        return result;
    }
}
