package HW;

public class Lesson2 {
    public static void printArray(int[] massive) {
        for (int i = 0; i < massive.length; i++) {
            System.out.print(massive[i] + " ");
        }
    }

    public static int math1(int a) {
        return Math.abs(a - 1);
    }

    public static int[] math2(int[] a) {
        for (int i = 0; i < a.length; i++) {
            a[i] = 1 + 3 * i;
        }
        return a;
    }

    public static int[] math3(int[] a) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] < 6) {
                a[i] *= 2;
            }
        }
        return a;
    }

    public static void math4Min(int[] a) {
        int b = 0;
        for (int i = 0; i < a.length; i++) {

            if (b > a[i]) {
                b = a[i];
            }
        }
        System.out.println("Min = " + b);
    }

    public static void math4Max(int[] a) {
        int b = 0;
        for (int i = 0; i < a.length; i++) {

            if (b < a[i]) {
                b = a[i];
            }
        }
        System.out.println("Min = " + b);
    }

    public static void math5(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            a[i][i] = 1;
            a[i][a.length - 1 - i] = 1;

        }
    }

    public static void math7(int[] a, int b) {
        b %= a.length;
        System.out.println(a.length);
        System.out.println(b + " ");
        if (b < 0) {
            b = Math.abs(b);
            System.out.println(b + " ");
            for (int i = 0; i < b; i++) {
                for (int j = a.length - 1; j > 0; j--) {
                    a[j] += a[j - 1];
                    a[j - 1] = a[j] - a[j - 1];
                    a[j] -= a[j - 1];
                }
            }
        } else {
            for (int i = 0; i < b; i++) {
                for (int j = 0; j < a.length - 1; j++) {
                    a[j] += a[j + 1];
                    a[j + 1] = a[j] - a[j + 1];
                    a[j] -= a[j + 1];
                }
            }
        }

        printArray(a);
    }


    public static void main(String[] args) {

        System.out.println("Задание 1");
        int[] binaryArray = {1, 1, 1, 0, 0, 0, 0, 1, 1};
        int[] reversBinaryArray = new int[binaryArray.length];
        for (int i = 0; i < binaryArray.length; i++) {
            reversBinaryArray[i] = math1(binaryArray[i]);
            System.out.print(binaryArray[i]);
        }
        System.out.println();
        for (int i = 0; i < binaryArray.length; i++) {
            System.out.print(reversBinaryArray[i]);
        }
        System.out.println();

        System.out.println("Задание 2");
        int[] massiveEightLength = new int[8];
        math2(massiveEightLength);
        for (int i = 0; i < massiveEightLength.length; i++) {
            System.out.print(massiveEightLength[i] + " ");
        }
        System.out.println();

        System.out.println("Задание 3");
        int[] massive3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

        printArray(massive3);
        System.out.println();
        printArray(math3(massive3));
        System.out.println();

        System.out.println("Задание 4");
        int[] search = new int[100];
        search[5] = 45;
        search[7] = -45;
        math4Min(search);
        math4Max(search);

        System.out.println("Задание 5");
        int sqr = 9;
        int[][] square = new int[sqr][sqr];
        math5(square);
        for (int i = 0; i < sqr; i++) {
            for (int j = 0; j < sqr; j++) {
                System.out.print(square[i][j]);
            }
            System.out.println();
        }
        System.out.println();

        System.out.println("Задание 7");
        int[] massive6 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        printArray(massive6);
        int transfer = -13;
        System.out.println();
        math7(massive6, transfer);

    }


}