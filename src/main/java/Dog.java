public class Dog extends Animal{
    public static int countDog;

    public Dog() {
        countDog++;
    }

    public Dog(String name) {
        super(name);
        countDog++;
    }

    @Override
    public void run(int distance) {
        if(distance <= 500) {
            System.out.println(name + " runs " + distance + " m");
        } else {
            System.out.println(name + " and other dogs can't run more than 500m");
        }
    }

    @Override
    public void swim(int distance) {
        if(distance <= 10) {
            System.out.println(name + " swims " + distance + " m");
        } else {
            System.out.println(name + " and other dogs can't swim more than 10m");
        }
    }
}
