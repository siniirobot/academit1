package ru.academItScholl.gorbunov.matrix;

import java.util.Arrays;


import ru.academItSchool.gorbunov.vector.Vector;

public class Matrix {

    private Vector[] fields;

    public Matrix(int linesNumber, int columnNumber) {
        if (columnNumber <= 0 || linesNumber <= 0) {
            throw new IllegalArgumentException("Высота и ширина матрицы не может быть меньше или равен нулю.");
        }
        this.fields = new Vector[linesNumber];
        for (int i = 0; i < fields.length; i++) {
            this.fields[i] = new Vector(columnNumber);
        }
    }

    public Matrix(double[][] components) {
        if (components.length == 0 && getColumnNumber(components) > 0) {
            throw new IllegalArgumentException("Высота и ширина матрицы не может быть меньше или равен нулю.");
        }

        this.fields = new Vector[components.length];
        for (int i = 0; i < fields.length; i++) {
            this.fields[i] = new Vector(components[i]);
        }
    }

    public Matrix(Vector[] fields) {
        if (fields.length == 0) {
            throw new IllegalArgumentException("Высота и ширина матрицы не может быть меньше или равен нулю.");
        }
        int columnNumber = getColumnNumber(fields);
        this.fields = new Vector[fields.length];
        for (int i = 0; i < this.fields.length; i++) {
            this.fields[i] = new Vector(columnNumber);
            for (int j = 0; j < fields[i].getSize(); j++) {
                this.fields[i].setElementByIndex(j, fields[i].getElementByIndex(j));
            }
        }
    }

    public Matrix(Matrix matrix) {
        this.fields = new Vector[matrix.getLineNumber()];
        for (int i = 0; i < matrix.getLineNumber(); i++) {
            this.fields[i] = new Vector(matrix.getLineVector(i));
        }

    }

    /**
     * Возвращает значение ширины массива.
     *
     * @return int
     */
    private int getColumnNumber(double[][] array) {
        int columnNumber = 0;
        for (double[] arr : array) {
            if (arr != null) {
                if (columnNumber < arr.length) {
                    columnNumber = arr.length;
                }
            } else {
                throw new IllegalArgumentException("Вы не указали ширину массива.");
            }
        }
        return columnNumber;
    }

    /**
     * Возвращает значение ширины векторного массива.
     *
     * @return int
     */
    private int getColumnNumber(Vector[] vector) {
        int columnNumber = 0;
        for (Vector vec : vector) {
            if (vec != null) {
                if (columnNumber < vec.getSize()) {
                    columnNumber = vec.getSize();
                }
            } else {
                throw new IllegalArgumentException("Вы не указали ширину массива.");
            }
        }
        return columnNumber;
    }

    /**
     * Возвращает значение ширины матрицы.
     *
     * @return int
     */
    public int getColumnNumber() {
        return getColumnNumber(this.fields);
    }

    /**
     * Возвращает значение длины матрицы.
     *
     * @return int
     */
    public int getLineNumber() {
        return fields.length;
    }

    /**
     * Возвращает вектор из матрицы по индексу
     *
     * @param index int
     * @return Vector
     */
    public Vector getLineVector(int index) {
        if (index >= this.fields.length || index < 0) {
            throw new IllegalArgumentException("Индекс не может быть меньше нуля и больше высоты матрицы");
        }
        return this.fields[index];
    }

    /**
     * Заменяет существующий вектор по индексу, на новый.
     *
     * @param index  int
     * @param vector Vector
     */
    public void setLineVector(int index, Vector vector) {
        if (index >= this.fields.length || index < 0) {
            throw new IllegalArgumentException("Индекс не может быть меньше нуля и больше высоты матрицы");
        }
        int oldWidth = getColumnNumber();
        this.fields[index] = vector;
        if (oldWidth < getColumnNumber()) {
            for (int i = 0; i < this.fields.length; i++) {
                Vector copyVector = this.fields[i];
                this.fields[i] = new Vector(vector.getSize());
                for (int j = 0; j < copyVector.getSize(); j++) {
                    this.fields[i].setElementByIndex(j, copyVector.getElementByIndex(j));
                }
            }
        }
    }

