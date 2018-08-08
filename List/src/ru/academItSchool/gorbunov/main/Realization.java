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

        System.out.println(list.getElementByIndex(3));

        System.out.println(list.setElementByIndex(2,"1534"));

        System.out.println(list.deleteElementByIndex(5));

        System.out.println(list.toSting());

        list.addElementAsFirst("Ноль");

        System.out.println(list.toSting());

        list.addElementByIndex(1,"lf");

        System.out.println(list.toSting());

        if (list.deleteElementByData("1534")) {
            System.out.println("Элемент 1534, был удален из списка.");
        }else {
            System.out.println("Элемента 1534, не было в спске.");
        }

        if (list.deleteElementByData("lf")) {
            System.out.println("Элемент lf, был удален из списка.");
        }else {
            System.out.println("Элемента lf, не было в спске.");
        }

        if (list.deleteElementByData("lf")) {
            System.out.println("Элемент lf, был удален из списка.");
        }else {
            System.out.println("Элемента lf, не было в спске.");
        }



        System.out.println(list.toSting());

        System.out.println(list.getSize());

        list.addElementByIndex(2,"Два");
        list.addElementByIndex(5,"Пять");

        System.out.println(list.toSting());
        System.out.println(list.getSize());

        System.out.println(list.setElementByIndex(6,"Шесть"));
        System.out.println(list.toSting());

        System.out.println(list.deleteFirstElement());

        System.out.println(list.toSting());

        list.turnList();
        System.out.println(list.toSting());

        list.addElement("Ноль");
        System.out.println(list.toSting());
        System.out.println(list.getSize());

        System.out.println(list.copyList().toString());
    }
}
