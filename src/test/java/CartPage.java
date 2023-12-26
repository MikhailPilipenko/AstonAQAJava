import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;

public class CartPage {
    private WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> getCartItems() {
        return  driver.findElements(By.xpath("//div[@class = 'list-item__wrap']/div/a"));
    }

    public List<Product> getListOfProduct() throws InterruptedException {
        List<Product> productsInCart = new ArrayList<>();

        List<String> titles = new ArrayList<>();
        for (WebElement e : getCartItems()) {
            titles.add(e.getAttribute("title"));
        }

        List<Long> ids = new ArrayList<>();
        for (WebElement e : getCartItems()) {
            ids.add(Long.parseLong(e.getAttribute("href").replaceAll(".*/(\\d+)/.*", "$1")));
        }

        Thread.sleep(500);
        List<WebElement> priceItems = driver.findElements(By.xpath("//div[@class = 'list-item__price-new']"));
        List<Integer> prices = new ArrayList<>();
        for (WebElement e : priceItems) {
            prices.add(Utils.convert(e.getText()));
        }

        for (int i = titles.size() - 1; i >= 0; i--) {
            productsInCart.add(new Product(ids.get(i), titles.get(i), prices.get(i)));
        }

        return productsInCart;
    }
}
