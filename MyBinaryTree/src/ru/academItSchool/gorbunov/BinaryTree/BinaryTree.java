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

    public int compare(T o1, T o2) {
        if (this.comparator != null) {
            return this.comparator.compare(o1, o2);
        }
        if (Objects.equals(o1, o2)) {
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

    public boolean isSearch(T data) {
        if (this.root == null) {
            return false;
        }
        Node<T> node = this.root;
        while (node.getLeft() != null || node.getRight() != null) {
            int search = compare(data, node.getData());
            if (search == 0) {
                return true;
            }
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
        return compare(data, node.getData()) == 0;
    }

    public boolean isDelete(T data) {
        if (this.root == null) {
            return false;
        }
        Node<T> node = this.root;
        Node<T> parentNode = null;
        int requiredNode = compare(data, node.getData());
        while (requiredNode != 0) {
            if (requiredNode < 0) {
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
            requiredNode = compare(data, node.getData());
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
            if (leafParent == null) {
                this.root = node;
            } else {
                if (leafParent.getRight() != null && compare(data, leafParent.getRight().getData()) == 0) {
                    leafParent.setRight(node);
                } else {
                    leafParent.setLeft(node);
                }
            }
            node.setLeft(leaf.getLeft());
            if (compare(leaf.getData(), parentNode.getData()) != 0) {
                node.setRight(leaf.getRight());
            }
            this.size--;
            return true;
        } else {
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
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        if (this.root == null) {
            stringBuilder.append("Дерево пусто.");
            return stringBuilder.toString();
        }
        wideBypass(x -> stringBuilder.append(x).append(", "));
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
        Deque<Node<?>> stack = new LinkedList<>();
        stack.push(nodeThis);
        stack.push(nodeThat);
        while (stack.size() > 0) {
            Node<?> leafThat = stack.pop();
            Node<?> leafThis = stack.pop();
            if (!leafThis.equals(leafThat)) {
                return false;
            }
            if (leafThis.getRight() != null) {
                stack.push(leafThis.getRight());
            }
            if (leafThat.getRight() != null) {
                stack.push(leafThat.getRight());
            }
            if (leafThis.getLeft() != null) {
                stack.push(leafThis.getLeft());
            }
            if (leafThat.getLeft() != null) {
                stack.push(leafThat.getLeft());
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        Node<?> node = this.root;
        Deque<Node<?>> stack = new LinkedList<>();
        stack.push(node);
        while (stack.size() > 0) {
            Node<?> leaf = stack.pop();
            if (leaf == null) {
                continue;
            }
            result = prime * result + leaf.hashCode();
            if (leaf.getRight() != null) {
                stack.push(leaf.getRight());
            }
            if (leaf.getLeft() != null) {
                stack.push(leaf.getLeft());
            }
        }
        return result;
    }

    public void wideBypass(Consumer<T> consumer) {
        Queue<Node<T>> linkedList = new LinkedList<>();
        linkedList.add(this.root);
        while (linkedList.size() != 0) {
            Node<T> leaf = linkedList.remove();
            if (leaf == null) {
                return;
            }
            consumer.accept(leaf.getData());
            if (leaf.getLeft() != null) {
                linkedList.add(leaf.getLeft());
            }
            if (leaf.getRight() != null) {
                linkedList.add(leaf.getRight());
            }
        }
    }

    public void depthCrawlByStack(Consumer<T> consumer) {
        Deque<Node<T>> stack = new LinkedList<>();
        stack.push(this.root);
        while (stack.size() != 0) {
            Node<T> leaf = stack.pop();
            if (leaf == null) {
                return;
            }
            consumer.accept(leaf.getData());
            if (leaf.getRight() != null) {
                stack.push(leaf.getRight());
            }
            if (leaf.getLeft() != null) {
                stack.push(leaf.getLeft());
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
