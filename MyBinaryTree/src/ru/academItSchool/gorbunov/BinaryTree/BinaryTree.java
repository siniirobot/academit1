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
            stringBuilder.append(String.valueOf(leaf.getData())).append(", ");
            if (leaf.getLeft() != null) {
                queue.add(leaf.getLeft());
            }
            if (leaf.getRight() != null) {
                queue.add(leaf.getRight());
            }
        }
        return stringBuilder.toString();
    }
}
