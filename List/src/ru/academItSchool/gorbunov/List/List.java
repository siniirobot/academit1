package ru.academItSchool.gorbunov.List;

import ru.academItSchool.gorbunov.List.Element;

public class List<T> {
    private Element head;
    private Element next;
    private int size = 0;

    public void addElement(T data) {
        Element element = new Element(data,this.next);

        if (head == null) {
            this.head = element;
            this.next = this.head;

            size++;
        }else {
            this.next = element;

            size++;
        }

    }

    public int getSize() {
        return size;
    }
    public String toSting() {
        Element element = this.head;
        StringBuilder stringBuilder = new StringBuilder();

        while (element != null) {
            stringBuilder.append(element.getData()).append(" ");
            element = this.head.getNext();
        }
        return stringBuilder.toString();
    }
}
