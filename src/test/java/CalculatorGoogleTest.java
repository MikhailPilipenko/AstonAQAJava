import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import jdk.jfr.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class CalculatorGoogleTest {
    AndroidDriver driver;

    @BeforeClass
    public void initialize() {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("deviceName", "Pixel 7 API 30");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("appPackage", "com.google.android.calculator");
        capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");

        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), capabilities);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    @Description("This test checks the addition function")
    @Severity(SeverityLevel.BLOCKER)
    @Owner("Mikhail P")
    public void checkAddition() {
        driver.findElement(By.id("com.google.android.calculator:id/digit_9")).click();
        driver.findElement(By.id("com.google.android.calculator:id/op_add")).click();
        driver.findElement(By.id("com.google.android.calculator:id/digit_5")).click();
        driver.findElement(By.id("com.google.android.calculator:id/eq")).click();

        String result = driver.findElement(By.id("com.google.android.calculator:id/result_final")).getText();

        Assert.assertEquals(result, "14");
    }

    @Test
    @Description("This test checks the substraction function")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Mikhail P")
    public void checkSubstraction() {
        driver.findElement(By.id("com.google.android.calculator:id/digit_8")).click();
        driver.findElement(By.id("com.google.android.calculator:id/op_sub")).click();
        driver.findElement(By.id("com.google.android.calculator:id/digit_3")).click();
        driver.findElement(By.id("com.google.android.calculator:id/eq")).click();

        String result = driver.findElement(By.id("com.google.android.calculator:id/result_final")).getText();

        Assert.assertEquals(result, "5");
    }

    @Test
    @Description("This test checks the division function")
    @Severity(SeverityLevel.MINOR)
    @Owner("Mikhail P")
    public void checkDivision() {
        driver.findElement(By.id("com.google.android.calculator:id/digit_6")).click();
        driver.findElement(By.id("com.google.android.calculator:id/op_div")).click();
        driver.findElement(By.id("com.google.android.calculator:id/digit_2")).click();
        driver.findElement(By.id("com.google.android.calculator:id/eq")).click();

        String result = driver.findElement(By.id("com.google.android.calculator:id/result_final")).getText();

        Assert.assertEquals(result, "3");
    }

    @Test
    @Description("This test checks the multiplication function")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Mikhail P")
    public void checkMultiplication() {
        driver.findElement(By.id("com.google.android.calculator:id/digit_4")).click();
        driver.findElement(By.id("com.google.android.calculator:id/op_mul")).click();
        driver.findElement(By.id("com.google.android.calculator:id/digit_7")).click();
        driver.findElement(By.id("com.google.android.calculator:id/eq")).click();

        String result = driver.findElement(By.id("com.google.android.calculator:id/result_final")).getText();

        Assert.assertEquals(result, "28");
    }

    @AfterClass
    public void close() {
        driver.quit();
    }

}
