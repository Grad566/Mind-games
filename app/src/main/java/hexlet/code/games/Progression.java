package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Progression {
    public static final int ROUNDS_COUNT = 3;
    public static final int MAX_STEP_PROGRESSION = 8;
    public static final int MAX_INITIAL_NUMBER = 100;
    public static final int MIN_PROGRESSION_LENGTH = 5;
    public static final int AVERAGE_PROGRESSION_LENGTH = 10;
    // запускаем игру
    public static void playProgression() {
        var rule = "What number is missing in the progression?";
        String[][] questionsAndAnswers = new String[ROUNDS_COUNT][2];

        // генерируем массив из вопросов и ответов
        for (var i = 0; i < ROUNDS_COUNT; i++) {
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
    public static String[] getRandomArray(int step, int initialNumber, int progressionLength) {
        String[] arrayNumbers = new String[progressionLength];
        var arrayLength = arrayNumbers.length;

        for (var i = 0; i < arrayLength; i++) {
            arrayNumbers[i] = String.valueOf(initialNumber);
            initialNumber += step;
        }
        return arrayNumbers;
    }

    // Генерируем вопрос и ответ на один раунд
    public static String[] generateRoundDate() {
        String[] roundDate = new String[2];

        // получаем случайный массив с арифм. прогр.
        var step = Utils.getRandomNumber(MAX_STEP_PROGRESSION);
        var initialNumber = Utils.getRandomNumber(MAX_INITIAL_NUMBER);
        var progressionLength = Utils.getRandomNumber(AVERAGE_PROGRESSION_LENGTH)
                    + MIN_PROGRESSION_LENGTH;
        String[] randomArray = getRandomArray(step, initialNumber, progressionLength);
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
