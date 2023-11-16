public class Main {
    public static void main(String[] args) {
        // task 2
        Employee[] employees = new Employee[5];
        employees[0] = new Employee("Stephen Spencer", "manager", "stephenspencer@gmail.com", 15417057949L, 300000, 52);
        employees[1] = new Employee("Scott Berry", "programmer", "scottberry@gmail.com", 15417057931L, 150000, 47);
        employees[2] = new Employee("Dennis Beck", "tester", "dennisbeck@gmail.com", 15417057900L, 95000, 36);
        employees[3] = new Employee("Christine Day", "programmer", "christineday@gmail.com", 15417057997L, 110000, 28);
        employees[4] = new Employee("Susan Thomas", "tester", "susanthomas@gmail.com", 15417057976L, 210000, 33);

        for (Employee e : employees) {
            if (e.getAge() > 40) {
                e.info();
            }
        }

        // task 3
        Park.Attraction attraction = new Park().new Attraction("Big Wheel", "Monday-Friday, 10:00-20:00", 250);
        attraction.info();
    }
}
