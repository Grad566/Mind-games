package hexlet.code.games;

import hexlet.code.Engine;

public class Calc {
    // выводим привественное сообщение
    // запускаем игру
    public static void playCalcGame() {
        final int countMathSigns = 3;
        final int maxNumberGenerated = 500;

        Engine.cheers();

        System.out.println("What is the result of the expression?");

        String[][] questionsAndAnswers = new String[Engine.getCountOfQuestions()][2];

        // генерируем массив из вопросов и ответов
        for (var i = 0; i < Engine.getCountOfQuestions(); i++) {
            var mathSign = Engine.getMathSign(Engine.getRandomNumber(countMathSigns));
            var firstNumber = Engine.getRandomNumber(maxNumberGenerated);
            var secondNumber = Engine.getRandomNumber(maxNumberGenerated);
            var correctAnswer = Engine.getExpressionResult(firstNumber, secondNumber, mathSign);

            questionsAndAnswers[i][0] = firstNumber + " " + mathSign + " " + secondNumber;
            questionsAndAnswers[i][1] = correctAnswer;
        }
        Engine.playGame(questionsAndAnswers);
    }
}
