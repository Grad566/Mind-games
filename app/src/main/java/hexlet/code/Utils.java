package hexlet.code;

import java.util.Random;

public class Utils {
    // получаем случайное число в заданном диапазоне
    public static int getRandomNumber(int max) {
        Random range = new Random();

        return range.nextInt(max) + 1;
    }

    // получаем случайно число от 0 до 99999
    public static int getRandomNumber() {
        final int maxGeneratedNumber = 100000;

        return getRandomNumber(maxGeneratedNumber);
    }
}
