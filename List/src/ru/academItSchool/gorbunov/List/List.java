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

    public T getElementBuIndex(int index) {
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

    public T setElementBuIndex(int index, T data) {
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
        Element<T> deletedElement = null;
        int indexCount = this.size;
        Element<T> p = this.head;
        for (; p != null; p = p.getNext()) {
            if (indexCount == index + 1) {
                deletedElement = p.getNext();
                p.setNext(p.getNext().getNext());
                this.size--;
            }
            indexCount--;
        }
        return deletedElement.getData();
    }
}
