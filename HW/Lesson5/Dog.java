package HW.Lesson5;

public class Dog extends Animals {
    public Dog(float run, int swim, float jump) {
        super(run, swim, jump);
    }

    public void run(float run) {
        if (run <= 500) {
            System.out.println("Собака побежала");
        }
    }

    public void jump(float jump) {
        if (jump <= (float) 0.5) {
            System.out.println("Собака прыгнула");
        }
    }

    public void swim(float swim) {
        if (swim <= 10) {
            System.out.println("Собака поплыла");
        }
    }
}
