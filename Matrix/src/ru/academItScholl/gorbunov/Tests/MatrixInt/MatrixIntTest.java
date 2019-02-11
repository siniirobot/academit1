package ru.academItScholl.gorbunov.Tests.MatrixInt;


import org.junit.Before;
import org.junit.Test;
import ru.academItScholl.gorbunov.matrix.Matrix;
import ru.academItSchool.gorbunov.vector.Vector;


import static org.junit.Assert.*;

public class MatrixIntTest {
    private Matrix matrix;

    private int firstNumber;
    private int secondNumber;

    @Test
    public void createMatrixIllegalArgumentExceptionHeightTest() {
        firstNumber = 0;
        secondNumber = 5;
        try {
            matrix = new Matrix(firstNumber, secondNumber);
        } catch (IllegalArgumentException e) {
            System.out.println("Проверка MatrixInt на неверные данные в ширине матрицы" + e);
        }
    }

    @Test
    public void createMatrixIllegalArgumentExceptionWidthTest() {
        firstNumber = 5;
        secondNumber = -1;
        try {
            matrix = new Matrix(firstNumber, secondNumber);
        } catch (IllegalArgumentException e) {
            System.out.println("Проверка MatrixInt на неверные данные в высоте матрицы" + e);
        }
    }

    @Before
    public void setMatrix() {
        firstNumber = 5;
        secondNumber = 5;
        this.matrix = new Matrix(firstNumber, secondNumber);

    }

    @Test
    public void getWidthTest() {
        System.out.println("MatrixInt возврат ширины.");
        int actual = matrix.getWidth();
        int expected = 5;
        assertEquals(expected, actual);
    }

    @Test
    public void getHeightTest() {
        System.out.println("MatrixInt возврат высоты.");
        int actual = matrix.getHeight();
        int expected = 5;
        assertEquals(expected, actual);
    }

    @Test
    public void getSizeTest() {
        System.out.println("MatrixInt возврат размера матрицы в массиве");
        int[] actual = matrix.getSize();
        int[] expected = new int[]{5, 5};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void toStringTest() {
        System.out.println("MatrixInt правильно возвращает toString" + System.lineSeparator() + matrix.toString());
        String actual =matrix.toString();
        String expected = "{{0.0, 0.0, 0.0, 0.0, 0.0}, {0.0, 0.0, 0.0, 0.0, 0.0}, {0.0, 0.0, 0.0, 0.0, 0.0}, {0.0, 0.0, 0.0, 0.0, 0.0}, {0.0, 0.0, 0.0, 0.0, 0.0}}";
        assertEquals(expected, actual);
    }

    @Test
    public void getLineVectorTest() {
        System.out.println("MatrixInt правильно достает Vector");
        int index = 2;
        Vector actual = this.matrix.getLineVector(index);
        Vector expected = new Vector(new double[]{0.0, 0.0, 0.0, 0.0, 0.0 });
        assertEquals(expected,actual);
    }
}

