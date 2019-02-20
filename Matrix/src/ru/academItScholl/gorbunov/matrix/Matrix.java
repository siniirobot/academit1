package ru.academItScholl.gorbunov.matrix;

import java.util.Arrays;


import ru.academItSchool.gorbunov.vector.Vector;

public class Matrix {

    private Vector[] vectors;

    public Matrix(int height, int width) {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("Высота и ширина матрицы не может быть меньше или равен нулю.");
        }
        this.vectors = new Vector[height];
        for (int i = 0; i < vectors.length; i++) {
            this.vectors[i] = new Vector(width);
        }
    }

    public Matrix(double[][] content) {
        if (content.length == 0 && getWidth(content)) {
            throw new IllegalArgumentException("Высота и ширина матрицы не может быть меньше или равен нулю.");
        }

        this.vectors = new Vector[content.length];
        for (int i = 0; i < vectors.length; i++) {
            this.vectors[i] = new Vector(content[i]);
        }
    }

    public Matrix(Vector[] vectors) {
        if (vectors.length == 0) {
            throw new IllegalArgumentException("Высота и ширина матрицы не может быть меньше или равен нулю.");
        }
        int maxVectorsLength = getWidth(vectors);
        this.vectors = new Vector[vectors.length];
        for (int i = 0; i < this.vectors.length; i++) {
            this.vectors[i] = new Vector(maxVectorsLength);
            for (int j = 0; j < vectors[i].getSize(); j++) {
                this.vectors[i].setElementByIndex(j, vectors[i].getElementByIndex(j));
            }
        }
    }

    public Matrix(Matrix matrix) {
        this.vectors = new Vector[matrix.getHeight()];
        for (int i = 0; i < matrix.getHeight(); i++) {
            this.vectors[i] = new Vector(matrix.getLineVector(i));
        }

    }

    /**
     * Возвращает значение ширины массива.
     *
     * @return int
     */
    private boolean getWidth(double[][] array) {
        int width = 0;
        for (double[] arr: array) {
            if (arr != null) {
                if (width < arr.length) {
                    width = arr.length;
                }
            }else {
                throw new IllegalArgumentException("Вы не указали ширину массива.");
            }

        }
        return true;
    }

    /**
     * Возвращает значение ширины векторного массива.
     *
     * @return int
     */
    private int getWidth(Vector[] vector) {
        int width = 0;
        for (Vector vec : vector) {
            if (vec != null) {
                if (width < vec.getSize()) {
                    width = vec.getSize();
                }
            }else {
                throw new IllegalArgumentException("Вы не указали ширину массива.");
            }
        }
        return width;
    }
    /**
     * Возвращает значение ширины матрицы.
     *
     * @return int
     */
    public int getWidth() {
        return getWidth(this.vectors);
    }

    /**
     * Возвращает значение длины матрицы.
     *
     * @return int
     */
    public int getHeight() {
        return vectors.length;
    }

    /**
     * Возвращает значение размера матрицы.
     *
     * @return int []
     */
    public int[] getSize() {
        return new int[]{getHeight(), getWidth()};
    }

    /**
     * Возвращает вектор из матрицы по индексу
     *
     * @param index int
     * @return Vector
     */
    public Vector getLineVector(int index) {
        if (index >= this.vectors.length || index < 0) {
            throw new IllegalArgumentException("Индекс не может быть меньше нуля и больше высоты матрицы");
        }
        return this.vectors[index];
    }

    /**
     * Заменяет существующий вектор по индексу, на новый.
     *
     * @param index  int
     * @param vector Vector
     */
    public void setLineVector(int index, Vector vector) {
        if (index >= this.vectors.length || index < 0) {
            throw new IllegalArgumentException("Индекс не может быть меньше нуля и больше высоты матрицы");
        }
        int oldWidth = getWidth();
        this.vectors[index] = vector;
        if (oldWidth < getWidth()) {
            for (int i = 0; i < this.vectors.length; i++) {
                Vector copyVector = this.vectors[i];
                this.vectors[i] = new Vector(vector.getSize());
                for (int j = 0; j < copyVector.getSize(); j++) {
                    this.vectors[i].setElementByIndex(j, copyVector.getElementByIndex(j));
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
        if (index < 0 || index > getWidth()) {
            throw new IllegalArgumentException("Значение индекса не может быть меньше нуля или больше ширины матрицы.");
        }
        Vector columnVector = new Vector(this.vectors.length);
        for (int i = 0; i < this.vectors.length; i++) {
            columnVector.setElementByIndex(i, this.vectors[i].getElementByIndex(index));
        }
        return columnVector;
    }

    /**
     * Транспонирование матрицы.
     */
    public void transposition() {
        Matrix copyMatrix = new Matrix(this.vectors);
        if (getWidth() != getHeight()) {
            this.vectors = new Vector[copyMatrix.getWidth()];
            for (int i = 0; i < this.vectors.length; i++) {
                this.vectors[i] = new Vector(copyMatrix.getHeight());
            }
        }
        for (int j = 0; j < copyMatrix.getHeight(); j++) {
            Vector copyVector = copyMatrix.getLineVector(j);
            for (int k = 0; k < copyVector.getSize(); k++) {
                this.vectors[k].setElementByIndex(j, copyVector.getElementByIndex(k));
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
        for (Vector vec : this.vectors) {
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
        if (getWidth() != getHeight()) {
            throw new IllegalArgumentException("Вычислить детерминант не квадратичной матрицы нельзя.");
        }
        if (this.vectors.length == 1) {
            return this.vectors[0].getElementByIndex(0);
        } else if (this.vectors.length == 2) {
            return this.vectors[0].getElementByIndex(0) * this.vectors[1].getElementByIndex(1) - this.vectors[0].getElementByIndex(1) * this.vectors[1].getElementByIndex(0);
        } else if (this.vectors.length == 3) {
            return this.vectors[0].getElementByIndex(0) * this.vectors[1].getElementByIndex(1) * this.vectors[2].getElementByIndex(2)
                    + this.vectors[0].getElementByIndex(1) * this.vectors[1].getElementByIndex(2) * this.vectors[2].getElementByIndex(0)
                    + this.vectors[0].getElementByIndex(2) * this.vectors[1].getElementByIndex(0) * this.vectors[2].getElementByIndex(1)
                    - this.vectors[2].getElementByIndex(0) * this.vectors[1].getElementByIndex(1) * this.vectors[0].getElementByIndex(2)
                    - this.vectors[2].getElementByIndex(1) * this.vectors[1].getElementByIndex(2) * this.vectors[0].getElementByIndex(0)
                    - this.vectors[2].getElementByIndex(2) * this.vectors[1].getElementByIndex(0) * this.vectors[0].getElementByIndex(1);
        } else {
            double epsilon = 0.1e-10;
            double determinant = 0;
            for (int i = 0; i < this.vectors.length; ++i) {
                if (Math.abs(this.vectors[i].getElementByIndex(0)) >= epsilon) {
                    Matrix smallerMatrix = new Matrix(this.vectors.length - 1, this.vectors.length - 1);
                    for (int j = 0, n = 0; j < this.vectors.length; ++j) {
                        if (j != i) {
                            for (int k = 1, m = 0; k < this.vectors.length; ++k) {
                                smallerMatrix.getLineVector(n).setElementByIndex(m, this.vectors[j].getElementByIndex(k));
                                m++;
                            }
                            n++;
                        }
                    }
                    if (i % 2 == 0) {
                        determinant += this.vectors[i].getElementByIndex(0) * smallerMatrix.getDeterminant();
                    } else {
                        determinant += (this.vectors[i].getElementByIndex(0) * -1) * smallerMatrix.getDeterminant();
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
        if (getWidth() != vector.getSize()) {
            throw new IllegalArgumentException("Число столбцов матрицы должно быть равно числу длины вектора");
        }
        Vector result = new Vector(this.vectors.length);
        for (int i = 0; i < this.vectors.length; i++) {
            double sum = 0;
            for (int j = 0; j < this.vectors[i].getSize(); j++) {
                sum += this.vectors[i].getElementByIndex(j) * vector.getElementByIndex(j);
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
        if (!Arrays.equals(getSize(), matrix.getSize())) {
            throw new IllegalArgumentException("Сложение матриц разной размерности невозможно.");
        }
        for (int i = 0; i < this.vectors.length; i++) {
            for (int j = 0; j < this.vectors[i].getSize(); j++) {
                this.vectors[i].setElementByIndex(j, this.vectors[i].getElementByIndex(j) + matrix.getLineVector(i).getElementByIndex(j));
            }
        }
    }

    /**
     * Вычитает две матрицы.
     *
     * @param matrix Matrix
     */
    public void subtraction(Matrix matrix) {
        if (!Arrays.equals(getSize(), matrix.getSize())) {
            throw new IllegalArgumentException("Вычитание матриц разной размерности невозможно.");
        }
        for (int i = 0; i < this.vectors.length; i++) {
            for (int j = 0; j < this.vectors[i].getSize(); j++) {
                this.vectors[i].setElementByIndex(j, this.vectors[i].getElementByIndex(j) - matrix.getLineVector(i).getElementByIndex(j));
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
        if (matrix1.getWidth() != matrix2.getHeight()) {
            throw new IllegalArgumentException("Чтобы можно было умножить две матрицы, количество столбцов первой матрицы должно быть равно количеству строк второй матрицы.");
        }

        Matrix multiplicationMatrix = new Matrix(matrix1.getHeight(), matrix2.getWidth());

        if (matrix2.getWidth() == 1) {
            multiplicationMatrix.getMultiplicationByVector(matrix2.getColumnVector(0));
            return multiplicationMatrix;
        }

        for (int i = 0; i < multiplicationMatrix.getHeight(); i++) {
            Vector hashLine = matrix1.getLineVector(i);
            for (int j = 0; j < multiplicationMatrix.getWidth(); j++) {
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
        return Arrays.equals(matrix.vectors, ((Matrix) obj).vectors);
    }

    @Override
    public int hashCode() {
        return 31 + Arrays.hashCode(this.vectors);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        for (Vector vec : this.vectors) {
            stringBuilder.append("{");
            for (int i = 0; i < vec.getSize(); i++) {
                stringBuilder.append(vec.getElementByIndex(i)).append(", ");
            }
            stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
            stringBuilder.append("}, ");
        }
        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
        return stringBuilder.append("}").toString();
    }
}