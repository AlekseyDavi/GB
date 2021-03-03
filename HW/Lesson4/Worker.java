package HW.Lesson4;

public class Worker {
    static int workerId = 0;
    public String surname;
    public String name;
    public String middleName;
    public String position;
    public String phoneNumber;
    public int pay;
    public int age;
    public int id;

    public Worker(String surname, String name, String middleName, String position, String phoneNumber, int pay, int age) {
        this.surname = surname;
        this.name = name;
        this.middleName = middleName;
        this.position = position;
        this.phoneNumber = phoneNumber;
        this.pay = pay;
        this.age = age;
        this.id = workerId;
        workerId++;
    }

    String getFullInfo() {
        return this.id + " " +
                this.surname + " " +
                this.name + " " +
                this.middleName + " " +
                this.position + " " +
                this.phoneNumber + " " +
                this.pay + " " +
                this.age + " ";
    }
}

