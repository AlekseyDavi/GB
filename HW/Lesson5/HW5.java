package HW.Lesson5;

public class HW5 {
    public static void main(String[] args) {
        String tempWinEvent = " получилось";
        String tempLossEvent = " не получилось";
        String eventName;
        String eventResult;
        Cat cat1 = new Cat("Барсик", 1, 1, 1);
        Cat cat2 = new Cat("Черныш", 1, 1, 1);
        Dog dog1 = new Dog("Лесси", 1, 1, 1);
        Bird bird1 = new Bird("Кеша", 1, 1, 1);
        Horse horse1 = new Horse("Черныш", 1, 1, 1);

        Animals[] arr = {cat1, cat2, dog1, bird1, horse1};
        float jumpLength = 2.5f;
        float runLength = 240;
        float swimLength = 6;
        for (int i = 0; i < arr.length; i++) {
            String nameString = arr[i].getType() + " " + arr[i].getName() + " может ";
            eventName = "прыгнуть на " + arr[i].getMaxJump() + "м. Пытается прыгнуть на ";
            eventResult = (arr[i].jump(jumpLength)) ? tempWinEvent : tempLossEvent;
            result(nameString, eventName, jumpLength, eventResult);

            eventName = "пробежать " + arr[i].getMaxRun() + "м. Пытается пробежать ";
            eventResult = (arr[i].run(runLength)) ? tempWinEvent : tempLossEvent;
            result(nameString, eventName, runLength, eventResult);

            int swimResult =arr[i].swim(swimLength);
            eventName = "проплыть " + arr[i].getMaxRun() + "м. Пытается проплыть ";
            eventResult = (swimResult == Animals.SWIM_OK) ? tempWinEvent : tempLossEvent;
            if(swimResult==Animals.SWIM_NONE)
                eventResult= " это не получилось, т.к. не умеет плавать";
            result(nameString, eventName, runLength, eventResult);


        }
    }

    public static void result(String nameString, String eventName, float length, String eventResult) {
        System.out.println(nameString + eventName + length + eventResult);
    }
}
