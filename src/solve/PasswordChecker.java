package solve;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PasswordChecker {
    private static boolean isLatinUpperCase(char ch) {
        return ch >= 'A' && ch <= 'Z';
    }

    private static boolean isLatinLetter(char ch) {
        return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z');
    }

    private static boolean isUnderscore(char ch) {
        return ch == '_';
    }

    private static boolean lastCharLetterOrDigit(char ch) {
        return isLatinLetter(ch) || Character.isDigit(ch);
    }

    private static boolean isCorrectLength(String password) {
        int minPasswordLength = 12;
        int maxPasswordLength = 32;

        return password.length() >= minPasswordLength && password.length() <= maxPasswordLength;
    }

    private static boolean isCorrectChars(String password) {
        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);
            if (!(isLatinLetter(ch) || Character.isDigit(ch) || isUnderscore(ch))) {
                return false;
            }
        }
        return true;
    }

    public static void checkPassword(String password) {
        boolean flag = true;

        if (!isCorrectLength(password)) {
            System.out.println("\"Длина пороля должно не меньше 12 и не больше 32!\"");
            flag = false;
        }
        if (!isLatinUpperCase(password.charAt(0))) {
            System.out.println("\"Пароль должен начинаться с заглавной буĸвы.!\"");
            flag = false;
        }
        if (!lastCharLetterOrDigit(password.charAt(password.length() - 1))) {
            System.out.println("\"Пароль должен заĸанчиваться тольĸо латинсĸой буĸвой или цифрой!\"");
            flag = false;
        }
        if (!isCorrectChars(password)) {
            System.out.println(
                    "Пароль должен состоять тольĸо из латинсĸих буĸв, цифр " +
                            "и символа нижнего подчёрĸивания! "
            );
            flag = false;
        }

        if (flag) {
            System.out.println("Пароль принят!");
            saveToFile(password);
        }

    }

    private static void saveToFile(String password) {
        try (FileWriter file = new FileWriter("validPasswords.txt", true)) {
            file.write(password + "\n");
        } catch (IOException e) {
            System.out.println("При сохренение файла возникла ошибка: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Введите пароль: ");
        String password = scan.nextLine();

        scan.close();

        if (password.isEmpty()) {
            System.out.println("\"Пароль не может быть пустым!\"");
        } else {
            checkPassword(password);
        }

    }
}
