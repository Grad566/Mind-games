package hexlet.code.games;

import hexlet.code.Engine;

public class Progression {

    public static void playProgression() {
        var victory = true;

        Engine.cheers();

        System.out.println("What number is missing in the progression?");

        for (var i = 0; i < 3; i++) {

            if (!victory) {
                break;
            }

            var step = Engine.getRandomNumber(8);
            String[] randomArray = getRandomArray(step);
            var correctAnswer = getCorrectAnswer(randomArray, step);
            String arrayAsString = String.join(" ", randomArray);

            System.out.println("Question: "
                    + arrayAsString);

            victory = Engine.checkAnswer(correctAnswer);

        }

        Engine.checkVictory(victory);
    }

    public static String[] getRandomArray(int step) {
        var initialNumber = Engine.getRandomNumber(100);
        var minLength = 5;
        String[] arrayNumber = new String[Engine.getRandomNumber(10) + minLength];
        var arrayLength = arrayNumber.length;

        for (var i = 0; i < arrayLength; i++) {
            arrayNumber[i] = String.valueOf(initialNumber);
            initialNumber += step;
        }

        arrayNumber[Engine.getRandomNumber(arrayLength) - 1] = "..";

        return  arrayNumber;
    }

    public static String getCorrectAnswer(String[] arrayNumber, int step) {
        var correctAnswer = 0;

        for (var i = 0; i < arrayNumber.length; i++) {
            if (arrayNumber[i].equals("..")) {
                if (i > 0) {
                    correctAnswer = Integer.parseInt(arrayNumber[i - 1]) + step;
                } else {
                    correctAnswer = Integer.parseInt(arrayNumber[i + 1]) - step;
                }
            }
        }

        return String.valueOf(correctAnswer);
    }
}
