package hexlet.code;

import java.util.Scanner;

public class App {
    // метод реализует меню и выбор игры
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet \n2 - Even \n0 - Exit");
        int choice = scanner.nextInt();
        System.out.println("You choice: " + choice);
        System.out.println();

        switch (choice) {
            case 1:
                Greeting.cheers();
            case 2:
                EvenGame.playEvenGame();
            default:
                break;
        }
    }
}
