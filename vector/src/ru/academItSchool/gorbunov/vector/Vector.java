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
        this.content = new double[n + 1];
    }

    public Vector(Vector vector) {
        this.n = vector.n;
        this.content = Arrays.copyOf(vector.content, vector.content.length);
    }

    public Vector(double[] content) {
        if (n <= 0) {
            throw new IllegalArgumentException("Меньше нуля вектор быть не может");
        }
        this.content = content;
        this.n = this.content.length - 1;
    }

    public Vector(int n, double[] content) {
        if (n <= 0) {
            throw new IllegalArgumentException("Меньше нуля вектор быть не может");
        }
        this.n = n;
        if (this.n + 1 < content.length) {
            this.content = Arrays.copyOf(content, this.n + 1);
        } else {
            this.content = Arrays.copyOf(content, content.length);
        }

    }

    private int getN() {
        return n;
    }

    public double getSize() {
        return this.n;
    }

    public void getVectorSum(Vector vector) {
        if (Arrays.equals(this.content, vector.content)) {
            for (int i = 0; i < this.content.length; ++i) {
                this.content[i] *= 2;
            }
        } else {
            this.n = Math.max(this.n, vector.n);
            for (int i = 0; i < this.n; ++i) {
                if (this.content.length > i && vector.content.length > i) {
                    this.content[i] += vector.content[i];
                } else {
                    break;
                }
            }
        }
    }

    public void getVectorSubtraction(Vector vector) {
        if (Arrays.equals(this.content, vector.content)) {
            for (int i = 0; i < this.content.length; ++i) {
                this.content[i] /= 2;
            }
        } else {
            this.n = Math.max(this.n, vector.n);
            for (int i = 0; i < this.n; ++i) {
                if (this.content.length > i && vector.content.length > i) {
                    this.content[i] -= vector.content[i];
                } else {
                    break;
                }
            }
        }
    }

    public void getVectorScalar(int scalar) {
        for (int i = 0; i < this.content.length; ++i) {
            this.content[i] *= scalar;
        }
    }

    public void getVectorTurn() {
        for (int i = 0; i < this.content.length; ++i) {
            this.content[i] *= -1;
        }
    }

    public int getVectorLength() {
        return this.n + 1;
    }

    public double getVectorElementByIndex(int index) {
        return this.content[index];
    }

    public void setVectorElementByIndex(int index, double element) {
        this.content[index] = element;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.n < 0) {
            this.n = Math.abs(this.n);
        }
        for (int i = 0; i < this.n + 1; ++i) {
            if (i < this.content.length) {
                stringBuilder.append(this.content[i]).append(",");
            } else {
                stringBuilder.append(0.0).append(",");
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
        double[] newContent = new double[vector1.n + vector2.n];
        for (int i = 0; i < newContent.length; ++i) {
            if (vector1.content.length > i && vector2.content.length > i) {
                newContent[i] = vector1.content[i] + vector2.content[i];
            } else {
                break;
            }
        }
        return new Vector(newContent.length, newContent);
    }

    public static Vector getStaticVectorSubtraction(Vector vector1, Vector vector2) {
        double[] newContent = new double[Math.max(vector1.n, vector2.n) - Math.min(vector1.n, vector2.n)];
        for (int i = 0; i < newContent.length; ++i) {
            if (vector1.content.length > i && vector2.content.length > i) {
                newContent[i] = vector1.content[i] - vector2.content[i];
            } else {
                break;
            }
        }
        return new Vector(newContent.length, newContent);
    }

    public static double getStaticVectorScalar(Vector vector1, Vector vector2) {
        int result = 0;
        for (int i = 0; i < Math.min(vector1.content.length,vector2.content.length); ++i) {
            result += vector1.content[i] * vector2.content[i];
        }
        return result;
    }
}
