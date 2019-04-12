package ru.academItSchool.gorbunov.BinaryTree;

import java.awt.*;
import java.util.*;


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
            if (edge.getData() != data) {
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
            } else if (edge.getLeft() == null && edge.getRight() == null) {
                if (parentEdge.getLeft() != null && parentEdge.getLeft().getData() == data) {
                    parentEdge.setLeft(null);
                } else {
                    parentEdge.setRight(null);
                }
                this.size--;
                return true;
            } else if (edge.getLeft() != null && edge.getRight() != null) {
                Edge<T> leafParent = parentEdge;
                Edge<T> leaf = edge;
                parentEdge = edge;
                edge = edge.getRight();
                if (edge.getLeft() != null) {
                    while (edge.getLeft() != null) {
                        parentEdge = edge;
                        edge = edge.getLeft();
                    }
                    parentEdge.setLeft(edge.getRight());
                }
                if (this.root.getData() == data) {
                    this.root = edge;
                } else {
                    if (leafParent.getRight() != null && leafParent.getRight().getData() == data) {
                        leafParent.setRight(edge);
                    } else {
                        leafParent.setLeft(edge);
                    }
                }
                edge.setLeft(leaf.getLeft());
                if (!parentEdge.equals(leaf)) {
                    edge.setRight(leaf.getRight());
                }
                this.size--;
                return true;
            } else {
                if (edge.getLeft() == null) {
                    parentEdge.setRight(edge.getRight());
                } else {
                    parentEdge.setRight(edge.getLeft());
                }
                this.size--;
                return true;
            }
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
            Edge<?> leaf = linkedList.peek();
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BinaryTree<?> that = (BinaryTree<?>) o;
        if (this.size != that.size) {
            return false;
        }
        Edge<?> edgeThis = this.root;
        Edge<?> edgeThat = that.root;
        Stack<Edge<?>> stack = new Stack<>();
        stack.push(edgeThis);
        stack.push(edgeThat);
        while (stack.size() > 0) {
            Edge<?> leafThat = stack.pop();
            Edge<?> leafThis = stack.pop();
            if (!leafThis.equals(leafThat)) {
                return false;
            }
            stack.push(leafThis.getRight());
            stack.push(leafThat.getRight());
            stack.push(leafThis.getLeft());
            stack.push(leafThat.getLeft());
        }
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        Edge<?> edge = this.root;
        Stack<Edge<?>> stack = new Stack<>();
        stack.push(edge);
        while (stack.size() > 0) {
            Edge<?> leaf = stack.pop();
            result = prime * result + leaf.hashCode();
            stack.push(leaf.getRight());
            stack.push(leaf.getLeft());
        }
        return result;
    }
}
