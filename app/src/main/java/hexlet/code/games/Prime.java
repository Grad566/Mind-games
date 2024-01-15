package hexlet.code.games;

import hexlet.code.Engine;

public class Prime {
    // запускает саму игру и привественное сообщение
    public static void playPrime() {
        final int maxRandomNumber = 200;

        Engine.cheers();

        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");

        String[][] QuestionsAndAnswers = new String[Engine.getCountOfQuestions()][2];

        for (var i = 0; i < Engine.getCountOfQuestions(); i++) {
            var randomNumber = Engine.getRandomNumber(maxRandomNumber);
            var correctAnswer = getCorrectAnswer(randomNumber);

            QuestionsAndAnswers[i][0] = String.valueOf(randomNumber);
            QuestionsAndAnswers[i][1] = correctAnswer;
        }
        Engine.playGame(QuestionsAndAnswers);
    }

    // получаем правильный ответ (простое число или нет)
    public static String getCorrectAnswer(int number) {

        for (var i = 2; i <= (number / 2); i++) {
            if (number % i == 0) {
                return "no";
            }
        }

        return "yes";
    }
}
