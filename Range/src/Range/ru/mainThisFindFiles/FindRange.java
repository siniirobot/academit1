package Range.ru.mainThisFindFiles;

import Range.ru.FilesForFindRange.Range;

import java.util.Scanner;


public class FindRange {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите начало диапазона первого отрезка:");
        double firstLineBegan = scanner.nextDouble();

        System.out.println("Введите конец дииапозона первого отрезка:");
        double firstLineEnd = scanner.nextDouble();

        System.out.println("Введите начало диапазона второго отрезка:");
        double secondLineBegan = scanner.nextDouble();

        System.out.println("Введите конец дииапозона второго отрезка:");
        double secondLineEnd = scanner.nextDouble();

        System.out.println("Введите число для проверки диапозона.");
        double inRange = scanner.nextDouble();

        Range range = new Range(firstLineBegan, firstLineEnd);
        Range range2 = new Range(secondLineBegan, secondLineEnd);

        System.out.printf("Числовой диапозон первого отрезка равен: %f %n", range.getLength());

        Range intersection = range.getNewRange(range2);

        if (intersection == null) {
            System.out.print("Нет пересечения");
        } else {
            System.out.print("Пересечение происходит в числах: ");
            System.out.print(intersection);
        }

        Range[] unionRange = range.getUnionRange(range2);

        if (unionRange.length == 2) {
            System.out.printf("%nОбьеденение делает два отрезка:");
            for (Range e : unionRange) {
                System.out.print(e + " ");
            }
        } else {
            System.out.printf("%nОбьеденение делает новый отрезок с диапозонм:");
            for (Range e : unionRange) {
                System.out.print(e);
            }
        }

        Range[] difference = range.getDifference(range2);
        if (difference.length == 0) {
            System.out.printf("%nВторой отрезок больше первого.");
        } else {
            System.out.printf("%nРазность двух отрезков равна:");
            for (Range e : difference) {
                System.out.print(e + " ");
            }
        }

        if (range.isInRange(inRange)) {
            System.out.printf("%nЧисло в диапозоне.");
        } else {
            System.out.printf("%nЧисло вне диапозона.");
        }
    }
}
