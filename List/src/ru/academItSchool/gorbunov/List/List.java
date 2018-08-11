package ru.academItSchool.gorbunov.List;

import java.util.Objects;

public class List<T> {
    private Element<T> head;
    private int size = 0;

    //Колличество элементов в списке
    public int getSize() {
        return size;
    }

    //Распечатка списка
    public String toSting() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (Element<T> p = this.head; p != null; p = p.getNext()) {
            stringBuilder.append(p.getData()).append(", ");
        }
        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
        return stringBuilder.append("}").toString();
    }

    //Счетчик по индексу
    private Element<T> getElementFromIndex(int index) {
        if (index > this.size || index < 0) {
            throw new ArrayIndexOutOfBoundsException("Введеный вами индекс за пределами размера списка");
        }
        int i = 0;
        Element<T> p = this.head;
        while (i != index){
            p = p.getNext();
            i++;
        }
        return p;
    }

    //Получить данные из первого элемента списка
    public T getFirstElement() {
        if (this.size < 0) {
            throw new ArrayIndexOutOfBoundsException("Список пуст");
        }
        return this.head.getData();
    }

    //Получить данные из элемента по индексу
    public T getElementByIndex(int index) {
        return getElementFromIndex(index).getData();
    }

    //Установить элемент по индексу
    public T setElementByIndex(int index, T data) {
        Element<T> oldElement = getElementFromIndex(index);
        getElementFromIndex(index).setData(data);
        return oldElement.getData();
    }

    //Удаление элемента по индексу
    public T deleteElementByIndex(int index) {
        Element<T> deletedElement = getElementFromIndex(index);
        if (index == 0) {
            deleteFirstElement();
            return deletedElement.getData();
        } else {
            Element<T> elementForDeleting = getElementFromIndex(index - 1);
            elementForDeleting.setNext(deletedElement.getNext());
        }
        this.size--;
        return deletedElement.getData();
    }

    // Добавить элемент в начало
    public void addElementAsFirst(T data) {
        this.head = new Element<>(data, this.head);
        size++;
    }

    // Добавить элемент по индексу
    public void addElementByIndex(int index, T data) {
        if (index > this.size || index < 0) {
            throw new ArrayIndexOutOfBoundsException("Введеный вами индекс за пределами размера списка");
        }
        if (index == 0) {
            addElementAsFirst(data);
        } else {
            Element<T> addElement = getElementFromIndex(index - 1);
            addElement.setNext(new Element<>(data, addElement.getNext()));
            this.size++;
        }
    }

    // Удаление элемента по выбранным данным
    public boolean deleteElementByData(T data) {
        for (Element<T> p = this.head; p != null; p = p.getNext()) {
            if (p.getNext() != null && Objects.equals(p.getNext().getData(), data)) {
                p.setNext(p.getNext().getNext());
                this.size--;
                return true;
            }
        }
        return false;
    }

    //Удаление первого элемента
    public T deleteFirstElement() {
        if (this.size < 0) {
            throw new ArrayIndexOutOfBoundsException("Список пуст");
        }
        Element<T> deletedElement = this.head;
        this.head = this.head.getNext();
        this.size--;
        return deletedElement.getData();
    }

    //Разворот списка
    public void turnList() {
        Element<T> copy = null;
        Element<T> temp;
        while (this.head != null) {
            temp = this.head.getNext();
            this.head.setNext(copy);
            copy = this.head;
            this.head = temp;
        }
        this.head = copy;
    }

    //Копирование списка
    public List<T> getList() {
        List<T> copyList = new List<>();
        int i = 0;
        for (Element<T> p = this.head; p != null; p = p.getNext()) {
            copyList.addElementByIndex(i, p.getData());
            i++;
        }
        return copyList;
    }
}
