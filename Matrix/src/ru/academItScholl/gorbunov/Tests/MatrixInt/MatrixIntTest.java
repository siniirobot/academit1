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
        int actual = matrix.getWidth();
        int expected = 5;
        assertEquals(expected, actual);
        System.out.println("MatrixInt возврат ширины.");
    }

    @Test
    public void getHeightTest() {
        int actual = matrix.getHeight();
        int expected = 5;
        assertEquals(expected, actual);
        System.out.println("MatrixInt возврат высоты.");
    }

    @Test
    public void getSizeTest() {
        int[] actual = matrix.getSize();
        int[] expected = new int[]{5, 5};
        assertArrayEquals(expected, actual);
        System.out.println("MatrixInt возврат размера матрицы в массиве");
    }

    @Test
    public void toStringTest() {
        String actual =matrix.toString();
        String expected = "{{0.0, 0.0, 0.0, 0.0, 0.0}, {0.0, 0.0, 0.0, 0.0, 0.0}, {0.0, 0.0, 0.0, 0.0, 0.0}, {0.0, 0.0, 0.0, 0.0, 0.0}, {0.0, 0.0, 0.0, 0.0, 0.0}}";
        assertEquals(expected, actual);
        System.out.println("MatrixInt правильно возвращает toString" + System.lineSeparator() + matrix.toString());
    }

    @Test
    public void getLineVectorTest() {
        int index = 2;
        Vector actual = this.matrix.getLineVector(index);
        Vector expected = new Vector(new double[]{0.0, 0.0, 0.0, 0.0, 0.0 });
        assertEquals(expected,actual);
        System.out.println("MatrixInt правильно достает Vector");
    }

    @Test
    public void setLineVectorTest(){
        int index = 0;
        Vector testVector = new Vector(11);
        this.matrix.setLineVector(index,testVector);
        String actual =matrix.toString();
        String expected = "{{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0}, {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0}, {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0}, {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0}, {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0}}";
        assertEquals(expected, actual);
        System.out.println("Вставка нового вектора по индексу и реформация MatrixInt просходит правильно" + System.lineSeparator() + actual);
    }

    @Test
    public void getColumnVector(){
        int index = 0;
        Vector actual = this.matrix.getColumnVector(index);
        Vector expected = new Vector(new double[]{0.0, 0.0, 0.0, 0.0, 0.0 });
        assertEquals(expected,actual);
        System.out.println("MatrixInt правильно достает columnVector");
    }

    @Test
    public void transpositionMatrix(){
        this.matrix.transpositionMatrix();
        String actual = this.matrix.toString();
        String expected = "{{0.0, 0.0, 0.0, 0.0, 0.0}, {0.0, 0.0, 0.0, 0.0, 0.0}, {0.0, 0.0, 0.0, 0.0, 0.0}, {0.0, 0.0, 0.0, 0.0, 0.0}, {0.0, 0.0, 0.0, 0.0, 0.0}}";
        assertEquals(expected, actual);
        System.out.println("Транспонирование MatrixInt просходит правильно" + System.lineSeparator() + actual);
    }

    @Test
    public void getMatrixScalarTest(){
        int scalar = 1;
        this.matrix.getMatrixScalar(scalar);
        String actual = this.matrix.toString();
        String expected = "{{0.0, 0.0, 0.0, 0.0, 0.0}, {0.0, 0.0, 0.0, 0.0, 0.0}, {0.0, 0.0, 0.0, 0.0, 0.0}, {0.0, 0.0, 0.0, 0.0, 0.0}, {0.0, 0.0, 0.0, 0.0, 0.0}}";
        assertEquals(expected,actual);
        System.out.println("MatrixInt умножена на скаляр правильно");
    }
}

