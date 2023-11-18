public class Rechtangle extends Shape implements ShapeCalculation{
    private double side1;
    private double side2;

    public Rechtangle(String color, String borderColor, double side1, double side2) {
        super(color, borderColor);
        this.side1 = side1;
        this.side2 = side2;
    }


    @Override
    public void calculatePerimeter() {
        this.perimeter = 2 * (side1 + side2);
    }

    @Override
    public double getPerimeter() {
        calculatePerimeter();
        return this.perimeter;
    }

    @Override
    public void calculateSquare() {
        this.square = side1 * side2;
    }

    @Override
    public double getSquare() {
        calculateSquare();
        return this.square;
    }

    @Override
    public void info() {
        System.out.print("Rechtangle");
        super.info();
    }
}
