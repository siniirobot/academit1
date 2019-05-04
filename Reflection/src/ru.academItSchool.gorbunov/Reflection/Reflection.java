package ru.academItSchool.gorbunov.Reflection;

import ru.academItSchool.gorbunov.Classes.ClassA;
import ru.academItSchool.gorbunov.Classes.ClassB;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Reflection {
    public static void main(String[] args) throws
            ClassNotFoundException, NoSuchMethodException,
            IllegalAccessException, InvocationTargetException,
            InstantiationException, NoSuchFieldException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите название класса с которым хотите работать.");
        String className = scanner.nextLine();
        Class a = Class.forName("ru.academItSchool.gorbunov.Classes." + className);
        className = scanner.nextLine();
        Class b = Class.forName("ru.academItSchool.gorbunov.Classes." + className);
        Constructor constructorA = a.getConstructor(int.class,String.class);
        ClassA classA = (ClassA)constructorA.newInstance(3,"Пень");
        Constructor constructorB = b.getConstructor(int.class,String.class);
        ClassB classB = (ClassB) constructorB.newInstance(2,"Intel");

        Field fieldA = a.getField("a");
        fieldA.setAccessible(true);
        Field fieldB = classB.getClass().getDeclaredField("b");
        fieldB.setAccessible(true);
        fieldA.set(classA,25);
        fieldB.set(classB,"Селерон");

        Method methodClassA = a.getMethod("getA");
        System.out.println(methodClassA.invoke(classA));
    }
}
