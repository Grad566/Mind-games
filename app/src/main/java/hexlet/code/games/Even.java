package hexlet.code.games;

import hexlet.code.Engine;

public class Even {
    // запускает саму игру и привественное сообщение
    public static void playEven() {
        Engine.cheers();

        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        String[][] questionsAndAnswers = new String[Engine.getCountOfQuestions()][2];

        for (var i = 0; i < Engine.getCountOfQuestions(); i++) {
            var number = Engine.getRandomNumber();
            var correctAnswer = checkEvenRandomNumber(number);

            questionsAndAnswers[i][0] = String.valueOf(number);
            questionsAndAnswers[i][1] = correctAnswer;
        }
        Engine.playGame(questionsAndAnswers);
    }

    // определяем четность числа
    public static String checkEvenRandomNumber(int number) {
        if (number % 2 == 0) {
            return "yes";
        } else {
            return "no";
        }
    }

}
