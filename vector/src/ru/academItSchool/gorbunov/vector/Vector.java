package ru.academItSchool.gorbunov.vector;

import java.util.Arrays;

public class Vector {
    private int n;
    private double[] content;

    public Vector(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Меньше нуля вектор быть не может");
        }
        this.n = n;
        this.content = new double[n];
    }

    public Vector(Vector vector) {
        this.n = vector.n;
        double[] copy = new double[vector.content.length];
        System.arraycopy(vector.content,0,copy,0,vector.content.length);
        this.content = copy;
    }

    public Vector(double[] content) {
        this.content = content;
    }

    public Vector(int n, double[] content) {
        if (n <= 0) {
            throw new IllegalArgumentException("Меньше нуля вектор быть не может");
        }
        this.n = n;
        this.content = new double[this.n];
        for (int i = 0; i < this.n; ++i) {
            if (i < content.length) {
                this.content[i] = content[i];
            } else {
                this.content[i] = 0;
            }
        }
    }

    private int getN() {
        return n;
    }

    public double getSize() {
        return this.n;
    }

    public void getVectorSum(Vector vector) {
        for (int i = 0; i < Math.max(this.content.length, vector.content.length); ++i) {
            if (Math.min(this.content.length, vector.content.length) > i) {
                this.content[i] += vector.content[i];
            } else {
                break;
            }
        }
        this.n += vector.n;
    }

    public void getVectorSubtraction(Vector vector) {
        for (int i = 0; i < Math.max(this.content.length, vector.content.length); ++i) {
            if (Math.min(this.content.length, vector.content.length) > i) {
                this.content[i] -= vector.content[i];
            } else {
                break;
            }
        }
        this.n = Math.max(this.n,vector.n) - Math.min(this.n, vector.n);
    }

    public void getVectorScalar(int scalar) {
        for (int i = 0; i < this.content.length; ++i) {
            this.content[i] *= scalar;
        }
        this.n *= scalar;
    }

    public void getVectorTurn() {
        for (int i = 0; i < this.content.length; ++i) {
            this.content[i] *= -1;
        }
    }

    public int getVectorLength() {
        return this.content.length;
    }

    public double getVectorElementByIndex(int index) {
        return this.content[index];
    }

    public void setVectorElementByIndex(double element, int index) {
        this.content[index] = element;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.n < 0) {
            this.n = Math.abs(this.n);
        }
        for (int i = 0; i < this.n; ++i) {
            if (i < this.content.length) {
                stringBuilder.append(this.content[i]).append(",");
            } else {
                stringBuilder.append(0).append(",");
            }
        }
        stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length());
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
        int maxLength = Math.max(vector1.n,vector2.n);
        double[] newContent = new double[maxLength];
        for (int i = 0; i < Math.max(vector1.content.length,  vector2.content.length); ++i) {
            if (Math.min(vector1.content.length,  vector2.content.length) > i) {
                newContent[i] = vector1.content[i] + vector2.content[i];
            } else {
                break;
            }
        }
        maxLength = vector1.n + vector2.n;
        return new Vector(maxLength,newContent);
    }

    public static Vector getStaticVectorSubtraction(Vector vector1, Vector vector2) {
        int maxLength = Math.max(vector1.n,vector2.n);
        double[] newContent = new double[maxLength];
        for (int i = 0; i < Math.max(vector1.content.length,  vector2.content.length); ++i) {
            if (Math.min(vector1.content.length,  vector2.content.length) > i) {
                newContent[i] = vector1.content[i] - vector2.content[i];
            } else {
                break;
            }
        }
        maxLength = Math.max(vector1.n,vector2.n) - Math.min(vector1.n, vector2.n);
        return new Vector(maxLength,newContent);
    }

    public static Vector getStaticVectorScalar(Vector vector1, Vector vector2) {
        int maxLength = Math.max(vector1.n,vector2.n);
        double[] newContent = new double[maxLength];
        for (int i = 0; i < Math.max(vector1.content.length,  vector2.content.length); ++i) {
            if (Math.min(vector1.content.length,  vector2.content.length) > i) {
                newContent[i] = vector1.content[i] * vector2.content[i];
            } else {
                break;
            }
        }
        maxLength = vector1.n * vector2.n;
        return new Vector(maxLength,newContent);
    }
}
