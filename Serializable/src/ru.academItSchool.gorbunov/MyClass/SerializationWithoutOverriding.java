package ru.academItSchool.gorbunov.MyClass;

import java.io.Serializable;

public class SerializationWithoutOverriding implements Serializable {
    private int[][] matrix;
    static final long serialVersionUID = 1L;

    public SerializationWithoutOverriding(int n) {
        if (n % 2 != 0) {
            throw new IllegalArgumentException("Матрица должна быть симметрична то есть делимо на 2");
        }

        this.matrix = new int[n][n];

        for (int i = 0, m = n - 1; i < (n / 2); i++, m--) {
            for (int j = 0, k = n - 1; j < (n / 2); j++, k--) {
                this.matrix[i][j] = j + i;
                this.matrix[i][k] = this.matrix[i][j];
            }

            this.matrix[m] = this.matrix[i];
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        boolean firstTime = true;
        stringBuilder.append("{");
        for (int[] arr : this.matrix) {
            if (firstTime) {
                stringBuilder.append("{");
                firstTime = false;
            } else {
                stringBuilder.append(" {");
            }
            for (int el : arr) {
                stringBuilder.append(el).append(", ");
            }
            stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
            stringBuilder.append("},").append(System.lineSeparator());
        }
        stringBuilder.delete(stringBuilder.length() - 3, stringBuilder.length());
        return stringBuilder.append("}").toString();
    }
}
