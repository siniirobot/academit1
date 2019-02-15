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
    public void CreateMatrix_IllegalArgumentExceptionHeight_Error() {
        firstNumber = 0;
        secondNumber = 5;
        try {
            matrix = new Matrix(firstNumber, secondNumber);
        } catch (IllegalArgumentException e) {
            System.out.println("Проверка MatrixInt на неверные данные в ширине матрицы" + e);
        }
    }

    @Test
    public void CreateMatrix_IllegalArgumentExceptionWidth_Error() {
        firstNumber = 5;
        secondNumber = -1;
        try {
            matrix = new Matrix(firstNumber, secondNumber);
        } catch (IllegalArgumentException e) {
            System.out.println("Проверка MatrixInt на неверные данные в высоте матрицы" + e);
        }
    }

    @Before
    public void SetMatrix_Int_Matrix() {
        firstNumber = 5;
        secondNumber = 5;
        this.matrix = new Matrix(firstNumber, secondNumber);

    }

    @Test
    public void GetWidth_Matrix_Int() {
        int actual = matrix.getWidth();
        int expected = 5;
        assertEquals(expected, actual);
        System.out.println("MatrixInt возврат ширины.");
    }

    @Test
    public void GetHeight_Matrix_Int() {
        int actual = matrix.getHeight();
        int expected = 5;
        assertEquals(expected, actual);
        System.out.println("MatrixInt возврат высоты.");
    }

    @Test
    public void GetHeight_Matrix_ArrayInt() {
        int[] actual = matrix.getSize();
        int[] expected = new int[]{5, 5};
        assertArrayEquals(expected, actual);
        System.out.println("MatrixInt возврат размера матрицы в массиве");
    }

    @Test
    public void ToStringTest_Matrix_String() {
        String actual = matrix.toString();
        String expected = "{{0.0, 0.0, 0.0, 0.0, 0.0}, {0.0, 0.0, 0.0, 0.0, 0.0}, {0.0, 0.0, 0.0, 0.0, 0.0}, {0.0, 0.0, 0.0, 0.0, 0.0}, {0.0, 0.0, 0.0, 0.0, 0.0}}";
        assertEquals(expected, actual);
        System.out.println("MatrixInt правильно возвращает toString" + System.lineSeparator() + matrix.toString());
    }

    @Test
    public void GetLineVector_Matrix_Vector() {
        int index = 2;
        Vector actual = this.matrix.getLineVector(index);
        Vector expected = new Vector(new double[]{0.0, 0.0, 0.0, 0.0, 0.0});
        assertEquals(expected, actual);
        System.out.println("MatrixInt правильно достает Vector");
    }

    @Test
    public void GetLineVector_Matrix_Matrix() {
        int index = 0;
        Vector testVector = new Vector(11);
        this.matrix.setLineVector(index, testVector);
        String actual = matrix.toString();
        String expected = "{{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0}, {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0}, {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0}, {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0}, {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0}}";
        assertEquals(expected, actual);
        System.out.println("Вставка нового вектора по индексу и реформация MatrixInt просходит правильно" + System.lineSeparator() + actual);
    }

    @Test
    public void GetColumnVector_Matrix_Vector() {
        int index = 0;
        Vector actual = this.matrix.getColumnVector(index);
        Vector expected = new Vector(new double[]{0.0, 0.0, 0.0, 0.0, 0.0});
        assertEquals(expected, actual);
        System.out.println("MatrixInt правильно достает columnVector");
    }

    @Test
    public void TranspositionMatrix_Matrix_Matrix() {
        this.matrix.transpositionMatrix();
        String actual = this.matrix.toString();
        String expected = "{{0.0, 0.0, 0.0, 0.0, 0.0}, {0.0, 0.0, 0.0, 0.0, 0.0}, {0.0, 0.0, 0.0, 0.0, 0.0}, {0.0, 0.0, 0.0, 0.0, 0.0}, {0.0, 0.0, 0.0, 0.0, 0.0}}";
        assertEquals(expected, actual);
        System.out.println("Транспонирование MatrixInt просходит правильно" + System.lineSeparator() + actual);
    }

    @Test
    public void GetMatrixScalarTest_Matrix_Matrix() {
        int scalar = 1;
        this.matrix.getMatrixScalar(scalar);
        String actual = this.matrix.toString();
        String expected = "{{0.0, 0.0, 0.0, 0.0, 0.0}, {0.0, 0.0, 0.0, 0.0, 0.0}, {0.0, 0.0, 0.0, 0.0, 0.0}, {0.0, 0.0, 0.0, 0.0, 0.0}, {0.0, 0.0, 0.0, 0.0, 0.0}}";
        assertEquals(expected, actual);
        System.out.println("MatrixInt умножена на скаляр правильно");
    }

    @Test
    public void GetDeterminantTest_Matrix_Double() {
        double actual = this.matrix.getDeterminant();
        double expected = 0;
        assertEquals(expected, actual, 0.1e-10);
        System.out.println("Детерминант MatrixInt вычисляется верно");
    }


    @Test
    public void GetMatrixMultiplicationByVector_Matrix_Matrix() {
        try {
            this.matrix.getMatrixMultiplicationByVector(new Vector(1));
        } catch (IllegalArgumentException e) {
            System.out.println("Умножение MatrixInt на вектор выдает верное исключение" + e);
        }
    }

    @Test
    public void GetMatrixSumTest_Matrix_Matrix() {
        try {
            Matrix matrixSum = new Matrix(new double[][]{{1, 2, 3}, {1, 2, 3}, {1, 2, 3}});
            this.matrix.getMatrixSum(matrixSum);
        } catch (IllegalArgumentException e) {
            System.out.println("Обработка исключения не правильного сложения матриц происходит верно-" + System.lineSeparator() + e);
        }
    }

    @Test
    public void GetMatrixSubtraction_Matrix_MatrixTest() {
        try {
            Matrix matrixSum = new Matrix(new double[][]{{1, 2, 3}, {1, 2, 3}, {1, 2, 3}});
            this.matrix.getMatrixSubtraction(matrixSum);
        } catch (IllegalArgumentException e) {
            System.out.println("Обработка исключения не правильного вычитания матриц происходит верно-" + System.lineSeparator() + e);
        }
    }
}

