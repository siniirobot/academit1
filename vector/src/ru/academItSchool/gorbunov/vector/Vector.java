package ru.academItSchool.gorbunov.vector;

public class Vector {
    private double n;
    private double[] content;

    public Vector(double n) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        }
        this.n = n;
    }

    public Vector(double[] content) {
        this.content = content;
    }

    public Vector(double n, double[] content) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        }
        this.n = n;
        this.content = content;
    }

    public Vector(Vector aVector) {
        this(aVector.getN(), aVector.getContent());
    }

    public double getN() {
        return n;
    }

    public void setN(double n) {
        this.n = n;
    }

    public double[] getContent() {
        return content;
    }

    public void setContent(double[] content) {
        this.content = content;
    }

    public double getSize() {
        return this.n;
    }

    public double get
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

}
