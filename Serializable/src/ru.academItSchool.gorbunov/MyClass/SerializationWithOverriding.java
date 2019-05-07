package ru.academItSchool.gorbunov.MyClass;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;

public class SerializationWithOverriding implements Serializable {
    private int[][] matrix;

    public SerializationWithOverriding(int n) {
        if (n % 2 != 0) {
            throw new IllegalArgumentException("Матрица должна быть симметрична то есть делимо на 2");
        }

        this.matrix = new int[n][n];

        for (int i = 0, m = n - 1; i < (n / 2); i++, m--) {
            for (int j = 0, k = n - 1; j < (n / 2); j++, k--) {
                this.matrix[i][j] = (int) (Math.random() * 100);
                this.matrix[i][k] = this.matrix[i][j];
            }

            this.matrix[m] = this.matrix[i];
        }
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        int[][] copy = new int[this.matrix.length / 2][this.matrix.length / 2];

        for (int i = 0; i < copy.length; i++) {
            copy[i] = Arrays.copyOf(this.matrix[i], copy.length);
        }

        out.writeObject(copy);
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        this.matrix = (int[][]) in.readObject();
        int[][] copy = new int[this.matrix.length * 2][this.matrix.length * 2];

        for (int i = 0, k = copy.length - 1; i < this.matrix.length; i++, k--) {
            for (int j = 0, m = copy[i].length - 1; j < this.matrix[i].length; j++, m--) {
                copy[i][j] = this.matrix[i][j];
                copy[i][m] = this.matrix[i][j];
            }

            copy[k] = copy[i];
        }

        this.matrix = copy;
    }
}
