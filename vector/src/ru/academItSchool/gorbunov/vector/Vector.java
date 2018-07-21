package ru.academItSchool.gorbunov.vector;

import java.util.Arrays;

public class Vector {
    private int length;
    private double[] content;

    public Vector(int length) {
        if (length <= 0) {
            throw new IllegalArgumentException();
        }
        this.length = length;
    }

    public Vector(Vector aVector) {
        this(aVector.getLength(), aVector.getContent());
    }

    public Vector(double[] content) {
        this.content = content;
    }

    public Vector(int length, double[] content) {
        if (length <= 0) {
            throw new IllegalArgumentException();
        }
        this.length = length;
        this.content = new double[this.length];
        System.arraycopy(content, 0, this.content, 0, content.length);
    }

    private int getLength() {
        return length;
    }

/*    public void setLength(int length) {
        this.length = length;
    }

    private double[] getContent() {
        return content;
    }

    private void setContent(double[] content) {
        this.content = content;
    }*/

    public double getSize() {
        return this.length;
    }

    public int getVectorSum(Vector vector) {
        return this.length + vector.length;
    }

    public int getVectorSubtraction(Vector vector) {
        return this.length - vector.length;
    }

    public int getVectorScalar(int scalar) {
        return this.length * scalar;
    }

    /*public Vector getVectorTurn() {
        double[] turnContent = new double[this.content.length];
        for (int i = 0; i < this.content.length; ++i) {
            turnContent[i] = this.content[i] * -1;
        }
        setContent(turnContent);
        return new Vector(this.length, this.content);
    }*/

    public int getVectorLength() {
        return this.content.length;
    }

   /* public double getInsert(double insert, int index) {
        double returnContent = 0;

        if (index > this.content.length) {
            double[] newContent = new double[index + 1];
            System.arraycopy(this.content, 0, newContent, 0, this.content.length - 1);
            newContent[index] = insert;
            setContent(newContent);
            setLength(index);
            return returnContent;
        }
        returnContent = this.content[index];
        this.content[index] = insert;
        setContent(this.content);

        return returnContent;
    }*/

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.length < 0) {
            this.length = Math.abs(this.length);
        }
        for (int i = 0; i <= this.length; ++i) {
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
        return this.length == vector.length && Arrays.equals(this.content, vector.content);
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;
        result = prime * result + length;
        result = prime * result + Arrays.hashCode(content);
        return result;
    }

    public static Vector getStaticVectorSum(Vector vector1, Vector vector2) {
        if (vector1.content.length > vector2.content.length) {
            return new Vector(vector1.length + vector2.length, vector1.content);
        }
        return new Vector(vector1.length + vector2.length, vector2.content);
    }

    public static Vector getStaticVectorSubtraction(Vector vector1, Vector vector2) {
        int newLength = vector1.length - vector2.length;

        if (newLength < 0) {

            if (vector1.content.length > vector2.content.length) {
                for (int i = 0; i < vector1.content.length; ++i) {
                    vector1.content[i] *= -1;
                }
                return new Vector(newLength, vector1.content);
            } else {
                for (int i = 0; i < vector2.content.length; ++i) {
                    vector2.content[i] *= -1;
                }
                return new Vector(newLength, vector2.content);
            }
        }
        if (vector1.content.length > vector2.content.length) {
            return new Vector(newLength, vector1.content);
        }
        return new Vector(newLength, vector2.content);

    }

    public static Vector getStaticVectorScalar(Vector vector1, Vector vector2) {
        if (vector1.content.length > vector2.content.length) {
            return new Vector(vector1.length * vector2.length, vector1.content);
        }
        return new Vector(vector1.length * vector2.length, vector2.content);
    }
}
