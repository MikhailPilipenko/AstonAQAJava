// task 3
public class Park {
    public class Attraction {
        private String type;
        private String workHours;
        private double price;

        public Attraction(String type, String workHours, double price) {
            this.type = type;
            this.workHours = workHours;
            this.price = price;
        }

        public void info() {
            System.out.println("Attraction{" + "type='" + type + '\'' + ", workHours='" + workHours + '\'' +
                    ", price=" + price + " rub}");
        }
    }
}
