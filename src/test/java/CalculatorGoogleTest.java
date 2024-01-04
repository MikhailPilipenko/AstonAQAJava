import io.appium.java_client.android.AndroidDriver;
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
        //AndroidDriver driver;
        DesiredCapabilities capabilities = new DesiredCapabilities();

//        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 7 API 30");
        capabilities.setCapability("deviceName", "Pixel 7 API 30");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("appPackage", "com.google.android.calculator");
        capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
//        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.google.android.calculator");
//        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "cal.CalculatorActivity");
//        capabilities.setCapability(MobileCapabilityType.NO_RESET, true);

        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), capabilities);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void checkCalculate() {
        driver.findElement(By.id("com.google.android.calculator:id/digit_9")).click();
//        driver.findElementById("com.google.android.calculator:id/digit_9").click();
        driver.findElement(By.id("com.google.android.calculator:id/op_add")).click();
//        driver.findElementById("com.google.android.calculator:id/op_add").click();
        driver.findElement(By.id("com.google.android.calculator:id/digit_5")).click();
//        driver.findElementById("com.google.android.calculator:id/digit_5").click();
        driver.findElement(By.id("com.google.android.calculator:id/eq")).click();
//        driver.findElementById("com.google.android.calculator:id/eq").click();

//        driver.findElement(By.id("com.google.android.calculator:id/result_final")).click();
        String result = driver.findElement(By.id("com.google.android.calculator:id/result_final")).getText();

        Assert.assertEquals(result, "14");
    }

    @AfterClass
    public void close() {
        driver.quit();
    }

}
