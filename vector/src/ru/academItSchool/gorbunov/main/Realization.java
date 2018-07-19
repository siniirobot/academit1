package ru.academItSchool.gorbunov.main;

import ru.academItSchool.gorbunov.vector.Vector;

public class Realization {
    public static void main(String[] args) {
        Vector vector1 = new Vector(5,new double[]{0,1,2,3,4,5});
        System.out.println("Векстор 1 - " + vector1.toString());

        Vector vector2 = new Vector(10, new double[]{0,1,2});
        System.out.println("Векстор 2 - " + vector2.toString());

        System.out.println("Размерность вектора равна = " + vector1.getSize());

        System.out.println("Сумма векторов равна = " + vector1.getVectorSum(vector2));

        System.out.println("Вычитание векторов равно = " + vector1.getVectorSubtraction(vector2));

        System.out.println("Скаляр векторов равен = " + vector1.getVectorScalar(10));

        System.out.println("Разворот вектора = " + vector1.getVectorTurn());
        vector1.getVectorTurn();

        System.out.println("Длина вектора равна = " + vector1.getVectorLength());

        System.out.println("На указаном месте стоит  число - " + vector1.getInsert(100,1000));
        System.out.println("Теперь на указаном месте стоит указаное число" + vector1.toString());

        vector1.setLength(1);
        System.out.println("Сумма векторов = " + Vector.getStaticVectorSum(vector1,vector2));

        System.out.println("Вычитание векторов равно = " + Vector.getStaticVectorSubtraction(vector1,vector2));

        System.out.println("Скаляр векторов равен = " + Vector.getStaticVectorScalar(vector1,vector2));
    }
}
