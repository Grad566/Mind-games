package hexlet.code.games;

import hexlet.code.Engine;

public class Calc {
    // запускаем саму игру и привественное сообщение
    public static void playCalcGame() {
        var victory = true;
        final int countMathSigns = 3;
        final int maxNumberGenerated = 500;

        Engine.cheers();

        System.out.println("What is the result of the expression?");

        // выводим пользователю выражение и проверяем его ответ
        // если ответ ложный, прекращаем игру и выводим сообщение о проигрыше
        // повторяем трижды, либо до победы, либо до 1-го неправильного ответа
        for (var i = 0; i < Engine.getCountOfQuestions(); i++) {

            if (!victory) {
                break;
            }

            var mathSign = getMathSign(Engine.getRandomNumber(countMathSigns));
            var firstNumber = Engine.getRandomNumber(maxNumberGenerated);
            var secondNumber = Engine.getRandomNumber(maxNumberGenerated);
            var correctAnswer = getExpressionResult(firstNumber, secondNumber, mathSign);

            System.out.println("Question: "
                        + firstNumber
                        + " "
                        + mathSign
                        + " "
                        + secondNumber);

            victory = Engine.checkAnswer(correctAnswer);

        }

        // проверяме условие победы
        // выводим сообещние, если условие true
        Engine.checkVictory(victory);

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
