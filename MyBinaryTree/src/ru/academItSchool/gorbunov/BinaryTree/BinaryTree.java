package ru.academItSchool.gorbunov.BinaryTree;

import java.util.*;

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

    public int compare(T o1, T o2) {
        if (this.comparator != null) {
            return this.comparator.compare(o1, o2);
        } else {
            if (Objects.equals(o1, o2)) {
                return 0;
            }
            if (o1 == null || o2 == null) {
                return (o1 == null) ? -1 : 1;
            }
            return ((Comparable<T>) o1).compareTo(o2);
        }
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
        while (node.getLeft() != null || node.getRight() != null) {
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
        if (compare(data, node.getData()) < 0) {
            node.setLeft(new Node<>(data));
        } else {
            node.setRight(new Node<>(data));
        }
        size++;
    }

    public boolean search(T data) {
        if (this.root == null) {
            return false;
        }
        Node<T> node = this.root;
        while (node.getLeft() != null || node.getRight() != null) {
            int search = compare(data, node.getData());
            if (search == 0) {
                return true;
            } else if (search < 0) {
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
        return compare(data, node.getData()) == 0;
    }

    public boolean delete(T data) {
        if (this.root == null) {
            return false;
        }
        Node<T> node = this.root;
        Node<T> parentNode = null;
        while (node.getData() != data) {
            if (compare(data, node.getData()) < 0) {
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
        }
        if (node.getLeft() != null && node.getRight() != null) {
            Node<T> leafParent = parentNode;
            Node<T> leaf = node;
            parentNode = node;
            node = node.getRight();
            if (node.getLeft() != null) {
                while (node.getLeft() != null) {
                    parentNode = node;
                    node = node.getLeft();
                }
                parentNode.setLeft(node.getRight());
            }
            if (this.root.getData() == data) {
                this.root = node;
            } else {
                if (leafParent.getRight() != null && leafParent.getRight().getData() == data) {
                    leafParent.setRight(node);
                } else {
                    leafParent.setLeft(node);
                }
            }
            node.setLeft(leaf.getLeft());
            if (!parentNode.equals(leaf)) {
                node.setRight(leaf.getRight());
            }
            this.size--;
            return true;
        } else {
            if (parentNode != null) {
                if (parentNode.getLeft() != null && parentNode.getLeft().getData() == data) {
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
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        if (this.root == null) {
            stringBuilder.append("Дерево пусто.");
            return stringBuilder.toString();
        }
        LinkedList<Node> linkedList = new LinkedList<>();
        linkedList.add(this.root);
        while (linkedList.size() > 0) {
            Node<?> leaf = linkedList.peek();
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
        Node<?> nodeThis = this.root;
        Node<?> nodeThat = that.root;
        Stack<Node<?>> stack = new Stack<>();
        stack.push(nodeThis);
        stack.push(nodeThat);
        while (stack.size() > 0) {
            Node<?> leafThat = stack.pop();
            Node<?> leafThis = stack.pop();
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
        Node<?> node = this.root;
        Stack<Node<?>> stack = new Stack<>();
        stack.push(node);
        while (stack.size() > 0) {
            Node<?> leaf = stack.pop();
            result = prime * result + leaf.hashCode();
            stack.push(leaf.getRight());
            stack.push(leaf.getLeft());
        }
        return result;
    }

    public void getWideBypass() {
        LinkedList<Node> linkedList = new LinkedList<>();
        linkedList.add(this.root);
        while (linkedList.size() != 0) {
            Node<?> leaf = linkedList.peek();
            linkedList.remove();
            System.out.print(leaf.getData() + ", ");
            if (leaf.getLeft() != null) {
                linkedList.add(leaf.getLeft());
            }
            if (leaf.getRight() != null) {
                linkedList.add(leaf.getRight());
            }
        }
        System.out.println();
    }

    public void getDepthCrawlByStack() {
        Stack<Node<T>> stack = new Stack<>();
        stack.push(this.root);
        while (stack.size() != 0) {
            Node<T> leaf = stack.pop();
            System.out.print(leaf.getData() + ", ");
            if (leaf.getRight() != null) {
                stack.push(leaf.getRight());
            }
            if (leaf.getLeft() != null) {
                stack.push(leaf.getLeft());
            }
        }
        System.out.println();
    }

    public void getDepthCrawlByRecursion() {
        getDepthCrawlByRecursion(this.root);
    }

    private void getDepthCrawlByRecursion(Node<T> node) {
        System.out.print(node.getData() + ", ");
        for (Node<T> child : getChild(node)) {
            if (child == null) {
                continue;
            }
            getDepthCrawlByRecursion(child);
        }
    }

    private Node<T>[] getChild(Node<T> node) {
        Node<T>[] children = new Node[2];
        if (node.getLeft() != null) {
            children[0] = node.getLeft();
        }
        if (node.getRight() != null) {
            children[1] = node.getRight();
        }
        return children;
    }
}
