package ru.academItScholl.gorbunov.matrix;

import java.util.Arrays;
import ru.academItSchool.gorbunov.vector.Vector;

public class Matrix {

    private Vector[] rows;

    public Matrix(int rowsNumber, int columnsNumber) {
        if (columnsNumber <= 0 || rowsNumber <= 0) {
            throw new IllegalArgumentException("Количество столбцов и количество рядов не может быть меньше или равен нулю.");
        }
        this.rows = new Vector[rowsNumber];
        for (int i = 0; i < rows.length; i++) {
            this.rows[i] = new Vector(columnsNumber);
        }
    }

    public Matrix(double[][] components) {
        if (components.length == 0 || getColumnsNumber(components) <= 0) {
            throw new NullPointerException("Количество столбцов и количество рядов не может быть меньше или равен нулю.");
        }
        int columnNumber = getColumnsNumber(components);
        this.rows = new Vector[components.length];
        for (int i = 0; i < rows.length; i++) {
            this.rows[i] = new Vector(columnNumber, components[i]);
        }
    }

    public Matrix(Vector[] rows) {
        if (rows.length == 0) {
            throw new NullPointerException("Количество столбцов и количество рядов не может быть меньше или равен нулю.");
        }
        int columnNumber = getColumnsNumber(rows);
        this.rows = new Vector[rows.length];
        for (int i = 0; i < this.rows.length; i++) {
            this.rows[i] = new Vector(columnNumber);
            for (int j = 0; j < rows[i].getSize(); j++) {
                this.rows[i].setElementByIndex(j, rows[i].getElementByIndex(j));
            }
        }
    }

    public Matrix(Matrix matrix) {
        this.rows = new Vector[matrix.getRowsNumber()];
        for (int i = 0; i < matrix.getRowsNumber(); i++) {
            this.rows[i] = new Vector(matrix.getRowVector(i));
        }
    }

    /**
     * Возвращает значение ширины массива.
     *
     * @return int
     */
    private int getColumnsNumber(double[][] components) {
        int columnsNumber = 0;
        for (double[] arr : components) {
            if (arr.length != 0) {
                if (columnsNumber < arr.length) {
                    columnsNumber = arr.length;
                }
            } else {
                throw new NullPointerException("Двумерный массив содержит пустые массивы.");
            }
        }
        return columnsNumber;
    }

    /**
     * Возвращает значение ширины векторного массива.
     *
     * @return int
     */
    private int getColumnsNumber(Vector[] columns) {
        int columnsNumber = 0;
        for (Vector vec : columns) {
            if (vec != null) {
                if (columnsNumber < vec.getSize()) {
                    columnsNumber = vec.getSize();
                }
            } else {
                throw new NullPointerException("Векторный массив содержит пустые вектора.");
            }
        }
        return columnsNumber;
    }

    /**
     * Возвращает значение ширины матрицы.
     *
     * @return int
     */
    public int getColumnsNumber() {
        return getColumnsNumber(this.rows);
    }

    /**
     * Возвращает значение длины матрицы.
     *
     * @return int
     */
    public int getRowsNumber() {
        return rows.length;
    }

