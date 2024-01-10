package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public class EvenGame {
    // запускает саму игру и привественное сообщение
    public static void playEvenGame() {
        var victory = true;

        System.out.println("Welcome to the Brain Games!");
        System.out.println("May I have your name?");
        var userName = Greeting.getName();
        System.out.println("Hello, " + userName + "!");

        // выводим пользователю число
        // проверяме его ответ
        // повторяем 3 раза
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
        for (var i = 0; i < 3; i++) {
            var number = getRandomNumber();
            var even = checkEvenRandomNumber(number);

            System.out.println("Question: " + number);

            var answer = getAnswer();

            if (even.equalsIgnoreCase(answer)) {
                System.out.println("Your answer: " + answer);
                System.out.println("Correct!");
            } else {
                victory = false;
                System.out.println("Your answer: " + answer);
                System.out.println("\'"
                        + answer
                        + "\'"
                        + " is wrong answer ;(. Correct answer was "
                        + "\'"
                        + even
                        + '\'');
                System.out.println("Let's try again, " + userName + "!");
                break;
            }
        }

        if (victory) {
            System.out.println("Congratulations, " + userName + "!");
        }

    }
    // генерируем рандомное число в диапазоне от 0 до 199999
    public static int getRandomNumber() {
        Random range = new Random();
        int randomNumber = range.nextInt(100000);
        return randomNumber;
    }

    // определяем четность числа
    public static String checkEvenRandomNumber(int number) {
        if (number % 2 == 0) {
            return "yes";
        } else {
            return "no";
        }
    }
    // принимаем ответ от пользователя
    public static String getAnswer() {
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.next();
        return  answer;
    }

}
