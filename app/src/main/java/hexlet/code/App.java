package hexlet.code;

import hexlet.code.games.Even;
import hexlet.code.games.GCD;
import hexlet.code.games.Calc;
import hexlet.code.games.Prime;
import hexlet.code.games.Progression;

import java.util.Scanner;

public class App {
    // метод реализует меню
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet \n2 - Even \n3 - Calc \n4 - GCD "
                    + "\n5 - Progression "
                    + "\n6 - Prime "
                    + "\n0 - Exit");

        startGame();
    }

    // Принимаем ответ
    // запускам выбранную игру
    public static void startGame() {
        Scanner scanner = new Scanner(System.in);
        var choice = scanner.next();
        System.out.println("You choice: " + choice);
        System.out.println();

        switch (choice) {
            case "1" -> Cli.cheers();
            case "2" -> Even.playEven();
            case "3" -> Calc.playCalcGame();
            case "4" -> GCD.playGCD();
            case "5" -> Progression.playProgression();
            case "6" -> Prime.playPrime();
            default -> {
                break;
            }
        }
    }
}
