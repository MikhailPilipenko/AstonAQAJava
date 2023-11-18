public interface ShapeCalculation {
     default void calculatePerimeter() {}
     double getPerimeter();
     default void calculateSquare() {}
     double getSquare();
}
