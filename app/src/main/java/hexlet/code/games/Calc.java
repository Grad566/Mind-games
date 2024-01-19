package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Calc {
    public static final int ROUNDS_COUNT = 3;
    // запускаем игру
    public static void playCalcGame() {
        var rule = "What is the result of the expression?";
        String[][] questionsAndAnswers = new String[ROUNDS_COUNT][2];

        // генерируем массив из вопросов и ответов
        for (var i = 0; i < ROUNDS_COUNT; i++) {
            questionsAndAnswers[i] = generateRoundData();
        }
        Engine.playGame(questionsAndAnswers, rule);
    }

    // получаем случайный математический знак
    public static String getMathSign(int randomNumber) {
        String mathSign = "";
        switch (randomNumber) {
            case 1:
                mathSign = "+";
                break;
            case 2:
                mathSign = "-";
                break;
            default:
                mathSign = "*";
                break;
        }
        return mathSign;
    }

    // получаем результат матем. выражения
    public static String getExpressionResult(int firstNumber, int secondNumber, String sign) {
        return switch (sign) {
            case "+" -> {
                int sum = firstNumber + secondNumber;
                yield String.valueOf(sum);
            }
            case "-" -> {
                int difference = firstNumber - secondNumber;
                yield String.valueOf(difference);
            }
            default -> {
                int product = firstNumber * secondNumber;
                yield String.valueOf(product);
            }
        };
    }

    // Генерируем вопрос и ответ на один раунд
    public static String[] generateRoundData() {
        final int countMathSigns = 3;
        final int maxNumberGenerated = 500;
        String[] roundDate = new String[2];

        var mathSign = getMathSign(Utils.getRandomNumber(countMathSigns));
        var firstNumber = Utils.getRandomNumber(maxNumberGenerated);
        var secondNumber = Utils.getRandomNumber(maxNumberGenerated);
        var correctAnswer = getExpressionResult(firstNumber, secondNumber, mathSign);

        roundDate[0] = firstNumber + " " + mathSign + " " + secondNumber;
        roundDate[1] = correctAnswer;

        return roundDate;
    }
}
