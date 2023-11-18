public class Circle extends Shape implements ShapeCalculation{
    private double radius;

    public Circle(String color, String borderColor, double radius) {
        super(color, borderColor);
        this.radius = radius;
    }


    @Override
    public void calculatePerimeter() {
        this.perimeter = 2 * Math.PI * radius;
    }

    @Override
    public double getPerimeter() {
        calculatePerimeter();
        return this.perimeter;
    }

    @Override
    public void calculateSquare() {
        this.square = Math.pow(radius, 2) * Math.PI;
    }

    @Override
    public double getSquare() {
        calculateSquare();
        return this.square;
    }

    @Override
    public void info() {
        System.out.print("Circle");
        super.info();
    }
}
