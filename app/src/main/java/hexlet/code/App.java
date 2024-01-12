package hexlet.code;

import hexlet.code.games.*;

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

    public static void startGame() {
        var choice = Engine.getAnswer();
        System.out.println("You choice: " + choice);
        System.out.println();

        switch (choice) {
            case "1":
                Engine.cheers();
                break;
            case "2":
                EvenGames.playEven();
                break;
            case "3":
                Calc.playCalcGame();
                break;
            case "4":
                GCD.playGCD();
                break;
            case "5":
                Progression.playProgression();
                break;
            case "6":
                Prime.playPrime();
                break;
            default:
                break;
        }
    }
}
