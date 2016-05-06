import java.io.File;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class test {

    public WebDriver driver = null;

    @BeforeMethod
    public void setUp() throws Exception {
        // set up appium

        File appDir = new File("/Users/vanithakasala/vanitha");
        File app = new File(appDir, "Albert.app");
        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability(CapabilityType.BROWSER_NAME, "iOS");
        capabilities.setCapability(CapabilityType.VERSION, "9.3");
        capabilities.setCapability(CapabilityType.PLATFORM, "Mac");
        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("deviceName", "iPhone 6 Plus");
        capabilities.setCapability("platformVersion", "9.3");
        capabilities.setCapability("app", app.getAbsolutePath());
        driver = new RemoteWebDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
    }

    @Test
    public void test1SignUp() throws InterruptedException {

        Thread.sleep(10000);

        driver.findElement(By.xpath("//*[@name='BtnSignUpEnabled']")).click();

        driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATextField[1]")).sendKeys("test1008@mailinator.com");

        driver.findElement(By.xpath("//*[@name='BtnNextEnabled']")).click();

        for (int i = 0; i < 8; i++) {
            driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[3]")).click();
        }

        driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATextField[1]")).sendKeys("Century Innovations Ltd");

        driver.findElement(By.xpath("//*[@name='Century Innovations Ltd']")).click();

        driver.findElement(By.xpath("//*[@name='BtnFinish']")).click();


    }

    @Test
    public void test2Login() throws InterruptedException {

        driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[2]")).click();

        driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATextField[1]")).sendKeys("test1002@mailinator.com");

        driver.findElement(By.xpath("//*[@name='BtnNextEnabled']")).click();

        for (int i = 0; i < 4; i++) {
            driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[3]")).click();
        }
    }


    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
    }

}