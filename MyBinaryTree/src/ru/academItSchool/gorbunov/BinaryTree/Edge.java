package ru.academItSchool.gorbunov.BinaryTree;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (o == null || getClass() != o.getClass()){
            return false;
        }
        Edge<?> edge = (Edge<?>) o;
        return Objects.equals(this.data, edge.data) &&
                this.left.equals(edge.left) &&
                this.right.equals(edge.right);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Objects.hashCode(this.data);
        result = prime * result + this.left.hashCode();
        result = prime * result + this.right.hashCode();
        return result;
    }
}
