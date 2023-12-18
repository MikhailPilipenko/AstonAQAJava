import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class mtsTest {
    @Test
    public void testTitle() {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        driver.get("https://www.mts.by/");
        driver.findElement(By.xpath("//button[@id = 'cookie-agree']")).click();

        String title = driver.findElement(By.xpath("//div[@class='pay__wrapper']/h2")).getText();
        Assert.assertEquals(title, "Онлайн пополнение\nбез комиссии");

        driver.quit();
    }

    @Test
    public void testLogos() {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        driver.get("https://www.mts.by/");
        driver.findElement(By.xpath("//button[@id = 'cookie-agree']")).click();

        List<WebElement> logos = driver.findElements(By.xpath("//div[@class='pay__partners']/ul/li/img"));
        Assert.assertTrue(logos.get(0).getAttribute("alt").equals("Visa"));
        Assert.assertTrue(logos.get(1).getAttribute("alt").equals("Verified By Visa"));
        Assert.assertTrue(logos.get(2).getAttribute("alt").equals("MasterCard"));
        Assert.assertTrue(logos.get(3).getAttribute("alt").equals("MasterCard Secure Code"));
        Assert.assertTrue(logos.get(4).getAttribute("alt").equals("Белкарт"));
        Assert.assertTrue(logos.get(5).getAttribute("alt").equals("МИР"));

        driver.quit();
    }

    @Test
    public void linkTest() {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        driver.get("https://www.mts.by/");
        driver.findElement(By.xpath("//button[@id = 'cookie-agree']")).click();

        driver.findElement(By.xpath("//div[@class='pay__wrapper']/a")).click();
        Assert.assertEquals(driver.getTitle(), "Порядок оплаты и безопасность интернет платежей");

        driver.quit();
    }

    @Test
    public void testForm() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        driver.get("https://www.mts.by/");
        driver.findElement(By.xpath("//button[@id = 'cookie-agree']")).click();

        WebElement phoneNumber = driver.findElement(By.xpath("//input[@placeholder= 'Номер телефона']"));
        phoneNumber.click();
        phoneNumber.sendKeys("297777777");

        WebElement payment = driver.findElement(By.xpath("//input[@placeholder= 'Сумма']"));
        payment.click();
        payment.sendKeys("5");

        driver.findElement(By.xpath("//div[@class= 'pay__forms']/form/button")).click();

        WebElement iframe = driver.findElement(By.xpath("//iframe[@class = 'bepaid-iframe']"));
        driver.switchTo().frame(iframe);
        Thread.sleep(2000);

        Assert.assertEquals(driver.findElement(By.xpath("//p[@class = 'header__payment-info']")).getText(),
                "Оплата: Услуги связи Номер:375297777777");

        driver.quit();
    }
}
