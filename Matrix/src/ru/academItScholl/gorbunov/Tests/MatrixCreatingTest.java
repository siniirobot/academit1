package ru.academItScholl.gorbunov.Tests;

import org.junit.Test;
import ru.academItScholl.gorbunov.matrix.Matrix;
import ru.academItSchool.gorbunov.vector.Vector;

import static org.junit.Assert.*;

public class MatrixCreatingTest {

    @Test
    public void CreateMatrixInt_Int_Matrix() {
        try {
            int height = 3;
            int weight = 2;
            Matrix matrix = new Matrix(height, weight);
            assertEquals("{{0.0, 0.0}, {0.0, 0.0}, {0.0, 0.0}}", matrix.toString());
        } catch (NullPointerException e) {
            System.out.println("createMatrixInt - " + e);
        }
    }

    @Test
    public void CreateMatrixInt_Int_Error() {
        try {
            int height = 3;
            int weight = 0;
            Matrix matrix = new Matrix(height, weight);
            assertEquals("{{0.0, 0.0}, {0.0, 0.0}, {0.0, 0.0}}", matrix.toString());
        } catch (IllegalArgumentException e) {
            System.out.println("createMatrixInt - " + e);
        }
    }

    @Test
    public void CreateMatrixArray_Array_Matrix() {
        try {
            double[][] array = new double[3][2];
            Matrix matrix = new Matrix(array);
            assertEquals("{{0.0, 0.0}, {0.0, 0.0}, {0.0, 0.0}}", matrix.toString());
        } catch (NullPointerException e) {
            System.out.println("createMatrixArray - " + e);
        }
    }

    @Test
    public void CreateMatrixArray_Array_Error() {
        try {
            double[][] array = new double[0][2];
            Matrix matrix = new Matrix(array);
            assertEquals("{{0.0, 0.0}, {0.0, 0.0}, {0.0, 0.0}}", matrix.toString());
        } catch (NullPointerException e) {
            System.out.println("createMatrixArray - " + e);
        }
    }

    @Test
    public void CreateMatrixArray_Array_Error2() {
        try {
            double[][] array = new double[][]{{}, {}, {}};
            Matrix matrix = new Matrix(array);
            assertEquals("{{1.0, 2.0, 3.0}, {1.0, 0.0, 0.0}, {0.0, 0.0, 0.0}}", matrix.toString());
        } catch (NullPointerException e) {
            System.out.println("createMatrixArray - " + e);
        }
    }


    @Test
    public void CreateMatrixCopy_Matrix_Matrix() {
        try {
            Matrix matrix = new Matrix(2, 2);
            Matrix copyMatrix = new Matrix(matrix);
            assertEquals("{{0.0, 0.0}, {0.0, 0.0}}", copyMatrix.toString());
        } catch (NullPointerException e) {
            System.out.println("createMatrixCopy - " + e);
        }
    }

    @Test
    public void CreateMatrixCopyForChange_Matrix_Matrix() {
        try {
            Matrix matrix = new Matrix(2, 2);
            Matrix copyMatrix = new Matrix(matrix);
            matrix.setRow(1,new Vector(2,new double[]{1,2}));
            assertNotEquals(matrix,copyMatrix);
        } catch (NullPointerException e) {
            System.out.println("createMatrixCopy - " + e);
        }
    }

    @Test
    public void CreateMatrixVector_Vector_Matrix() {
        try {
            Vector[] vectors = new Vector[]{
                    new Vector(new double[]{1, 2, 3}),
                    new Vector(new double[]{1, 2, 3}),
                    new Vector(new double[]{1, 2, 3})
            };
            Matrix matrix = new Matrix(vectors);
            assertEquals("{{1.0, 2.0, 3.0}, {1.0, 2.0, 3.0}, {1.0, 2.0, 3.0}}", matrix.toString());
        } catch (NullPointerException e) {
            System.out.println("createMatrixVector - " + e);
        }
    }

    @Test
    public void CreateMatrixVector_Vector_Error() {
        try {
            Vector[] vectors = new Vector[0];
            Matrix matrix = new Matrix(vectors);
            assertEquals("{{1.0, 2.0, 3.0}, {1.0, 2.0, 3.0}, {1.0, 2.0, 3.0}}", matrix.toString());
        } catch (NullPointerException e) {
            System.out.println("createMatrixVector - " + e);
        }
    }
}
