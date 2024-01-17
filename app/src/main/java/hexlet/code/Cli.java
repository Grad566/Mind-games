package hexlet.code;

import java.util.Scanner;

public class Cli {
    private static String userName;

    Cli(String inputUserName) {
        Cli.userName = inputUserName;
    }

    // Вызываем приветсвие
    public static String cheers() {
        System.out.println("Welcome to the Brain Games!");
        System.out.println("May I have your name?");
        if (userName == null) {
            Scanner scanner = new Scanner(System.in);

            userName = scanner.next();
        }
        System.out.println("Hello, " + userName + "!");

        return userName;
    }
}
