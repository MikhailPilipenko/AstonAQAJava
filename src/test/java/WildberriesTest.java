import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
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
        };

        return Integer.parseInt(result);
    };

    @Test
    public void testShoppingCart() {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.manage().window().maximize();
        Actions actions = new Actions(driver);
        List<Product> products = new ArrayList<>();

        driver.get("https://www.wildberries.ru/");

        WebElement product1 = driver.findElement(By.xpath("//article[@data-index='1']/div/a"));
        actions.moveToElement(product1).perform();
        String are = product1.getAttribute("aria-label");
        System.out.println(are);
        String ae = driver.findElement(By.xpath("//article[@data-index='1']//*[@class = 'price__lower-price']")).getText();
        int qw = convert(ae);
        System.out.println(ae);
        System.out.println(qw);
        String l = driver.findElement(By.xpath("//article[@data-index='1']")).getAttribute("data-nm-id");
        long id = Long.parseLong(l);
        System.out.println(id);

        driver.findElement(By.xpath("//article[@data-index='1']//p//a")).click();

        products.add(new Product(id,are,qw));
        System.out.println(products.get(0));

        WebElement product2 = driver.findElement(By.xpath("//article[@data-index='3']/div"));
        actions.moveToElement(product2).perform();
        driver.findElement(By.xpath("//article[@data-index='3']//p[@class = 'product-card__order-wrap']/a")).click();

        WebElement product3 = driver.findElement(By.xpath("//article[@data-index='5']/div"));
        actions.moveToElement(product3).perform();
        driver.findElement(By.xpath("//article[@data-index='5']//p[@class = 'product-card__order-wrap']/a")).click();





    }
}


