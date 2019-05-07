package ru.academItSchool.gorbunov.MyClass;

import java.io.Serializable;

public class SerializationWithoutOverriding implements Serializable {
    private int[][] matrix;
    static final long serialVersionUID = 1L;

    public SerializationWithoutOverriding(int n) {
        this.matrix = new int[n][n];

        for (int i = 0, m = n - 1; i < (n / 2); i++, m--) {
            for (int j = 0, k = n - 1; j < (n / 2); j++, k--) {
                this.matrix[i][j] = (int) (Math.random() * 100);
                this.matrix[i][k] = this.matrix[i][j];
            }

            this.matrix[m] = this.matrix[i];
        }
    }
}
