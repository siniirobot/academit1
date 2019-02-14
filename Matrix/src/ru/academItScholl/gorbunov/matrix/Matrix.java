package ru.academItScholl.gorbunov.matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


import ru.academItSchool.gorbunov.vector.Vector;

public class Matrix {

    final private double EPSILON = 0.1e-10;
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

    public void getMatrixScalar(int scalar) {
        if (scalar == 1) {
            System.out.println("Матрица останется неизменной");
            return;
        }
        for (Vector vec : this.vectors) {
            for (int i = 0; i < vec.getSize(); i++) {
                vec.setVectorElementByIndex(i, vec.getVectorElementByIndex(i) * scalar);
            }
        }
    }

    public double getDeterminant() {
        if (getWidth() != getHeight()) {
            throw new IllegalArgumentException("Вычислить детерминант не квадратичной матрицы нельзя.");
        }
        if (this.vectors.length == 1) {
            return this.vectors[0].getVectorElementByIndex(0);
        } else if (this.vectors.length == 2) {
            return this.vectors[0].getVectorElementByIndex(0) * this.vectors[1].getVectorElementByIndex(1) - this.vectors[0].getVectorElementByIndex(1) * this.vectors[1].getVectorElementByIndex(0);
        } else if (this.vectors.length == 3) {
            return this.vectors[0].getVectorElementByIndex(0) * this.vectors[1].getVectorElementByIndex(1) * this.vectors[2].getVectorElementByIndex(2)
                    + this.vectors[0].getVectorElementByIndex(1) * this.vectors[1].getVectorElementByIndex(2) * this.vectors[2].getVectorElementByIndex(0)
                    + this.vectors[0].getVectorElementByIndex(2) * this.vectors[1].getVectorElementByIndex(0) * this.vectors[2].getVectorElementByIndex(1)
                    - this.vectors[2].getVectorElementByIndex(0) * this.vectors[1].getVectorElementByIndex(1) * this.vectors[0].getVectorElementByIndex(2)
                    - this.vectors[2].getVectorElementByIndex(1) * this.vectors[1].getVectorElementByIndex(2) * this.vectors[0].getVectorElementByIndex(0)
                    - this.vectors[2].getVectorElementByIndex(2) * this.vectors[1].getVectorElementByIndex(0) * this.vectors[0].getVectorElementByIndex(1);
        } else {
            double determinant = 0;
            for (int i = 0; i < this.vectors.length; ++i) {
                if (Math.abs(this.vectors[i].getVectorElementByIndex(0)) >= EPSILON) {
                    Matrix smallerMatrix = new Matrix(this.vectors.length - 1, this.vectors.length - 1);
                    for (int j = 0, n = 0; j < this.vectors.length; ++j) {
                        if (j != i) {
                            for (int k = 1, m = 0; k < this.vectors.length; ++k) {
                                smallerMatrix.getLineVector(n).setVectorElementByIndex(m, this.vectors[j].getVectorElementByIndex(k));
                                m++;
                            }
                            n++;
                        }
                    }
                    if (i % 2 == 0) {
                        determinant += this.vectors[i].getVectorElementByIndex(0) * smallerMatrix.getDeterminant();
                    } else {
                        determinant += (this.vectors[i].getVectorElementByIndex(0) * -1) * smallerMatrix.getDeterminant();
                    }
                }
            }
            return determinant;
        }
    }

    public Vector getMatrixMultiplicationByVector(Vector vector) {
        if (getWidth() != vector.getSize()){
            throw  new IllegalArgumentException("Число столбцов матрицы должно быть равно числу длины вектора");
        }
        Vector result = new Vector(this.vectors.length);
        for (int i = 0; i < this.vectors.length;i++) {
            double sum = 0;
            for (int j = 0; j < this.vectors[i].getSize();j++) {
                sum += this.vectors[i].getVectorElementByIndex(j) * vector.getVectorElementByIndex(j);
            }
            result.setVectorElementByIndex(i,sum);
        }
        return result;
    }

    public void getMatrixSum(Matrix matrix) {
        if (!Arrays.equals(getSize() , matrix.getSize())) {
            throw new IllegalArgumentException("Сложение матриц разной размерности невозможно.");
        }
        for (int i = 0; i < this.vectors.length; i++){
            for (int j = 0; j < this.vectors[i].getSize(); j++) {
                this.vectors[i].setVectorElementByIndex(j,this.vectors[i].getVectorElementByIndex(j) + matrix.getLineVector(i).getVectorElementByIndex(j));
            }
        }
    }

    public void getMatrixSubtraction(Matrix matrix) {
        if (!Arrays.equals(getSize() , matrix.getSize())) {
            throw new IllegalArgumentException("Вычитание матриц разной размерности невозможно.");
        }
        for (int i = 0; i < this.vectors.length; i++){
            for (int j = 0; j < this.vectors[i].getSize(); j++) {
                this.vectors[i].setVectorElementByIndex(j,this.vectors[i].getVectorElementByIndex(j) - matrix.getLineVector(i).getVectorElementByIndex(j));
            }
        }
    }

    public static Matrix getStaticMatrixSum(Matrix matrix1, Matrix matrix2) {
        Matrix sumMatrix = new Matrix(matrix1);
        sumMatrix.getMatrixSum(matrix2);
        return sumMatrix;
    }
}