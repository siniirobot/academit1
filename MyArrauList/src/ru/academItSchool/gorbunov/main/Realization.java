package ru.academItSchool.gorbunov.main;

import ru.academItSchool.gorbunov.ArrayList.MyArrayList;

import java.lang.reflect.Array;
//import java.util.ArrayList;
//import java.util.Arrays;

public class Realization {
    public static void main(String[] args) {
        MyArrayList<Integer> proba = new MyArrayList<>();
        //ArrayList<Integer> proba2 = new ArrayList<>(Arrays.asList(1,2,3));
        System.out.println("Проверка массива на пустоту - " + proba.isEmpty());
        proba.add(1);
        proba.add(2);
        proba.add(3);
        System.out.println("Текущий размер массива - " + proba.size());
        System.out.println();
        System.out.println("Просто распечатал массив" + proba);
        System.out.println();
        System.out.println("Проверка массива на пустоту - " + proba.isEmpty());
        System.out.println("Содержит ли массив 1 - " + proba.contains(1));
        System.out.println("Содержит ли массив s - " + proba.contains("s"));
        System.out.println("Содержит ли массив 5 - " + proba.contains(5));

        System.out.println();
        MyArrayList<Integer> proba3 = new MyArrayList<>();
        proba3.add(1);
        proba3.add(2);
        System.out.println("Этот список содержит элементы второго - " + proba.containsAll(proba3));
        MyArrayList.MyArrayListIterator it = (MyArrayList.MyArrayListIterator) proba3.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
