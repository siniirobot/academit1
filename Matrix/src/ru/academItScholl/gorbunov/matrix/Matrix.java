package ru.academItScholl.gorbunov.matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


import ru.academItSchool.gorbunov.vector.Vector;

public class Matrix {
    private int width;
    private int height;
    private double[][] content;
    private Vector[] vectors;

    public Matrix(int width, int height) {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("Высота и ширина матрицы не может быть меньше нуля.");
        }
        this.width = width;
        this.height = height;
        this.content = new double[this.width][this.height];
    }

    public Matrix(double[][] content) {
        this.content = content;
        this.height = this.content.length;
        this.width = maxWidth(this.content);
    }

    public Matrix(Vector[] vectors) {
        this.height = vectors.length;
        this.width = 0;
        for (Vector vec : vectors) {
            if (this.width < vec.getSize()) {
                this.width = vec.getSize();
            }
        }
        this.content = new double[this.height][this.width];
        for (int i = 0; i < this.height; i++) {
            int vectorsSize = vectors[i].getSize();
            for (int j = 0; j < vectorsSize; j++) {
                this.content[i][j] = vectors[i].getVectorElementByIndex(j);
            }
        }
    }
    //TODO Написать проверку ошибок

    private int maxWidth(double[][] array) {
        int maxWidth = 0;
        for (double[] arr : array) {
            for (int j = 0; j < arr.length; j++) {
                if (maxWidth < arr.length) {
                    maxWidth = arr.length;
                }
            }
        }
        return maxWidth;
    }

    public Matrix(Matrix matrix) {
        this.width = matrix.width;
        this.height = matrix.height;
        this.content = Arrays.copyOf(matrix.content, matrix.content.length);

    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        for (double[] e : this.content) {
            stringBuilder.append("{");
            for (double a : e) {
                stringBuilder.append(a).append(", ");
            }
            stringBuilder.deleteCharAt(stringBuilder.length() - 2);
            stringBuilder.append("}, ");
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 2);
        return stringBuilder.append("}").toString();
    }

    public int[] getSize() {
        return new int[]{this.height, this.width};
    }

    public Vector getLineVector(int index) {
        return new Vector(this.content[index]);
    }

    public void setLineVector(int index, Vector vector) {
    }
}
