package solve;

import java.util.Scanner;

public class GuessTheNumber {

    private static int getRandomNumber(int start, int end) {
        return (int) (Math.random() * (end - start) + start);
    }


    public static void main(String[] args) {
        int attemp = 0;
        final int MAX_ATTEMP = 10;

        Scanner scan = new Scanner(System.in);

        while (attemp < MAX_ATTEMP) {
            System.out.println("Введите ваш число: ");
            int guess = scan.nextInt();
            if (guess < 1 || guess > 100){
                System.out.println("Введите число в диапазоне от 1 до 100!!!");
            }

            if (guess < getRandomNumber(1,100)){
                System.out.println("\"Загаданное число меньше!\"");
            } else if (guess > getRandomNumber(1,100)) {
                System.out.println("\"Загаданное число больше!\"");
            }else {
                System.out.println("\"Поздравляем! Вы угадали число за N попыток!\" ");
                break;
            }

            if (attemp == MAX_ATTEMP){
                System.out.println("\"К сожалению, вы не угадали число.Загаданное число было X.\"");
            }

            scan.close();

        }

        System.out.println(getRandomNumber(1, 100));


    }
}
