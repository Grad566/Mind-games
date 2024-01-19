package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Prime {
    public static final int ROUNDS_COUNT = 3;
    // запускаем игру
    public static void playPrime() {
        var rule = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
        String[][] questionsAndAnswers = new String[ROUNDS_COUNT][2];

        // генерируем массив из вопросов и ответов
        for (var i = 0; i < ROUNDS_COUNT; i++) {
            questionsAndAnswers[i] = generateRoundData();
        }
        Engine.playGame(questionsAndAnswers, rule);
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

    // Генерируем вопрос и ответ на один раунд
    public static String[] generateRoundData() {
        final int maxRandomNumber = 200;

        String[] roundDate = new String[2];

        var randomNumber = Utils.getRandomNumber(maxRandomNumber);
        var correctAnswer = checkPrime(randomNumber);

        roundDate[0] = String.valueOf(randomNumber);
        roundDate[1] = correctAnswer;

        return roundDate;
    }
}
