package ru.academItSchool.gorbunov.BinaryTree;

import java.awt.*;
import java.util.LinkedList;
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

    public boolean delete(T data) {
        if (this.root == null) {
            return false;
        }
        Edge<T> edge = this.root;
        Edge<T> parentEdge = edge;
        while (edge.getLeft() != null || edge.getRight() != null) {
            if (edge.getData() == data) {
                if (edge.getLeft() == null || edge.getRight() == null) {
                    if (edge.getLeft() == null) {
                        parentEdge.setRight(edge.getRight());
                        this.size--;
                        return true;
                    } else {
                        parentEdge.setRight(edge.getLeft());
                        this.size--;
                        return true;
                    }
                } else {
                    Edge<T> leafParent = parentEdge;
                    Edge<T> leaf = edge;
                    parentEdge = edge;
                    edge = edge.getRight();
                    if (edge.getLeft() == null) {
                        leafParent.setRight(edge);
                        edge.setLeft(leaf.getLeft());
                        this.size--;
                        return true;
                    }
                    while (edge.getLeft() != null) {
                        parentEdge = edge;
                        edge = edge.getLeft();
                    }
                    parentEdge.setLeft(edge.getRight());
                    leafParent.setLeft(edge);
                    edge.setLeft(leaf.getLeft());
                    edge.setRight(leaf.getRight());
                    this.size--;
                    return true;
                }
            } else {
                if (data.compareTo(edge.getData()) < 0) {
                    if (edge.getLeft() != null) {
                        parentEdge = edge;
                        edge = edge.getLeft();
                    } else {
                        return false;
                    }
                } else {
                    if (edge.getRight() != null) {
                        parentEdge = edge;
                        edge = edge.getRight();
                    } else {
                        return false;
                    }
                }
            }
        }
        if (parentEdge.getLeft() != null && parentEdge.getLeft().getData() == data) {
            parentEdge.setLeft(null);
            this.size--;
            return true;
        } else if (parentEdge.getRight() != null && parentEdge.getRight().getData() == data) {
            parentEdge.setRight(null);
            this.size--;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        if (this.root == null) {
            stringBuilder.append("Дерево пусто.");
            return stringBuilder.toString();
        }
        LinkedList<Edge> linkedList = new LinkedList<>();
        linkedList.add(this.root);
        while (linkedList.size() > 0) {
            Edge leaf = linkedList.peek();
            linkedList.remove();
            stringBuilder.append(leaf.getData()).append(", ");
            if (leaf.getLeft() != null) {
                linkedList.add(leaf.getLeft());
            }
            if (leaf.getRight() != null) {
                linkedList.add(leaf.getRight());
            }
        }
        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
        return stringBuilder.toString();
    }
}
