package ru.academItSchool.gorbunov.List;

public class List<T> {
    private Element<T> head;
    private int size = 0;

    // Добавление элемента.
    public void addElement(T data) {
        this.head = new Element(data, this.head);
        size++;
    }

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

    //Получить данные из первого элемента списка
    public T getFirstElement() {
        int index = this.size;
        Element<T> p = this.head;
        for (; p != null; p = p.getNext()) {
            if (index == 1) {
                break;
            }
            index--;
        }
        return p.getData();
    }

    //Получить данные из элемента по индексу
    public T getElementByIndex(int index) {
        int indexCount = this.size;
        Element<T> p = this.head;
        for (; p != null; p = p.getNext()) {
            if (indexCount == index) {
                break;
            }
            indexCount--;
        }
        return p.getData();
    }

    //Установить элемент по индексу
    public T setElementByIndex(int index, T data) {
        Element<T> oldElement = null;
        int indexCount = this.size;
        Element<T> p = this.head;
        for (; p != null; p = p.getNext()) {
            if (indexCount == index) {
                oldElement = p;
                p.setData(data);
                break;
            }
            indexCount--;
        }
        return oldElement.getData();
    }

    //Удаление элемента по индексу
    public T deleteElementByIndex(int index) {
        int indexCount = this.size;
        Element<T> deletedElement = null;
        if (indexCount + 1 == index + 1) {
            deletedElement = this.head;
            this.head = this.head.getNext();
        } else {
            for (Element<T> p = this.head; p != null; p = p.getNext()) {
                if (indexCount == index + 1) {
                    deletedElement = p.getNext();
                    p.setNext(p.getNext().getNext());
                }
                indexCount--;
            }
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
        int indexCount = this.size;
        for (Element<T> p = this.head; p != null; p = p.getNext()) {
            if (indexCount == index) {
                p.setNext(new Element<>(data, p.getNext()));
                this.size++;
            }
            indexCount--;
        }
    }

    // Удаление элемента по выбранным данным
    public boolean deleteElementByData(T data) {
        for (Element<T> p = this.head; p != null; p = p.getNext()) {
            if (p.getNext() == null) {
                break;
            }
            if (p.getNext().getData().equals(data)) {
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
            copy = new Element<>(p.getData(),copy);
        }
        this.head = copy;
    }

    //Копирование списка
    public List<T> getCopy () {
        Element<T> list = null;
        for (Element<T> p = this.head; p != null; p = p.getNext()) {
            list = new Element<>(p.getData(),list);
        }
        List<T> list1 = new List<>();
        for (Element<T> p = list; p != null; p = p.getNext()) {
            list1.addElement(p.getData());
        }
        return list1;
    }
}
