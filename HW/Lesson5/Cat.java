package HW.Lesson5;

public class Cat extends Animals {

    public Cat(float run, float swim, float jump) {
        super(run, swim, jump);
    }

    public void run(float run) {
        if (run <= 200) {
            System.out.println("Кот побежал");
        }
    }

    public void swim(float swim) {
        System.out.println("Кот не плавает");
    }

    public void jump(float jump) {
        if (jump <= 2) {
            System.out.println("Кот прыгнул");
        }
    }
}
