package hexlet.code;

import java.util.Scanner;

public class Cli {
    // Вызываем приветсвие
    public static String cheers() {
        System.out.println("Welcome to the Brain Games!");
        System.out.println("May I have your name?");

        Scanner scanner = new Scanner(System.in);
        var userName = scanner.next();

        System.out.println("Hello, " + userName + "!");

        return userName;
    }
}
