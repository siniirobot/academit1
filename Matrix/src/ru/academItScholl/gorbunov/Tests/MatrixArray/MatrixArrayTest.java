package ru.academItScholl.gorbunov.Tests.MatrixArray;


import org.junit.Before;
import org.junit.Test;
import ru.academItScholl.gorbunov.matrix.Matrix;
import ru.academItSchool.gorbunov.vector.Vector;


import static org.junit.Assert.*;

public class MatrixArrayTest {
    private Matrix matrix;

    private double[][] array;

    @Test
    public void CreateMatrix_IllegalArgumentExceptionHeight_Error() {
        array = new double[0][5];
        try {
            matrix = new Matrix(array);
        } catch (IllegalArgumentException e) {
            System.out.println("Проверка MatrixArray на неверные данные в высоте матрицы" + e);
        }
    }

    @Test
    public void CreateMatrix_IllegalArgumentExceptionWidth_Error() {
        array = new double[5][0];
        try {
            matrix = new Matrix(array);
        } catch (IllegalArgumentException e) {
            System.out.println("Проверка MatrixArray на неверные данные в ширине матрицы" + e);
        }
    }

    @Before
    public void SetMatrix_Array_Matrix() {
        this.array = new double[][]{{1, 2, 3}, {1, 2, 3}, {1, 2, 3}};
        this.matrix = new Matrix(this.array);
    }

    @Test
    public void GetWidth_Matrix_Int() {
        System.out.println("MatrixArray возврат ширины.");
        int actual = matrix.getWidth();
        int expected = 3;
        assertEquals(expected, actual);
    }

    @Test
    public void GetHeight_Matrix_Int() {
        System.out.println("MatrixArray возврат высоты.");
        int actual = matrix.getHeight();
        int expected = 3;
        assertEquals(expected, actual);
    }

    @Test
    public void GetHeight_Matrix_ArrayInt() {
        System.out.println("MatrixArray возврат размера матрицы в массиве");
        int[] actual = matrix.getSize();
        int[] expected = new int[]{3, 3};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void ToStringTest_Matrix_String() {
        System.out.println("MatrixArray правильно возвращает toString" + System.lineSeparator() + matrix.toString());
        String actual = matrix.toString();
        String expected = "{{1.0, 2.0, 3.0}, {1.0, 2.0, 3.0}, {1.0, 2.0, 3.0}}";
        assertEquals(actual, expected);
    }

    @Test
    public void GetLineVector_Matrix_Vector() {
        System.out.println("MatrixArray правильно достает Vector");
        int index = 2;
        Vector actual = this.matrix.getLineVector(index);
        Vector expected = new Vector(new double[]{1.0, 2.0, 3.0});
        assertEquals(expected, actual);
    }

    @Test
    public void SetLineVector_Matrix_Matrix() {
        int index = 0;
        Vector testVector = new Vector(11);
        this.matrix.setLineVector(index, testVector);
        String actual = this.matrix.toString();
        String expected = "{{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0}, {1.0, 2.0, 3.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0}, {1.0, 2.0, 3.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0}}";
        assertEquals(expected, actual);
        System.out.println("Вставка нового вектора по индексу и реформация MatrixArray просходит правильно" + System.lineSeparator() + actual);
    }

    @Test
    public void GetColumnVector_Matrix_Vector() {
        int index = 0;
        Vector actual = this.matrix.getColumnVector(index);
        Vector expected = new Vector(new double[]{1.0, 1.0, 1.0});
        assertEquals(expected, actual);
        System.out.println("MatrixArray правильно достает columnVector");
    }

    @Test
    public void TranspositionMatrix_Matrix_Matrix() {
        this.matrix.transposition();
        String actual = this.matrix.toString();
        String expected = "{{1.0, 1.0, 1.0}, {2.0, 2.0, 2.0}, {3.0, 3.0, 3.0}}";
        assertEquals(expected, actual);
        System.out.println("Транспонирование MatrixArray просходит правильно" + System.lineSeparator() + actual);
    }

    @Test
    public void GetMatrixScalarTest_Matrix_Matrix() {
        int scalar = -5;
        this.matrix.multiplicationByScalar(scalar);
        String actual = this.matrix.toString();
        String expected = "{{-5.0, -10.0, -15.0}, {-5.0, -10.0, -15.0}, {-5.0, -10.0, -15.0}}";
        assertEquals(expected, actual);
        System.out.println("MatrixArray умножена на скаляр правильно");
    }

    @Test
    public void GetDeterminantTest_Matrix_Double() {
        double actual = this.matrix.getDeterminant();
        double expected = 0.0;
        assertEquals(expected, actual, 0.1e-10);
        System.out.println("Детерминант MatrixArray вычисляется верно");
    }

    @Test
    public void GetMatrixMultiplicationByVector_Matrix_Matrix() {
        Vector vector = new Vector(new double[]{1, 2, 3});
        Vector actual = this.matrix.getMultiplicationByVector(vector);
        Vector expected = new Vector(new double[]{14, 14, 14});
        assertEquals(expected, actual);
        System.out.println("Умножение MatrixArray на вектор вычисляется верно");
    }

    @Test
    public void GetMatrixSumTest_Matrix_Matrix() {
        Matrix matrixSum = new Matrix(new double[][]{{1, 2, 3}, {1, 2, 3}, {1, 2, 3}});
        this.matrix.sum(matrixSum);
        String actual = this.matrix.toString();
        String expected = "{{2.0, 4.0, 6.0}, {2.0, 4.0, 6.0}, {2.0, 4.0, 6.0}}";
        assertEquals(expected, actual);
        System.out.println("Сложение с MatrixArray проходит верно");
    }

    @Test
    public void GetMatrixSubtraction_Matrix_MatrixTest() {
        Matrix matrixSum = new Matrix(new double[][]{{1, 2, 3}, {1, 2, 3}, {1, 2, 3}});
        this.matrix.subtraction(matrixSum);
        String actual = this.matrix.toString();
        String expected = "{{0.0, 0.0, 0.0}, {0.0, 0.0, 0.0}, {0.0, 0.0, 0.0}}";
        assertEquals(expected, actual);
        System.out.println("Вычитание с MatrixArray проходит верно");
    }
}

