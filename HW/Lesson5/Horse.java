package HW.Lesson5;

public class Horse extends Animals {
    public Horse(float run, float swim, float jump) {
        super(run, swim, jump);
        if (this.run > 1500) {
            this.run = 1500;
        }
        if (this.jump > 3) {
            this.jump = 3;
        }
        if (this.swim > 100) {
            this.swim = 100;
        }
    }

    public void run(float run) {
        if (run <= 1500) {
            System.out.println("Лошадь побежала");
        }
    }

    public void jump(float jump) {
        if (jump <= 3) {
            System.out.println("Лошадь прыгнула");
        }
    }

    public void swim(float swim) {
        if (swim <= 10) {
            System.out.println("Лошадь поплыла");
        }
    }
}
