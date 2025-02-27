package solve;

import java.util.Scanner;

public class PasswordChecker {
    public static void checkPassword(String password){
        if (password.length() < 12 || password.length() > 32){
            System.out.println("\"Пароль не соответствует требованиям!\"");
        }
        if (Character.isLowerCase(password.charAt(0))){
            System.out.println("\"Пароль не соответствует требованиям!\"");
        }
        if ()

    }



    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите пароль: ");
        String password = scan.nextLine();


        if (password.isEmpty()){
            System.out.println("\"Пароль не соответствует требованиям!\"");
        } else {
            checkPassword(password);
        }

        scan.close();
    }
}
