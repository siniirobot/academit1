package ru.academItSchool.gorbunov.main;

import ru.academItSchool.gorbunov.Person.Person;

import java.util.*;
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
        //А) получить список уникальных имен
        Stream<Person> stream = persons.stream();
        stream.map(Person::getName).distinct().forEach(System.out::println);

        //Б) вывести список уникальных имен в формате: Имена: Иван, Сергей, Петр.
        String namesLine = persons.stream().map(Person::getName).distinct().collect(Collectors.joining(", ", "Names: ", "."));
        System.out.println(namesLine);

        //В) получить список людей младше 18, посчитать для них средний возраст
        Stream<Person> stream1 = persons.stream();
        double averageAgeLess18 = stream1.filter(person -> person.getAge() < 18).mapToDouble(Person::getAge).average().getAsDouble();
        System.out.println("Средний возраст лиц младше 18 - " + averageAgeLess18);

        //Г) при помощи группировки получить Map, в котором ключи – имена, а значения – средний возраст
        Stream<Person> stream2 = persons.stream();
        Map<String, Double> age = stream2.distinct().collect(Collectors.groupingBy(Person::getName,Collectors.averagingDouble(Person::getAge)));
        age.forEach((person, p) -> System.out.printf("%s: %s\n", person, p));

        Stream<Person> stream3 = persons.stream();
        Stream<Person> list = stream3.filter(person -> person.getAge() > 20 && person.getAge() < 45).map(Person::getName);

    }
}
