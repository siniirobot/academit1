package ru.academItScholl.gorbunov.Tests.MatrixInt;


import org.junit.Before;
import org.junit.Test;
import ru.academItScholl.gorbunov.matrix.Matrix;


import static org.junit.Assert.*;

public class MatrixIntTest {
    private Matrix matrix;

    private int firstNumber;
    private int secondNumber;

    @Test
    public void createMatrixIllegalArgumentExceptionHeightTest(){
        firstNumber = 0;
        secondNumber = 5;
        try {
            matrix = new Matrix(firstNumber,secondNumber);
        }catch (IllegalArgumentException e){
            System.out.println("Проверка высоты" + e);
        }
    }

    @Test
    public void createMatrixIllegalArgumentExceptionWidthTest(){
        firstNumber = 5;
        secondNumber = -1;
        try {
            matrix = new Matrix(firstNumber,secondNumber);
        }catch (IllegalArgumentException e){
            System.out.println("Проверка ширины" + e);
        }
    }

    @Before
    public void setMatrix() {
        firstNumber = 5;
        secondNumber = 5;
        this.matrix = new Matrix(firstNumber,secondNumber);
    }

    @Test
    public void getWidthTest() {
        int actual = matrix.getWidth();
        int expected = 5;
        assertEquals(expected,actual);
        System.out.println("Возврат ширины - Ок");
    }

    @Test
    public void getHeightTest() {
        int actual = matrix.getHeight();
        int expected = 5;
        assertEquals(expected, actual);
    }

    @Test
    public void getSizeTest() {
        int[] actual = matrix.getSize();
        int[] expected = new int[]{5,5};
        assertArrayEquals(expected,actual);
    }
}

