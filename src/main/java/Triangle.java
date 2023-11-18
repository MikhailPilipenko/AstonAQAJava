public class Triangle extends Shape implements ShapeCalculation{
    private double side1;
    private double side2;
    private double side3;

    public Triangle(String color, String borderColor, double side1, double side2, double side3) {
        super(color, borderColor);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    @Override
    public void calculatePerimeter() {
        this.perimeter = side1 + side2 + side3;
    }

    @Override
    public double getPerimeter() {
        calculatePerimeter();
        return this.perimeter;
    }

    @Override
    public void calculateSquare() {
        double p = (side1 + side2 + side3) / 2;
        this.square = Math.sqrt(p * (p - side1) * (p - side2) * (p - side3));
    }

    @Override
    public double getSquare() {
        calculateSquare();
        return this.square;
    }

    @Override
    public void info() {
        System.out.print("Triangle");
        super.info();
    }
}
