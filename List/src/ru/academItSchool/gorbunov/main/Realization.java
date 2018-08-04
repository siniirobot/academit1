package ru.academItSchool.gorbunov.main;

import ru.academItSchool.gorbunov.List.List;

public class Realization {
    public static void main(String[] args) {
        List<Integer> list = new List<>();

        list.addElement(1);
        list.addElement(2);
        list.addElement(3);
        list.addElement(4);
        list.addElement(5);

        System.out.println(list.getSize());

        System.out.println(list.toSting());
    }
}
