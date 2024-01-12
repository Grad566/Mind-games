package hexlet.code.games;

import hexlet.code.Engine;

public class Even {
    // запускает саму игру и привественное сообщение
    public static void playEven() {
        var victory = true;

        Engine.cheers();

        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        // выводим пользователю число
        // если ответ ложный, прекращаем игру и выводим сообщение о проигрыше
        // повторяем трижды, либо до победы, либо до 1-го неправильного ответа
        for (var i = 0; i < Engine.getCountOfQuestions(); i++) {

            if (!victory) {
                break;
            }

            var number = Engine.getRandomNumber();
            var correctAnswer = checkEvenRandomNumber(number);

            System.out.println("Question: " + number);

            victory = Engine.checkAnswer(correctAnswer);

        }

        // проверяме условие победы
        // выводим сообещние, если условие true
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
