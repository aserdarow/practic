package solve;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GuessTheNumberComp {
    public static void main(String[] args) {

        try (Scanner scan = new Scanner(System.in)) {
            int min = 0;
            int max = 0;
            boolean validInput = false;

            while (!validInput) {
                System.out.println("Введите начало и конец диапазона загаданного числа > ");
                try {
                    min = scan.nextInt();
                    max = scan.nextInt();
                    if (min >= max) {
                        System.out.println("Ошибка! Минимальное значение должно быть меньше максимального.");
                    } else {
                        validInput = true;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Ошибка! Введите два целых числа.");
                    scan.nextLine(); // Очищаем некорректный ввод
                }
            }

            int attempts = 0;
            final int MAX_ATTEMPTS = 7;
            boolean guessed = false;

            while (attempts < MAX_ATTEMPTS && !guessed) {
                int guess = (min + max) / 2;
                System.out.println("Мой вариант: " + guess);
                System.out.println("Введите ответ (больше / меньше / угадал) > ");
                String response = scan.next().toLowerCase();

                if (response.equals("угадал")) {
                    System.out.println("Я угадал! Загаданное число: " + guess + ". Количество попыток: " + attempts);
                    guessed = true;
                } else if (response.equals("больше")) {
                    min = guess + 1;
                    attempts++;
                } else if (response.equals("меньше")) {
                    max = guess - 1;
                    attempts++;
                } else {
                    System.out.println("Ответ может быть: больше, меньше или угадал.");
                    continue;
                }

                if (min > max) {
                    System.out.println("Ошибка! Похоже, вы дали противоречивые ответы.");
                    break;
                }
            }

            if (!guessed) {
                System.out.println("Попытки закончились! Я не смог угадать число.");
            }
        }
    }
}
