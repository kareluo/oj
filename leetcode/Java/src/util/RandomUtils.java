package util;

import java.util.Random;

public class RandomUtils {

    public static int[][] random(
            int minRows, int maxRows,
            int minCols, int maxCols,
            int minValue, int maxValue
    ) {
        Random random = new Random();
        int[][] values = new int[random.nextInt(maxRows - minRows + 1) + minRows][random.nextInt(maxCols - minCols + 1) + minCols];

        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values[i].length; j++) {
                values[i][j] = random.nextInt(maxValue - minValue + 1) + minValue;
            }
        }

        return values;
    }

    public static String random(Random random, int minLength, int maxLength) {
        StringBuilder sb = new StringBuilder();
        int len = random.nextInt(maxLength - minLength + 1) + minLength;
        for (int i = 0; i < len; i++) {
            sb.append((char) ('a' + random.nextInt(26)));
        }
        return sb.toString();
    }

    public static int[] random(Random random, int min, int max, int len) {
        int[] nums = new int[len];
        for (int i = 0; i < len; i++) {
            nums[i] = random.nextInt(max - min + 1) + min;
        }
        return nums;
    }

    public static char[][] randomChars(Random random, int rows, int cols) {
        char[][] grid = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = random.nextInt(10) < 3 ? '1' : '0';
            }
        }

        return grid;
    }
}
