package hexlet.code;

import java.util.Scanner;

public class Cli {
    public static void cheers() {
        System.out.println("Welcome to the Brain Games!");
        System.out.println("May I have your name?");
        System.out.println("Hello, " + getName() + "!");
    }
    public static String getName() {
        Scanner scanner = new Scanner(System.in);

        String userName = scanner.next();

        scanner.close();

        return userName;
    }

}
