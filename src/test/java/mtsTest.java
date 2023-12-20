import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class mtsTest {
    private static final double PAYMENT = 5.00;
    private static final long PHONE = 297777777;

    @Test
    public void testDropDownList() {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        driver.get("https://www.mts.by/");
        driver.findElement(By.xpath("//button[@id = 'cookie-agree']")).click();

        driver.findElement(By.xpath("//div[@class = 'select__wrapper']")).click();

        List<WebElement> dropDownList = driver.findElements(By.xpath("//div[@class = 'select']/div/ul/li/p"));
        Assert.assertTrue(dropDownList.get(0).getText().equals("Услуги связи"));
        Assert.assertTrue(dropDownList.get(1).getText().equals("Домашний интернет"));
        Assert.assertTrue(dropDownList.get(2).getText().equals("Рассрочка"));
        Assert.assertTrue(dropDownList.get(3).getText().equals("Задолженность"));

        driver.quit();
    }

    @Test
    public void testFormFrame() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        driver.get("https://www.mts.by/");
        driver.findElement(By.xpath("//button[@id = 'cookie-agree']")).click();

        WebElement phoneNumber = driver.findElement(By.xpath("//input[@placeholder= 'Номер телефона']"));
        phoneNumber.click();
        phoneNumber.sendKeys(Long.toString(PHONE));

        WebElement payment = driver.findElement(By.xpath("//input[@placeholder= 'Сумма']"));
        payment.click();
        payment.sendKeys(Double.toString(PAYMENT));

        driver.findElement(By.xpath("//div[@class= 'pay__forms']/form/button")).click();

        WebElement iframe = driver.findElement(By.xpath("//iframe[@class = 'bepaid-iframe']"));
        driver.switchTo().frame(iframe);
        Thread.sleep(2000);

        String amount = driver.findElement(By.xpath("//p[@class = 'header__payment-amount']")).getText();
        Assert.assertTrue(amount.contains(Double.toString(PAYMENT)));
        String amountInButton = driver.findElement(By.xpath("//div[@class = 'card-page__card']/button"))
                .getText();
        Assert.assertTrue(amountInButton.contains(Double.toString(PAYMENT)));

        String phoneNumberWithCode = driver.findElement(By.xpath("//p[@class = 'header__payment-info']"))
                .getText();
        Assert.assertTrue(phoneNumberWithCode.contains(Long.toString(PHONE)));

        Assert.assertEquals(driver.findElement(By.xpath("//input[@id = 'cc-number']/following::label[1]"))
                .getText(), "Номер карты");
        Assert.assertEquals(driver.findElement(By.xpath("//input[@id = 'cc-number']/following::label[2]"))
                .getText(), "Срок действия");
        Assert.assertEquals(driver.findElement(By.xpath("//input[@id = 'cc-number']/following::label[3]"))
                .getText(), "CVC");
        Assert.assertEquals(driver.findElement(By.xpath("//input[@id = 'cc-number']/following::label[4]"))
                .getText(), "Имя держателя (как на карте)");

        List<WebElement> icons = driver.findElements(By.xpath("//app-input//div/img"));
        Assert.assertEquals(icons.get(0).getAttribute("src"),
                "https://checkout.bepaid.by/widget_v2/assets/images/payment-icons/card-types/mastercard-system.svg");
        Assert.assertEquals(icons.get(1).getAttribute("src"),
                "https://checkout.bepaid.by/widget_v2/assets/images/payment-icons/card-types/visa-system.svg");
        Assert.assertEquals(icons.get(2).getAttribute("src"),
                "https://checkout.bepaid.by/widget_v2/assets/images/payment-icons/card-types/belkart-system.svg");
        Assert.assertEquals(icons.get(3).getAttribute("src"),
                "https://checkout.bepaid.by/widget_v2/assets/images/payment-icons/card-types/mir-system-ru.svg");
        Assert.assertEquals(icons.get(4).getAttribute("src"),
                "https://checkout.bepaid.by/widget_v2/assets/images/payment-icons/card-types/maestro-system.svg");

        driver.quit();
    }
}
