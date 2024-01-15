package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public class Engine {
    private static String userName;
    Engine(String inputUserName) {
        Engine.userName = inputUserName;
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
        final int maxGeneratedNumber = 100000;

        return range.nextInt(maxGeneratedNumber);
    }

    // сравниваем ответ пользователя с правильным ответов
    // если ответ верный, выводим сообщение об этом
    public static boolean compareAnswers(String correctAnswer, String userAnswer) {
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

    // проверяем победил ли пользователь
    // если да, выводим сообщение об этом
    public static void checkVictory(boolean victory) {
        if (victory) {
            System.out.println("Congratulations, " + Engine.getName() + "!");
        }
    }

    // проверяме ответ пользователя
    // если ответ ложный, выводим сообщение об этом
    public static boolean checkAnswer(String correctAnswer) {
        var answer = Engine.getAnswer();
        var victory = true;

        victory = Engine.compareAnswers(correctAnswer, answer);

        if (!victory) {
            System.out.println("Your answer: " + answer);
            System.out.println("\'"
                    + answer
                    + "\'"
                    + " is wrong answer ;(. Correct answer was "
                    + "\'"
                    + correctAnswer
                    + '\'');
            System.out.println("Let's try again, " + Engine.getName() + "!");
            return victory;
        }
        return victory;
    }

    public static int getCountOfQuestions() {
        final int countOfQuestions = 3;
        return countOfQuestions;
    }

    public static void playGame(String[][] QuestionsAndAnswers) {
        var victory = true;

        for (var i = 0; i < getCountOfQuestions(); i++) {
            if (!victory) {
                break;
            }

            System.out.println("Question: " + QuestionsAndAnswers[i][0]);

            victory = Engine.checkAnswer(QuestionsAndAnswers[i][1]);
        }
        Engine.checkVictory(victory);
    }

}

