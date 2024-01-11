package hexlet.code.games;

import hexlet.code.Engine;

public class Calc {
    // запускаем саму игру и привественное сообщение
    public static void playCalcGame() {
        var victory = true;

        Engine.cheers();

        System.out.println("What is the result of the expression?");

        // выводим пользователю выражение и проверяем его ответ
        for (var i = 0; i < 3; i++) {
            var mathSign = getMathSign(Engine.getRandomNumber(3));
            var firstNumber = Engine.getRandomNumber(500);
            var secondNumber = Engine.getRandomNumber(500);
            var correctAnswer = expressionResult(firstNumber, secondNumber, mathSign);

            System.out.println("Question: "
                        + firstNumber
                        + " "
                        + mathSign
                        + " "
                        + secondNumber);

            var answer = Engine.getAnswer();

            victory = Engine.checkAnswer(correctAnswer, answer);

            if (!victory) {
                System.out.println("Your answer: " + answer);
                System.out.println("\'"
                        + answer
                        + "\'"
                        + " is wrong answer ;(. Correct answer was "
                        + "\'"
                        + correctAnswer
                        + '\'');
                System.out.println("Let's try again, " + Engine.getName() + "!");
                break;
            }

        }

        // проверяем условие победы в игре
        if (victory) {
            System.out.println("Congratulations, " + Engine.getName() + "!");
        }

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
    public static String expressionResult(int firstNumber, int secondNumber, String sign) {
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
