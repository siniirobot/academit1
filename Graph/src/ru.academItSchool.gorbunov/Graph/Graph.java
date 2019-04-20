package ru.academItSchool.gorbunov.Graph;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.function.IntConsumer;

public class Graph {
    private int[][] matrix;

    public Graph(int[][] matrix) {
        this.matrix = matrix;
    }

    private boolean isVisited(int topIndex, boolean[] visited) {
        if (visited[topIndex]) {
            return true;
        }
        visited[topIndex] = true;
        return false;
    }

    public void wideBypass(IntConsumer consumer) {
        if (this.matrix.length == 0) {
            return;
        }
        boolean[] visited = new boolean[this.matrix.length];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < this.matrix.length; i++) {
            queue.add(i);
            while (!queue.isEmpty()) {
                int topIndex = queue.remove();
                if (isVisited(topIndex, visited)) {
                    continue;
                }
                consumer.accept(topIndex);
                for (int j = 0; j < this.matrix[topIndex].length; j++) {
                    if (this.matrix[topIndex][j] == 0) {
                        continue;
                    }
                    queue.add(j);
                }
            }
        }
    }

    public void depthCrawlByStack(IntConsumer consumer) {
        if (this.matrix.length == 0) {
            return;
        }
        boolean[] visited = new boolean[this.matrix.length];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < this.matrix.length; i++) {
            stack.push(i);
            while (!stack.isEmpty()) {
                int topIndex = stack.pop();
                if (isVisited(topIndex, visited)) {
                    continue;
                }
                consumer.accept(topIndex);
                for (int j = this.matrix.length - 1; j >= 0; j--) {
                    if (this.matrix[j][topIndex] == 0) {
                        continue;
                    }
                    stack.push(j);
                }
            }
        }
    }

    public void depthCrawlByRecursion(IntConsumer consumer) {
        if (this.matrix.length == 0) {
            return;
        }
        boolean[] visited = new boolean[this.matrix.length];
        for (int i = 0; i < this.matrix.length; i++) {
            depthCrawlByRecursion(i, consumer, visited);
        }
    }

    private void depthCrawlByRecursion(int topIndex, IntConsumer consumer, boolean[] visited) {
        if (isVisited(topIndex, visited)) {
            return;
        }
        consumer.accept(topIndex);
        for (int i = 0; i < this.matrix[topIndex].length; i++) {
            if (this.matrix[i][topIndex] == 0) {
                continue;
            }
            depthCrawlByRecursion(i, consumer, visited);
        }
    }
}
