package ru.academItSchool.gorbunov.main;

import ru.academItSchool.gorbunov.vector.Vector;

public class Realization {
    public static void main(String[] args) {
        Vector vector1 = new Vector(10, new double[]{1, 2, 3, 4, 5});
        System.out.println("Вектор 1 - " + vector1);

        Vector vector2 = new Vector(12, new double[]{1, 2, 3, 4, 5, 6, 7});
        System.out.println("Вектор 2 - " + vector2.toString());

        Vector vector3 = new Vector(vector1);
        System.out.println("Вектор 3 - " + vector3.toString());

        Vector vector6 = new Vector(new double[]{1, 2, 3});
        System.out.println("Вектор 4 - " + vector6.toString());

        System.out.println("Размерность вектора равна = " + vector1.getSize());

        vector1.sum(vector2);
        System.out.println("Сумма векторов равна = " + vector1.toString());

        vector1.subtraction(vector2);
        System.out.println("Вычитание векторов равно = " + vector1.toString());

        vector1.multiplicationByScalar(5);
        System.out.println("Скаляр векторов равен = " + vector1.toString());

        vector1.turn();
        System.out.println("Разворот вектора = " + vector1.toString());
        vector1.turn();

        System.out.println("Длина вектора равна = " + vector1.getLength());

        System.out.println("По заданому индексу стоит элемент - " + vector1.getElementByIndex(0));

        vector1.setElementByIndex(0, 25);
        System.out.println("Теперь на указаном месте стоит указаное число - " + vector1.toString());

        System.out.println("Если сложить два массива то получится новый - " + Vector.getSum(vector1, vector2).toString());

        System.out.println("Если вычесть два массива то получится новый - " + Vector.getSubtraction(vector1, vector2).toString());

        System.out.println("Cкалярное произведение векторов будет равно =  " + Vector.getScalarMultiplication(vector1, vector2));

        Vector vector4 = new Vector(5);
        System.out.println(vector4);

        Vector vector5 = new Vector(new double[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 40});
        System.out.println(vector5);
    }
}
