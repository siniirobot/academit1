package ru.academItSchool.gorbunov.main;

import ru.academItSchool.gorbunov.Person.Person;

import java.util.*;
import java.util.stream.*;

public class Realization {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>(Arrays.asList(new Person("Петр", 28),
                new Person("Петр", 19),
                new Person("Павел", 20),
                new Person("Сергей", 26),
                new Person("Сергей", 35),
                new Person("Александр", 29),
                new Person("Александр", 27),
                new Person("Алексей", 46),
                new Person("Николай", 37)));

        System.out.println("А) получить список уникальных имен");
        Stream<String> stream = persons.stream()
                .map(Person::getName)
                .distinct();

        System.out.println("Б) вывести список уникальных имен в формате: Имена: Иван, Сергей, Петр.");
        System.out.println(stream.collect(Collectors.joining(", ", "Names: ", ".")));

        System.out.println();
        System.out.println("В) получить список людей младше 18, посчитать для них средний возраст.");
        System.out.println("Средний возраст лиц младше 18 - " + persons.stream()
                .filter(person -> person.getAge() < 18)
                .mapToDouble(Person::getAge)
                .average()
                .orElse(0));

        System.out.println();
        System.out.println("Г) при помощи группировки получить Map, в котором ключи – имена, а значения – средний возраст.");
        Map<String, Double> age = persons.stream()
                .collect(Collectors.groupingBy(Person::getName, Collectors.averagingDouble(Person::getAge)));
        age.forEach((person, p) -> System.out.printf("%s: %s %n", person, p));

        System.out.println();
        System.out.println("Д) получить людей, возраст которых от 20 до 45, вывести в консоль их имена в порядке убывания возраста");
        System.out.println(persons.stream()
                .filter(person -> person.getAge() >= 20 && person.getAge() <= 45)
                .sorted((o1, o2) -> o2.getAge() - o1.getAge())
                .map(Person::getName)
                .collect(Collectors.joining(" старше чем ")));

        System.out.println();
        System.out.println("E) создать бесконечный поток корней чисел." + System.lineSeparator() + "С консоли прочитать число – сколько элементов нужно вычислить, затем – распечатать эти элементы");
        System.out.println("Введите колличество корней");
        DoubleStream squares = DoubleStream.iterate(0, x -> x + 1)
                .map(Math::sqrt)
                .limit(new Scanner(System.in)
                        .nextInt());
        squares.forEach(System.out::println);

        System.out.println();
        System.out.println("Ж)Попробовать реализовать бесконечный поток чисел Фиббоначчи");
        System.out.println("Введите сколько вывести чисел фибоначи: ");
        LongStream fibonacci = LongStream.iterate(0, x -> x + 1)
                .map(x -> (long) (Math.pow((((Math.sqrt(5)) + 1) / 2), x) / Math.sqrt(5) + 0.5))
                .limit(new Scanner(System.in).nextInt());
        fibonacci.forEach(System.out::println);
    }
}
