package HW.Lesson5;


public class Bird extends Animals {

    public Bird(float run, float swim, float jump) {
        super(run, swim, jump);
    }

    public void run(float run) {
        if (run <= 5) {
            System.out.println("Птица побежала");
        }
    }

    public void jump(float jump) {
        if (jump <= (float) 0.2) {
            System.out.println("Птица прыгнула");
        }
    }

    public void swim(float swim) {
        System.out.println("Птица не плавает");
    }

}