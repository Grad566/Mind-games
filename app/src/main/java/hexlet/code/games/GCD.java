package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class GCD {
    public static final int ROUNDS_COUNT = 3;
    // запускаем игру
    public static void playGCD() {
        var rule = "Find the greatest common divisor of given numbers.";
        String[][] questionsAndAnswers = new String[ROUNDS_COUNT][2];

        // генерируем массив из вопросов и ответов
        for (var i = 0; i < ROUNDS_COUNT; i++) {
            questionsAndAnswers[i] = generateRoundData();
        }
        Engine.playGame(questionsAndAnswers, rule);
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

    // Генерируем вопрос и ответ на один раунд
    public static String[] generateRoundData() {
        final int maxNumberGenerated = 200;

        String[] roundDate = new String[2];

        var firstNumber = Utils.getRandomNumber(maxNumberGenerated);
        var secondNumber = Utils.getRandomNumber(maxNumberGenerated);
        var correctAnswer = getGCD(firstNumber, secondNumber);

        roundDate[0] = String.valueOf(firstNumber) + " " + String.valueOf(secondNumber);
        roundDate[1] = correctAnswer;

        return roundDate;
    }
}
