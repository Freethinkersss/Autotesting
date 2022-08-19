/*Написать программу, вычисляющую среднее арифметическое чисел из некоторого диапазона чисел.
Концы диапазона задать переменными, начальное число берите > 1, чтобы было посложнее.
В этом же классе - найти среднее арифметическое только четных чисел из этого диапазона чисел.*/

import java.util.Scanner;

public class Average {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите первое число (1 <= Х <= 1000): ");

        int firstNumber = scanner.nextInt();

        while (firstNumber < 1 || firstNumber > 1000) {
            System.out.println("Вы ввели некорректное число, попробуйте снова :");
            firstNumber = scanner.nextInt();
        }

        System.out.println("Вы ввели число: " + firstNumber);

        System.out.println("Введите второе число (X < Y <= 1000): ");
        int secondNumber = scanner.nextInt();

        while (secondNumber <= firstNumber || secondNumber > 1000) {
            System.out.println("Вы ввели некорректное число, попробуйте снова :");
            secondNumber = scanner.nextInt();
        }

        System.out.println("Вы ввели число: " + secondNumber);

        int sum = 0;
        int sumEven = 0;
        int amountNumbers = 0;
        int amountOfEvenNumbers = 0;

        for (int i = firstNumber; i <= secondNumber; i++) {
            sum = sum + i;
            amountNumbers++;
            if (i % 2 == 0) {
                sumEven = sumEven + i;
                amountOfEvenNumbers++;
            }
        }

        double average = (double) sum / amountNumbers;
        double averageEven = (double) sumEven / amountOfEvenNumbers;

        System.out.println("Среднее арифметическое чисел диапазона = " + average);
        System.out.println("Среднее арифметическое чётных чисел диапазона = " + averageEven);


    }
}