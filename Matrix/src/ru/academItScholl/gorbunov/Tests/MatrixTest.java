package ru.academItScholl.gorbunov.Tests;

import java.util.Arrays;
import java.util.Collection;

import org.junit.runners.*;
import org.junit.Test;
import org.junit.Assume;
import ru.academItScholl.gorbunov.matrix.Matrix;
import org.junit.runner.RunWith;
import ru.academItSchool.gorbunov.vector.Vector;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class MatrixTest {
    enum Type {
        WIDTH, HEIGHT, TO_STRING, GET_VECTOR_LINE, SET_VECTOR_LINE, TRANSPOSITION, MULTIPLICATION_BY_SCALAR, DETERMINANT,
        VECTOR_MULTIPLICATION, GET_VECTOR_COLUMN, SUM, SUBTRACT
    }

    private Type type;
    private Matrix matrix1, matrix2;
    private String expectedMatrix;
    private Integer index;
    private Vector vector;

    public MatrixTest(Type type, Matrix matrix1, Matrix matrix2, Integer index, Vector vector, String expectedMatrix) {
        this.type = type;
        this.matrix1 = matrix1;
        this.matrix2 = matrix2;
        this.index = index;
        this.vector = vector;
        this.expectedMatrix = expectedMatrix;
    }

    @Parameterized.Parameters
    public static Collection<Object> dataSum() {
        return Arrays.asList(new Object[][]{
                {
                        Type.WIDTH,
                        new Matrix(new Vector[]{new Vector(1),
                                new Vector(2),
                                new Vector(3),
                                new Vector(4),
                                new Vector(5),
                                new Vector(10)}),
                        null,
                        null,
                        null,
                        "10"
                },
                {
                        Type.HEIGHT,
                        new Matrix(new Vector[]{new Vector(1)}),
                        null,
                        null,
                        null,
                        "1"
                },
                {
                        Type.TO_STRING,
                        new Matrix(new Vector[]{new Vector(1),
                                new Vector(7),
                                new Vector(7),
                                new Vector(7),
                                new Vector(7)}),
                        null,
                        null,
                        null,
                        "{{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0}, {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0}, {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0}, {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0}, {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0}}"
                },
                {
                        Type.GET_VECTOR_LINE,
                        new Matrix(new Vector[]{new Vector(1),
                                new Vector(7),
                                new Vector(7),
                                new Vector(7),
                                new Vector(7)}),
                        null,
                        1,
                        null,
                        "{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0}"
                },
                {
                        Type.GET_VECTOR_LINE,
                        new Matrix(new Vector[]{new Vector(1),
                                new Vector(7),
                                new Vector(7),
                                new Vector(7),
                                new Vector(7)}),
                        null,
                        10,
                        null,
                        "{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0}"
                },
                {
                        Type.GET_VECTOR_LINE,
                        new Matrix(new Vector[]{new Vector(1),
                                new Vector(7),
                                new Vector(7),
                                new Vector(7),
                                new Vector(7)}),
                        null,
                        -10,
                        null,
                        "{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0}"
                },
                {
                        Type.SET_VECTOR_LINE,
                        new Matrix(new Vector[]{new Vector(1),
                                new Vector(7),
                                new Vector(7),
                                new Vector(7),
                                new Vector(7)}),
                        null,
                        10,
                        null,
                        "{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0}"
                },
                {
                        Type.SET_VECTOR_LINE,
                        new Matrix(new Vector[]{new Vector(1),
                                new Vector(7),
                                new Vector(7),
                                new Vector(7),
                                new Vector(7)}),
                        null,
                        -10,
                        null,
                        "{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0}"
                },
                {
                        Type.SET_VECTOR_LINE,
                        new Matrix(new Vector[]{new Vector(1),
                                new Vector(7),
                                new Vector(7),
                                new Vector(7),
                                new Vector(7)}),
                        null,
                        5,
                        new Vector(5, new double[]{1, 2, 3, 4, 5}),
                        "{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0}"
                },
                {
                        Type.SET_VECTOR_LINE,
                        new Matrix(new Vector[]{new Vector(1),
                                new Vector(7),
                                new Vector(7),
                                new Vector(7),
                                new Vector(7)}),
                        null,
                        4,
                        new Vector(7, new double[]{1, 2, 3, 4, 5}),
                        "{{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0}, {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0}, {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0}, {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0}, {1.0, 2.0, 3.0, 4.0, 5.0, 0.0, 0.0}}"
                },
                {
                        Type.GET_VECTOR_COLUMN,
                        new Matrix(new Vector[]{new Vector(1),
                                new Vector(7),
                                new Vector(7),
                                new Vector(7),
                                new Vector(7)}),
                        null,
                        1,
                        null,
                        "{0.0, 0.0, 0.0, 0.0, 0.0}"
                },
                {
                        Type.GET_VECTOR_COLUMN,
                        new Matrix(new Vector[]{new Vector(1),
                                new Vector(7),
                                new Vector(7),
                                new Vector(7),
                                new Vector(7)}),
                        null,
                        10,
                        null,
                        "{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0}"
                },
                {
                        Type.GET_VECTOR_COLUMN,
                        new Matrix(new Vector[]{new Vector(1),
                                new Vector(7),
                                new Vector(7),
                                new Vector(7),
                                new Vector(7)}),
                        null,
                        -10,
                        null,
                        "{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0}"
                },
                {
                        Type.TRANSPOSITION,
                        new Matrix(new Vector[]{new Vector(3, new double[]{1, 2, 3})}),
                        null,
                        null,
                        null,
                        "{{1.0}, {2.0}, {3.0}}"
                },
                {
                        Type.TRANSPOSITION,
                        new Matrix(new Vector[]{new Vector(new double[]{1}),
                                new Vector(new double[]{1}),
                                new Vector(new double[]{1}),
                                new Vector(new double[]{1}),
                                new Vector(new double[]{1})}),
                        null,
                        null,
                        null,
                        "{{1.0, 1.0, 1.0, 1.0, 1.0}}"
                },
                {
                        Type.TRANSPOSITION,
                        new Matrix(new Vector[]{new Vector(3, new double[]{1, 2, 3}),
                                new Vector(3, new double[]{1, 2, 3}),
                                new Vector(3, new double[]{1, 2, 3}),
                        }),
                        null,
                        null,
                        null,
                        "{{1.0, 1.0, 1.0}, {2.0, 2.0, 2.0}, {3.0, 3.0, 3.0}}"
                },
                {
                        Type.MULTIPLICATION_BY_SCALAR,
                        new Matrix(new Vector[]{new Vector(3, new double[]{1, 2, 3}),
                                new Vector(3, new double[]{1, 2, 3}),
                                new Vector(3, new double[]{1, 2, 3}),
                        }),
                        null,
                        3,
                        null,
                        "{{3.0, 6.0, 9.0}, {3.0, 6.0, 9.0}, {3.0, 6.0, 9.0}}"
                },
                {
                        Type.DETERMINANT,
                        new Matrix(new Vector[]{new Vector(3, new double[]{1, 2, 3}),
                                new Vector(3, new double[]{1, 2, 3}),
                                new Vector(3, new double[]{1, 2, 3}),
                        }),
                        null,
                        null,
                        null,
                        "0.0"
                },
                {
                        Type.DETERMINANT,
                        new Matrix(new Vector[]{new Vector(3, new double[]{43, 21, 376}),
                                new Vector(3, new double[]{1.34, -2, 0.3}),
                                new Vector(3, new double[]{0, 21, 398}),
                        }),
                        null,
                        null,
                        null,
                        "-35117.98"
                },
                {
                        Type.DETERMINANT,
                        new Matrix(new Vector[]{new Vector(3, new double[]{1, 2, 3})}),
                        null,
                        null,
                        null,
                        "0.0"
                },
                {
                        Type.VECTOR_MULTIPLICATION,
                        new Matrix(new Vector[]{new Vector(3, new double[]{43, 21, 376}),
                                new Vector(3, new double[]{1.34, -2, 0.3}),
                                new Vector(3, new double[]{0, 21, 398}),
                        }),
                        null,
                        null,
                        new Vector(new double[]{1, 2, 3}),
                        "{1213.0, -1.7600000000000002, 1236.0}"
                },
                {
                        Type.VECTOR_MULTIPLICATION,
                        new Matrix(new Vector[]{new Vector(3, new double[]{43, 21, 376}),
                                new Vector(3, new double[]{1.34, -2, 0.3}),
                                new Vector(3, new double[]{0, 21, 398}),
                        }),
                        null,
                        null,
                        new Vector(new double[]{2, 3}),
                        "{1213.0, -1.7600000000000002, 1236.0}"
                },
                {
                        Type.VECTOR_MULTIPLICATION,
                        new Matrix(new Vector[]{new Vector(2, new double[]{43, 21, 376})}),
                        null,
                        null,
                        new Vector(new double[]{2, 3}),
                        "{149.0}"
                },
                {
                        Type.SUM,
                        new Matrix(new Vector[]{new Vector(3, new double[]{1, 2, 3}),
                                new Vector(3, new double[]{1, 2, 3}),
                                new Vector(3, new double[]{1, 2, 3})
                        }),
                        new Matrix(new Vector[]{new Vector(3, new double[]{1, 2, 3}),
                                new Vector(3, new double[]{1, 2, 3}),
                                new Vector(3, new double[]{1, 2, 3})
                        }),
                        null,
                        null,
                        "{{2.0, 4.0, 6.0}, {2.0, 4.0, 6.0}, {2.0, 4.0, 6.0}}"
                },
                {
                        Type.SUM,
                        new Matrix(new Vector[]{new Vector(3, new double[]{1, 2, 3}),
                                new Vector(3, new double[]{1, 2, 3}),
                        }),
                        new Matrix(new Vector[]{new Vector(3, new double[]{1, 2, 3}),
                                new Vector(3, new double[]{1, 2, 3}),
                                new Vector(3, new double[]{1, 2, 3})
                        }),
                        null,
                        null,
                        "{{2.0, 4.0, 6.0}, {2.0, 4.0, 6.0}, {2.0, 4.0, 6.0}}"
                },
                {
                        Type.SUBTRACT,
                        new Matrix(new Vector[]{new Vector(3, new double[]{1, 2, 3}),
                                new Vector(3, new double[]{1, 2, 3}),
                                new Vector(3, new double[]{1, 2, 3})
                        }),
                        new Matrix(new Vector[]{new Vector(3, new double[]{1, 2, 3}),
                                new Vector(3, new double[]{1, 2, 3}),
                                new Vector(3, new double[]{1, 2, 3})
                        }),
                        null,
                        null,
                        "{{0.0, 0.0, 0.0}, {0.0, 0.0, 0.0}, {0.0, 0.0, 0.0}}"
                },
                {
                        Type.SUBTRACT,
                        new Matrix(new Vector[]{new Vector(3, new double[]{1, 2, 3}),
                                new Vector(3, new double[]{1, 2, 3}),
                        }),
                        new Matrix(new Vector[]{new Vector(3, new double[]{1, 2, 3}),
                                new Vector(3, new double[]{1, 2, 3}),
                                new Vector(3, new double[]{1, 2, 3})
                        }),
                        null,
                        null,
                        "{{2.0, 4.0, 6.0}, {2.0, 4.0, 6.0}, {2.0, 4.0, 6.0}}"
                }
        });
    }

    @Test
    public void GetWidth_Matrix_IntWidth() {
        try {
            Assume.assumeTrue(this.type == Type.WIDTH);
            assertEquals(this.expectedMatrix, (Integer.toString(this.matrix1.getColumnsCount())));
        } catch (IllegalArgumentException e) {
            System.out.println("getColumnsCount - " + e);
        }
    }

    @Test
    public void GetHeight_Matrix_IntHeight() {
        try {
            Assume.assumeTrue(this.type == Type.HEIGHT);
            assertEquals(this.expectedMatrix, (Integer.toString(this.matrix1.getRowsCount())));
        } catch (IllegalArgumentException e) {
            System.out.println("getRowsCount - " + e);
        }
    }

    @Test
    public void ToString_Matrix_StringMatrix() {
        try {
            Assume.assumeTrue(this.type == Type.TO_STRING);
            System.out.println(this.expectedMatrix);
            System.out.println(this.matrix1.toString());
            assertEquals(this.expectedMatrix, this.matrix1.toString());
        } catch (IllegalArgumentException e) {
            System.out.println("ToString - " + e);
        }
    }

    @Test
    public void GetRowVector_Matrix_Vector() {
        try {
            Assume.assumeTrue(this.type == Type.GET_VECTOR_LINE);
            assertEquals(this.expectedMatrix, this.matrix1.getRow(this.index).toString());
        } catch (IndexOutOfBoundsException e) {
            System.out.println("getRow - " + e);
        }
    }

    @Test
    public void SetLineVector_Matrix_Matrix() {
        try {
            Assume.assumeTrue(this.type == Type.SET_VECTOR_LINE);
            matrix1.setRow(this.index, this.vector);
            assertEquals(this.expectedMatrix, this.matrix1.toString());
        } catch (IllegalArgumentException | IndexOutOfBoundsException e) {
            System.out.println("setRow - " + e);
        }
    }

    @Test
    public void GetColumn_Matrix_Vector() {
        try {
            Assume.assumeTrue(this.type == Type.GET_VECTOR_COLUMN);
            assertEquals(this.expectedMatrix, this.matrix1.getColumn(this.index).toString());
        } catch (IndexOutOfBoundsException e) {
            System.out.println("getColumn - " + e);
        }
    }

    @Test
    public void TranspositionMatrix_Matrix_Matrix_Matrix_Matrix() {
        try {
            Assume.assumeTrue(this.type == Type.TRANSPOSITION);
            this.matrix1.transposition();
            assertEquals(this.expectedMatrix, this.matrix1.toString());
        } catch (IllegalArgumentException e) {
            System.out.println("transposition - " + e);
        }
    }

    @Test
    public void GetMatrixScalar_Matrix_Matrix() {
        try {
            Assume.assumeTrue(this.type == Type.MULTIPLICATION_BY_SCALAR);
            this.matrix1.multiplicationByScalar(index);
            assertEquals(this.expectedMatrix, this.matrix1.toString());
        } catch (IllegalArgumentException e) {
            System.out.println("getMatrixScalar - " + e);
        }
    }

    @Test
    public void GetDeterminant_Matrix_Double() {
        try {
            Assume.assumeTrue(this.type == Type.DETERMINANT);
            assertEquals(this.expectedMatrix, Double.toString(this.matrix1.getDeterminant()));
        } catch (IllegalArgumentException e) {
            System.out.println("getDeterminant - " + e);
        }
    }

    @Test
    public void GetMatrixMultiplicationByVector_MatrixVector_Matrix() {
        try {
            Assume.assumeTrue(this.type == Type.VECTOR_MULTIPLICATION);
            assertEquals(this.expectedMatrix, this.matrix1.getMultiplicationByVector(vector).toString());
        } catch (IllegalArgumentException e) {
            System.out.println("getMatrixMultiplicationByVector - " + e);
        }
    }

    @Test
    public void GetMatrixSum_Matrix_Matrix() {
        try {
            Assume.assumeTrue(this.type == Type.SUM);
            this.matrix1.sum(this.matrix2);
            assertEquals(this.expectedMatrix, this.matrix1.toString());
        } catch (IllegalArgumentException e) {
            System.out.println("getMatrixSum - " + e);
        }
    }

    @Test
    public void GetMatrixSubtraction_Matrix_MatrixTest() {
        try {
            Assume.assumeTrue(this.type == Type.SUBTRACT);
            this.matrix1.subtraction(this.matrix2);
            assertEquals(this.expectedMatrix, this.matrix1.toString());
        } catch (IllegalArgumentException e) {
            System.out.println("getMatrixSubtraction - " + e);
        }
    }
}