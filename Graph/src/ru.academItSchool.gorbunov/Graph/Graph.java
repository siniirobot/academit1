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

    public void wideBypass(IntConsumer consumer) {
        if (this.matrix.length == 0) {
            return;
        }
        boolean[] visited = new boolean[this.matrix.length];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < this.matrix.length; i++) {
            if (visited[i]) {
                continue;
            }
            queue.add(i);
            while (!queue.isEmpty()) {
                int vertexIndex = queue.remove();
                visited[vertexIndex] = true;
                consumer.accept(vertexIndex);
                for (int j = 0; j < this.matrix[vertexIndex].length; j++) {
                    if (this.matrix[vertexIndex][j] == 0 || visited[j] || queue.contains(j)) {
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
            if (visited[i]) {
                continue;
            }
            stack.push(i);
            while (!stack.isEmpty()) {
                int vertexIndex = stack.pop();
                visited[vertexIndex] = true;
                consumer.accept(vertexIndex);
                for (int j = this.matrix.length - 1; j >= 0; j--) {
                    if (this.matrix[j][vertexIndex] == 0 || visited[j] || stack.contains(j)) {
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
            if (visited[i]) {
                continue;
            }
            depthCrawlByRecursion(i, consumer, visited);
        }
    }

    private void depthCrawlByRecursion(int vertexIndex, IntConsumer consumer, boolean[] visited) {
        if (visited[vertexIndex]) {
            return;
        }
        visited[vertexIndex] = true;
        consumer.accept(vertexIndex);
        for (int i = 0; i < this.matrix[vertexIndex].length; i++) {
            if (this.matrix[i][vertexIndex] == 0 || visited[i]) {
                continue;
            }
            depthCrawlByRecursion(i, consumer, visited);
        }
    }
}
