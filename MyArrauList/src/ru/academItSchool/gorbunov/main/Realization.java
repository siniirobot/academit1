package ru.academItSchool.gorbunov.main;

import ru.academItSchool.gorbunov.ArrayList.MyArrayList;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Realization {
    public static void main(String[] args) {
        MyArrayList<String> proba = new MyArrayList<>();
        ArrayList<String> proba1 = new ArrayList<>(Arrays.asList("1","2","3","4","5"));


        System.out.println(proba);
    }
}
