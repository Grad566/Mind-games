package hexlet.code.games;

import hexlet.code.Engine;

public class GCD {
    // выводим привественное сообщение
    // запускаем игру
    public static void playGCD() {
        final int maxNumberGenerated = 200;

        Engine.cheers();

        System.out.println("Find the greatest common divisor of given numbers.");

        String[][] questionsAndAnswers = new String[Engine.getCountOfQuestions()][2];

        // генерируем массив из вопросов и ответов
        for (var i = 0; i < Engine.getCountOfQuestions(); i++) {
            var firstNumber = Engine.getRandomNumber(maxNumberGenerated);
            var secondNumber = Engine.getRandomNumber(maxNumberGenerated);
            var correctAnswer = getGCD(firstNumber, secondNumber);

            questionsAndAnswers[i][0] = String.valueOf(firstNumber) + " "
                        + String.valueOf(secondNumber);
            questionsAndAnswers[i][1] = correctAnswer;
        }
        Engine.playGame(questionsAndAnswers);
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
}
