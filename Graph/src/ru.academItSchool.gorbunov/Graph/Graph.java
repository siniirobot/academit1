package ru.academItSchool.gorbunov.Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.function.Consumer;

public class Graph {
    private int[][] matrix;

    public Graph(int[][] matrix) {
        this.matrix = matrix;
    }

    private boolean[] visited(int length) {
        boolean[] visited = new boolean[length];
        for (boolean top : visited) {
            top = false;
        }
        return visited;
    }

    public void getWideBypass(Consumer consumer) {
        boolean[] visited = visited(this.matrix.length);
        Queue queue = new LinkedList();
        for (int i = 0; i < this.matrix.length; i++) {
            queue.add(this.matrix[i]);
            while (queue.size() > 0) {
                if (visited[i]) {
                    continue;
                }
                visited[i] = true;
                int[] top = (int[]) queue.remove();
                consumer.accept(top);
                for(int j = 0; j < top.length;j++) {
                    if (top[j] == 0) {
                        continue;
                    }
                    queue.add(this.matrix[j]);
                }
            }
        }
    }
}
