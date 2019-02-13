package ru.academItScholl.gorbunov.Tests.MatrixArray;



import org.junit.Before;
import org.junit.Test;
import org.testng.annotations.BeforeTest;
import ru.academItScholl.gorbunov.matrix.Matrix;
import ru.academItSchool.gorbunov.vector.Vector;


import static org.junit.Assert.*;

public class MatrixArrayTest {
    private Matrix matrix;

    private double [][] array;

    @Test
    public void createMatrixIllegalArgumentExceptionHeightTest(){
        array = new double[0][5];
        try {
            matrix = new Matrix(array);
        }catch (IllegalArgumentException e){
            System.out.println("Проверка MatrixArray на неверные данные в высоте матрицы" + e);
        }
    }

    @Test
    public void createMatrixIllegalArgumentExceptionWidthTest(){
        array = new double[5][0];
        try {
            matrix = new Matrix(array);
        }catch (IllegalArgumentException e){
            System.out.println("Проверка MatrixArray на неверные данные в ширине матрицы" + e);
        }
    }

    @Before
    public void setMatrix() {
        this.array = new double[][]{{1,2,3},{1,2,3},{1,2,3}};
        this.matrix = new Matrix(this.array);
    }

    @Test
    public void getWidthTest() {
        System.out.println("MatrixArray возврат ширины.");
        int actual = matrix.getWidth();
        int expected = 3;
        assertEquals(expected,actual);
    }

    @Test
    public void getHeightTest() {
        System.out.println("MatrixArray возврат высоты.");
        int actual = matrix.getHeight();
        int expected = 3;
        assertEquals(expected, actual);
    }

    @Test
    public void getSizeTest() {
        System.out.println("MatrixArray возврат размера матрицы в массиве");
        int[] actual = matrix.getSize();
        int[] expected = new int[]{3,3};
        assertArrayEquals(expected,actual);
    }

    @Test
    public void toStringTest(){
        System.out.println("MatrixArray правильно возвращает toString"+ System.lineSeparator() + matrix.toString());
        String actual = matrix.toString();
        String expected = "{{1.0, 2.0, 3.0}, {1.0, 2.0, 3.0}, {1.0, 2.0, 3.0}}";
        assertEquals(actual,expected);
    }

    @Test
    public void getLineVectorTest() {
        System.out.println("MatrixArray правильно достает Vector");
        int index = 2;
        Vector actual = this.matrix.getLineVector(index);
        Vector expected = new Vector(new double[]{1.0, 2.0, 3.0});
        assertEquals(expected,actual);
    }

    @Test
    public void setLineVectorTest(){
        int index = 0;
        Vector testVector = new Vector(11);
        this.matrix.setLineVector(index,testVector);
        String actual = this.matrix.toString();
        String expected = "{{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0}, {1.0, 2.0, 3.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0}, {1.0, 2.0, 3.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0}}";
        assertEquals(expected, actual);
        System.out.println("Вставка нового вектора по индексу и реформация MatrixArray просходит правильно" + System.lineSeparator() + actual);
    }

    @Test
    public void getColumnVector(){
        int index = 0;
        Vector actual = this.matrix.getColumnVector(index);
        Vector expected = new Vector(new double[]{1.0, 1.0, 1.0});
        assertEquals(expected,actual);
        System.out.println("MatrixArray правильно достает columnVector");
    }

    @Test
    public void transpositionMatrix(){
        this.matrix.transpositionMatrix();
        String actual = this.matrix.toString();
        String expected = "{{1.0, 1.0, 1.0}, {2.0, 2.0, 2.0}, {3.0, 3.0, 3.0}}";
        assertEquals(expected, actual);
        System.out.println("Транспонирование MatrixArray просходит правильно" + System.lineSeparator() + actual);
    }

    @Test
    public void getMatrixScalarTest(){
        int scalar = -5;
        this.matrix.getMatrixScalar(scalar);
        String actual = this.matrix.toString();
        String expected = "{{-5.0, -10.0, -15.0}, {-5.0, -10.0, -15.0}, {-5.0, -10.0, -15.0}}";
        assertEquals(expected,actual);
        System.out.println("MatrixArray умножена на скаляр правильно");
    }

    @Test
    public void getDeterminantTest(){
        double actual = this.matrix.getDeterminant();
        double expected = 0.0;
        assertEquals(expected,actual,0.1e-10);
        System.out.println("Детерминант MatrixArray вычисляется верно");
    }

    @Test
    public void getMatrixMultiplicationByVector(){
        Vector vector = new Vector(new double[]{1,2,3});
        Vector actual = this.matrix.getMatrixMultiplicationByVector(vector);
        Vector expected = new Vector(new double[]{14,14,14});
        assertEquals(expected,actual);
        System.out.println("Умножение MatrixArray на вектор вычисляется верно");
    }
    @Test
    public void getMatrixSumTest(){
        Matrix matrixSum = new Matrix(new double[][]{{1,2,3},{1,2,3},{1,2,3}});
        this.matrix.getMatrixSum(matrixSum);
        String actual = this.matrix.toString();
        String expected = "{{2.0, 4.0, 6.0}, {2.0, 4.0, 6.0}, {2.0, 4.0, 6.0}}";
        assertEquals(expected,actual);
    }
}

