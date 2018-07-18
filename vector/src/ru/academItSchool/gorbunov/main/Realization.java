package ru.academItSchool.gorbunov.main;

import ru.academItSchool.gorbunov.vector.Vector;

public class Realization {
    public static void main(String[] args) {
        Vector vector = new Vector(35,new double[]{0,1,2,3,4,5});

        System.out.println(vector.toString());

        vector.getInsert(5.0,35);
        System.out.println(vector.toString());
    }
}
