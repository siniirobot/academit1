package ru.academItSchool.gorbunov.main;

import ru.academItSchool.gorbunov.List.List;

public class Realization {
    public static void main(String[] args) {
        List<String> list = new List<>();

        //list.getFirstElement();
        //list.deleteFirstElement();
        list.addElementAsFirst("Один");
        list.addElementAsFirst("Два");
        list.addElementAsFirst("Три");
        list.addElementAsFirst("Четыре");
        list.addElementAsFirst("Пять");

        System.out.println("Размер списка равен - " + list.getSize());

        System.out.println("Список содержит - " + list.toSting());

        System.out.println("Первый элемент списка - " + list.getFirstElement());

        System.out.println("Элемент списка по индексу - " + list.getDataByIndex(3));

        System.out.println("За место элемента - " + list.setElementByIndex(2, "1534") + " был установлен другой элемент.");
        System.out.println("После установки список содержит - " + list.toSting());

        System.out.println(list.getSize());
        System.out.println("Удаленый элемент по индексу - " + list.deleteElementByIndex(3));
        System.out.println("Размер списка равен - " + list.getSize());
        System.out.println("После удаления список содержит - " + list.toSting());

        list.addElementAsFirst("Ноль");
        System.out.println("После добавления список содержит - " + list.toSting());

        list.addElementByIndex(1, "lf");
        System.out.println("Размер списка равен - " + list.getSize());
        System.out.println("После добавления список содержит - " + list.toSting());

        if (list.deleteElementByData("1534")) {
            System.out.println("Элемент 1534 был удален из списка.");
        } else {
            System.out.println("Элемент не был удален.");
        }
        System.out.println("Размер списка равен - " + list.getSize());

        if (list.deleteElementByData("lf")) {
            System.out.println("Элемент lf был удален.");
        } else {
            System.out.println("Элемент не был удален.");
        }

        if (list.deleteElementByData("lf")) {
            System.out.println("Элемент lf был удален.");
        } else {
            System.out.println("Элемент не был удален.");
        }

        list.addElementByIndex(4,null);

        if (list.deleteElementByData(null)) {
            System.out.println("Элемент null был удален.");
        } else {
            System.out.println("Элемент null не был удален.");
        }
        System.out.println("Размер списка равен - " + list.getSize());
        System.out.println("После удалений список содержит - " + list.toSting());

        list.setElementByIndex(1,"Один");
        list.setElementByIndex(2,"Два");
        list.setElementByIndex(3,"Три");
        list.addElementByIndex(4, "Четыре");
        list.addElementByIndex(5, "Пять");
        System.out.println("После изменений и добавлений размер списка равен - " + list.getSize());
        System.out.println("После вставки элементов список содержит - " + list.toSting());


        list.addElementByIndex(6, "Шесть");
        System.out.println("После установки элемента список содержит - " + list.toSting());

        System.out.println("Удаленый первый элемент - " + list.deleteFirstElement());
        System.out.println("После удаления список содержит - " + list.toSting());
        System.out.println("Размер списка равен - " + list.getSize());

        list.turnList();
        System.out.println("После разворота список содержит - " + list.toSting());

        List<String> list2 = list.getCopy();
        System.out.println("После копирования список содержит - " + list2.toSting());
        System.out.println("Размер скопированного списка равен - " + list2.getSize() + " Размер оригинального списка - " + list.getSize());

        list2.deleteElementByIndex(0);
        System.out.println("После  удаления скопированый список содержит - " + list2.toSting() + " А оригинальный список содержит" + list.toSting());
        System.out.println("Размер скопированного списка равен - " + list2.getSize() + " Размер оригинального списка - " + list.getSize());
        list.addElementAsFirst("пробное число не в тему");
        System.out.println("После добавления скопированый список содержит - " + list2.toSting() + " А оригинальный список содержит" + list.toSting());
        System.out.println("Размер скопированного списка равен - " + list2.getSize() + " Размер оригинального списка - " + list.getSize());
        list2.addElementAsFirst("Шесть");
        System.out.println("После вставки скопированый список содержит - " + list2.toSting() + "его размер - " + list2.getSize());

        list2.addElementByIndex(6,"Ноль");
        System.out.println(list2.toSting());

        List<String> newList = new List<>();
        List<String> copyList = newList.getCopy();

        copyList.addElementAsFirst("проба");
        System.out.println("Размер пробного скопированого списка - " + copyList.getSize());
        System.out.println("Удаление из пробного скопированого списка - " + copyList.deleteFirstElement());
        System.out.println("Размер после удаления в скопированом списке - " + copyList.getSize());
    }
}
