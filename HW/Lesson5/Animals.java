package HW.Lesson5;

import java.util.Random;

public abstract class Animals {
    static final int SWIM_OK =1;
    static final int SWIM_FAIL=0;
    static final int SWIM_NONE=-1;
    private final Random random = new Random();
    public float maxRun;
    public float maxSwim;
    public float maxJump;
    String name;
    String type;

    public Animals(String type, String name, float maxRun, float maxSwim, float maxJump) {
        float jumpDiff = random.nextFloat() * maxJump - (maxJump / 2);
        float runDiff = random.nextFloat() * maxRun - (maxRun / 2);
        float swimDiff = random.nextFloat() * maxSwim - (maxSwim / 2);

        this.maxRun = maxRun + runDiff;
        this.maxSwim = maxSwim + swimDiff;
        this.maxJump = maxJump + jumpDiff;
        this.name = name;
        this.type = type;
    }

    String getName() {
        return this.name;
    }

    String getType() {
        return this.type;
    }

    float getMaxRun() {
        return this.maxRun;
    }

    float getMaxSwim() {
        return this.maxSwim;
    }

    float getMaxJump() {
        return this.maxJump;
    }

    protected boolean run(float distance) {
        return (distance <= maxRun);
    }

    protected boolean jump(float height) {
        return (height <= maxJump);
    }

    protected int swim(float distance) {
        return (distance <= maxSwim) ? SWIM_OK : SWIM_FAIL;
    }


}
