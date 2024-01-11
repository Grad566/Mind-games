package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public class Engine {
    private static String userName;
    Engine(String userName) {
        Engine.userName = getName();
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

    // получаем случайно число от 0 до 199999
    public static int getRandomNumber() {
        Random range = new Random();

        return range.nextInt(100000);
    }

    // проверяем ответ пользователя
    public static boolean checkAnswer(String correctAnswer, String userAnswer) {
        if (correctAnswer.equalsIgnoreCase(userAnswer)) {
            System.out.println("Your answer: " + userAnswer);
            System.out.println("Correct!");

            return true;
        } else {
            return false;
        }
    }

    // выводим приветсвенное сообщение
    public static void cheers() {
        System.out.println("Welcome to the Brain Games!");
        System.out.println("May I have your name?");
        System.out.println("Hello, " + getName() + "!");
    }

}

