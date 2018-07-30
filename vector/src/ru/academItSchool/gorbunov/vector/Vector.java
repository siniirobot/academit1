package ru.academItSchool.gorbunov.vector;

import java.util.Arrays;

public class Vector {
    private double[] content;

    public Vector(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Меньше нуля вектор быть не может");
        }
        this.content = new double[n];
    }

    public Vector(Vector vector) {
        this.content = Arrays.copyOf(vector.content, vector.content.length);
    }

    public Vector(double[] content) {
        if (content.length <= 0) {
            throw new IllegalArgumentException("Меньше нуля вектор быть не может");
        }
        this.content = content;
    }

    public Vector(int n, double[] content) {
        if (n <= 0) {
            throw new IllegalArgumentException("Меньше нуля вектор быть не может");
        }
        this.content = new double[n];
        if (n > content.length) {
            System.arraycopy(content, 0, this.content, 0, content.length);
        } else {
            System.arraycopy(content, 0, this.content, 0, n);
        }

    }

    public double getSize() {
        return this.content.length;
    }

    public void getVectorSum(Vector vector) {
        if (this.content.length > vector.content.length) {
            for (int i = 0; i < this.content.length; ++i) {
                if (i < vector.content.length) {
                    this.content[i] += vector.content[i];
                } else {
                    break;
                }
            }
        } else {
            double[] copy = new double[vector.content.length];
            for (int i = 0; i < vector.content.length; ++i) {
                if (i < this.content.length) {
                    copy[i] = this.content[i] + vector.content[i];
                } else {
                    copy[i] = vector.content[i];
                }
                this.content = Arrays.copyOf(copy, copy.length);
            }
        }
    }

    public void getVectorSubtraction(Vector vector) {
        if (this.content.length > vector.content.length) {
            for (int i = 0; i < this.content.length; ++i) {
                if (i < vector.content.length) {
                    this.content[i] -= vector.content[i];
                } else {
                    break;
                }
            }
        } else {
            double[] copy = new double[vector.content.length];
            for (int i = 0; i < vector.content.length; ++i) {
                if (i < this.content.length) {
                    copy[i] = this.content[i] - vector.content[i];
                } else {
                    copy[i] = vector.content[i];
                }
                this.content = Arrays.copyOf(copy, copy.length);
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

    public double getVectorLength() {
        return Math.sqrt(this.content.length * this.content.length);
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
        for (double e : content) {
            stringBuilder.append(e).append(",");
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
        return Arrays.equals(this.content, vector.content);
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;
        result = prime * result + Arrays.hashCode(content);
        return result;
    }

    public static Vector getStaticVectorSum(Vector vector1, Vector vector2) {
        double[] newContent = new double[Math.max(vector1.content.length, vector2.content.length)];
        for (int i = 0; i < newContent.length; ++i) {
            if (i < vector1.content.length && i < vector2.content.length) {
                newContent[i] = vector1.content[i] + vector2.content[i];
            } else if (i < vector1.content.length) {
                newContent[i] = vector1.content[i];

            } else {
                newContent[i] = vector2.content[i];
            }
        }
        return new Vector(newContent.length, newContent);
    }

    public static Vector getStaticVectorSubtraction(Vector vector1, Vector vector2) {
        double[] newContent = new double[Math.max(vector1.content.length, vector2.content.length)];
        for (int i = 0; i < newContent.length; ++i) {
            if (i < vector1.content.length && i < vector2.content.length) {
                newContent[i] = vector1.content[i] - vector2.content[i];
            } else if (i < vector1.content.length) {
                newContent[i] = vector1.content[i];

            } else {
                newContent[i] = vector2.content[i];
            }
        }
        return new Vector(newContent.length, newContent);
    }

    public static double getStaticVectorScalar(Vector vector1, Vector vector2) {
        int result = 0;
        int minLength = Math.min(vector1.content.length, vector2.content.length);
        for (int i = 0; i < minLength; ++i) {
            result += vector1.content[i] * vector2.content[i];
        }
        return result;
    }
}
