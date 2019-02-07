package ru.academItScholl.gorbunov.matrix;

import org.junit.Test;
import ru.academItSchool.gorbunov.vector.Vector;

import static org.junit.Assert.*;

public class MatrixTest {


    @Test
    public void getWidth() {
        Matrix matrix = new Matrix(5,5);
        int actual = matrix.getWidth();
        int expected = 5;
        assertEquals(expected,actual);

        Matrix matrix1 = new Matrix(new double[][]{{1,2,3},{1,2,3,4,5}});
        int actual1 = matrix1.getWidth();
        int expected1 = 5;
        assertEquals(expected1,actual1);

        Vector vector0 = new Vector(9,new double[]{1,2,3,4,5,6});
        Vector vector1 = new Vector(1,new double[]{1,2,3,4,5});
        Vector vector2 = new Vector(10,new double[]{1,2,3,4,5});
        Vector vector3 = new Vector(2,new double[]{1,2,3,4,5});
        Vector vector4 = new Vector(6,new double[]{1,2,3,4,5});
        Matrix matrix2 = new Matrix(new Vector[]{vector0,vector1,vector2,vector3,vector4});
        int actual2 = matrix2.getWidth();
        int expected2 = 10;
        assertEquals(expected2,actual2);
    }

    @Test
    public void getHeight(){
        Matrix matrix = new Matrix(5,5);
        int actual = matrix.getHeight();
        int expected = 5;
        assertEquals(expected,actual);

        Matrix matrix1 = new Matrix(new double[][]{{1,2,3},{1,2,3,4,5}});
        int actual1 = matrix1.getHeight();
        int expected1 = 2;
        assertEquals(expected1,actual1);

        Vector vector0 = new Vector(9,new double[]{1,2,3,4,5,6});
        Vector vector1 = new Vector(1,new double[]{1,2,3,4,5});
        Vector vector2 = new Vector(10,new double[]{1,2,3,4,5});
        Vector vector3 = new Vector(2,new double[]{1,2,3,4,5});
        Vector vector4 = new Vector(6,new double[]{1,2,3,4,5});
        Matrix matrix2 = new Matrix(new Vector[]{vector0,vector1,vector2,vector3,vector4});
        int actual2 = matrix2.getHeight();
        int expected2 = 5;
        assertEquals(expected2,actual2);
    }

    @Test
    public void getSize() {
        Matrix matrix = new Matrix(5,5);
        int[] actual = matrix.getSize();
        int[] expected = new int[]{5,5};
        assertArrayEquals(expected,actual);

        Matrix matrix1 = new Matrix(new double[][]{{1,2,3},{1,2,3,4,5}});
        int[] actual1 = matrix1.getSize();
        int[] expected1 = new int[]{2,5};
        assertArrayEquals(expected1,actual1);

        Vector vector0 = new Vector(9,new double[]{1,2,3,4,5,6});
        Vector vector1 = new Vector(1,new double[]{1,2,3,4,5});
        Vector vector2 = new Vector(10,new double[]{1,2,3,4,5});
        Vector vector3 = new Vector(2,new double[]{1,2,3,4,5});
        Vector vector4 = new Vector(6,new double[]{1,2,3,4,5});
        Matrix matrix2 = new Matrix(new Vector[]{vector0,vector1,vector2,vector3,vector4});
        int[] actual2 = matrix2.getSize();
        int[] expected2 = new int[] {5,10};
        assertArrayEquals(expected2,actual2);
    }

    @Test
    public void getLineVector(){
        int index = 1;
        Matrix matrix = new Matrix(5,5);
        Vector actual = matrix.getLineVector(index);
        Vector expected = new Vector(5);
        assertEquals(expected,actual);

        Matrix matrix1 = new Matrix(new double[][]{{1,2,3},{1,2,3,4,5}});
        Vector actual1 = matrix1.getLineVector(index);
        Vector expected1= new Vector(new double[]{1,2,3,4,5});
        assertEquals(expected1,actual1);


        Vector vector0 = new Vector(9,new double[]{1,2,3,4,5,6});
        Vector vector1 = new Vector(1,new double[]{1,2,3,4,5});
        Vector vector2 = new Vector(10,new double[]{1,2,3,4,5});
        Vector vector3 = new Vector(2,new double[]{1,2,3,4,5});
        Vector vector4 = new Vector(6,new double[]{1,2,3,4,5});
        Matrix matrix2 = new Matrix(new Vector[]{vector0,vector1,vector2,vector3,vector4});
        Vector actual2 = matrix2.getLineVector(index);
        Vector expected2 = new Vector(new double[]{1});
        assertEquals(expected,actual);

    }
}