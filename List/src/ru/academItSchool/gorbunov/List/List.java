package ru.academItSchool.gorbunov.List;

public class List<T> {
    private Element<T> head;
    private int size = 0;

    public void addElement(T data) {
        this.head = new Element(data, this.head);
        size++;
    }

    public int getSize() {
        return size;
    }

    public String toSting() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Element<T> p = this.head; p != null; p = p.getNext()) {
            stringBuilder.append(p.getData()).append(" ");
        }
        return stringBuilder.toString();
    }

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

    public T deleteElementByIndex(int index) {
        int indexCount = this.size;
        Element<T> deletedElement = null;
        if (indexCount + 1 == index + 1) {
            deletedElement = this.head;
            this.head = this.head.getNext();
        } else {
            Element<T> p = this.head;
            for (; p != null; p = p.getNext()) {
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

    public void addElementAsFirst(T data) {
        Element p = new Element<>(data, this.head);
        this.head = p;
        size++;
    }

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

    public T deleteFirstElement() {
        Element<T> deletedElement = this.head;
        this.head = this.head.getNext();
        this.size--;
        return deletedElement.getData();
    }

    public void turnList() {
        Element<T> copy = null;

        for (Element<T> p = this.head; p != null; p = p.getNext()) {
            copy = p;
        }

    }
}
