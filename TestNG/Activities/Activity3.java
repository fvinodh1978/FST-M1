package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.Test;

public class Activity3 {
    WebDriver driver;


    @BeforeClass
    public void setup(){
        WebDriverManager.firefoxdriver().setup();
        String url = "https://v1.training-support.net/selenium/login-form";
        driver = new FirefoxDriver();
        driver.get(url);
    }
    @Test
    public void Test() throws InterruptedException {
        WebElement userTextBox = driver.findElement(By.id("username"));
        WebElement passwordTextBox = driver.findElement(By.id("password"));
//        WebElement submitButton = driver.findElement(By.cssSelector("button.ui.button"));
        WebElement submitButton = driver.findElement(By.xpath("//button[text()='Log in']"));
        userTextBox.sendKeys("admin");
        passwordTextBox.sendKeys("password");
        submitButton.click();
        WebElement confirmationPage = driver.findElement(By.xpath("//div[@id='action-confirmation']"));
        String expectedText = "Welcome Back, admin";
        String actualText= confirmationPage.getText();
        Assert.assertEquals(actualText, expectedText);
    }

    @AfterClass
    public void cleanup(){
        driver.close();
    }
}
