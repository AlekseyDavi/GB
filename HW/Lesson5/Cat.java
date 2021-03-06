package HW.Lesson5;

public class Cat extends Animals {

    Cat(String name, float maxRun, float maxSwim, float maxJump) {
        super("Кот", name, 200, maxSwim, 2);
    }
    @Override
    protected int swim(float distance){
        return Animals.SWIM_NONE;
    }

}
