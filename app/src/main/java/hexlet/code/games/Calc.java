package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Calc {
    public static final int ROUNDS_COUNT = 3;
    public static final int COUNT_MATH_SIGNS = 3;
    public static final int MAX_NUMBER_GENERATED = 500;

    public static final String RULE = "What is the result of the expression?";
    // запускаем игру
    public static void playCalcGame() {
        String[][] questionsAndAnswers = new String[ROUNDS_COUNT][2];

        // генерируем массив из вопросов и ответов
        for (var i = 0; i < ROUNDS_COUNT; i++) {
            questionsAndAnswers[i] = generateRoundData();
        }
        Engine.playGame(questionsAndAnswers, RULE);
    }

    // получаем случайный математический знак
    public static char getMathSign(int randomNumber) {
        char[] mathSigns = {'+', '-', '*'};
        return mathSigns[randomNumber];
    }

    // получаем результат матем. выражения
    public static int getExpressionResult(int firstNumber, int secondNumber, char sign) {
        return switch (sign) {
            case '+' -> firstNumber + secondNumber;
            case '-' -> firstNumber - secondNumber;
            default -> firstNumber * secondNumber;
        };
    }

    // Генерируем вопрос и ответ на один раунд
    public static String[] generateRoundData() {
        String[] roundDate = new String[2];

        var mathSign = getMathSign(Utils.getRandomNumber(COUNT_MATH_SIGNS));
        var firstNumber = Utils.getRandomNumber(MAX_NUMBER_GENERATED);
        var secondNumber = Utils.getRandomNumber(MAX_NUMBER_GENERATED);
        var correctAnswer = String.valueOf(getExpressionResult(firstNumber, secondNumber, mathSign));

        roundDate[0] = firstNumber + " " + mathSign + " " + secondNumber;
        roundDate[1] = correctAnswer;

        return roundDate;
    }
}
