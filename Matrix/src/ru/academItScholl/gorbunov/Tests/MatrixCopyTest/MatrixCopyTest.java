package ru.academItScholl.gorbunov.Tests.MatrixCopyTest;


import org.junit.Before;
import org.junit.Test;
import ru.academItScholl.gorbunov.matrix.Matrix;
import ru.academItSchool.gorbunov.vector.Vector;


import static org.junit.Assert.*;

public class MatrixCopyTest {
    private Matrix matrix;

    private Matrix matrixCopy = new Matrix(5, 5);

    @Before
    public void SetMatrix_Matrix_Matrix() {
        this.matrix = new Matrix(matrixCopy);
    }

    @Test
    public void GetWidth_Matrix_Int() {
        System.out.println("MatrixCopy возврат ширины.");
        int actual = matrix.getWidth();
        int expected = 5;
        assertEquals(expected, actual);
    }

    @Test
    public void GetHeight_Matrix_Int() {
        System.out.println("MatrixCopy возврат высоты.");
        int actual = matrix.getHeight();
        int expected = 5;
        assertEquals(expected, actual);
    }

    @Test
    public void GetHeight_Matrix_ArrayInt() {
        System.out.println("MatrixCopy возврат размера матрицы в массиве");
        int[] actual = matrix.getSize();
        int[] expected = new int[]{5, 5};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void ToStringTest_Matrix_String_Matrix_String() {
        System.out.println("MatrixCopy правильно возвращает toString" + System.lineSeparator() + matrix.toString());
        String actual = matrix.toString();
        String expected = "{{0.0, 0.0, 0.0, 0.0, 0.0}, {0.0, 0.0, 0.0, 0.0, 0.0}, {0.0, 0.0, 0.0, 0.0, 0.0}, {0.0, 0.0, 0.0, 0.0, 0.0}, {0.0, 0.0, 0.0, 0.0, 0.0}}";
        assertEquals(actual, expected);
    }

    @Test
    public void GetLineVector_Matrix_Vector() {
        System.out.println("MatrixCopy правильно достает Vector");
        int index = 1;
        Vector actual = this.matrix.getLineVector(index);
        Vector expected = new Vector(new double[]{0.0, 0.0, 0.0, 0.0, 0.0});
        assertEquals(expected, actual);
    }

    @Test
    public void SetLineVector_Matrix_Matrix() {
        int index = 0;
        Vector testVector = new Vector(11);
        this.matrix.setLineVector(index, testVector);
        String actual = matrix.toString();
        String expected = "{{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0}, {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0}, {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0}, {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0}, {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0}}";
        assertEquals(expected, actual);
        System.out.println("Вставка нового вектора по индексу и реформация MatrixCopy просходит правильно" + System.lineSeparator() + actual);
    }

    @Test
    public void GetColumnVector_Matrix_Vector() {
        int index = 0;
        Vector actual = this.matrix.getColumnVector(index);
        Vector expected = new Vector(new double[]{0.0, 0.0, 0.0, 0.0, 0.0});
        assertEquals(expected, actual);
        System.out.println("MatrixCopy правильно достает columnVector");
    }

    @Test
    public void TranspositionMatrix_Matrix_Matrix() {
        this.matrix.transpositionMatrix();
        String actual = this.matrix.toString();
        String expected = "{{0.0, 0.0, 0.0, 0.0, 0.0}, {0.0, 0.0, 0.0, 0.0, 0.0}, {0.0, 0.0, 0.0, 0.0, 0.0}, {0.0, 0.0, 0.0, 0.0, 0.0}, {0.0, 0.0, 0.0, 0.0, 0.0}}";
        assertEquals(expected, actual);
        System.out.println("Транспонирование MatrixCopy просходит правильно" + System.lineSeparator() + actual);
    }

    @Test
    public void GetMatrixScalarTest_Matrix_Matrix() {
        int scalar = 1;
        this.matrix.getMatrixScalar(scalar);
        String actual = this.matrix.toString();
        String expected = "{{0.0, 0.0, 0.0, 0.0, 0.0}, {0.0, 0.0, 0.0, 0.0, 0.0}, {0.0, 0.0, 0.0, 0.0, 0.0}, {0.0, 0.0, 0.0, 0.0, 0.0}, {0.0, 0.0, 0.0, 0.0, 0.0}}";
        assertEquals(expected, actual);
        System.out.println("MatrixCopy умножена на скаляр правильно");
    }

    @Test
    public void GetDeterminantTest_Matrix_Double() {
        double actual = this.matrix.getDeterminant();
        double expected = 0;
        assertEquals(expected, actual, 0.1e-10);
        System.out.println("Детерминант MatrixCopy вычисляется верно");
    }

    @Test
    public void GetMatrixMultiplicationByVector_Matrix_Matrix() {
        try {
            this.matrix.getMatrixMultiplicationByVector(new Vector(1));
        } catch (IllegalArgumentException e) {
            System.out.println("Умножение MatrixCopy на вектор выдает верное исключение" + e);
        }
    }

    @Test
    public void GetMatrixSumTest_Matrix_Matrix() {
        Matrix matrixSum = new Matrix(new double[][]{{1, 2, 3, 4, 5}, {1, 2, 3, 4, 5}, {1, 2, 3, 4, 5}, {1, 2, 3, 4, 5}, {1, 2, 3, 4, 5}});
        this.matrix.getMatrixSum(matrixSum);
        String actual = this.matrix.toString();
        String expected = "{{1.0, 2.0, 3.0, 4.0, 5.0}, {1.0, 2.0, 3.0, 4.0, 5.0}, {1.0, 2.0, 3.0, 4.0, 5.0}, {1.0, 2.0, 3.0, 4.0, 5.0}, {1.0, 2.0, 3.0, 4.0, 5.0}}";
        assertEquals(expected, actual);
        System.out.println("Сложение с MatrixCopy проходит верно");
    }

    @Test
    public void GetMatrixSubtraction_Matrix_MatrixTest() {
        Matrix matrixSum = new Matrix(new double[][]{{1, 2, 3, 4, 5}, {1, 2, 3, 4, 5}, {1, 2, 3, 4, 5}, {1, 2, 3, 4, 5}, {1, 2, 3, 4, 5}});
        this.matrix.getMatrixSubtraction(matrixSum);
        String actual = this.matrix.toString();
        String expected = "{{-1.0, -2.0, -3.0, -4.0, -5.0}, {-1.0, -2.0, -3.0, -4.0, -5.0}, {-1.0, -2.0, -3.0, -4.0, -5.0}, {-1.0, -2.0, -3.0, -4.0, -5.0}, {-1.0, -2.0, -3.0, -4.0, -5.0}}";
        assertEquals(expected, actual);
        System.out.println("Вычитание с MatrixArray проходит верно");
    }
}
