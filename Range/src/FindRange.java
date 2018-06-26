import java.util.Scanner;

public class FindRange {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите начало диапазона:");
        double from = scanner.nextDouble();

        System.out.println("Введите конец дииапозона:");
        double to = scanner.nextDouble();

        System.out.println("Введите число для проверки диапозона.");
        double inRange = scanner.nextDouble();

        Range range = new Range(from, to);

        System.out.printf("Числовой диапозон чисел равен %f %n", range.getLength());

        if (range.isInRange(inRange)) {
            System.out.println("Число в диапозоне.");
        } else {
            System.out.println("Число вне диапозонаю");
        }
    }
}
