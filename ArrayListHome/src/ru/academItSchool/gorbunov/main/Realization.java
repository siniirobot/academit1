package ru.academItSchool.gorbunov.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Realization {
    public static void main(String[] args) throws FileNotFoundException {
        try (Scanner scanner = new Scanner(new FileInputStream("try.txt"), "windows-1251")) {
            ArrayList<String> lines = new ArrayList<>();
            while (scanner.hasNextLine()) {
                lines.add(scanner.nextLine());
            }
            System.out.println(lines);
        }

        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        for (int i = 0; i < numbers.size(); ++i) {
            if (numbers.get(i) % 2 == 0) {
                numbers.remove(i);
            }
        }
        System.out.println(numbers);

        ArrayList<Integer> sameNumbers = new ArrayList<>(Arrays.asList(1, 1, 2, 2, 3, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 3, 8, 9, 9, 10, 10));
        for (int i = 0; i < sameNumbers.size(); ++i) {
            int nextSameNumber = sameNumbers.indexOf(sameNumbers.get(i));
            int lastSameNumber = sameNumbers.lastIndexOf(sameNumbers.get(i));
            while (nextSameNumber != lastSameNumber) {
                sameNumbers.remove(lastSameNumber);
                lastSameNumber = sameNumbers.lastIndexOf(sameNumbers.get(i));
            }
        }
        System.out.println(sameNumbers);
    }
}
