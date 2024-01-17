package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Progression {
    // запускаем игру
    public static void playProgression() {
        final int countOfQuestions = 3;
        var rule = "What number is missing in the progression?";
        String[][] questionsAndAnswers = new String[countOfQuestions][2];

        // генерируем массив из вопросов и ответов
        for (var i = 0; i < countOfQuestions; i++) {
            questionsAndAnswers[i] = generateRoundDate();
        }
        Engine.playGame(questionsAndAnswers, rule);
    }

    // меняем один элемент на ".."
    public static String[] getArrayForUser(String[] arrayNumbers, int randomIndex) {
        arrayNumbers[randomIndex] = "..";
        return arrayNumbers;
    }

    // получаем случайный массив с ариф. прогрессией
    public static String[] getRandomArray(int step) {
        final int maxInitialNumber = 100;
        final int minLength = 5;
        final int averageArrayLength = 10;
        var initialNumber = Utils.getRandomNumber(maxInitialNumber);
        String[] arrayNumbers = new String[Utils.getRandomNumber(averageArrayLength) + minLength];
        var arrayLength = arrayNumbers.length;

        for (var i = 0; i < arrayLength; i++) {
            arrayNumbers[i] = String.valueOf(initialNumber);
            initialNumber += step;
        }
        return arrayNumbers;
    }

    // Генерируем вопрос и ответ на один раунд
    public static String[] generateRoundDate() {
        final int maxStepProgression = 8;

        String[] roundDate = new String[2];

        var step = Utils.getRandomNumber(maxStepProgression);
        // получаем случайный массив с арифм. прогр.
        String[] randomArray = getRandomArray(step);
        // получаем номер элемента для замены
        var randomIndex = Utils.getRandomNumber(randomArray.length - 1);
        // записываем верный ответ
        var correctAnswer = randomArray[randomIndex];
        // получаем массив, который покажем пользователю
        randomArray = getArrayForUser(randomArray, randomIndex);
        String arrayAsString = String.join(" ", randomArray);

        roundDate[0] = arrayAsString;
        roundDate[1] = correctAnswer;

        return roundDate;
    }
}
