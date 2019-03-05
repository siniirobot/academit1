package ru.academItSchool.gorbunov.main;

import ru.academItSchool.gorbunov.OldArrayList.MyArrayList;
//import java.util.OldArrayList;
//import java.util.Arrays;

public class Realization {
    public static void main(String[] args) {
        MyArrayList<Integer> proba = new MyArrayList<>();
        //OldArrayList<Integer> proba2 = new OldArrayList<>(Arrays.asList(1,2,3));
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
            System.out.println("С помощью иттератора it мы распечатали элемент - " + it.next());
        }
        proba.addAll(proba3);
        System.out.println("Текущий размер массива - " + proba.size());
        proba.addAll(proba3);
        System.out.println("Текущий размер массива - " + proba.size());
        proba.addAll(proba3);
        proba.addAll(proba3);
        System.out.println("Текущий размер массива - " + proba.size());
        proba3.add(3);
        proba3.add(4);
        proba3.add(5);
        proba3.add(6);
        proba3.add(7);
        proba.addAll(proba3);
        System.out.println(proba);
        System.out.println("Текущий размер массива - " + proba.size());
       proba.clear();
        System.out.println(proba);
        proba.addAll(proba3);
        System.out.println(proba);
        proba.remove((Object)3);
        System.out.println(proba);
        proba.remove(2);
        System.out.println(proba);
        proba3.clear();
        proba3.add(3);
        proba3.add(4);
        System.out.println(proba3);
        proba.addAll(2,proba3);
        System.out.println(proba);
        proba.add(0,0);
        proba.add(8,8);
        System.out.println(proba);
    }
}
