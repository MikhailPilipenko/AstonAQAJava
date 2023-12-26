import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class WildberriesTest {

    @Test
    public void testShoppingCart() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        Actions actions = new Actions(driver);
        List<Product> products = new ArrayList<>();
        int countAddedProduct = 0;
        int sumAddedProduct = 0;
        HomePage homePage = new HomePage(driver, actions, products, countAddedProduct, sumAddedProduct);
        CartPage cartPage = new CartPage(driver);
        List<Product> productsInCart = cartPage.getListOfProduct();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        driver.manage().window().maximize();

        driver.get("https://www.wildberries.ru/");

        homePage.addProductToCart(1);
        homePage.addProductToCart(3);
        homePage.addProductToCart(5);

        driver.findElement(By.xpath("//a[@data-wba-header-name = 'Cart']")).click();

        for (int i = 0; i < productsInCart.size(); i++) {
            Assert.assertEquals(productsInCart.get(i).getId(), products.get(i).getId());
            Assert.assertEquals(productsInCart.get(i).getPrice(), products.get(i).getPrice());
            Assert.assertTrue(products.get(i).getTitle().contains(productsInCart.get(i).getTitle()));
        }

        Thread.sleep(500);
        int totalPrice = Utils.convert(driver.findElement(By.xpath("//div[@class = 'sidebar__sticky-wrap']//span[@class = 'b-right']")).getText());
        int numberItem = Utils.convert(driver.findElement(By.xpath("//div[@class = 'sidebar__sticky-wrap']//span[@class = 'b-right']/preceding::span[1]")).getText());

        Assert.assertEquals(totalPrice, homePage.getSumAddedProduct());
        Assert.assertEquals(numberItem, homePage.getCountAddedProduct());

        driver.quit();
    }
}


