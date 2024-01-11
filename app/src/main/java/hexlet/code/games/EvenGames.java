package hexlet.code.games;

import hexlet.code.Engine;

public class EvenGames {
    // запускает саму игру и привественное сообщение
    public static void playEvenGame() {
        var victory = true;

        Engine.cheers();

        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        // выводим пользователю число
        for (var i = 0; i < 3; i++) {

            if(!victory) {
                break;
            }

            var number = Engine.getRandomNumber();
            var correctAnswer = checkEvenRandomNumber(number);

            System.out.println("Question: " + number);

            victory = Engine.checkAnswer(correctAnswer);

        }

        Engine.checkVictory(victory);

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
