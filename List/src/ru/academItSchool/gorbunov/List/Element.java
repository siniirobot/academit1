package ru.academItSchool.gorbunov.List;

public class Element<T> {
    private Element<T> next;
    private T data;

    public Element(){}
    public Element(T data) {
        this.data = data;
    }

    public Element (T data, Element<T> next) {
        this.data = data;
        this.next = next;
    }

    public Element<T> getNext() {
        return next;
    }

    public void setNext(Element<T> next) {
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
