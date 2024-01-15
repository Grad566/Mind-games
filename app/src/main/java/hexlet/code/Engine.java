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

    // возращаем кол-во вопросов для пользовльвотеля
    public static int getCountOfQuestions() {
        final int countOfQuestions = 3;
        return countOfQuestions;
    }

    // Сверяем ответы пользователя с правильными ответами
    // Если правильно выводим победное сообщение
    // Если неправильно, выводим сообщение об ошибке
    public static void playGame(String[][] questionsAndAnswers) {
        var victory = true;

        for (var i = 0; i < getCountOfQuestions(); i++) {
            if (!victory) {
                break;
            }

            System.out.println("Question: " + questionsAndAnswers[i][0]);

            victory = Engine.checkAnswer(questionsAndAnswers[i][1]);
        }
        Engine.checkVictory(victory);
    }

    // получаем результат матем. выражения
    public static String getExpressionResult(int firstNumber, int secondNumber, String sign) {
        return switch (sign) {
            case "+" -> {
                int sum = firstNumber + secondNumber;
                yield String.valueOf(sum);
            }
            case "-" -> {
                int difference = firstNumber - secondNumber;
                yield String.valueOf(difference);
            }
            default -> {
                int product = firstNumber * secondNumber;
                yield String.valueOf(product);
            }
        };
    }

    // получаем случайный математический знак
    public static String getMathSign(int randomNumber) {
        String mathSign = "";
        switch (randomNumber) {
            case 1:
                mathSign = "+";
                break;
            case 2:
                mathSign = "-";
                break;
            default:
                mathSign = "*";
                break;
        }
        return mathSign;
    }

    // проверяем четность числа
    public static String checkEvenRandomNumber(int number) {
        if (number % 2 == 0) {
            return "yes";
        } else {
            return "no";
        }
    }

    // получаем НОД
    public static String getGCD(int firstNumber, int secondNumber) {
        var smallestNumber = Math.min(firstNumber, secondNumber);
        var biggestNumber = Math.max(firstNumber, secondNumber);
        while (smallestNumber != 0) {
            int temp = smallestNumber;
            smallestNumber = biggestNumber % smallestNumber;
            biggestNumber = temp;
        }
        return String.valueOf(biggestNumber);
    }

    // Проверям простое ли число
    public static String checkPrime(int number) {
        for (var i = 2; i <= (number / 2); i++) {
            if (number % i == 0) {
                return "no";
            }
        }
        return "yes";
    }

    // получаем случайный массив с ариф. прогрессией
    public static String[] getRandomArray(int step) {
        final int maxInitialNumber = 100;
        var initialNumber = Engine.getRandomNumber(maxInitialNumber);
        final int minLength = 5;
        final int averageArrayLength = 10;
        String[] arrayNumbers = new String[Engine.getRandomNumber(averageArrayLength) + minLength];
        var arrayLength = arrayNumbers.length;

        for (var i = 0; i < arrayLength; i++) {
            arrayNumbers[i] = String.valueOf(initialNumber);
            initialNumber += step;
        }
        return arrayNumbers;
    }
}

