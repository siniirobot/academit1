package ru.academItSchool.gorbunov.main;

import ru.academItSchool.gorbunov.List.List;

public class Realization {
    public static void main(String[] args) {
        List<String> list = new List<>();

        list.addElement("Один");
        list.addElement("Два");
        list.addElement("Три");
        list.addElement("Четыре");
        list.addElement("Пять");

        System.out.println(list.getSize());

        System.out.println(list.toSting());

        System.out.println(list.getFirstElement());

        System.out.println(list.getElementBuIndex(3));

        list.setElementBuIndex(2,"1534");
        System.out.println(list.toSting());

        System.out.println(list.deleteElementByIndex(2));

        System.out.println(list.toSting());
    }
}
