package ru.academItScholl.gorbunov.Tests.MatrixCopyTest;


import org.junit.Before;
import org.junit.Test;
import ru.academItScholl.gorbunov.matrix.Matrix;


import static org.junit.Assert.*;

public class MatrixCopyTest {
    private Matrix matrix;

    private Matrix matrixCopy;

    @Before
    public void setMatrix() {
        this.matrixCopy =new Matrix(5,5);
        this.matrix = new Matrix(matrixCopy);
    }

    @Test
    public void getWidthTest() {
        System.out.println("MatrixCopy возврат ширины.");
        int actual = matrix.getWidth();
        int expected = 5;
        assertEquals(expected,actual);
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
        int[] expected = new int[]{5,5};
        assertArrayEquals(expected,actual);
    }
}

