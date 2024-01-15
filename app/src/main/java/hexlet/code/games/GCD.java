package hexlet.code.games;

import hexlet.code.Engine;

public class GCD {
    // запускает саму игру и привественное сообщение
    public static void playGCD() {
        final int maxNumberGenerated = 200;

        Engine.cheers();

        System.out.println("Find the greatest common divisor of given numbers.");

        String[][] QuestionsAndAnswers = new String[Engine.getCountOfQuestions()][2];

        for (var i = 0; i < Engine.getCountOfQuestions(); i++) {
            var firstNumber = Engine.getRandomNumber(maxNumberGenerated);
            var secondNumber = Engine.getRandomNumber(maxNumberGenerated);
            var correctAnswer = getCorrectAnswer(firstNumber, secondNumber);

            QuestionsAndAnswers[i][0] = String.valueOf(firstNumber) + " "
                        + String.valueOf(secondNumber);
            QuestionsAndAnswers[i][1] = correctAnswer;
        }
        Engine.playGame(QuestionsAndAnswers);
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