    /**
     * Возвращает вектор состоящий из значений выбранного столбца матрицы
     *
     * @param index int
     * @return Vector
     */
    public Vector getColumnVector(int index) {
        if (index < 0 || index > getColumnNumber()) {
            throw new IllegalArgumentException("Значение индекса не может быть меньше нуля или больше ширины матрицы.");
        }
        Vector columnVector = new Vector(this.fields.length);
        for (int i = 0; i < this.fields.length; i++) {
            columnVector.setElementByIndex(i, this.fields[i].getElementByIndex(index));
        }
        return columnVector;
    }

    /**
     * Транспонирование матрицы.
     */
    public void transposition() {
        Matrix copyMatrix = new Matrix(this.fields);
        if (getColumnNumber() != getLineNumber()) {
            this.fields = new Vector[copyMatrix.getColumnNumber()];
            for (int i = 0; i < this.fields.length; i++) {
                this.fields[i] = new Vector(copyMatrix.getLineNumber());
            }
        }
        for (int j = 0; j < copyMatrix.getLineNumber(); j++) {
            Vector copyVector = copyMatrix.getLineVector(j);
            for (int k = 0; k < copyVector.getSize(); k++) {
                this.fields[k].setElementByIndex(j, copyVector.getElementByIndex(k));
            }
        }
    }

    /**
     * Перемножает все значения матрицы на скаляр.
     *
     * @param scalar double
     */
    public void multiplicationByScalar(double scalar) {
        if (scalar == 1) {
            System.out.println("Матрица останется неизменной");
            return;
        }
        for (Vector vec : this.fields) {
            for (int i = 0; i < vec.getSize(); i++) {
                vec.setElementByIndex(i, vec.getElementByIndex(i) * scalar);
            }
        }
    }

    /**
     * Вычисляет Определитель.
     *
     * @return double
     */
    public double getDeterminant() {
        if (getColumnNumber() != getLineNumber()) {
            throw new IllegalArgumentException("Вычислить детерминант не квадратичной матрицы нельзя.");
        }
        if (this.fields.length == 1) {
            return this.fields[0].getElementByIndex(0);
        } else if (this.fields.length == 2) {
            return this.fields[0].getElementByIndex(0) * this.fields[1].getElementByIndex(1) - this.fields[0].getElementByIndex(1) * this.fields[1].getElementByIndex(0);
        } else if (this.fields.length == 3) {
            return this.fields[0].getElementByIndex(0) * this.fields[1].getElementByIndex(1) * this.fields[2].getElementByIndex(2)
                    + this.fields[0].getElementByIndex(1) * this.fields[1].getElementByIndex(2) * this.fields[2].getElementByIndex(0)
                    + this.fields[0].getElementByIndex(2) * this.fields[1].getElementByIndex(0) * this.fields[2].getElementByIndex(1)
                    - this.fields[2].getElementByIndex(0) * this.fields[1].getElementByIndex(1) * this.fields[0].getElementByIndex(2)
                    - this.fields[2].getElementByIndex(1) * this.fields[1].getElementByIndex(2) * this.fields[0].getElementByIndex(0)
                    - this.fields[2].getElementByIndex(2) * this.fields[1].getElementByIndex(0) * this.fields[0].getElementByIndex(1);
        } else {
            double epsilon = 0.1e-10;
            double determinant = 0;
            for (int i = 0; i < this.fields.length; ++i) {
                if (Math.abs(this.fields[i].getElementByIndex(0)) >= epsilon) {
                    Matrix smallerMatrix = new Matrix(this.fields.length - 1, this.fields.length - 1);
                    for (int j = 0, n = 0; j < this.fields.length; ++j) {
                        if (j != i) {
                            for (int k = 1, m = 0; k < this.fields.length; ++k) {
                                smallerMatrix.getLineVector(n).setElementByIndex(m, this.fields[j].getElementByIndex(k));
                                m++;
                            }
                            n++;
                        }
                    }
                    if (i % 2 == 0) {
                        determinant += this.fields[i].getElementByIndex(0) * smallerMatrix.getDeterminant();
                    } else {
                        determinant += (this.fields[i].getElementByIndex(0) * -1) * smallerMatrix.getDeterminant();
                    }
                }
            }
            return determinant;
        }
    }

