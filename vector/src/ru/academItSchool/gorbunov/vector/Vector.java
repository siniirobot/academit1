package ru.academItSchool.gorbunov.vector;

import java.util.Arrays;
import java.util.Objects;

public class Vector {
    private int n;
    private double[] content;

    public Vector(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        }
        this.n = n;
    }

    public Vector(Vector aVector) {
        this(aVector.getN(), aVector.getContent());
    }

    public Vector(double[] content) {
        this.content = content;
    }

    public Vector(int n, double[] content) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        }
        this.n = n;
        this.content = content;
    }

    private int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    private double[] getContent() {
        return content;
    }

    private void setContent(double[] content) {
        this.content = content;
    }

    public double getSize() {
        return this.n;
    }

    public int getVectorSum(Vector vector) {
        return this.n + vector.n;
    }

    public int getVectorSubtraction(Vector vector) {
        return this.n - vector.n;
    }

    public double getVectorScalar(double scalar) {
        return this.n * scalar;
    }

    public double[] getVectorTurn() {
        double[] turnContent = new double[this.content.length];
        for (int i = 0; i < this.content.length; ++i) {
            turnContent[i] = this.content.length * -1;
        }
        return turnContent;
    }

    public int getVectorLength() {
        return this.n;
    }

    public double getInsert(double insert, int index) {
        double returnContent = 0;

        if (index > this.content.length) {
            double[] newContent = new double[index + 1];
            System.arraycopy(this.content, 0, newContent, 0, this.content.length - 1);
            newContent[index] = insert;
            setContent(newContent);
            return returnContent;
        }
        returnContent = this.content[index];
        this.content[index] = insert;
        setContent(this.content);

        return returnContent;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        for (int i = 0; i <= this.n; ++i) {
            if (i < this.content.length) {
                stringBuilder.append(this.content[i]).append(",");
            } else {
                stringBuilder.append(0).append(",");
            }
        }
        stringBuilder.delete(this.content.length, this.content.length);
        return stringBuilder.append("}").toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Vector vector = (Vector) obj;
        return this.n == vector.n && Arrays.equals(this.content, vector.content);
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;
        result = prime * result + n;
        result = prime * result + Arrays.hashCode(content);
        return result;
    }

    public static Vector getStaticVectorSum(Vector vector1, Vector vector2) {
        if (vector1.content.length > vector2.content.length) {
            return new Vector(vector1.n + vector2.n,vector1.content);
        }
        return new Vector(vector1.n + vector2.n, vector2.content);
    }
}
