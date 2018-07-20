package ru.academItScholl.gorbunov.matrix;

import java.util.Vector;

public class Matrix {
    private int width;
    private int height;
    private double[][] content;
    private Vector[] vectors;

    public Matrix(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public Matrix(double[][] content) {
        this.content = content;
    }

    public Matrix(Vector[] vectors) {
        this.vectors = vectors;
    }

    public Matrix(Matrix aMatrix) {
        this(aMatrix.getWidth(), aMatrix.height);
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public double[][] getContent() {
        return content;
    }

    public void setContent(double[][] content) {
        this.content = content;
    }

    public Vector[] getVectors() {
        return vectors;
    }

    public void setVectors(Vector[] vectors) {
        this.vectors = vectors;
    }

    public int[] getSize() {
        return new int[]{this.width,this.height};
    }

    public int getInsert() {
        return 0;
    }
}
