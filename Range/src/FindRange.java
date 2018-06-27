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

        System.out.printf("Числовой диапозон чисел равен %f %n", range.getLength());

        if (range.isInRange(inRange)) {
            System.out.println("Число в диапозоне.");
        } else {
            System.out.println("Число вне диапозонаю");
        }

        double[] intersection = range.getNewRange(firstLineBegan, firstLineEnd, secondLineBegan, secondLineEnd);
        if (intersection == null) {
            System.out.println("Нет пересечения");
        }else {
            System.out.print("Пересечение происходит в числах:");
            for (double e:intersection) {
                System.out.printf(" %f",e);
            }
        }
    }
}
