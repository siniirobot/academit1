package ru.academItSchool.gorbunov.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Realization {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new FileInputStream("try.txt"), "windows-1251")) {
            ArrayList<String> lines = new ArrayList<>();
            while (scanner.hasNextLine()) {
                lines.add(scanner.nextLine());
            }
            System.out.println(lines);
        } catch (FileNotFoundException e) {
            System.out.println("Потерялся файл");
        }

        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(0, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16));
        for (int i = 0; i < numbers.size(); ) {
            if (numbers.get(i) % 2 == 0) {
                numbers.remove(i);
                continue;
            }
            ++i;
        }

        System.out.println("Список без четных чисел -" + numbers);

        ArrayList<Integer> sameNumbers = new ArrayList<>(Arrays.asList(1, 1, 2, 2, 3, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 3, 8, 9, 9, 10, 10));
        ArrayList<Integer> copySameNumber = new ArrayList<>();
        for (int e : sameNumbers) {
            if (!copySameNumber.contains(e)) {
                copySameNumber.add(e);
            }
        }
        System.out.println("Изначальный список - " + sameNumbers);
        System.out.println("Новый список без повторений" + copySameNumber);
    }
}
