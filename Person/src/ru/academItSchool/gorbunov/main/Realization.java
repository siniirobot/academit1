package ru.academItSchool.gorbunov.main;

import ru.academItSchool.gorbunov.Person.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class Realization {
    public static void main(String[] args) {
        Person piter = new Person("Петр", 28);
        Person pavel = new Person("Павел", 20);
        Person serega = new Person("Сергей", 35);
        Person kuzia = new Person("Кузя", 413);
        Person piter1 = new Person("Петр", 40);

        ArrayList<Person> list = new ArrayList<>(Arrays.asList(piter, pavel, serega, kuzia, piter1));
        Stream<Person> stream = list.stream();
        ArrayList<Object> names = stream.sorted(x -> x.getName());
    }
}
