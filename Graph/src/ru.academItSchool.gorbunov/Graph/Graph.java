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

    private boolean[] getFilling(int length) {
        boolean[] visited = new boolean[length];
        for (boolean top : visited) {
            top = false;
        }
        return visited;
    }

    private boolean isVisited(int topIndex, boolean[] visited) {
        if (visited[topIndex]) {
            return true;
        }
        visited[topIndex] = true;
        return false;
    }

    public void wideBypass(IntConsumer consumer) {
        boolean[] visited = getFilling(this.matrix.length);
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < this.matrix.length; i++) {
            queue.add(i);
            while (queue.size() > 0) {
                int topIndex = queue.remove();
                if (isVisited(topIndex, visited)) {
                    continue;
                }
                consumer.accept(topIndex);
                for (int j = 0; j < this.matrix[topIndex].length; j++) {
                    if (this.matrix[topIndex][j] == 0 || queue.contains(j)) {
                        continue;
                    }
                    queue.add(j);
                }
            }
        }
    }

    public void depthCrawlByStack(IntConsumer consumer) {
        boolean[] visited = getFilling(this.matrix.length);
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < this.matrix.length; i++) {
            queue.add(i);
            while (!queue.isEmpty()) {
                int topIndex = queue.remove();
                if (isVisited(topIndex, visited)) {
                    continue;
                }
                consumer.accept(topIndex);
                for (int j = 0; j < this.matrix.length; j++) {
                    if (this.matrix[j][topIndex] == 0 || queue.contains(j)) {
                        continue;
                    }
                    queue.add(j);
                }
            }
        }
    }
}
