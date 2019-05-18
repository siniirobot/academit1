package ru.academItSchool.gorbunov.MyClass;

import java.io.Serializable;

public class SerializationWithoutOverriding implements Serializable {
    private int[][] matrix;
    static final long serialVersionUID = 1L;

    public SerializationWithoutOverriding(int[][] n) {
        this.matrix = n;
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
