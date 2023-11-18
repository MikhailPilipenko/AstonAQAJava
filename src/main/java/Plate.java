public class Plate {
    public int food;

    public Plate(int food) {
        this.food = food;
    }

    public void decreaseFood(int n) {
        food -= n;
    }

    public void increaseFood(int n) {
        food += n;
    }

    public void getFoodAmount() {
        System.out.println("Amount of food: " + food);
    }
}
