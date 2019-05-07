package ru.academItSchool.gorbunov.MyClass;

import java.io.Serializable;

public class MyClass implements Serializable {
    private int[][] matrix;

    public MyClass(int n) {
        this.matrix = new int[n][n];

    }
}
