public class Shape {
    public double perimeter;
    public double square;
    public String color;
    public String BorderColor;

    public Shape(String color, String borderColor) {
        this.color = color;
        BorderColor = borderColor;
    }

    public void info() {
        System.out.printf(" {" + "perimeter=" + "%.2f" + ", square=" + "%.2f" +
                ", color='" + color + '\'' + ", BorderColor='" + BorderColor + '\'' + "}\n", perimeter, square);
    }
}
