package ru.academItSchool.gorbunov.MyClass;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SerializationWithOverriding implements Serializable {
    private int[][] matrix;
    static final long serialVersionUID = 2L;

    public SerializationWithOverriding(int[][] n) {
        this.matrix = n;
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        ArrayList<Integer> copy = new ArrayList<>();
        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j <= i; j++) {
                copy.add(this.matrix[i][j]);
            }
        }

        out.writeObject(copy.toArray());
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        Object[] copy = ((Object[]) in.readObject());

        int step = copy.length;
        int len = 0;
        while (step != 0) {
            len++;
            step -= len;
        }

        int i = 0;
        int pos = 0;
        this.matrix = new int[len][len];

        while (i < this.matrix.length) {
            for (int j = 0; j <= i; j++) {
                if (j != i) {
                    this.matrix[i][j] = (int) copy[j + pos];
                    this.matrix[j][i] = (int) copy[j + pos];
                } else {
                    this.matrix[i][j] = (int) copy[j + pos];
                }
            }

            i++;
            pos += i;
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
