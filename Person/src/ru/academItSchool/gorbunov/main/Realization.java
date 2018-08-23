package ru.academItSchool.gorbunov.main;

import ru.academItSchool.gorbunov.Person.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Realization {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>(Arrays.asList(new Person("Петр", 28),
                new Person("Петр", 16),
                new Person("Павел", 20),
                new Person("Сергей", 11),
                new Person("Александр", 15),
                new Person("Алексей", 46),
                new Person("Николай", 0)));
        Stream<Person> stream = persons.stream();
        stream.map(Person::getName).distinct().forEach(System.out::println);
        String namesLine = persons.stream().map(Person::getName).distinct().collect(Collectors.joining(", ", "Names: ", "."));
        System.out.println(namesLine);
        Stream<Person> stream1 = persons.stream();
        double averageAgeLess18 = stream1.filter(person -> person.getAge() < 18).mapToInt(Person::getAge).average().getAsDouble();
        System.out.println("Средний возраст лиц младше 18 - " + averageAgeLess18);
        Stream<Person> stream2 = persons.stream();
        //Map<List<Person>, List<Person>> age = stream2.collect(Collectors.groupingBy(Person::getName,Collectors.summarizingInt()));
       // age.forEach((person, p) -> System.out.printf("age %s: %s\n", person, p));
    }
}
