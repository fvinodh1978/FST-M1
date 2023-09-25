package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.implementation.bytecode.Throw;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class Activity2 {
    WebDriver driver;
    @BeforeClass
    public void setup(){

        WebDriverManager.firefoxdriver().setup();
        String url="https://v1.training-support.net/selenium/target-practice";
        driver = new FirefoxDriver();
        driver.get(url);
    }

    @Test(enabled = true)
    public void verifyTitle(){
        String expectedTitle="Target Practice";
        String title = driver.getTitle();
        Assert.assertEquals(title, expectedTitle);
    }

    @Test(enabled = true)
    public void blackButton(){

        WebElement blackButton = driver.findElement(By.xpath("//button[@class='ui black button']"));
        String buttonText = blackButton.getText();
        Assert.assertTrue(blackButton.isDisplayed());
        Assert.assertEquals(buttonText, "white");
    }

    @Test(enabled = false)
    public void skipTest(){

        WebElement blackButton = driver.findElement(By.xpath("//button[@class='ui black button']"));
        String buttonText = blackButton.getText();
        Assert.assertNull(buttonText);
    }

    @Test(enabled = true)
    public void skipExceptionTest() throws Exception {
        String condition = "Skip Test";
        if(condition.equals("Skip Test")){
            throw new Exception("This Test is Skipped");
        }
    }

    @AfterClass
    public void cleanup(){
        driver.close();
    }
}
