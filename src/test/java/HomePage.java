import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import java.util.List;

public class HomePage {
    private WebDriver driver;
    private Actions actions;
    private List<Product> products;
    private int countAddedProduct;
    private int sumAddedProduct;

    public HomePage(WebDriver driver, Actions actions, List<Product> products, int countAddedProduct, int sumAddedProduct) {
        this.driver = driver;
        this.actions = actions;
        this.products = products;
        this.countAddedProduct = countAddedProduct;
        this.sumAddedProduct = sumAddedProduct;
    }

    public void addProductToCart(int dataIndex) {
        WebElement item = driver.findElement(By.xpath("//article[@data-index='" + dataIndex + "']/div/a"));
        actions.moveToElement(item).perform();
        getItemName(item);
        getItemPrice(driver, dataIndex);
        getItemId(driver, dataIndex);

        products.add(new Product(getItemId(driver, dataIndex), getItemName(item), getItemPrice(driver, dataIndex)));
        countAddedProduct++;
        sumAddedProduct += getItemPrice(driver, dataIndex);

        driver.findElement(By.xpath("//article[@data-index='" + dataIndex +"']//p[@class = 'product-card__order-wrap']/a")).click();

        try {
            WebElement size = driver.findElement(By.xpath("//div[@class = 'popup__content']/ul/li[1]"));
            size.click();
        } catch (NoSuchElementException e) {

        }
    }

    public String getItemName(WebElement cartItem) {
        return cartItem.getAttribute("aria-label");
    }

    public int getItemPrice(WebDriver driver, int dataIndex) {
        return Utils.convert(driver.findElement(By.xpath("//article[@data-index='" + dataIndex + "']//*[@class = 'price__lower-price']")).getText());
    }

    public long getItemId(WebDriver driver, int dataIndex) {
        return Long.parseLong(driver.findElement(By.xpath("//article[@data-index='" + dataIndex + "']")).getAttribute("data-nm-id"));
    }

    public int getCountAddedProduct() {
        return countAddedProduct;
    }

    public int getSumAddedProduct() {
        return sumAddedProduct;
    }
}
