package HW;

public class Lesson1 {
    public static float meth1(float a1,float a2,float a3,float a4) {
        float aEnd = a1 * (a2 + (a3 / a4));
        return aEnd;

    }
    public static boolean meth2(int a, int b) {
        int sum = a + b;
        if (sum > 20) {
            return false;
        } else if (sum >= 10) {
            return true;}
        else {
            return false;
        }
    }
    public static void meth3(int a) {
                if (a > 0) {
            System.out.println("Число положительное");
        } else {
                    System.out.println("Число отрицательное");;
        }
    }
    public static void meth4(String a) {
                   System.out.println("Привет, " + a);

    }
    public static boolean meth5(int a) {
        if ((a%4) != 0) {
            return false;
        }
            else if ((a % 400) == 0) {
                        return true;
        }
            else if ((a % 100) == 0) {
            return false;
                    }
        else {
            return true;
        }
    }

    public static void main(String[] args) {
        int a =-18;
        int b =2;
        int c =3;
        int d =4;
        String name = "Alex";
        System.out.println(meth1(a,b,c,d));
        System.out.println(meth2(a,b));
        meth3(a);
        meth4(name);
        System.out.println(meth5(4));
        System.out.println(meth5(100));
        System.out.println(meth5(1601));
        System.out.println(meth5(1604));










    }
}