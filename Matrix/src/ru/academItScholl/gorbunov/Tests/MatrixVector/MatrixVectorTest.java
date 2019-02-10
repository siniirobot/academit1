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
    private Vector vector5= new Vector(10);

    private Vector[] vectors;

    @Test
    public void createMatrixIllegalArgumentExceptionHeightTest(){
        vectors = new Vector[0];
        try {
            matrix = new Matrix(vectors);
        }catch (IllegalArgumentException e){
            System.out.println("Проверка MatrixVector на неверные данные в высоте матрицы" + e);
        }
    }


    @Before
    public void setMatrix() {
        this.vectors = new Vector[]{this.vector0,this.vector1,this.vector2,this.vector3,this.vector4,this.vector5};
        this.matrix = new Matrix(vectors);
    }

    @Test
    public void getWidthTest() {
        System.out.println("MatrixVector возврат ширины.");
        int actual = matrix.getWidth();
        int expected = 10;
        assertEquals(expected,actual);
    }

    @Test
    public void getHeightTest() {
        System.out.println("MatrixVector возврат высоты.");
        int actual = matrix.getHeight();
        int expected = 6;
        assertEquals(expected, actual);
    }

    @Test
    public void getSizeTest() {
        System.out.println("MatrixVector возврат размера матрицы в массиве");
        int[] actual = matrix.getSize();
        int[] expected = new int[]{6,10};
        assertArrayEquals(expected,actual);
    }
}

