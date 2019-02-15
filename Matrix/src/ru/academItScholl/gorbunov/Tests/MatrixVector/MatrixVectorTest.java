package ru.academItScholl.gorbunov.Tests.MatrixVector;


import org.junit.Before;
import org.junit.Test;
import ru.academItScholl.gorbunov.matrix.Matrix;
import ru.academItSchool.gorbunov.vector.Vector;


import static org.junit.Assert.*;

public class MatrixVectorTest {
    private Matrix matrix;

    private Vector vector0 = new Vector(1);
    private Vector vector1 = new Vector(2);
    private Vector vector2 = new Vector(3);
    private Vector vector3 = new Vector(4);
    private Vector vector4 = new Vector(5);
    private Vector vector5 = new Vector(10);

    private Vector[] vectors;

    @Test
    public void CreateVectorMatrix_Vectors_Error() {
        vectors = new Vector[0];
        try {
            matrix = new Matrix(vectors);
        } catch (IllegalArgumentException e) {
            System.out.println("Проверка MatrixVector на неверные данные в высоте матрицы" + e);
        }
    }


    @Before
    public void SetMatrix_Vector_Matrix() {
        this.vectors = new Vector[]{this.vector0, this.vector1, this.vector2, this.vector3, this.vector4, this.vector5};
        this.matrix = new Matrix(vectors);
    }

    @Test
    public void GetWidth_Matrix_IntWidth() {
        System.out.println("MatrixVector возврат ширины.");
        int actual = matrix.getWidth();
        int expected = 10;
        assertEquals(expected, actual);
    }

    @Test
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
        this.matrix.transpositionMatrix();
        String actual = this.matrix.toString();
        String expected = "{{0.0, 0.0, 0.0, 0.0, 0.0, 0.0}, {0.0, 0.0, 0.0, 0.0, 0.0, 0.0}, {0.0, 0.0, 0.0, 0.0, 0.0, 0.0}, {0.0, 0.0, 0.0, 0.0, 0.0, 0.0}, {0.0, 0.0, 0.0, 0.0, 0.0, 0.0}, {0.0, 0.0, 0.0, 0.0, 0.0, 0.0}, {0.0, 0.0, 0.0, 0.0, 0.0, 0.0}, {0.0, 0.0, 0.0, 0.0, 0.0, 0.0}, {0.0, 0.0, 0.0, 0.0, 0.0, 0.0}, {0.0, 0.0, 0.0, 0.0, 0.0, 0.0}}";
        assertEquals(expected, actual);
        System.out.println("Транспонирование MatrixVector просходит правильно" + System.lineSeparator() + actual);
    }

    @Test
    public void GetMatrixScalar_Matrix_Matrix() {
        int scalar = 1;
        this.matrix.getMatrixScalar(scalar);
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
        Vector actual = this.matrix.getMatrixMultiplicationByVector(vector);
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
        this.matrix.getMatrixSum(matrixSum);
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
        this.matrix.getMatrixSubtraction(matrixSum);
        String actual = this.matrix.toString();
        String expected = "{{-2.0, -2.0, -3.0, -4.0, -5.0, -6.0, -7.0, -8.0, -9.0, -10.0}, {-1.0, -2.0, -3.0, -4.0, -5.0, -6.0, -7.0, -8.0, -9.0, -10.0}, {-1.0, -2.0, -3.0, -4.0, -5.0, -6.0, -7.0, -8.0, -9.0, -10.0}, {-1.0, -2.0, -3.0, -4.0, -5.0, -6.0, -7.0, -8.0, -9.0, -10.0}, {-1.0, -2.0, -3.0, -4.0, -5.0, -6.0, -7.0, -8.0, -9.0, -10.0}, {-1.0, -2.0, -3.0, -4.0, -5.0, -6.0, -7.0, -8.0, -9.0, -10.0}}";
        assertEquals(expected, actual);
        System.out.println("Вычитание с MatrixVector проходит верно");
    }
}

