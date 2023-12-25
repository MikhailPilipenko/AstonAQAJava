import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WildberriesTest {
    public static int convert(String str) {
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(str);
        String result = "";

        while (matcher.find()) {
            result += matcher.group();
        }

        return Integer.parseInt(result);
    }

    @Test
    public void testShoppingCart() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        driver.manage().window().maximize();
        Actions actions = new Actions(driver);
        List<Product> products = new ArrayList<>();
        List<Product> productsInBasket = new ArrayList<>();
        int count = 0;
        int sum = 0;

        driver.get("https://www.wildberries.ru/");

        WebElement product1 = driver.findElement(By.xpath("//article[@data-index='1']/div/a"));
        actions.moveToElement(product1).perform();
        String title1 = product1.getAttribute("aria-label");

        int price1 = convert(driver.findElement(By.xpath("//article[@data-index='1']//*[@class = 'price__lower-price']")).getText());
        sum += price1;

        long id1 = Long.parseLong(driver.findElement(By.xpath("//article[@data-index='1']")).getAttribute("data-nm-id"));

        driver.findElement(By.xpath("//article[@data-index='1']//p[@class = 'product-card__order-wrap']/a")).click();

        try {
            WebElement size = driver.findElement(By.xpath("//div[@class = 'popup__content']/ul/li[1]"));
            size.click();
        } catch (NoSuchElementException e) {

        }

        products.add(new Product(id1, title1, price1));
        count++;

        WebElement product2 = driver.findElement(By.xpath("//article[@data-index='3']/div/a"));
        actions.moveToElement(product2).perform();
        String title2 = product2.getAttribute("aria-label");

        int price2 = convert(driver.findElement(By.xpath("//article[@data-index='3']//*[@class = 'price__lower-price']")).getText());
        sum += price2;

        long id2 = Long.parseLong(driver.findElement(By.xpath("//article[@data-index='3']")).getAttribute("data-nm-id"));

        driver.findElement(By.xpath("//article[@data-index='3']//p[@class = 'product-card__order-wrap']/a")).click();

        try {
            WebElement size = driver.findElement(By.xpath("//div[@class = 'popup__content']/ul/li[1]"));
            size.click();
        } catch (NoSuchElementException e) {

        }

        products.add(new Product(id2, title2, price2));
        count++;

        WebElement product3 = driver.findElement(By.xpath("//article[@data-index='5']/div/a"));
        actions.moveToElement(product3).perform();
        String title3 = product3.getAttribute("aria-label");

        int price3 = convert(driver.findElement(By.xpath("//article[@data-index='5']//*[@class = 'price__lower-price']")).getText());
        sum += price3;

        long id3 = Long.parseLong(driver.findElement(By.xpath("//article[@data-index='5']")).getAttribute("data-nm-id"));

        driver.findElement(By.xpath("//article[@data-index='5']//p[@class = 'product-card__order-wrap']/a")).click();

        try {
            WebElement size = driver.findElement(By.xpath("//div[@class = 'popup__content']/ul/li[1]"));
            size.click();
        } catch (NoSuchElementException e) {

        }

        products.add(new Product(id3, title3, price3));
        count++;

        driver.findElement(By.xpath("//a[@data-wba-header-name = 'Cart']")).click();

        List<WebElement> titleItems = driver.findElements(By.xpath("//div[@class = 'list-item__wrap']/div/a"));
        List<String> titles = new ArrayList<>();
        for (WebElement e : titleItems) {
            titles.add(e.getAttribute("title"));
        }

        List<WebElement> idItems = driver.findElements(By.xpath("//div[@class = 'list-item__wrap']/div/a"));
        List<Long> ids = new ArrayList<>();
        for (WebElement e : idItems) {
            ids.add(Long.parseLong(e.getAttribute("href").replaceAll(".*/(\\d+)/.*", "$1")));
        }

        Thread.sleep(500);
        List<WebElement> priceItems = driver.findElements(By.xpath("//div[@class = 'list-item__price-new']"));
        List<Integer> prices = new ArrayList<>();
        for (WebElement e : priceItems) {
            prices.add(convert(e.getText()));
        }

        for (int i = titles.size() - 1; i >= 0; i--) {
            productsInBasket.add(new Product(ids.get(i), titles.get(i), prices.get(i)));
        }

        for (int i = 0; i < productsInBasket.size(); i++) {
            Assert.assertEquals(productsInBasket.get(i).getId(), products.get(i).getId());
            Assert.assertEquals(productsInBasket.get(i).getPrice(), products.get(i).getPrice());
            Assert.assertTrue(products.get(i).getTitle().contains(productsInBasket.get(i).getTitle()));
        }

        Thread.sleep(500);
        int totalPrice = convert(driver.findElement(By.xpath("//div[@class = 'sidebar__sticky-wrap']//span[@class = 'b-right']")).getText());
        int numberItem = convert(driver.findElement(By.xpath("//div[@class = 'sidebar__sticky-wrap']//span[@class = 'b-right']/preceding::span[1]")).getText());

        Assert.assertEquals(totalPrice, sum);
        Assert.assertEquals(numberItem, count);

        driver.quit();
    }
}


