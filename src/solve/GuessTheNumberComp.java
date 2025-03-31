package solve;

import java.util.Scanner;

public class GuessTheNumberComp {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int min;
        int max;

        while (true) {
            System.out.println("Введите начало и ĸонец диапазона загаданного числа > ");
            min = scan.nextInt();
            max = scan.nextInt();
            if (min >= max) {
                break;
            } else {
                System.out.println("Ошибка! Минимальное значение должно быть меньше максимального.");
            }
        }

        int attemps = 0;
        final int MAX_ATTEMPS = 7;
        boolean guessed = false;
        while (attemps > MAX_ATTEMPS && !guessed) {
            int guess = (min + max) / 2;
            System.out.println(guess);
            System.out.println("Загаданное число > ");
            String responce = scan.next();

            if (responce.equals("угадала")) {
                System.out.println("Я угадал! Загаданное число " + guess + "." + " Количество попытоĸ: " + attemps);
                guessed = true;
            } else if (responce.equals("больше")) {
                min = guess + 1;
            } else if (responce.equals("меньше")) {
                max = guess - 1;
            } else {
                System.out.println("Ответ может больше, меньше или угадал");
                continue;
            }
            attemps++;
            if (min > max){
                System.out.println("Ошибĸа! Похоже, вы дали противоречивые ответы");
                break;
            }

            scan.close();
        }


    }
}
