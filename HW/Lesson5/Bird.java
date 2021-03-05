package HW.Lesson5;


public class Bird extends Animals {

    Bird(String name, float maxRun, float maxSwim, float maxJump) {
        super("Птица", name, 5, maxSwim, 0.2f);
    }

    @Override
    protected int swim(float distance) {
        return Animals.SWIM_NONE;
    }

}