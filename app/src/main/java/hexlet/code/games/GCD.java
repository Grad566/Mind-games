package hexlet.code.games;

import hexlet.code.Engine;

public class GCD {
    // запускает саму игру и привественное сообщение
    public static void playGCD() {
        var victory = true;

        Engine.cheers();

        System.out.println("Find the greatest common divisor of given numbers");

        // выводим пользователю выражение
        // если ответ ложный, прекращаем игру и выводим сообщение о проигрыше
        // повторяем трижды, либо до победы, либо до 1-го неправильного ответа
        for (var i = 0; i < 3; i++) {

            if (!victory) {
                break;
            }

            var firstNumber = Engine.getRandomNumber(200);
            var secondNumber = Engine.getRandomNumber(200);
            var correctAnswer = getCorrectAnswer(firstNumber, secondNumber);

            System.out.println("Question: "
                    + firstNumber
                    + " "
                    + secondNumber);

            victory = Engine.checkAnswer(correctAnswer);

        }

        // проверяме условие победы
        // выводим сообещние, если условие true
        Engine.checkVictory(victory);
    }

    // получаем правильный результат выражения
    public static String getCorrectAnswer(int firstNumber, int secondNumber) {
        var smallestNumber = Math.min(firstNumber, secondNumber);
        var biggestNumber = Math.max(firstNumber, secondNumber);
        while (smallestNumber != 0) {
            int temp = smallestNumber;
            smallestNumber = biggestNumber % smallestNumber;
            biggestNumber = temp;
        }

        return String.valueOf(biggestNumber);
    }
}
