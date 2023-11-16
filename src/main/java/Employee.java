// task 1
public class Employee {
    private String name;
    private String position;
    private String email;
    private long phoneNumber;
    private double salary;
    private int age;

      public Employee(String name, String position, String email, long phoneNumber, double salary, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    public void info() {
        System.out.println("Employee{" + "name='" + name + '\'' + ", position='" + position + '\'' +
            ", email='" + email + '\'' + ", phoneNumber='" + phoneNumber + '\'' +
            ", salary=" + salary + " rub, age=" + age + '}');
    }

    public int getAge() {
        return age;
    }
}
