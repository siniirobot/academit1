package ru.academItSchool.gorbunov.main;

import ru.academItSchool.gorbunov.vector.Vector;

public class Realization {
    public static void main(String[] args) {
        Vector vector1 = new Vector(12, new double[]{1, 2, 3, 4, 5});
        System.out.println("Векстор 1 - " + vector1.toString());

        Vector vector2 = new Vector(25, new double[]{1, 2, 3, 4, 5, 6, 7});
        System.out.println("Векстор 2 - " + vector2.toString());

        Vector vector3 = new Vector(vector1);
        System.out.println("Векстор 3 - " + vector3.toString());

        System.out.println("Размерность вектора равна = " + vector1.getSize());

        vector1.getVectorSum(vector2);
        System.out.println("Сумма векторов равна = " + vector1.toString());
        System.out.println(vector3.toString());

        vector1.getVectorSubtraction(vector2);
        System.out.println("Вычитание векторов равно = " + vector1.toString());

        vector1.getVectorScalar(3);
        System.out.println("Скаляр векторов равен = " + vector1.toString());
        System.out.println(vector3.toString());
        vector1.getVectorTurn();
        System.out.println("Разворот вектора = " + vector1.toString());
        vector1.getVectorTurn();

        System.out.println("Длина вектора равна = " + vector1.getVectorLength());

        System.out.println("По заданому индексу стоит элемент - " + vector1.getVectorElementByIndex(2));

        vector1.setVectorElementByIndex(25, 4);
        System.out.println("Теперь на указаном месте стоит указаное число - " + vector1.toString());

        System.out.println("Если сложить два массива то получится новый - " + Vector.getStaticVectorSum(vector1, vector2).toString());

        System.out.println("Если вычесть два массива то получится новый - " + Vector.getStaticVectorSubtraction(vector1, vector2).toString());

        System.out.println("Если произвести скалярное произведение векторов то получится новый - " + Vector.getStaticVectorScalar(vector1, vector2).toString());

        Vector vector4 = new Vector(5);
        System.out.println(vector4);

        Vector vector5 = new Vector(new double[]{1,2,4,7});
        System.out.println(vector5);
    }
}
