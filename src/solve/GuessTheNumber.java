package solve;

import java.util.Scanner;

public class GuessTheNumber {

    private static int getRandomNumber(int start, int end) {
        return (int) (Math.random() * (end - start) + start);
    }


    public static void main(String[] args) {
        int target = getRandomNumber(1,100);
        int attempts = 0;
        final int MAX_ATTEMPS = 10;

        Scanner scan = new Scanner(System.in);



        while (attempts < MAX_ATTEMPS) {
            System.out.println("Введите ваш число: ");
            int guess = scan.nextInt();
            if (guess < 1 || guess > 100){
                System.out.println("Введите число в диапазоне от 1 до 100!!!");
                continue;
            }

            attempts++;



            if (guess < target){
                System.out.println("Загаданное число меньше!");
            } else if (guess > target) {
                System.out.println("Загаданное число больше!");
            }else {
                System.out.println("Поздравляем! Вы угадали число за " + attempts + " попыток!");
                break;
            }
        }

        if (attempts == MAX_ATTEMPS){
            System.out.println("К сожалению, вы не угадали число.Загаданное число было " + target + " .");
        }

        scan.close();
    }
}
