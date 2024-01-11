package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;
import java.util.Scanner;

public class EvenGames {
    // запускает саму игру и привественное сообщение
    public static void playEvenGame() {
        var victory = true;

        Engine.cheers();

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
                System.out.println("Let's try again, " + Engine.getName() + "!");
            }

        }

        if (victory) {
            System.out.println("Congratulations, " + Engine.getName() + "!");
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
