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
        this.width = width;
        this.height = height;
        this.content = new double[this.width][this.height];
    }

    public Matrix(double[][] content) {
        this.content = content;
        this.width = this.content.length;
        this.height = this.content[0].length;
    }

    public Matrix(Vector[] vectors) {

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
        for (double[] e :this.content) {
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
        return new int[]{this.width, this.height};
    }

    public Vector getLineVector(int index) {
        return vectors[index];
    }

    public void setLineVector ( int index, Vector vector) {
        for ( int i = 0; i < vector.getVectorLength(); ++i) {
            this.vectors[index].setVectorElementByIndex(i,vector.getVectorElementByIndex(i));
        }
    }
}
