package ru.academItSchool.gorbunov.main;

import ru.academItSchool.gorbunov.Person.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Realization {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>(Arrays.asList(new Person("Петр", 28),
                new Person("Павел", 20),
                new Person("Сергей", 32),
                new Person("Александр", 33),
                new Person("Алексей", 46),
                new Person("Николай", 0)));
        Stream<Person> stream = persons.stream();
        //List<Person> tryPerson = persons.stream().forEach(Person -> ).collect(Collectors.toList());

    }
}
