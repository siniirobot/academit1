package ru.academItScholl.gorbunov.main;

import ru.academItScholl.gorbunov.matrix.Matrix;
import ru.academItSchool.gorbunov.vector.Vector;

public class Realization {
    public static void main(String[] args) {
        Matrix matrix1 = new Matrix(5,5);
        System.out.println(matrix1.toString());

        Matrix matrix2 = new Matrix(new double[1][5]);
        System.out.println(matrix2.toString());

        Vector vector0 = new Vector(5,new double[]{1,2,3,4,5});
        Vector vector1 = new Vector(5,new double[]{1,2,3,4,5});
        Vector vector2 = new Vector(10,new double[]{1,2,3,4,5});
        Vector vector3 = new Vector(5,new double[]{1,2,3,4,5});
        Vector vector4 = new Vector(5,new double[]{1,2,3,4,5});

        Matrix matrix3 = new Matrix(new Vector[]{vector0,vector1,vector2,vector3,vector4});
        System.out.println(matrix3.toString());
    }
}
