package ru.academItSchool.gorbunov.List;

public class List<T> {
    private Element<T> head;
    private int size = 0;

    public void addElement(T data) {
        Element<T> element = new Element(data, this.head);
        if (this.head == null) {
            this.head = element;
        } else {
            this.head = element;
        }

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

    public void setElementBuIndex(int index, T data) {
        int indexCount = this.size;
        Element<T> p = this.head;
        for (; p != null; p = p.getNext()) {
            if (indexCount == index) {
                p.setData(data);
                break;
            }
            indexCount--;
        }
    }

    public T deleteElementByIndex(int index) {
        Element<T> deletedElement = null;
        int indexCount = this.size;
        Element<T> p = this.head;
        for (; p != null; p = p.getNext()) {
            if (indexCount == index + 1) {
                deletedElement = p;
                p = p.getNext().getNext();
                System.out.println(p.getData());
                this.size--;
            }
            indexCount--;
        }
        return deletedElement.getData();
    }
}
