package hexlet.code.games;

import hexlet.code.Engine;

public class Calc {
    // запускаем саму игру и привественное сообщение
    public static void playCalcGame() {
        final int countMathSigns = 3;
        final int maxNumberGenerated = 500;

        Engine.cheers();

        System.out.println("What is the result of the expression?");

        String[][] questionsAndAnswers = new String[Engine.getCountOfQuestions()][2];

        for (var i = 0; i < Engine.getCountOfQuestions(); i++) {
            var mathSign = getMathSign(Engine.getRandomNumber(countMathSigns));
            var firstNumber = Engine.getRandomNumber(maxNumberGenerated);
            var secondNumber = Engine.getRandomNumber(maxNumberGenerated);
            var correctAnswer = getExpressionResult(firstNumber, secondNumber, mathSign);

            questionsAndAnswers[i][0] = firstNumber + " " + mathSign + " " + secondNumber;
            questionsAndAnswers[i][1] = correctAnswer;
        }
        Engine.playGame(questionsAndAnswers);
    }

    // получаем случайный оператор
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

    // получаем результат выражения
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
}
