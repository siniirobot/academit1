package ru.academItScholl.gorbunov.Tests;

import org.junit.Test;
import ru.academItScholl.gorbunov.matrix.Matrix;


import static org.junit.Assert.*;

public class MatrixTest {
    private Matrix matrixSquare = new Matrix(new double[][]{{1, 2, 3}, {1, 2, 3}, {1, 2, 3}});
    private Matrix matrixSquare2 = new Matrix(new double[][]{{1, 2, 3}, {1, 2, 3}, {1, 2, 3}});
    private Matrix matrixNotSquare = new Matrix(new double[][]{{1, 2}, {1, 2}, {1, 2}});
    private Matrix matrixNotSquare2 = new Matrix(new double[][]{{1, 2, 3}, {1, 2, 3}});

    @Test
    public void MatrixStaticSum_SquareMatrix_NewMatrix() {
        try {
            String actual = Matrix.getStaticMatrixSum(this.matrixSquare, this.matrixSquare2).toString();
            String expected = new Matrix(new double[][]{{2.0, 4.0, 6.0}, {2.0, 4.0, 6.0}, {2.0, 4.0, 6.0}}).toString();
            assertEquals(expected, actual);
            System.out.println("Функция статической суммы работает нормально");
        } catch (IllegalArgumentException e) {
            System.out.println("Функция статической суммы правильно обрабатывает исключения." + System.lineSeparator() + e);

        }

    }

    @Test
    public void MatrixStaticSum_NotSquareMatrix_Error() {
        try {
            Matrix.getStaticMatrixSum(this.matrixNotSquare, this.matrixNotSquare2);
        } catch (IllegalArgumentException e) {
            System.out.println("Функция статической суммы правильно обрабатывает исключения." + System.lineSeparator() + e);
        }
    }

    @Test
    public void MatrixStaticSubtraction_SquareMatrix_NewMatrix() {
        try {
            String actual = Matrix.getStaticMatrixSubtraction(this.matrixSquare, this.matrixSquare2).toString();
            String expected = new Matrix(new double[][]{{0.0, 0.0, 0.0}, {0.0, 0.0, 0.0}, {0.0, 0.0, 0.0}}).toString();
            assertEquals(expected, actual);
            System.out.println("Функция статического вычитания работает нормально");
        } catch (IllegalArgumentException e) {
            System.out.println("Функция статического вычитания правильно обрабатывает исключения." + System.lineSeparator() + e);
        }

    }

    @Test
    public void MatrixStaticSubtraction_NotSquareMatrix_Error() {
        try {
            Matrix.getStaticMatrixSubtraction(this.matrixNotSquare, this.matrixNotSquare2);
        } catch (IllegalArgumentException e) {
            System.out.println("Функция статического вычитания правильно обрабатывает исключения." + System.lineSeparator() + e);
        }
    }

    @Test
    public void MatrixStaticMultiplication_SquareMatrix_NewMatrix() {
        try {
            String actual = Matrix.getStaticMatrixMultiplication(this.matrixSquare, this.matrixSquare2).toString();
            String expected = new Matrix(new double[][]{{6.0, 12.0, 18.0}, {6.0, 12.0, 18.0}, {6.0, 12.0, 18.0}}).toString();
            assertEquals(expected, actual);
            System.out.println("Функция статического умножения работает нормально");
        } catch (IllegalArgumentException e) {
            System.out.println("Функция статического умгожения правильно обрабатывает исключения." + System.lineSeparator() + e);
        }

    }

    @Test
    public void MatrixStaticMultiplication_NotSquareMatrix_NewMatrix() {
        try {
            String actual = Matrix.getStaticMatrixMultiplication(this.matrixNotSquare2, this.matrixNotSquare).toString();
            String expected = new Matrix(new double[][]{{6.0, 12.0}, {6.0, 12.0}}).toString();
            assertEquals(expected, actual);
            System.out.println("Функция статического умножения работает нормально");
        } catch (IllegalArgumentException e) {
            System.out.println("Функция статического умножения правильно обрабатывает исключения." + System.lineSeparator() + e);
        }
    }

    @Test
    public void MatrixStaticMultiplication_SquareAndNotSquareMatrix_Error() {
        try {
            Matrix.getStaticMatrixMultiplication(this.matrixSquare, this.matrixNotSquare2);
        } catch (IllegalArgumentException e) {
            System.out.println("Функция статического вычитания правильно обрабатывает исключения." + System.lineSeparator() + e);
        }
    }
}