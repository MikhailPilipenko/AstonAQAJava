public class Lesson_10 {
    public static void main(String[] args) {
        Box<Apple> box1 = new Box<>();
        box1.putFruit(new Apple());
        box1.putFruit(new Apple());
        box1.putFruit(new Apple());

        System.out.println("Weight of box1: " + box1.getWeight());

        Box<Orange> box2 = new Box<>();
        box2.putFruit(new Orange());
        box2.putFruit(new Orange());

        System.out.println("Weight of box2: " + box2.getWeight());

        System.out.println("Compare box1 and box2: " + box1.compare(box2));

        Box<Apple> box3 = new Box<>();
        box3.putFruit(new Apple());

        System.out.println("\nWeight of box3: " + box3.getWeight());

        box3.transferTo(box1);

        System.out.println("Weight of box3 after transfer: " + box3.getWeight());
        System.out.println("Weight of box1 after transfer: " + box1.getWeight());
        System.out.println("\nCompare box1 and box2 after transfer: " + box1.compare(box2));
    }
}
