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

    private boolean visited(int[] top, boolean[] visited) {
        for (int i = 0; i < this.matrix.length; i++) {
            if (Arrays.equals(this.matrix[i], top)) {
                if (visited[i]) {
                    return true;
                }
                visited[i] = true;
                return false;
            }
        }
        throw new NullPointerException("Такой вершины нет в массиве.");
    }

    public void getWideBypass(Consumer consumer) {
        boolean[] visited = filling(this.matrix.length);
        Queue queue = new LinkedList();
        for (int i = 0; i < this.matrix.length; i++) {
            queue.add(this.matrix[i]);
            ArrayList<Integer> chain = new ArrayList<>();

            while (queue.size() > 0) {
                int[] top = (int[]) queue.remove();
                if (visited(top, visited)) {
                    continue;
                }
                for (int k = 0; k < this.matrix.length; k++) {
                    if (Arrays.equals(this.matrix[k], top)) {
                        chain.add(k);
                        break;
                    }
                }
                for (int j = 0; j < top.length; j++) {
                    if (top[j] == 0) {
                        continue;
                    }
                    queue.add(this.matrix[j]);
                }
            }
            if (!chain.isEmpty()) {
                consumer.accept(chain.toArray());
                chain.clear();
            }
        }
    }
}
