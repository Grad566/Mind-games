package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.EvenGames;

import java.util.Scanner;

public class App {
    // метод реализует меню и выбор игры
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet \n2 - Even \n3 - Calc \n0 - Exit ");
        int choice = scanner.nextInt();
        System.out.println("You choice: " + choice);
        System.out.println();

        switch (choice) {
            case 1:
                Engine.cheers();
                break;
            case 2:
                EvenGames.playEvenGame();
                break;
            case 3:
                Calc.playCalcGame();
                break;
            default:
                break;
        }
    }
}
