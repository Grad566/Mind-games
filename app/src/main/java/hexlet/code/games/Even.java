package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Even {
    // запускаем игру
    public static void playEven() {
        final int countOfQuestions = 3;
        var rule = "Answer 'yes' if the number is even, otherwise answer 'no'.";
        String[][] questionsAndAnswers = new String[countOfQuestions][2];

        // генерируем массив из вопросов и ответов
        for (var i = 0; i < countOfQuestions; i++) {
            questionsAndAnswers[i] = generateRoundDate();
        }
        Engine.playGame(questionsAndAnswers, rule);
    }

    // проверяем четность числа
    public static String checkEvenRandomNumber(int number) {
        if (number % 2 == 0) {
            return "yes";
        } else {
            return "no";
        }
    }

    // Генерируем вопрос и ответ на один раунд
    public static String[] generateRoundDate() {
        String[] roundDate = new String[2];

        var number = Utils.getRandomNumber();
        var correctAnswer = checkEvenRandomNumber(number);

        roundDate[0] = String.valueOf(number);
        roundDate[1] = correctAnswer;

        return roundDate;
    }
}
