package ru.academItScholl.gorbunov.Tests;

import org.junit.Test;
import ru.academItScholl.gorbunov.matrix.Matrix;
import ru.academItSchool.gorbunov.vector.Vector;

import static org.junit.Assert.*;

public class MatrixTest {

    private Matrix matrixInt = new Matrix(5,5);

    private Matrix matrixArray = new Matrix(new double[][] {{1,2,3,4,5,6,7,8,9},{1,2,3}});

    private Vector vector0 = new Vector(9,new double[]{1,2,3,4,5,6});
    private Vector vector1 = new Vector(1,new double[]{1,2,3,4,5});
    private Vector vector2 = new Vector(10,new double[]{1,2,3,4,5});
    private Vector vector3 = new Vector(2,new double[]{1,2,3,4,5});
    private Vector vector4 = new Vector(6,new double[]{1,2,3,4,5});
    private Matrix matrixVector = new Matrix(new Vector[]{vector0,vector1,vector2,vector3,vector4});




    @Test
    public void getWidthMatrixArrayTest() {
        int actual = matrixArray.getWidth();
        int expected = 9;
        assertEquals(expected,actual);
    }

    @Test
    public void getWidthMatrixVectorTest() {
        int actual = matrixVector.getWidth();
        int expected = 10;
        assertEquals(expected,actual);
    }



    @Test
    public void getHeightMatrixArrayTest() {
        int actual = matrixArray.getHeight();
        int expected = 2;
        assertEquals(expected, actual);
    }

    @Test
    public void getHeightMatrixVectorTest() {
        int actual = matrixVector.getHeight();
        int expected = 5;
        assertEquals(expected, actual);
    }



    @Test
    public void getSizeMatrixArrayTest() {
        int[] actual = matrixArray.getSize();
        int[] expected = new int[]{2,9};
        assertArrayEquals(expected,actual);
    }

    @Test
    public void getSizeMatrixVectorTest() {
        int[] actual = matrixVector.getSize();
        int[] expected = new int[]{5,10};
        assertArrayEquals(expected,actual);
    }
}