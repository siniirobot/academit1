package ru.academItSchool.gorbunov.BinaryTree;

import java.util.*;
import java.util.function.Consumer;

public class BinaryTree<T> {
    private Node<T> root;
    private int size = 0;
    private Comparator<T> comparator;

    public BinaryTree() {
        this.root = null;
    }

    public BinaryTree(Comparator<T> comparator) {
        this.root = null;
        this.comparator = comparator;
    }

    @SuppressWarnings("unchecked")
    private int compare(T o1, T o2) {
        if (this.comparator != null) {
            return this.comparator.compare(o1, o2);
        }
        if (o1 == null && o2 == null) {
            return 0;
        }
        if (o1 == null || o2 == null) {
            return (o1 == null) ? -1 : 1;
        }
        return ((Comparable<T>) o1).compareTo(o2);
    }

    public int getSize() {
        return size;
    }

    public void add(T data) {
        if (this.root == null) {
            this.root = new Node<>(data);
            size++;
            return;
        }
        Node<T> node = root;
        while (true) {
            if (compare(data, node.getData()) < 0) {
                if (node.getLeft() == null) {
                    node.setLeft(new Node<>(data));
                    size++;
                    return;
                }
                node = node.getLeft();
            } else {
                if (node.getRight() == null) {
                    node.setRight(new Node<>(data));
                    size++;
                    return;
                }
                node = node.getRight();
            }
        }
    }

    public boolean contains(T data) {
        if (this.root == null) {
            return false;
        }
        Node<T> node = this.root;
        int search;
        while ((search = compare(data, node.getData())) != 0) {
            if (search < 0) {
                if (node.getLeft() == null) {
                    return false;
                }
                node = node.getLeft();
            } else {
                if (node.getRight() == null) {
                    return false;
                }
                node = node.getRight();
            }
        }
        return true;
    }

    public boolean delete(T data) {
        if (this.root == null) {
            return false;
        }
        Node<T> node = this.root;
        Node<T> parentNode = null;
        int compareResult = compare(data, node.getData());
        while (compareResult != 0) {
            if (compareResult < 0) {
                if (node.getLeft() == null) {
                    return false;
                }
                parentNode = node;
                node = node.getLeft();
            } else {
                if (node.getRight() == null) {
                    return false;
                }
                parentNode = node;
                node = node.getRight();
            }
            compareResult = compare(data, node.getData());
        }
        if (node.getLeft() == null || node.getRight() == null) {
            if (parentNode != null) {
                if (parentNode.getLeft() != null && compare(data, parentNode.getLeft().getData()) == 0) {
                    if (node.getLeft() != null) {
                        parentNode.setLeft(node.getLeft());
                    } else {
                        parentNode.setLeft(node.getRight());
                    }
                } else {
                    if (node.getLeft() != null) {
                        parentNode.setRight(node.getLeft());
                    } else {
                        parentNode.setRight(node.getRight());
                    }
                }
            } else {
                if (node.getLeft() != null) {
                    this.root = node.getLeft();
                } else if (node.getRight() != null) {
                    this.root = node.getRight();
                } else {
                    this.root = null;
                }
            }
            this.size--;
            return true;
        }
        Node<T> tempParent = parentNode;
        Node<T> temp = node;
        parentNode = node;
        node = node.getRight();
        if (node.getLeft() != null) {
            while (node.getLeft() != null) {
                parentNode = node;
                node = node.getLeft();
            }
            parentNode.setLeft(node.getRight());
        }
        if (tempParent == null) {
            this.root = node;
        } else {
            if (tempParent.getRight() != null && compare(data, tempParent.getRight().getData()) == 0) {
                tempParent.setRight(node);
            } else {
                tempParent.setLeft(node);
            }
        }
        node.setLeft(temp.getLeft());
        if (temp != parentNode) {
            node.setRight(temp.getRight());
        }
        this.size--;
        return true;
    }

    public void wideBypass(Consumer<T> consumer) {
        if (this.root == null) {
            return;
        }
        Queue<Node<T>> linkedList = new LinkedList<>();
        linkedList.add(this.root);
        while (linkedList.size() != 0) {
            Node<T> temp = linkedList.remove();
            consumer.accept(temp.getData());
            if (temp.getLeft() != null) {
                linkedList.add(temp.getLeft());
            }
            if (temp.getRight() != null) {
                linkedList.add(temp.getRight());
            }
        }
    }

    public void depthCrawlByStack(Consumer<T> consumer) {
        if (this.root == null) {
            return;
        }
        Deque<Node<T>> stack = new LinkedList<>();
        stack.push(this.root);
        while (stack.size() != 0) {
            Node<T> temp = stack.pop();
            consumer.accept(temp.getData());
            if (temp.getRight() != null) {
                stack.push(temp.getRight());
            }
            if (temp.getLeft() != null) {
                stack.push(temp.getLeft());
            }
        }
    }

    public void depthCrawlByRecursion(Consumer<T> consumer) {
        depthCrawlByRecursion(this.root, consumer);
    }

    private void depthCrawlByRecursion(Node<T> node, Consumer<T> consumer) {
        if (node == null) {
            return;
        }
        consumer.accept(node.getData());
        if (node.getLeft() != null) {
            depthCrawlByRecursion(node.getLeft(), consumer);
        }
        if (node.getRight() != null) {
            depthCrawlByRecursion(node.getRight(), consumer);
        }
    }
}
