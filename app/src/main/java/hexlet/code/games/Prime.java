package hexlet.code.games;

import hexlet.code.Engine;

public class Prime {
    // запускает саму игру и привественное сообщение
    public static void playPrime() {
        var victory = true;

        Engine.cheers();

        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");

        // выводим пользователю число
        // если ответ ложный, прекращаем игру и выводим сообщение о проигрыше
        // повторяем трижды, либо до победы, либо до 1-го неправильного ответа
        for (var i = 0; i < 3; i++) {

            if (!victory) {
                break;
            }

            var randomNumber = Engine.getRandomNumber(200);
            var correctAnswer = getCorrectAnswer(randomNumber);

            System.out.println("Question: "
                    + randomNumber);

            victory = Engine.checkAnswer(correctAnswer);

        }

        // проверяме условие победы
        // выводим сообещние, если условие true
        Engine.checkVictory(victory);
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
