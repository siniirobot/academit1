package ru.academItSchool.gorbunov.BinaryTree;

public class Edge<T extends Comparable<T>> implements Comparable<Edge<T>> {
    private T data;
    private Edge left;
    private Edge right;

    @Override
    public int compareTo(Edge<T> o) {
        return data.compareTo(o.data);
    }

    public Edge(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public Edge(T data, Edge <T> edge) {
        this.data = data;
        if (compareTo(edge) < 0) {
            this.left = edge;
            this.right = null;
        } else {
            this.left = null;
            this.right = edge;
        }
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Edge getLeft() {
        return left;
    }

    public void setLeft(Edge left) {
        this.left = left;
    }

    public Edge getRight() {
        return right;
    }

    public void setRight(Edge right) {
        this.right = right;
    }

}
