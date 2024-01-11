package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public class EvenGame {
    // запускает саму игру и привественное сообщение
    public static void playEvenGame() {
        var victory = true;

        System.out.println("Welcome to the Brain Games!");
        System.out.println("May I have your name?");
        var userName = Engine.getName();
        System.out.println("Hello, " + userName + "!");

        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        // выводим пользователю число
        for (var i = 0; i < 3; i++) {
            var number = Engine.getRandomNumber();
            var even = checkEvenRandomNumber(number);

            System.out.println("Question: " + number);

            var answer = Engine.getAnswer();

            victory = Engine.checkAnswer(even, answer);

            if (!victory) {
                System.out.println("Your answer: " + answer);
                System.out.println("\'"
                        + answer
                        + "\'"
                        + " is wrong answer ;(. Correct answer was "
                        + "\'"
                        + even
                        + '\'');
                System.out.println("Let's try again, " + userName + "!");
            }

        }

        if (victory) {
            System.out.println("Congratulations, " + userName + "!");
        }

    }

    // определяем четность числа
    public static String checkEvenRandomNumber(int number) {
        if (number % 2 == 0) {
            return "yes";
        } else {
            return "no";
        }
    }

}
