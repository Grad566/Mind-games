package hexlet.code.games;

import hexlet.code.Engine;

public class Prime {
    // выводим привественное сообщение
    // запускаем игру
    public static void playPrime() {
        final int maxRandomNumber = 200;

        Engine.cheers();

        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");

        String[][] questionsAndAnswers = new String[Engine.getCountOfQuestions()][2];

        // генерируем массив из вопросов и ответов
        for (var i = 0; i < Engine.getCountOfQuestions(); i++) {
            var randomNumber = Engine.getRandomNumber(maxRandomNumber);
            var correctAnswer = checkPrime(randomNumber);

            questionsAndAnswers[i][0] = String.valueOf(randomNumber);
            questionsAndAnswers[i][1] = correctAnswer;
        }
        Engine.playGame(questionsAndAnswers);
    }

    // Проверям простое ли число
    public static String checkPrime(int number) {
        for (var i = 2; i <= (number / 2); i++) {
            if (number % i == 0) {
                return "no";
            }
        }
        return "yes";
    }
}
