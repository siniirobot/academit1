package ru.academItSchool.gorbunov.BinaryTree;

import java.awt.*;
import java.util.PriorityQueue;
import java.util.Queue;

public class BinaryTree<T extends Comparable<T>> {
    private Edge<T> root;
    private int size = 0;

    public int getSize() {
        return size;
    }

    public boolean add(Edge<T> leaf) {
        if (this.root == null) {
            this.root = leaf;
            size++;
            return true;
        }
        Edge<T> edge = root;
        while (edge.getLeft() != null || edge.getRight() != null) {
            if (leaf.compareTo(edge) < 0) {
                if (edge.getLeft() == null) {
                    edge.setLeft(leaf);
                    size++;
                    return true;
                } else {
                    edge = edge.getLeft();
                }
            } else {
                if (edge.getRight() == null) {
                    edge.setRight(leaf);
                    size++;
                    return true;
                } else {
                    edge = edge.getRight();
                }
            }
        }
        if (leaf.compareTo(edge) < 0) {
            edge.setLeft(leaf);
        } else {
            edge.setRight(leaf);
        }
        size++;
        return true;
    }

    public boolean search(T data) {
        if (this.root == null) {
            return false;
        }
        Edge<T> edge = this.root;
        while (edge.getLeft() != null || edge.getRight() != null) {
            if (edge.getData() == data) {
                return true;
            }
            if (data.compareTo(edge.getData()) < 0) {
                if (edge.getLeft() != null) {
                    edge = edge.getLeft();
                } else {
                    return false;
                }
            } else {
                if (edge.getRight() != null) {
                    edge = edge.getRight();
                } else {
                    return false;
                }
            }

        }
        return edge.getData() == data;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        if (this.root == null) {
            stringBuilder.append("Дерево пусто.");
            return stringBuilder.toString();
        }
        Queue<Edge> queue = new PriorityQueue<>();
        queue.add(this.root);
        while (queue.size() > 0) {
            Edge leaf = queue.peek();
            queue.remove();
            stringBuilder.append(leaf.getData()).append(", ");
            if (leaf.getLeft() != null) {
                queue.add(leaf.getLeft());
            }
            if (leaf.getRight() != null) {
                queue.add(leaf.getRight());
            }
        }
        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
        return stringBuilder.toString();
    }
}
