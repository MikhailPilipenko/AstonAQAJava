public class Cat extends Animal{
    public static int countCat;
    public int appetite;
    public boolean fullness;

    public Cat() {
        countCat++;
    }

    public Cat(String name) {
        super(name);
        countCat++;
    }

    public Cat(String name, int appetite, boolean fullness) {
        super(name);
        this.appetite = appetite;
        this.fullness = fullness;
        countCat++;
    }

    public void eat (Plate p) {
        p.decreaseFood(appetite);
    }

    @Override
    public void run(int distance) {
        if(distance <= 200) {
            System.out.println(name + " runs " + distance + " m");
        } else {
            System.out.println(name + " and other cats can't run more than 200m");
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println(name +  " and other cats can't swim");
    }
}
