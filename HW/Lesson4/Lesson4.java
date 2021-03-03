package HW.Lesson4;

public class Lesson4 {
    public static void main(String[] args) {
        Worker worker1 = new Worker("F1F", "f1f", "d1dd", "d1ds", "s1sss", 10000, 20);

        Worker[] workers = {worker1,
                new Worker("F2F", "f2f", "d2dd", "d2ds", "s2sss", 12000, 30),
                new Worker("F3F", "f3f", "d3dd", "d3ds", "s3sss", 15000, 40),
                new Worker("F4F", "f4f", "d4dd", "d4ds", "s4sss", 30000, 50),
                new Worker("F5F", "f5f", "d5dd", "d5ds", "s5sss", 45000, 60)
        };
        System.out.println("Сотрудник " + worker1.surname + " " + worker1.name + " " + worker1.middleName + " занимает должность " + worker1.position);
        for (Worker worker : workers) {
            if (worker.age > 40) {
                System.out.println(worker.getFullInfo());
            }
        }

    }
}
