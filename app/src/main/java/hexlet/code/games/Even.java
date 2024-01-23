package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Even {
    public static final String RULE = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    // запускаем игру
    public static void playEven() {
        String[][] questionsAndAnswers = new String[Engine.ROUNDS_COUNT][2];

        // генерируем массив из вопросов и ответов
        for (var i = 0; i < Engine.ROUNDS_COUNT; i++) {
            questionsAndAnswers[i] = generateRoundData();
        }
        Engine.playGame(questionsAndAnswers, RULE);
    }

    // проверяем четность числа
    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    // Генерируем вопрос и ответ на один раунд
    public static String[] generateRoundData() {
        String[] roundDate = new String[2];
        var number = Utils.getRandomNumber();
        var correctAnswer = isEven(number) ? "yes" : "no";

        return new String[]{String.valueOf(number), correctAnswer};
    }
}