    /**
     * Проверяет входит ли индекс в размеры матрицы.
     *
     * @param index int
     */
    private void exceptionForWrongIndex(int index) {
        if (index >= this.rows.length || index < 0) {
            throw new ArrayIndexOutOfBoundsException("Индекс не может быть меньше нуля и больше количества строк " +
                    this.rows.length + " матрицы");
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
        return new Vector(this.rows[index]);
    }

    /**
     * Заменяет существующий вектор по индексу, на новый.
     *
     * @param index int
     * @param row   Vector
     */
    public void setRowVector(int index, Vector row) {
        exceptionForWrongIndex(index);
        if (row.getSize() > getColumnsNumber()) {
            throw new ArrayIndexOutOfBoundsException("Длина строки не может быть больше количества столбцов "
                    + getColumnsNumber() + " матрицы");
        }
        this.rows[index] = row;
    }

    /**
     * Возвращает вектор состоящий из значений выбранного столбца матрицы
     *
     * @param index int
     * @return Vector
     */
    public Vector getColumnVector(int index) {
        if (index >= getColumnsNumber() || index < 0) {
            throw new ArrayIndexOutOfBoundsException("Индекс не может быть меньше нуля и больше количества колонок " +
                    getColumnsNumber() + " матрицы");
        }
        Vector columnVector = new Vector(this.rows.length);
        for (int i = 0; i < this.rows.length; i++) {
            columnVector.setElementByIndex(i, this.rows[i].getElementByIndex(index));
        }
        return columnVector;
    }

    /**
     * Транспонирование матрицы.
     */
    public void transposition() {
        Vector[] transposeMatrix = new Vector[getColumnsNumber()];
        for (int i = 0; i < transposeMatrix.length; i++) {
            transposeMatrix[i] = getColumnVector(i);
        }
        this.rows = transposeMatrix;
    }

    /**
     * Перемножает все значения матрицы на скаляр.
     *
     * @param scalar double
     */
    public void multiplicationByScalar(double scalar) {
        if (scalar == 1) return;
        for (Vector vec : this.rows) {
            vec.multiplicationByScalar(scalar);
        }
    }

    /**
     * Вычисляет Определитель.
     *
     * @return double
     */
    public double getDeterminant() {
        if (getColumnsNumber() != getRowsNumber()) {
            throw new IllegalArgumentException("Вычислить детерминант не квадратичной матрицы нельзя.");
        }
        if (this.rows.length == 1) {
            return this.rows[0].getElementByIndex(0);
        } else if (this.rows.length == 2) {
            return this.rows[0].getElementByIndex(0) * this.rows[1].getElementByIndex(1) - this.rows[0].getElementByIndex(1) * this.rows[1].getElementByIndex(0);
        } else if (this.rows.length == 3) {
            return this.rows[0].getElementByIndex(0) * this.rows[1].getElementByIndex(1) * this.rows[2].getElementByIndex(2)
                    + this.rows[0].getElementByIndex(1) * this.rows[1].getElementByIndex(2) * this.rows[2].getElementByIndex(0)
                    + this.rows[0].getElementByIndex(2) * this.rows[1].getElementByIndex(0) * this.rows[2].getElementByIndex(1)
                    - this.rows[2].getElementByIndex(0) * this.rows[1].getElementByIndex(1) * this.rows[0].getElementByIndex(2)
                    - this.rows[2].getElementByIndex(1) * this.rows[1].getElementByIndex(2) * this.rows[0].getElementByIndex(0)
                    - this.rows[2].getElementByIndex(2) * this.rows[1].getElementByIndex(0) * this.rows[0].getElementByIndex(1);
        } else {
            double epsilon = 0.1e-10;
            double determinant = 0;
            for (int i = 0; i < this.rows.length; ++i) {
                if (Math.abs(this.rows[i].getElementByIndex(0)) >= epsilon) {
                    Matrix smallerMatrix = new Matrix(this.rows.length - 1, this.rows.length - 1);
                    for (int j = 0, n = 0; j < this.rows.length; ++j) {
                        if (j != i) {
                            for (int k = 1, m = 0; k < this.rows.length; ++k) {
                                smallerMatrix.getRowVector(n).setElementByIndex(m, this.rows[j].getElementByIndex(k));
                                m++;
                            }
                            n++;
                        }
                    }
                    if (i % 2 == 0) {
                        determinant += this.rows[i].getElementByIndex(0) * smallerMatrix.getDeterminant();
                    } else {
                        determinant += (this.rows[i].getElementByIndex(0) * -1) * smallerMatrix.getDeterminant();
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
        if (getColumnsNumber() != vector.getSize()) {
            throw new IllegalArgumentException("Число столбцов матрицы должно быть равно числу длины вектора");
        }
        Vector result = new Vector(this.rows.length);
        for (int i = 0; i < this.rows.length; i++) {
            double sum = 0;
            for (int j = 0; j < this.rows[i].getSize(); j++) {
                sum += this.rows[i].getElementByIndex(j) * vector.getElementByIndex(j);
            }
            result.setElementByIndex(i, sum);
        }
        return result;
    }

    /**
     * Проверяет возможно ли сложение или вычитание матриц
     *
     * @param matrix Matrix
     */
    private void exceptionForNotIdenticalMatrix(Matrix matrix) {
        if (getRowsNumber() != matrix.getRowsNumber() || getColumnsNumber() != matrix.getColumnsNumber()) {
            throw new IllegalArgumentException("Сложение и вычитание матриц разной размерности невозможно.");
        }
    }

    /**
     * Складывает две матрицы.
     *
     * @param matrix Matrix
     */
    public void sum(Matrix matrix) {
        exceptionForNotIdenticalMatrix(matrix);
        for (int i = 0; i < this.rows.length; i++) {
            this.rows[i].sum(matrix.getRowVector(i));
        }

    }

    /**
     * Вычитает две матрицы.
     *
     * @param matrix Matrix
     */
    public void subtraction(Matrix matrix) {
        exceptionForNotIdenticalMatrix(matrix);
        for (int i = 0; i < this.rows.length; i++) {
            this.rows[i].subtraction(matrix.getRowVector(i));
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
        matrix1.exceptionForNotIdenticalMatrix(matrix2);
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
        matrix1.exceptionForNotIdenticalMatrix(matrix2);
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
        if (matrix1.getColumnsNumber() != matrix2.getRowsNumber()) {
            throw new IllegalArgumentException("Чтобы можно было умножить две матрицы, количество столбцов первой матрицы должно быть равно количеству строк второй матрицы.");
        }
        Vector[] tempMatrix = new Vector[matrix1.getRowsNumber()];
        for (int i = 0; i < tempMatrix.length; i++) {
            Vector tempLine = matrix1.getRowVector(i);
            tempMatrix[i] = new Vector(matrix2.getColumnsNumber());
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
        return Arrays.equals(matrix.rows, rows);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(this.rows);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        for (Vector vec : this.rows) {
            stringBuilder.append(vec.toString()).append(", ");
        }
        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
        return stringBuilder.append("}").toString();
    }
}