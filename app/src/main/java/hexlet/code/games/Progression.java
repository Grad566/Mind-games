package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Progression {
    public static final int MAX_STEP_PROGRESSION = 8;
    public static final int MAX_INITIAL_NUMBER = 100;
    public static final int MIN_PROGRESSION_LENGTH = 5;
    public static final int AVERAGE_PROGRESSION_LENGTH = 10;
    public static final String RULE = "What number is missing in the progression?";
    // запускаем игру
    public static void playProgression() {
        String[][] questionsAndAnswers = new String[Engine.ROUNDS_COUNT][2];

        // генерируем массив из вопросов и ответов
        for (var i = 0; i < Engine.ROUNDS_COUNT; i++) {
            questionsAndAnswers[i] = generateRoundData();
        }
        Engine.playGame(questionsAndAnswers, RULE);
    }

    // получаем массив с ариф. прогрессией
    public static String[] getProgression(int step, int initialNumber, int progressionLength) {
        String[] arrayNumbers = new String[progressionLength];
        var arrayLength = arrayNumbers.length;

        for (var i = 0; i < arrayLength; i++) {
            arrayNumbers[i] = String.valueOf(initialNumber);
            initialNumber += step;
        }
        return arrayNumbers;
    }

    // Генерируем вопрос и ответ на один раунд
    public static String[] generateRoundData() {
        // получаем случайный массив с арифм. прогр.
        var step = Utils.getRandomNumber(MAX_STEP_PROGRESSION);
        var initialNumber = Utils.getRandomNumber(MAX_INITIAL_NUMBER);
        var progressionLength = Utils.getRandomNumber(AVERAGE_PROGRESSION_LENGTH)
                    + MIN_PROGRESSION_LENGTH;
        String[] randomArray = getProgression(step, initialNumber, progressionLength);
        // получаем номер элемента для замены
        var randomIndex = Utils.getRandomNumber(randomArray.length - 1);
        // записываем верный ответ
        var correctAnswer = randomArray[randomIndex];
        // получаем массив, который покажем пользователю
        randomArray[randomIndex] = "..";
        String arrayAsString = String.join(" ", randomArray);

        return new String[]{arrayAsString, correctAnswer};
    }
}
