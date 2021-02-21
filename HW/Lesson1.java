package HW;

public class Lesson1 {
    public static float meth1(float a1,float a2,float a3,float a4) {
        return  a1 * (a2 + (a3 / a4));


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
    public static void meth5(int a) {
        if ((a%4) != 0) {
            System.out.println("Невисокосный год");
        }
        else if ((a % 400) == 0) {
            System.out.println("Високосный год");
        }
        else if ((a % 100) == 0) {
            System.out.println("Невисокосный год");
        }
        else {
            System.out.println("Високосный год");
        }
    }

    public static void main(String[] args) {
        int a =-18;
        int b =2;
        int c =4;
        int d =3;
        String name = "Alex";
        System.out.println(meth1(a,b,c,d));
        System.out.println(meth2(a,b));
        meth3(a);
        meth4(name);
        meth5(100);
        meth5(4);
        meth5(1601);
        meth5(2000);











    }
}