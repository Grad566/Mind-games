package hexlet.code;

import java.util.Scanner;

public class Engine {
    public static final int ROUNDS_COUNT = 3;
    // Реализует логику игры
    // Выводим вопрос пользователю
    // Получаем ответ пользователя
    // Сравниваем ответы
    // Выводим сообщение о победе или поражение
    public static void playGame(String[][] questionsAndAnswers, String rules) {
        var victory = true;
        var userName = Cli.cheers();

        System.out.println(rules);

        for (var i = 0; i < ROUNDS_COUNT; i++) {
            if (!victory) {
                break;
            }

            var correctAnswer = questionsAndAnswers[i][1];

            System.out.println("Question: " + questionsAndAnswers[i][0]);

            Scanner scanner = new Scanner(System.in);
            var answer = scanner.next();

            if (correctAnswer.equalsIgnoreCase(answer)) {
                System.out.println("Your answer: " + answer);
                System.out.println("Correct!");
            } else {
                victory = false;
            }

            if (!victory) {
                System.out.printf("Your answer: %s%n", answer);
                System.out.printf("'%s' is wrong answer ;(. Correct answer was '%s'", answer, correctAnswer);
                System.out.println(String.format("Let's try again, %s!", userName));
            }
        }
        if (victory) {
            System.out.println("Congratulations, " + userName + "!");
        }
    }
}

