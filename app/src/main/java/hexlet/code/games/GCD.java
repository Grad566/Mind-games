package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class GCD {
    public static final String RULE = "Find the greatest common divisor of given numbers.";
    // запускаем игру
    public static void playGCD() {
        String[][] questionsAndAnswers = new String[Engine.ROUNDS_COUNT][2];

        // генерируем массив из вопросов и ответов
        for (var i = 0; i < Engine.ROUNDS_COUNT; i++) {
            questionsAndAnswers[i] = generateRoundData();
        }
        Engine.playGame(questionsAndAnswers, RULE);
    }

    // получаем НОД
    public static int getGCD(int firstNumber, int secondNumber) {
        var smallestNumber = Math.min(firstNumber, secondNumber);
        var biggestNumber = Math.max(firstNumber, secondNumber);
        while (smallestNumber != 0) {
            int temp = smallestNumber;
            smallestNumber = biggestNumber % smallestNumber;
            biggestNumber = temp;
        }
        return biggestNumber;
    }

    // Генерируем вопрос и ответ на один раунд
    public static String[] generateRoundData() {
        final int maxNumberGenerated = 200;
        var firstNumber = Utils.getRandomNumber(maxNumberGenerated);
        var secondNumber = Utils.getRandomNumber(maxNumberGenerated);
        var correctAnswer = String.valueOf(getGCD(firstNumber, secondNumber));
        var question = firstNumber + " " + secondNumber;

        return new String[]{question, correctAnswer};
    }
}
