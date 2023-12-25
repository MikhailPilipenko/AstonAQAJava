public class Product {
    private long id;
    private String title;
    private int price;

    public Product(long id, String title, int price) {
        this.id = id;
        this.title = title;
        this.price = price;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                '}';
    }
}
