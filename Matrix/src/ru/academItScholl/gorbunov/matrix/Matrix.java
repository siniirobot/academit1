package ru.academItScholl.gorbunov.matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


import ru.academItSchool.gorbunov.vector.Vector;

public class Matrix {

    private Vector[] vectors;

    public Matrix(int width, int height) {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("Высота и ширина матрицы не может быть меньше или равен нулю.");
        }
        this.vectors = new Vector[height];
        for (int i = 0; i < vectors.length; i++) {
            this.vectors[i] = new Vector(width);
        }
    }

    public Matrix(double[][] content) {
        if (content.length == 0) {
            throw new IllegalArgumentException("Высота и ширина матрицы не может быть меньше или равен нулю.");
        }
        boolean minWidth = false;
        for (double[] arr : content) {
            if (arr.length == 0) {
                minWidth = true;
                break;
            }
        }
        if (minWidth) {
            throw new IllegalArgumentException("Высота и ширина матрицы не может быть меньше или равен нулю.");
        }
        this.vectors = new Vector[content.length];
        for (int i = 0; i < vectors.length; i++) {
            this.vectors[i] = new Vector(content[i]);
        }
    }

    public Matrix(Vector[] vectors) {
        if (vectors.length == 0) {
            throw new IllegalArgumentException("Высота и ширина матрицы не может быть меньше или равен нулю.");
        }
        int maxVectorsLength = 0;
        for (Vector vec : vectors) {
            if (maxVectorsLength < vec.getSize()) {
                maxVectorsLength = vec.getSize();
            }
        }
        this.vectors = new Vector[vectors.length];
        for (int i = 0; i < this.vectors.length; i++) {
            this.vectors[i] = new Vector(maxVectorsLength);
            for (int j = 0; j < vectors[i].getSize(); j++) {
                this.vectors[i].setVectorElementByIndex(j, vectors[i].getVectorElementByIndex(j));
            }
        }
    }

    public Matrix(Matrix matrix) {
        this.vectors = new Vector[matrix.getHeight()];
        for (int i = 0; i < matrix.getHeight(); i++) {
            this.vectors[i] = matrix.getLineVector(i);
        }

    }

    public int getWidth() {
        int width = 0;
        for (Vector vec : vectors) {
            if (width < vec.getSize()) {
                width = vec.getSize();
            }
        }
        return width;

    }

    public int getHeight() {
        return vectors.length;
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        for (Vector vec : this.vectors) {
            stringBuilder.append("{");
            for (int i = 0; i < vec.getSize(); i++) {
                stringBuilder.append(vec.getVectorElementByIndex(i)).append(", ");
            }
            stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
            stringBuilder.append("}, ");
        }
        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
        return stringBuilder.append("}").toString();
    }

    public int[] getSize() {
        return new int[]{getHeight(), getWidth()};
    }

    public Vector getLineVector(int index) {
        return this.vectors[index];
    }

    public void setLineVector(int index, Vector vector) {
        int oldWidth = getWidth();
        this.vectors[index] = vector;
        if (oldWidth < getWidth()) {
            for (int i = 0; i < this.vectors.length; i++) {
                Vector copyVector = this.vectors[i];
                this.vectors[i] = new Vector(vector.getSize());
                for (int j = 0; j < copyVector.getSize(); j++) {
                    this.vectors[i].setVectorElementByIndex(j, copyVector.getVectorElementByIndex(j));
                }
            }
        }
    }

    public Vector getColumnVector(int index) {
        Vector columnVector = new Vector(this.vectors.length);
        for (int i = 0; i < this.vectors.length; i++) {
            columnVector.setVectorElementByIndex(i, this.vectors[i].getVectorElementByIndex(index));
        }
        return columnVector;
    }

    public void transpositionMatrix() {
        Matrix copyMatrix = new Matrix(this.vectors);
        this.vectors = new Vector[copyMatrix.getWidth()];
        for (int i = 0; i < this.vectors.length; i++) {
            this.vectors[i] = new Vector(copyMatrix.getHeight());
        }
        for (int j = 0; j < copyMatrix.getHeight(); j++) {
            Vector copyVector = copyMatrix.getLineVector(j);
            for (int k = 0; k < copyVector.getSize(); k++) {
                this.vectors[k].setVectorElementByIndex(j, copyVector.getVectorElementByIndex(k));
            }
        }
    }

    public void getMatrixScalar(int scalar){
        if (scalar == 1){
            System.out.println("Матрица останется неизменной");
            return;
        }
        for (Vector vec:this.vectors) {
            for (int i = 0;i<vec.getSize();i++){
                vec.setVectorElementByIndex(i,vec.getVectorElementByIndex(i) * scalar);
            }
        }
    }
}
