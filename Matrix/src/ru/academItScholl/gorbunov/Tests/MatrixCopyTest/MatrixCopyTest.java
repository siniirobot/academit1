package ru.academItScholl.gorbunov.Tests.MatrixCopyTest;

import org.junit.*;
import org.junit.Before;
import org.junit.Test;
import ru.academItScholl.gorbunov.matrix.Matrix;
import ru.academItSchool.gorbunov.vector.Vector;


import static org.junit.Assert.*;

public class MatrixCopyTest {
    private Matrix matrix;

    private Matrix matrixCopy = new Matrix(5, 5);

    @Before
    public void setMatrix() {
        this.matrix = new Matrix(matrixCopy);
    }

    @Test
    public void getWidthTest() {
        System.out.println("MatrixCopy возврат ширины.");
        int actual = matrix.getWidth();
        int expected = 5;
        assertEquals(expected, actual);
    }

    @Test
    public void getHeightTest() {
        System.out.println("MatrixCopy возврат высоты.");
        int actual = matrix.getHeight();
        int expected = 5;
        assertEquals(expected, actual);
    }

    @Test
    public void getSizeTest() {
        System.out.println("MatrixCopy возврат размера матрицы в массиве");
        int[] actual = matrix.getSize();
        int[] expected = new int[]{5, 5};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void toStringTest() {
        System.out.println("MatrixCopy правильно возвращает toString" + System.lineSeparator() + matrix.toString());
        String actual = matrix.toString();
        String expected = "{{0.0, 0.0, 0.0, 0.0, 0.0}, {0.0, 0.0, 0.0, 0.0, 0.0}, {0.0, 0.0, 0.0, 0.0, 0.0}, {0.0, 0.0, 0.0, 0.0, 0.0}, {0.0, 0.0, 0.0, 0.0, 0.0}}";
        assertEquals(actual, expected);
    }

    @Test
    public void getLineVectorTest() {
        System.out.println("MatrixCopy правильно достает Vector");
        int index = 1;
        Vector actual = this.matrix.getLineVector(index);
        Vector expected = new Vector(new double[]{0.0, 0.0, 0.0, 0.0, 0.0});
        assertEquals(expected, actual);
    }

    @Test
    public void setLineVectorTest() {
        int index = 0;
        Vector testVector = new Vector(11);
        this.matrix.setLineVector(index, testVector);
        String actual = matrix.toString();
        String expected = "{{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0}, {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0}, {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0}, {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0}, {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0}}";
        assertEquals(expected, actual);
        System.out.println("Вставка нового вектора по индексу и реформация MatrixCopy просходит правильно" + System.lineSeparator() + actual);
    }

    @Test
    public void getColumnVector() {
        int index = 0;
        Vector actual = this.matrix.getColumnVector(index);
        Vector expected = new Vector(new double[]{0.0, 0.0, 0.0, 0.0, 0.0});
        assertEquals(expected, actual);
        System.out.println("MatrixCopy правильно достает columnVector");
    }
}
