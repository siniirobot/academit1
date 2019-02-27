package ru.academItScholl.gorbunov.matrix;

import java.util.Arrays;


import ru.academItSchool.gorbunov.vector.Vector;

public class Matrix {

    private Vector[] fields;

    public Matrix(int rowNumber, int columnNumber) {
        if (columnNumber <= 0 || rowNumber <= 0) {
            throw new NullPointerException("Количество столбцов и количество рядов не может быть меньше или равен нулю.");
        }
        this.fields = new Vector[rowNumber];
        for (int i = 0; i < fields.length; i++) {
            this.fields[i] = new Vector(columnNumber);
        }
    }

    public Matrix(double[][] components) {
        if (components.length == 0 || getColumnNumber(components) <= 0) {
            throw new NullPointerException("Количество столбцов и количество рядов не может быть меньше или равен нулю.");
        }
        int columnNumber = getColumnNumber(components);
        this.fields = new Vector[components.length];
        for (int i = 0; i < fields.length; i++) {
            this.fields[i] = new Vector(columnNumber, components[i]);
        }
    }

    public Matrix(Vector[] fields) {
        if (fields.length == 0) {
            throw new NullPointerException("Количество столбцов и количество рядов не может быть меньше или равен нулю.");
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
        this.fields = new Vector[matrix.getRowNumber()];
        for (int i = 0; i < matrix.getRowNumber(); i++) {
            this.fields[i] = new Vector(matrix.getRowVector(i));
        }
    }

    /**
     * Возвращает значение ширины массива.
     *
     * @return int
     */
    private int getColumnNumber(double[][] components) {
        int columnNumber = 0;
        for (double[] arr : components) {
            if (arr.length != 0) {
                if (columnNumber < arr.length) {
                    columnNumber = arr.length;
                }
            } else {
                throw new NullPointerException("Двумерный массив содержит пустые массивы.");
            }
        }
        return columnNumber;
    }

    /**
     * Возвращает значение ширины векторного массива.
     *
     * @return int
     */
    private int getColumnNumber(Vector[] columns) {
        int columnNumber = 0;
        for (Vector vec : columns) {
            if (vec != null) {
                if (columnNumber < vec.getSize()) {
                    columnNumber = vec.getSize();
                }
            } else {
                throw new NullPointerException("Векторный массив содержит пустые вектора.");
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
    public int getRowNumber() {
        return fields.length;
    }

    /**
     * Проверяет входит ли индекс в размеры матрицы.
     *
     * @param index int
     */
    private void exceptionForWrongIndex(int index) {
        if (index >= this.fields.length || index < 0) {
            throw new ArrayIndexOutOfBoundsException("Индекс не может быть меньше нуля и больше количества строк " +
                    this.fields.length + " матрицы");
        }
    }

    /**
     * Возвращает вектор из матрицы по индексу
     *
     * @param index int
     * @return Vector
     */
    public Vector getRowVector(int index) {
        exceptionForWrongIndex(index);
        return new Vector(this.fields[index]);
    }

    /**
     * Заменяет существующий вектор по индексу, на новый.
     *
     * @param index int
     * @param row   Vector
     */
    public void setRowVector(int index, Vector row) {
        exceptionForWrongIndex(index);
        if (row.getSize() > getColumnNumber()) {
            throw new ArrayIndexOutOfBoundsException("Длина строки не может быть больше количества столбцов "
                    + getColumnNumber() + " матрицы");
        }
        this.fields[index] = row;
    }

    /**
     * Возвращает вектор состоящий из значений выбранного столбца матрицы
     *
     * @param index int
     * @return Vector
     */
    public Vector getColumnVector(int index) {
        if (index >= getColumnNumber() || index < 0) {
            throw new ArrayIndexOutOfBoundsException("Индекс не может быть меньше нуля и больше количества колонок " +
                    getColumnNumber() + " матрицы");
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
        Vector[] transposeMatrix = new Vector[getColumnNumber()];
        for (int i = 0; i < transposeMatrix.length; i++) {
            transposeMatrix[i] = new Vector(getColumnVector(i));
        }
        this.fields = transposeMatrix;
    }

    /**
     * Перемножает все значения матрицы на скаляр.
     *
     * @param scalar double
     */
    public void multiplicationByScalar(double scalar) {
        if (scalar == 1) return;
        for (Vector vec : this.fields) {
            vec.multiplicationByScalar(scalar);
        }
    }

    /**
     * Вычисляет Определитель.
     *
     * @return double
     */
    public double getDeterminant() {
        if (getColumnNumber() != getRowNumber()) {
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
                                smallerMatrix.getRowVector(n).setElementByIndex(m, this.fields[j].getElementByIndex(k));
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
     * Проверяет возможно ли сложение или вычитание матриц
     *
     * @param lineNumber1   int
     * @param columnNumber1 int
     * @param lineNumber2   int
     * @param columnNumber2 int
     */
    private static void exceptionForNotIdenticalMatrix(int lineNumber1, int columnNumber1, int lineNumber2, int columnNumber2) {
        if (lineNumber1 != lineNumber2 || columnNumber1 != columnNumber2) {
            throw new IllegalArgumentException("Сложение и вычитание матриц разной размерности невозможно.");
        }
    }

    /**
     * Складывает две матрицы.
     *
     * @param matrix Matrix
     */
    public void sum(Matrix matrix) {
        exceptionForNotIdenticalMatrix(getRowNumber(), getColumnNumber(), matrix.getRowNumber(), matrix.getColumnNumber());
        for (int i = 0; i < this.fields.length; i++) {
            this.fields[i].sum(matrix.getRowVector(i));
        }

    }

    /**
     * Вычитает две матрицы.
     *
     * @param matrix Matrix
     */
    public void subtraction(Matrix matrix) {
        exceptionForNotIdenticalMatrix(getRowNumber(), getColumnNumber(), matrix.getRowNumber(), matrix.getColumnNumber());
        for (int i = 0; i < this.fields.length; i++) {
            this.fields[i].subtraction(matrix.getRowVector(i));
        }
    }

    /**
     * Складывает две матрицы результат выводит в новую матрицу.
     *
     * @param matrix1 Matrix
     * @param matrix2 Matrix
     * @return Matrix
     */
    public static Matrix getSum(Matrix matrix1, Matrix matrix2) {
        exceptionForNotIdenticalMatrix(matrix1.getRowNumber(), matrix2.getColumnNumber(),
                matrix2.getRowNumber(), matrix2.getColumnNumber());
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
    public static Matrix getSubtraction(Matrix matrix1, Matrix matrix2) {
        exceptionForNotIdenticalMatrix(matrix1.getRowNumber(), matrix2.getColumnNumber(),
                matrix2.getRowNumber(), matrix2.getColumnNumber());
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
    public static Matrix getMultiplication(Matrix matrix1, Matrix matrix2) {
        if (matrix1.getColumnNumber() != matrix2.getRowNumber()) {
            throw new IllegalArgumentException("Чтобы можно было умножить две матрицы, количество столбцов первой матрицы должно быть равно количеству строк второй матрицы.");
        }
        Vector[] tempMatrix = new Vector[matrix1.getRowNumber()];
        for (int i = 0; i < tempMatrix.length; i++) {
            Vector tempLine = matrix1.getRowVector(i);
            tempMatrix[i] = new Vector(matrix2.getColumnNumber());
            for (int j = 0; j < tempMatrix[i].getSize(); j++) {
                double sum = 0;
                Vector tempColumn = matrix2.getColumnVector(j);
                for (int k = 0; k < tempColumn.getSize(); k++) {
                    sum += tempLine.getElementByIndex(k) * tempColumn.getElementByIndex(k);
                }
                tempMatrix[i].setElementByIndex(j, sum);
            }
        }
        return new Matrix(tempMatrix);
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