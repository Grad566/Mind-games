package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public class Utils {
    private static String userName;
    Utils(String inputUserName) {
        Utils.userName = inputUserName;
    }

    // получаем имя пользователя
    public static String getName() {
        if (userName == null) {
            Scanner scanner = new Scanner(System.in);

            userName = scanner.next();
        }
        return userName;
    }

    // получаем ответ пользователя
    public static String getAnswer() {
        Scanner scanner = new Scanner(System.in);

        return scanner.next();
    }

    // получаем случайное число в заданном диапазоне
    public static int getRandomNumber(int max) {
        Random range = new Random();

        return range.nextInt(max) + 1;
    }

    // получаем случайно число от 0 до 99999
    public static int getRandomNumber() {
        final int maxGeneratedNumber = 100000;

        return getRandomNumber(maxGeneratedNumber);
    }

    public static void cheers() {
        System.out.println("Welcome to the Brain Games!");
        System.out.println("May I have your name?");
        System.out.println("Hello, " + getName() + "!");
    }

    // возращаем кол-во вопросов для пользовльвотеля
    public static int getCountOfQuestions() {
        final int countOfQuestions = 3;
        return countOfQuestions;
    }
}
