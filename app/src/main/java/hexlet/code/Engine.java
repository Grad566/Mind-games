package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public class Engine {
    // Реализует логику игры
    // Выводим вопрос пользователю
    // Получаем ответ пользователя
    // Сравниваем ответы
    // Выводим сообщение о победе или поражение
    public static void playGame(String[][] questionsAndAnswers, String rules) {
        var victory = true;

        Cli.cheers();

        System.out.println(rules);

        for (var i = 0; i < Utils.getCountOfQuestions(); i++) {
            if (!victory) {
                break;
            }

            var correctAnswer = questionsAndAnswers[i][1];

            System.out.println("Question: " + questionsAndAnswers[i][0]);

            var answer = Utils.getAnswer();

            if (correctAnswer.equalsIgnoreCase(answer)) {
                System.out.println("Your answer: " + answer);
                System.out.println("Correct!");
            } else {
                victory = false;
            }

            if (!victory) {
                System.out.println("Your answer: " + answer);
                System.out.println("\'"
                        + answer
                        + "\'"
                        + " is wrong answer ;(. Correct answer was "
                        + "\'"
                        + correctAnswer
                        + '\'');
                System.out.println("Let's try again, " + Utils.getName() + "!");
            }
        }
        if (victory) {
            System.out.println("Congratulations, " + Utils.getName() + "!");
        }
    }
}