    /**
     * Умножает матрицу на вектор.
     *
     * @param vector Vector
     * @return Vector
     */
    public Vector getMultiplicationByVector(Vector vector) {
        if (getColumnNumber() != vector.getSize()) {
            throw new IllegalArgumentException("Число столбцов матрицы должно быть равно числу длины вектора");
        }
        Vector result = new Vector(this.fields.length);
        for (int i = 0; i < this.fields.length; i++) {
            double sum = 0;
            for (int j = 0; j < this.fields[i].getSize(); j++) {
                sum += this.fields[i].getElementByIndex(j) * vector.getElementByIndex(j);
            }
            result.setElementByIndex(i, sum);
        }
        return result;
    }

    /**
     * Складывает две матрицы.
     *
     * @param matrix Matrix
     */
    public void sum(Matrix matrix) {
        if (getLineNumber() != matrix.getLineNumber() && getColumnNumber() != matrix.getColumnNumber()) {
            throw new IllegalArgumentException("Сложение матриц разной размерности невозможно.");

        }
        for (int i = 0; i < this.fields.length; i++) {
            for (int j = 0; j < this.fields[i].getSize(); j++) {
                this.fields[i].setElementByIndex(j, this.fields[i].getElementByIndex(j) + matrix.getLineVector(i).getElementByIndex(j));
            }
        }
    }

    /**
     * Вычитает две матрицы.
     *
     * @param matrix Matrix
     */
    public void subtraction(Matrix matrix) {
        if (getLineNumber() != matrix.getLineNumber() && getColumnNumber() != matrix.getColumnNumber()) {
            throw new IllegalArgumentException("Сложение матриц разной размерности невозможно.");

        }
        for (int i = 0; i < this.fields.length; i++) {
            for (int j = 0; j < this.fields[i].getSize(); j++) {
                this.fields[i].setElementByIndex(j, this.fields[i].getElementByIndex(j) - matrix.getLineVector(i).getElementByIndex(j));
            }
        }
    }

    /**
     * Складывает две матрицы результат выводит в новую матрицу.
     *
     * @param matrix1 Matrix
     * @param matrix2 Matrix
     * @return Matrix
     */
    public static Matrix getStaticSum(Matrix matrix1, Matrix matrix2) {
        Matrix sumMatrix = new Matrix(matrix1);
        sumMatrix.sum(matrix2);
        return sumMatrix;
    }

    /**
     * Вычитает две матрицы результат выводит в новую матрицу.
     *
     * @param matrix1 Matrix
     * @param matrix2 Matrix
     * @return Matrix
     */
    public static Matrix getStaticSubtraction(Matrix matrix1, Matrix matrix2) {
        Matrix subtractionMatrix = new Matrix(matrix1);
        subtractionMatrix.subtraction(matrix2);
        return subtractionMatrix;
    }

    /**
     * Умножает две матрицы результат выводит в новую матрицу.
     *
     * @param matrix1 Matrix
     * @param matrix2 Matrix
     * @return Matrix
     */
    public static Matrix getStaticMultiplication(Matrix matrix1, Matrix matrix2) {
        if (matrix1.getColumnNumber() != matrix2.getLineNumber()) {
            throw new IllegalArgumentException("Чтобы можно было умножить две матрицы, количество столбцов первой матрицы должно быть равно количеству строк второй матрицы.");
        }

        Matrix multiplicationMatrix = new Matrix(matrix1.getLineNumber(), matrix2.getColumnNumber());

        if (matrix2.getColumnNumber() == 1) {
            multiplicationMatrix.getMultiplicationByVector(matrix2.getColumnVector(0));
            return multiplicationMatrix;
        }

        for (int i = 0; i < multiplicationMatrix.getLineNumber(); i++) {
            Vector hashLine = matrix1.getLineVector(i);
            for (int j = 0; j < multiplicationMatrix.getColumnNumber(); j++) {
                double sum = 0;
                Vector hashColumn = matrix2.getColumnVector(j);
                for (int o = 0; o < hashColumn.getSize(); o++) {
                    sum += hashLine.getElementByIndex(o) * hashColumn.getElementByIndex(o);
                }
                multiplicationMatrix.getLineVector(i).setElementByIndex(j, sum);
            }
        }
        return multiplicationMatrix;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Matrix matrix = (Matrix) obj;
        return Arrays.equals(matrix.fields, fields);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(this.fields);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        for (Vector vec : this.fields) {
            stringBuilder.append(vec.toString()).append(", ");
        }
        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
        return stringBuilder.append("}").toString();
    }


}