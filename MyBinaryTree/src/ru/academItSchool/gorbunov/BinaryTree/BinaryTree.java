package ru.academItSchool.gorbunov.BinaryTree;

import java.util.Comparator;

public class BinaryTree<T> {
    private class MyTreeNode<T> {
        private MyTreeNode<T> left;
        private MyTreeNode<T> right;
        private T data;

        public MyTreeNode(T data) {
            this.data = data;
        }

        public MyTreeNode(T data, MyTreeNode<T> node) {
            this.data = data;
            if (new CompareForTreeNode().compare(this.data, node.data) < 0) {
                this.left = node;
                this.right = null;
            } else {
                this.left = null;
                this.right = node;
            }
        }

        public MyTreeNode(T data, MyTreeNode<T> leftNode, MyTreeNode<T> rightNode) {
            this.data = data;
            this.right = rightNode;
            this.left = leftNode;
        }

        public MyTreeNode<T> getLeft() {
            return left;
        }

        public void setLeft(MyTreeNode<T> left) {
            this.left = left;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public MyTreeNode<T> getRight() {
            return right;
        }

        public void setRight(MyTreeNode<T> right) {
            this.right = right;
        }
    }

    @SuppressWarnings("unchecked")
    public class CompareForTreeNode implements Comparator<T> {
        public int compare(T val1, T val2) {
            return ((Comparable<? super T>) val1).compareTo(val2);
        }
    }
}
