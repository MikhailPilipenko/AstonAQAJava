public abstract class Animal {
    public static int count;
    public String name;

    public Animal() {
        count++;
    }

    public Animal(String name) {
        this.name = name;
        count++;
    }

    public abstract void run(int distance);
    public abstract void swim(int distance);
}
