package HW;

import java.util.Random;
import java.util.Scanner;

public class Lesson3 {
    public static char[][] map;
    public static int getSizeMapX = 3;
    public static int getSizeMapY = 3;
    //  public static int pointWin = 4;
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
        if (isValidCell(y, x) && isEmpty(y, x)) {
            map[x][y] = firstChar;
        }
    }

    public static void secondPlayer() {
        int x;
        int y;
        do {
            x = random.nextInt(getSizeMapX);
            y = random.nextInt(getSizeMapY);

        } while (!isEmpty(y, x));
        if (isValidCell(y, x) && isEmpty(y, x)) {
            map[x][y] = secondChar;
        }
    }

    public static boolean isEmpty(int y, int x) {
        return map[y][x] == emptyChar;
    }

    public static boolean isValidCell(int y, int x) {
        return x >= 0 && x < getSizeMapX && y >= 0 && y < getSizeMapY;
    }

    //    public static boolean checkWinPoint(int[] line, char playerChar) {
//        int checkPoint = 0;
//        for (int i = 0; i < line.length; i++) {
//            if (checkPoint < pointWin) {
//                if (line[i] == playerChar) {
//                    checkPoint += 1;
//                } else {
//                    checkPoint *= 0;
//                }
//            } else {
//                return true;
//            }
//        }
//        return false;
//    }
//
//
//    public static boolean checkWin(char playerChar) {
//        int[] line = new int[getSizeMapY + getSizeMapX];
//        for (int y = 0; y < getSizeMapX; y++) {
//            for (int x = 0; x < getSizeMapY; x++) {
//                line[x] = emptyChar;
//                line[x] = map[y][x];
//            }
//            if (checkWinPoint(line, playerChar)) return true;
//        }
//        for (int y = 0; y < getSizeMapX; y++) {
//            for (int x = 0; x < getSizeMapY; x++) {
//                line[x] = emptyChar;
//                line[x] = map[x][y];
//            }
//            if (checkWinPoint(line, playerChar)) return true;
//        }
//        for (int y = 0; y < getSizeMapX; y++) {
//            for (int x = 0; x < getSizeMapY; x++) {
//                line[x] = emptyChar;
//                line[x] = map[x][x];
//            }
//            if (checkWinPoint(line, playerChar)) return true;
//        }
//        for (int y = 0; y < getSizeMapX; y++) {
//            for (int x = 0; x < getSizeMapY; x++) {
//                line[x] = emptyChar;
//                line[x] = map[x][ getSizeMapX-x-1];
//            }
//            if (checkWinPoint(line, playerChar)) return true;
//        }
//        for (int i = 0; i < getSizeMapX - pointWin; i++) {
//            for (int y = 0; y < getSizeMapX; y++) {
//                for (int x = 0; x < getSizeMapY; x++) {
//                    line[x] = emptyChar;
//                    while (getSizeMapX > (x + getSizeMapX - pointWin)) line[x] = map[x][x + getSizeMapX - pointWin];
//                }
//                if (checkWinPoint(line, playerChar)) return true;
//            }
//        }
//        for (int i = 0; i < getSizeMapX - pointWin; i++) {
//            for (int y = 0; y < getSizeMapX; y++) {
//                for (int x = 0; x < getSizeMapY; x++) {
//                    line[x] = emptyChar;
//                    while (getSizeMapX > (x - getSizeMapX + pointWin)) line[x] = map[x][x - getSizeMapX + pointWin];
//                }
//                if (checkWinPoint(line, playerChar)) return true;
//            }
//        }
//        for (int i = 0; i < getSizeMapX - pointWin; i++) {
//            for (int y = 0; y < getSizeMapX; y++) {
//                for (int x = 0; x < getSizeMapY; x++) {
//                    line[x] = emptyChar;
//                    while (getSizeMapX > (x + getSizeMapX - pointWin)) line[x] = map[x + getSizeMapX - pointWin][x];
//                }
//                if (checkWinPoint(line, playerChar)) return true;
//            }
//        }
//        for (int i = 0; i < getSizeMapX - pointWin; i++) {
//            for (int y = 0; y < getSizeMapX; y++) {
//                for (int x = 0; x < getSizeMapY; x++) {
//                    line[x] = emptyChar;
//                    while (getSizeMapX > (x - getSizeMapX + pointWin)) line[x] = map[x - getSizeMapX + pointWin][x];
//                }
//                if (checkWinPoint(line, playerChar)) return true;
//            }
//        }
//        return false;
//    }
    public static boolean checkWin(char playerChar) {
        if (map[0][0] == playerChar && map[1][0] == playerChar && map[2][0] == playerChar) return true;
        if (map[0][1] == playerChar && map[1][1] == playerChar && map[2][1] == playerChar) return true;
        if (map[0][2] == playerChar && map[1][2] == playerChar && map[2][2] == playerChar) return true;

        if (map[0][0] == playerChar && map[0][1] == playerChar && map[0][2] == playerChar) return true;
        if (map[1][0] == playerChar && map[1][1] == playerChar && map[1][2] == playerChar) return true;
        if (map[2][0] == playerChar && map[2][1] == playerChar && map[2][2] == playerChar) return true;

        if (map[0][0] == playerChar && map[1][1] == playerChar && map[2][2] == playerChar) return true;
        if (map[0][2] == playerChar && map[1][1] == playerChar && map[2][0] == playerChar) return true;
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
