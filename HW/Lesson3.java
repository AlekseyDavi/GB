package HW;

import java.util.Random;
import java.util.Scanner;

public class Lesson3 {
    public static char[][] map;
    public static int getSizeMapX = 5;
    public static int getSizeMapY = 5;
    public static int winPoint = 4;
    public static char firstChar = 'X';
    public static char secondChar = 'O';
    public static char emptyChar = '_';
    public static Random random = new Random();

    public static Scanner scanner = new Scanner(System.in);

    public static void createMap() {
        map = new char[getSizeMapY][getSizeMapX];
        for (int y = 0; y < getSizeMapY; y++) {
            for (int x = 0; x < getSizeMapX; x++) {
                map[y][x] = emptyChar;
            }
        }
    }

    public static void printMap() {
        for (int y = 0; y < getSizeMapY; y++) {
            for (int x = 0; x < getSizeMapX; x++) {
                System.out.print(map[y][x] + " | ");
            }
            System.out.println();
        }
        System.out.println("__________");
    }

    public static void firstPlayer() {
        int x;
        int y;
        do {
            System.out.println("Введите координаты");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!isValidCell(y, x) || !isEmpty(y, x));
        map[y][x] = firstChar;
    }

    public static void secondPlayer() {
        int x;
        int y;
        do {
            x = random.nextInt(getSizeMapX);
            y = random.nextInt(getSizeMapY);

        } while (!isEmpty(y, x));
        if (isValidCell(y, x) || isEmpty(y, x)) {
            map[y][x] = secondChar;
        }
    }

    public static boolean isEmpty(int y, int x) {
        return map[y][x] == emptyChar;
    }

    public static boolean isValidCell(int y, int x) {

        return x >= 0 && x < getSizeMapX && y >= 0 && y < getSizeMapY;
    }

    public static boolean checkWin(char playerChar) {
        return checkWinLine(playerChar) || checkWinDiagonal(playerChar);
    }

    public static boolean checkWinDiagonal(char playerChar) {
        int lineY = 0;
        int lineX = 0;
        for (int i = 0; i < getSizeMapY; i++) {

            for (int y = 0; y < getSizeMapX; y++) {
                if (isValidCell(y, y + i)) {
                    if (map[y][y + i] == playerChar) {
                        lineY += 1;
                    } else {
                        lineY *= 0;
                    }
                    if (lineY == winPoint) {
                        return true;
                    }
                }
            }
            for (int x = 0; x < getSizeMapX; x++) {
                if (isValidCell(x + i, x)) {
                    if (map[x + i][x] == playerChar) {
                        lineX += 1;
                    } else {
                        lineX *= 0;
                    }
                    if (lineX == winPoint) {
                        return true;
                    }
                }
            }
            lineY = 0;
             lineX = 0;
            for (int y = 0; y < getSizeMapX; y++) {
                if (isValidCell(y, getSizeMapY - y - 1 + i)) {
                    if (map[y][getSizeMapY - y - 1 + i] == playerChar) {
                        lineY += 1;
                    } else {
                        lineY *= 0;
                    }
                    if (lineY == winPoint) {
                        return true;
                    }
                }
            }
            for (int x = 0; x < getSizeMapX; x++) {
                if (isValidCell(getSizeMapY - x - 1 + i, x)) {
                    if (map[getSizeMapY - x - 1 + i][x] == playerChar) {
                        lineX += 1;
                    } else {
                        lineX *= 0;
                    }
                    if (lineX == winPoint) {
                        return true;
                    }
                }
            }
        }


        return false;
    }

    public static boolean checkWinLine(char playerChar) {
        for (int y = 0; y < getSizeMapY; y++) {
            int lineX = 0;
            int lineY = 0;
            for (int x = 0; x < getSizeMapX; x++) {
                if (map[y][x] == playerChar) {
                    lineY += 1;
                } else {
                    lineY *= 0;
                }
                if (lineY == winPoint) {
                    return true;
                }
            }
            for (int x = 0; x < getSizeMapX; x++) {

                if (map[y][x] == playerChar) {
                    lineX += 1;
                } else {
                    lineX *= 0;
                }
                if (lineX == winPoint) {
                    return true;
                }
            }

        }
        return false;
    }

    public static boolean isMapFull() {
        for (int y = 0; y < getSizeMapY; y++) {
            for (int x = 0; x < getSizeMapX; x++) {
                if (map[y][x] == emptyChar) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        createMap();
        printMap();
        while (true) {
            firstPlayer();
            printMap();

            if (checkWin(firstChar)) {
                System.out.println("First Player Win");
                break;
            }
            if (isMapFull()) {
                System.out.println("Draw");
                break;
            }

            secondPlayer();
            printMap();
            if (checkWin(secondChar)) {
                System.out.println("Second Player Win");
                break;
            }
            if (isMapFull()) {
                System.out.println("Draw");
                break;
            }
        }
    }


}
