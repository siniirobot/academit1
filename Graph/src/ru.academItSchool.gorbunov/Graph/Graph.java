package ru.academItSchool.gorbunov.Graph;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.function.Consumer;

public class Graph {
    private int[][] matrix;

    public Graph(int[][] matrix) {
        this.matrix = matrix;
    }

    private boolean[] filling(int length) {
        boolean[] visited = new boolean[length];
        for (boolean top : visited) {
            top = false;
        }
        return visited;
    }

    private boolean visited(int topIndex, boolean[] visited) {
        if (visited[topIndex]) {
            return true;
        }
        visited[topIndex] = true;
        return false;
    }

    public void getWideBypass(Consumer consumer) {
        boolean[] visited = filling(this.matrix.length);
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < this.matrix.length; i++) {
            queue.add(i);
            ArrayList<Integer> chain = new ArrayList<>();
            while (queue.size() > 0) {
                int topIndex = queue.remove();
                if (visited(topIndex, visited)) {
                    continue;
                }
                chain.add(topIndex);
                for (int j = 0; j < this.matrix[topIndex].length; j++) {
                    if (this.matrix[topIndex][j] == 0 || queue.contains(j)) {
                        continue;
                    }
                    queue.add(j);
                }
            }
            if (!chain.isEmpty()) {
                consumer.accept(chain.toArray());
                chain.clear();
            }
        }
    }

    public void getDepthCrawl(Consumer consumer) {
        boolean[] visited = filling(this.matrix.length);
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < this.matrix.length; i++) {
            queue.add(i);
            ArrayList<Integer> chain = new ArrayList<>();
            while (!queue.isEmpty()) {
                int topIndex = queue.remove();
                if (visited(topIndex, visited)) {
                    continue;
                }
                chain.add(topIndex);
                for (int j = 0; j < this.matrix.length; j++) {
                    if (this.matrix[j][topIndex] == 0 || queue.contains(j)) {
                        continue;
                    }
                    queue.add(j);
                }
            }
            if (!chain.isEmpty()) {
                consumer.accept(chain.toArray());
                chain.clear();
            }
        }
    }
}
