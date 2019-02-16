package ru.academItScholl.gorbunov.Tests;

import java.util.Arrays;
import java.util.Collection;

import org.junit.runners.*;
import org.junit.Test;
import org.testng.annotations.Parameters;
import org.junit.Assume;
import ru.academItScholl.gorbunov.matrix.Matrix;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class MatrixTestStaticFunc {

    enum Type {SUM, SUBTRACT, MULTIPLICATION}

    ;

    @Parameterized.Parameters
    public static Collection dataSum() {
        return Arrays.asList(new java.lang.Object[][]{
                {
                        Type.SUM,
                        new Matrix(new double[][]{{1, 2, 3}, {1, 2, 3}, {1, 2, 3}}),
                        new Matrix(new double[][]{{1, 2, 3}, {1, 2, 3}, {1, 2, 3}}),
                        new Matrix(new double[][]{{2.0, 4.0, 6.0}, {2.0, 4.0, 6.0}, {2.0, 4.0, 6.0}})
                },
                {
                        Type.SUM,
                        new Matrix(new double[][]{{1, 2}, {1, 2}, {1, 2}}),
                        new Matrix(new double[][]{{1, 2, 3}, {1, 2, 3}}),
                        new Matrix(new double[][]{{1, 2, 3}, {1, 2, 3}})
                },
                {
                        Type.SUBTRACT,
                        new Matrix(new double[][]{{1, 2, 3}, {1, 2, 3}, {1, 2, 3}}),
                        new Matrix(new double[][]{{1, 2, 3}, {1, 2, 3}, {1, 2, 3}}),
                        new Matrix(new double[][]{{0.0, 0.0, 0.0}, {0.0, 0.0, 0.0}, {0.0, 0.0, 0.0}})
                },
                {
                        Type.SUBTRACT,
                        new Matrix(new double[][]{{1, 2}, {1, 2}, {1, 2}}),
                        new Matrix(new double[][]{{1, 2, 3}, {1, 2, 3}}),
                        new Matrix(new double[][]{{1, 2, 3}, {1, 2, 3}})
                },
                {
                        Type.MULTIPLICATION,
                        new Matrix(new double[][]{{1, 2, 3}, {1, 2, 3}, {1, 2, 3}}),
                        new Matrix(new double[][]{{1, 2, 3}, {1, 2, 3}, {1, 2, 3}}),
                        new Matrix(new double[][]{{6.0, 12.0, 18.0}, {6.0, 12.0, 18.0}, {6.0, 12.0, 18.0}})
                },
                {
                        Type.MULTIPLICATION,
                        new Matrix(new double[][]{{1, 2}, {1, 2}, {1, 2}}),
                        new Matrix(new double[][]{{1, 2, 3}, {1, 2, 3}}),
                        new Matrix(new double[][]{{3.0, 6.0, 9.0}, {3.0, 6.0, 9.0}, {3.0, 6.0, 9.0}})
                },
                {
                        Type.MULTIPLICATION,
                        new Matrix(new double[][]{{1}, {1}}),
                        new Matrix(new double[][]{{1, 2, 3}, {1, 2, 3}}),
                        new Matrix(new double[][]{{3.0, 6.0, 9.0}, {3.0, 6.0, 9.0}, {3.0, 6.0, 9.0}})
                },
        });
    }

    private Type type;
    private Matrix matrix1, matrix2, expected;

    public MatrixTestStaticFunc(Type type, Matrix matrix1, Matrix matrix2, Matrix expected) {
        this.type = type;
        this.matrix1 = matrix1;
        this.matrix2 = matrix2;
        this.expected = expected;
    }

    @Test
    public void StaticSum_Matrix_NewMatrix() {
        try {
            Assume.assumeTrue(type == Type.SUM);
                assertEquals(expected.toString(), Matrix.getStaticMatrixSum(matrix1, matrix2).toString());
        } catch (IllegalArgumentException e) {
            System.out.println("StaticSum - " + e);
        }
    }

    @Test
    public void StaticSubtraction_Matrix_NewMatrix() {
        try {
            Assume.assumeTrue(type == Type.SUBTRACT);
            assertEquals(expected.toString(), Matrix.getStaticMatrixSubtraction(matrix1, matrix2).toString());
        } catch (IllegalArgumentException e) {
            System.out.println("StaticSubtraction - " + e);
        }
    }

    @Test
    public void StaticMultiplication() {
        try {
            Assume.assumeTrue(type == Type.MULTIPLICATION);
            assertEquals(expected.toString(), Matrix.getStaticMatrixMultiplication(matrix1, matrix2).toString());
        } catch (IllegalArgumentException e) {
            System.out.println("StaticMultiplication - " + e);
        }
    }

}