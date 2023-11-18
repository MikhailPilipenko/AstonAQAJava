public class Main {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Barsik");
        Dog dog1 = new Dog("Bobik");
        Cat cat2 = new Cat("Marsik");
        Dog dog2 = new Dog("Atos");

        cat1.swim(2);
        cat1.run(200);
        cat2.run(201);
        dog1.swim(10);
        dog1.run(500);
        dog2.swim(11);
        dog2.run(501);

        System.out.println("\nThe total number of objects: " + Animal.count);
        System.out.println("The number of cats: " + Cat.countCat);
        System.out.println("The number of dogs: " + Dog.countDog);

        // task1 part2
        System.out.println("\ntask 1 part 2");
        Cat[] cats = new Cat[5];
        cats[0] = new Cat("Winter", 10,false);
        cats[1] = new Cat("Minter", 15,false);
        cats[2] = new Cat("Tinter", 20,false);
        cats[3] = new Cat("Kinter", 5,false);
        cats[4] = new Cat("Pinter", 18,false);

        Plate plate = new Plate(40);
        plate.getFoodAmount();

        feed(cats, plate);
        plate.getFoodAmount();

        plate.increaseFood(70);
        plate.getFoodAmount();

        feed(cats, plate);
        plate.getFoodAmount();

        System.out.println("\nThe total number of objects: " + Animal.count);

        // task2
        System.out.println("\ntask 2");
        Circle circle = new Circle("red", "green", 35);
        circle.getSquare();
        circle.getPerimeter();
        circle.info();

        Rechtangle rechtangle = new Rechtangle("black", "yellow", 20, 10);
        rechtangle.getPerimeter();
        rechtangle.getSquare();
        rechtangle.info();

        Triangle triangle = new Triangle("blue", "gold", 10, 15, 15);
        triangle.getPerimeter();
        triangle.getSquare();
        triangle.info();
    }

    public static void feed(Cat[] c, Plate p) {
        for (int i = 0; i < c.length; i++) {
            if (c[i].fullness == false && c[i].appetite < p.food) {
                c[i].eat(p);
                c[i].fullness = true;
                System.out.println("Cat " + c[i].name + " ate");
            } else {
                System.out.println("Cat " + c[i].name + " didn't eat");
            }
        }
    }
}
