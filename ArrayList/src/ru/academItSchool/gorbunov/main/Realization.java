package ru.academItSchool.gorbunov.main;

import ru.academItSchool.gorbunov.ArrayList.ArrayList;
//import java.util.ArrayList;
import java.util.Arrays;

public class Realization {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        System.out.println(list.isEmpty());
        list.add(0);
        System.out.println(list.isEmpty());
        System.out.println(Arrays.toString(list.toArray()));
    }
}
