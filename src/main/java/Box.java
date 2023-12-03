import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit>{
    private List<T> fruits;

    public Box() {
        this.fruits = new ArrayList<>();
    }

    public void putFruit(T fruit) {
        fruits.add(fruit);
    }

    public float getWeight() {
        float sumWeight = 0.0f;

        for (T fruit : fruits) {
            sumWeight += fruit.getWeight();
        }

        return sumWeight;
    }

    public boolean compare(Box<?> otherBox) {
        return this.getWeight() == otherBox.getWeight();
    }

    public void transferTo(Box<T> otherBox) {
        for (T fruit : fruits) {
            otherBox.putFruit(fruit);
        }

        fruits.clear();
    }
}
