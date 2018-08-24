package ru.academItSchool.gorbunov.main;

import ru.academItSchool.gorbunov.Person.Person;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Realization {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>(Arrays.asList(new Person("Петр", 28),
                new Person("Петр", 16),
                new Person("Павел", 20),
                new Person("Сергей", 11),
                new Person("Сергей", 35),
                new Person("Александр", 15),
                new Person("Александр", 27),
                new Person("Алексей", 46),
                new Person("Николай", 0)));

        System.out.println("А) получить список уникальных имен");
        Stream<Person> stream = persons.stream();
        stream.map(Person::getName).distinct().forEach(System.out::println);

        System.out.println("Б) вывести список уникальных имен в формате: Имена: Иван, Сергей, Петр.");
        System.out.println(persons.stream().map(Person::getName).distinct().collect(Collectors.joining(", ", "Names: ", ".")));

        System.out.println("В) получить список людей младше 18, посчитать для них средний возраст.");
        System.out.println("Средний возраст лиц младше 18 - " + persons.stream().filter(person -> person.getAge() < 18).mapToDouble(Person::getAge).average().getAsDouble());

        System.out.println("Г) при помощи группировки получить Map, в котором ключи – имена, а значения – средний возраст.");
        Map<String, Double> age = persons.stream().distinct().collect(Collectors.groupingBy(Person::getName, Collectors.averagingDouble(Person::getAge)));
        age.forEach((person, p) -> System.out.printf("%s: %s\n", person, p));

        System.out.println("Д) получить людей, возраст которых от 20 до 45, вывести в консоль их имена в порядке убывания возраста");
        System.out.println( persons.stream().filter(person -> person.getAge() > 20 && person.getAge() < 45).sorted((o1, o2) -> o2.getAge() - o1.getAge()).map(Person::getName).collect(Collectors.joining(", старше чем ")));

        System.out.println("Введите колличество корней");
        DoubleStream squares = DoubleStream.iterate(0, x-> x+1).limit(new Scanner(System.in).nextInt()).map(Math::cbrt);
        squares.forEach(System.out::println);


    }
}
