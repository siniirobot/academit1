package ru.academItScholl.gorbunov.Tests.MatrixVector;

import java.util.Arrays;
import java.util.Collection;

import org.junit.runners.*;
import org.junit.Test;
import org.junit.Assume;
import org.testng.annotations.Parameters;
import ru.academItScholl.gorbunov.Tests.MatrixTestStaticFunc;
import ru.academItScholl.gorbunov.matrix.Matrix;
import org.junit.runner.RunWith;
import ru.academItSchool.gorbunov.vector.Vector;
import org.junit.Before;
import org.junit.Test;
import ru.academItScholl.gorbunov.matrix.Matrix;
import ru.academItSchool.gorbunov.vector.Vector;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class MatrixVectorTest {
    enum Type {
        WIDTH, HEIGHT,SIZE, TO_STRING, GET_VECTOR_LINE, SET_VECTOR_LINE, TRANSPOSITION, SCALAR, DETERMINANTE,
        VECTOR_MULTIPLICATION, GET_VECTOR_COLUMN, SUM, SUBTRACT
    }

    ;
    private Type type;
    private Matrix matrix1, matrix2;
    private String expectedMatrix;

    public MatrixVectorTest(Type type, Matrix matrix1, Matrix matrix2, String expectedMatrix) {
        this.type = type;
        this.matrix1 = matrix1;
        this.matrix2 = matrix2;
        this.expectedMatrix = expectedMatrix;
    }

    @Parameterized.Parameters
    public static Collection dataSum() {
        return Arrays.asList(new Object[][]{
                {
                        Type.WIDTH,
                        new Matrix(new Vector[]{new Vector(1),
                                new Vector(2),
                                new Vector(3),
                                new Vector(4),
                                new Vector(5),
                                new Vector(10)}),
                        new Matrix(1,1),
                        "10"
                },
                {
                        Type.HEIGHT,
                        new Matrix(new Vector[]{new Vector(1)}),
                        new Matrix(1,1),
                        "1"
                },
                {
                        Type.SIZE,
                        new Matrix(new Vector[]{new Vector(1),
                                new Vector(7),
                                new Vector(7),
                                new Vector(7),
                                new Vector(7)}),
                        new Matrix(1,1),
                        "[5, 7]"
                },
        });
    }



    @Test
    public void GetWidth_Matrix_IntWidth() {
        try {
            Assume.assumeTrue(type == Type.WIDTH);
            assertEquals(expectedMatrix,(Integer.toString(matrix1.getWidth())) );
        } catch (IllegalArgumentException e) {
            System.out.println("getWidth - " + e);
        }
    }

    @Test
    public void GetHeight_Matrix_IntHeight() {
        try {
            Assume.assumeTrue(type == Type.HEIGHT);
            assertEquals(expectedMatrix,(Integer.toString(matrix1.getHeight())) );
        } catch (IllegalArgumentException e) {
            System.out.println("getWidth - " + e);
        }
    }

    @Test
    public void GetSize_Matrix_ArraySize() {
        try {
            Assume.assumeTrue(type == Type.SIZE);
            assertEquals(expectedMatrix,Arrays.toString(matrix1.getSize()));
        } catch (IllegalArgumentException e) {
            System.out.println("getWidth - " + e);
        }
    }
   /* @Test
    public void GetHeight_Matrix_IntHeight() {
        System.out.println("MatrixVector возврат высоты.");
        int actual = matrix.getHeight();
        int expected = 6;
        assertEquals(expected, actual);
    }

    @Test
    public void GetSize_Matrix_ArraySize() {
        System.out.println("MatrixVector возврат размера матрицы в массиве");
        int[] actual = matrix.getSize();
        int[] expected = new int[]{6, 10};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void ToString_Matrix_StringMatrix() {
        System.out.println("MatrixVector правильно возвращает toString" + System.lineSeparator() + matrix.toString());
        String actual = "{{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0}, {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0}, {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0}, {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0}, {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0}, {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0}}";
        String expected = matrix.toString();
        assertEquals(actual, expected);
    }

    @Test
    public void GetLineVector_Matrix_Vector() {
        System.out.println("MatrixVector правильно достает Vector");
        int index = 2;
        Vector actual = this.matrix.getLineVector(index);
        Vector expected = new Vector(new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0});
        assertEquals(expected, actual);
    }

    @Test
    public void SetLineVector_Matrix_Matrix() {
        int index = 0;
        Vector testVector = new Vector(11);
        this.matrix.setLineVector(index, testVector);
        String actual = matrix.toString();
        String expected = "{{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0}, {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0}, {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0}, {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0}, {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0}, {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0}}";
        assertEquals(expected, actual);
        System.out.println("Вставка нового вектора по индексу и реформация MatrixVector просходит правильно" + System.lineSeparator() + actual);
    }

    @Test
    public void GetColumn_Matrix_Vector() {
        int index = 0;
        Vector actual = this.matrix.getColumnVector(index);
        Vector expected = new Vector(new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0});
        assertEquals(expected, actual);
        System.out.println("MatrixVector правильно достает columnVector");
    }

    @Test
    public void TranspositionMatrix_Matrix_Matrix_Matrix_Matrix() {
        this.matrix.transposition();
        String actual = this.matrix.toString();
        String expected = "{{0.0, 0.0, 0.0, 0.0, 0.0, 0.0}, {0.0, 0.0, 0.0, 0.0, 0.0, 0.0}, {0.0, 0.0, 0.0, 0.0, 0.0, 0.0}, {0.0, 0.0, 0.0, 0.0, 0.0, 0.0}, {0.0, 0.0, 0.0, 0.0, 0.0, 0.0}, {0.0, 0.0, 0.0, 0.0, 0.0, 0.0}, {0.0, 0.0, 0.0, 0.0, 0.0, 0.0}, {0.0, 0.0, 0.0, 0.0, 0.0, 0.0}, {0.0, 0.0, 0.0, 0.0, 0.0, 0.0}, {0.0, 0.0, 0.0, 0.0, 0.0, 0.0}}";
        assertEquals(expected, actual);
        System.out.println("Транспонирование MatrixVector просходит правильно" + System.lineSeparator() + actual);
    }

    @Test
    public void GetMatrixScalar_Matrix_Matrix() {
        int getMultiplicationByScalar = 1;
        this.matrix.getMultiplicationByScalar(getMultiplicationByScalar);
        String actual = this.matrix.toString();
        String expected = "{{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0}, {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0}, {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0}, {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0}, {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0}, {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0}}";
        assertEquals(expected, actual);
        System.out.println("MatrixVector умножена на скаляр правильно");
    }

    @Test
    public void GetDeterminant_Matrix_Double() {
        try {
            this.matrix.getDeterminant();
        } catch (IllegalArgumentException e) {
            System.out.println("Детерминант не квадратной MatrixVector выдает верное исключение" + e);
        }
    }

    @Test
    public void GetMatrixMultiplicationByVector_MatrixVector_Matrix() {
        Vector vector = new Vector(new double[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        Vector actual = this.matrix.getMultiplicationByVector(vector);
        Vector expected = new Vector(6);
        assertEquals(expected, actual);
        System.out.println("Умножение MatrixVector на вектор вычисляется верно");
    }

    @Test
    public void GetMatrixSum_Matrix_Matrix() {
        Matrix matrixSum = new Matrix(new double[][]{
                {1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
                {1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
                {1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
                {1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
                {1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
                {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}
        });
        this.matrix.sum(matrixSum);
        String actual = this.matrix.toString();
        String expected = "{{1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0}, {1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0}, {1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0}, {1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0}, {1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0}, {1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0}}";
        assertEquals(expected, actual);
        System.out.println("Сложение с MatrixVector проходит верно");
    }

    @Test
    public void GetMatrixSubtraction_Matrix_MatrixTest() {
        Matrix matrixSum = new Matrix(new double[][]{
                {2, 2, 3, 4, 5, 6, 7, 8, 9, 10},
                {1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
                {1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
                {1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
                {1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
                {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}
        });
        this.matrix.subtraction(matrixSum);
        String actual = this.matrix.toString();
        String expected = "{{-2.0, -2.0, -3.0, -4.0, -5.0, -6.0, -7.0, -8.0, -9.0, -10.0}, {-1.0, -2.0, -3.0, -4.0, -5.0, -6.0, -7.0, -8.0, -9.0, -10.0}, {-1.0, -2.0, -3.0, -4.0, -5.0, -6.0, -7.0, -8.0, -9.0, -10.0}, {-1.0, -2.0, -3.0, -4.0, -5.0, -6.0, -7.0, -8.0, -9.0, -10.0}, {-1.0, -2.0, -3.0, -4.0, -5.0, -6.0, -7.0, -8.0, -9.0, -10.0}, {-1.0, -2.0, -3.0, -4.0, -5.0, -6.0, -7.0, -8.0, -9.0, -10.0}}";
        assertEquals(expected, actual);
        System.out.println("Вычитание с MatrixVector проходит верно");
    }*/
}

