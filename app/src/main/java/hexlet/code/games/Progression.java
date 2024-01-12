package hexlet.code.games;

import hexlet.code.Engine;

public class Progression {
    // запускает саму игру и привественное сообщение
    public static void playProgression() {
        var victory = true;
        final int maxStepProgression = 8;

        Engine.cheers();

        System.out.println("What number is missing in the progression?");
        // выводим пользователю арифметическую прогрессию
        // если ответ ложный, прекращаем игру и выводим сообщение о проигрыше
        // повторяем трижды, либо до победы, либо до 1-го неправильного ответа
        for (var i = 0; i < Engine.getCountOfQuestions(); i++) {

            if (!victory) {
                break;
            }
            // получаем шаг арифметической прогрессии
            var step = Engine.getRandomNumber(maxStepProgression);
            // получаем случайный массив с арифм. прогр.
            String[] randomArray = getRandomArray(step);
            // получаем номер элемента для замены
            var randomIndex = Engine.getRandomNumber(randomArray.length - 1);
            // записываем верный ответ
            var correctAnswer = randomArray[randomIndex];
            // получаем массив, который покажем пользователю
            randomArray = getArrayForUser(randomArray, randomIndex);
            String arrayAsString = String.join(" ", randomArray);

            System.out.println("Question: "
                    + arrayAsString);

            victory = Engine.checkAnswer(correctAnswer);

        }
        // проверяме условие победы
        // выводим сообещние, если условие true
        Engine.checkVictory(victory);
    }

    // получаем массив случайной длины, внутри - случайная арифм. прогрессия
    public static String[] getRandomArray(int step) {
        final int maxInitialNumber = 100;
        var initialNumber = Engine.getRandomNumber(maxInitialNumber);
        final int minLength = 5;
        final int averageArrayLength = 10;
        String[] arrayNumbers = new String[Engine.getRandomNumber(averageArrayLength) + minLength];
        var arrayLength = arrayNumbers.length;

        for (var i = 0; i < arrayLength; i++) {
            arrayNumbers[i] = String.valueOf(initialNumber);
            initialNumber += step;
        }

        return arrayNumbers;
    }

    // меняем один элемент на ".."
    public static String[] getArrayForUser(String[] arrayNumbers, int randomIndex) {
        arrayNumbers[randomIndex] = "..";
        return arrayNumbers;
    }
}
