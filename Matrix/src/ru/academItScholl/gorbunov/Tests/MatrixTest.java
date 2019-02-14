package ru.academItScholl.gorbunov.Tests;

import org.junit.Test;
import ru.academItScholl.gorbunov.matrix.Matrix;


import static org.junit.Assert.*;

public class MatrixTest {
    private Matrix matrix1 = new Matrix(new double[][] {{1,2,3},{1,2,3}});
    private Matrix matrix2 = new Matrix(new double[][] {{1,2,3},{1,2,3}});

    @Test
    public void getMatrixStaticSumTest(){
        String actual = Matrix.getStaticMatrixSum(this.matrix1,this.matrix2).toString();
        String expected = new Matrix(new double[][]{{2.0, 4.0, 6.0}, {2.0, 4.0, 6.0}}).toString();
        assertEquals(expected,actual);
        System.out.println("Функция статической суммы работает нормально");
    }

    @Test
    public void getMatrixStaticSumErrorTest() {
        try{
            Matrix.getStaticMatrixSum(this.matrix1,new Matrix(5,5));
        }catch (IllegalArgumentException e){
            System.out.println("Функция статической суммы правильно обрабатывает исключения.");
        }
    }

    @Test
    public void getMatrixStaticSubtractionTest(){
        String actual = Matrix.getStaticMatrixSubtraction(this.matrix1,this.matrix2).toString();
        String expected = new Matrix(new double[][]{{0.0, 0.0, 0.0}, {0.0, 0.0, 0.0}}).toString();
        assertEquals(expected,actual);
        System.out.println("Функция статического вычитания работает нормально");
    }

    @Test
    public void getMatrixStaticSubtractionErrorTest() {
        try{
            Matrix.getStaticMatrixSubtraction(this.matrix1,new Matrix(5,5));
        }catch (IllegalArgumentException e){
            System.out.println("Функция статического вычитания правильно обрабатывает исключения.");
        }
    }
}