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

        System.out.printf("Числовой диапозон первого отрезка равен: %f %n", range.getLength());

        double[] intersection = range.getNewRange(secondLineBegan, secondLineEnd);

        if (intersection == null) {
            System.out.print("Нет пересечения");
        } else {
            System.out.print("Пересечение происходит в числах:");
            for (double e : intersection) {
                System.out.printf(" %f", e);
            }
        }

        double[] unionRange = range.getUnionRange(secondLineBegan, secondLineEnd);

        if (unionRange.length == 2) {
            System.out.printf("%nОбьеденение делает новый отрезок с диапозонм:");
            for (double e : unionRange) {
                System.out.printf(" %f", e);
            }
        } else {
            System.out.printf("%nОбьеденение делает два отрезка:");
            for (double e : unionRange) {
                System.out.printf(" %f", e);
            }
        }

        double[] difference = range.getDifference(secondLineBegan, secondLineEnd);
        if (difference.length == 0) {
            System.out.printf("%nВторой оитрезок больше первого.");
        } else {
            System.out.printf("%nРазность двух отрезков равна:");
            for (double e : difference) {
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
