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

        System.out.println("Размер списка равен - " + list.getSize());

        System.out.println("Список содержит - " + list.toSting());

        System.out.println("Первый элемент списка - " + list.getFirstElement());

        System.out.println("Элемент списка по индексу - " + list.getElementByIndex(3));

        System.out.println("По индексу был установлен элемент - " + list.setElementByIndex(2,"1534"));
        System.out.println("После установки список содержит - " + list.toSting());

        System.out.println("Удаленый элемент по индексу - " + list.deleteElementByIndex(5));
        System.out.println("Размер списка равен - " + list.getSize());
        System.out.println("После удаления список содержит - " + list.toSting());

        list.addElementAsFirst("Ноль");
        System.out.println("После добавления список содержит - " + list.toSting());

        list.addElementByIndex(1,"lf");
        System.out.println("Размер списка равен - " + list.getSize());
        System.out.println("После добавления список содержит - " + list.toSting());

        if (list.deleteElementByData("1534")) {
            System.out.println("Элемент 1534 был удален из списка.");
        }else {
            System.out.println("Элемент не был удален.");
        }
        System.out.println("Размер списка равен - " + list.getSize());

        if (list.deleteElementByData("lf")) {
            System.out.println("Элемент lf был удален.");
        }else {
            System.out.println("Элемент не был удален.");
        }

        if (list.deleteElementByData("lf")) {
            System.out.println("Элемент lf был удален.");
        }else {
            System.out.println("Элемент не был удален.");
        }
        System.out.println("Размер списка равен - " + list.getSize());
        System.out.println("После удалений список содержит - " + list.toSting());

        list.addElementByIndex(2,"Два");
        list.addElementByIndex(5,"Пять");
        System.out.println("Размер списка равен - " + list.getSize());
        System.out.println("После вставки элементов список содержит - " + list.toSting());


        System.out.println("Установлен элемент по индексу - " +list.setElementByIndex(6,"Шесть"));
        System.out.println("После установки элемента список содержит - " + list.toSting());

        System.out.println("Удаленый первый элемент - " + list.deleteFirstElement());
        System.out.println("После удаления список содержит - " + list.toSting());
        System.out.println("Размер списка равен - " + list.getSize());

        list.turnList();
        System.out.println("После разворота список содержит - " + list.toSting());

        System.out.println("После копирования список содержит - " + list.getCopy().toSting());
        System.out.println("Размер списка равен - " + list.getCopy().getSize());



    }
}
