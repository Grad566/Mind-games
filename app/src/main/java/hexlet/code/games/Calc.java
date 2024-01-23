package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Calc {
    public static final int MAX_NUMBER_GENERATED = 500;
    public static final char[] MATH_SIGNS = {'+', '-', '*'};

    public static final String RULE = "What is the result of the expression?";
    // запускаем игру
    public static void playCalcGame() {
        String[][] questionsAndAnswers = new String[Engine.ROUNDS_COUNT][2];

        // генерируем массив из вопросов и ответов
        for (var i = 0; i < Engine.ROUNDS_COUNT; i++) {
            questionsAndAnswers[i] = generateRoundData();
        }
        Engine.playGame(questionsAndAnswers, RULE);
    }

    // получаем результат матем. выражения
    public static int getExpressionResult(int firstNumber, int secondNumber, char sign) {
        return switch (sign) {
            case '+' -> firstNumber + secondNumber;
            case '-' -> firstNumber - secondNumber;
            case '*' -> firstNumber * secondNumber;
            default -> throw new RuntimeException("Unknown sign!");
        };
    }

    // Генерируем вопрос и ответ на один раунд
    public static String[] generateRoundData() {
        String[] roundDate = new String[2];

        var mathSign = MATH_SIGNS[Utils.getRandomNumber(MATH_SIGNS.length) - 1];
        var firstNumber = Utils.getRandomNumber(MAX_NUMBER_GENERATED);
        var secondNumber = Utils.getRandomNumber(MAX_NUMBER_GENERATED);
        var correctAnswer = String.valueOf(getExpressionResult(firstNumber, secondNumber, mathSign));

        roundDate[0] = firstNumber + " " + mathSign + " " + secondNumber;
        roundDate[1] = correctAnswer;

        return roundDate;
    }
}
