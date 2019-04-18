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
        int i = 0;
        queue.add(this.matrix[i]);
        for (; i < this.matrix.length; i++) {
            int[] top = (int[]) queue.remove();
            if (visited[i]) {
                continue;
            }

        }
    }
}
