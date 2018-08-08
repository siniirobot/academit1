package ru.academItSchool.gorbunov.List;

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
        int indexCount = this.size;
        Element<T> p = this.head;
        for (; p != null; p = p.getNext()) {
            if (indexCount == index) {
                break;
            }
            indexCount--;
        }
        return p;
    }

    //Получить данные из первого элемента списка
    public T getFirstElement() {
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
        Element<T> deletedElement = getElementFromIndex(index + 1);
        int indexCount = this.size;
        if (indexCount + 1 == index + 1) {
            deletedElement = this.head;
            this.head = this.head.getNext();
        } else {
            deletedElement.setNext(deletedElement.getNext().getNext());
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
        Element<T> addElement = getElementFromIndex(index);
        addElement.setNext(new Element<>(data, addElement.getNext()));
        this.size++;
    }

    // Удаление элемента по выбранным данным
    public boolean deleteElementByData(T data) {
        for (Element<T> p = this.head; p != null; p = p.getNext()) {
            if (p.getNext() != null && p.getNext().getData().equals(data)) {
                p.setNext(p.getNext().getNext());
                this.size--;
                return true;
            }
        }
        return false;
    }

    //Удаление первого элемента
    public T deleteFirstElement() {
        Element<T> deletedElement = this.head;
        this.head = this.head.getNext();
        this.size--;
        return deletedElement.getData();
    }

    //Разворот списка
    public void turnList() {
        Element<T> copy = null;
        for (Element<T> p = this.head; p != null; p = p.getNext()) {
            copy = new Element<>(p.getData(), copy);
        }
        this.head = copy;
    }
    public void turnList2() {
        Element<T> copy = this.head;
        for (Element<T> p = this.head; p != null; p = p.getNext()) {

            copy.setNext(p.getNext());
            copy.setData(p.getData());

        }
    }

    //Копирование списка
    public List<T> getCopy() {
        Element<T> list = null;
        for (Element<T> p = this.head; p != null; p = p.getNext()) {
            list = new Element<>(p.getData(), list);
        }
        List<T> list1 = new List<>();
        for (Element<T> p = list; p != null; p = p.getNext()) {
            list1.addElementAsFirst(p.getData());
        }
        return list1;
    }
}
