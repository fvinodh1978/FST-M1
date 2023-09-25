package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.Reporter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.Alert;


public class Activity9 {
    WebDriver driver;

    @BeforeMethod
    public void resetTest(){
        driver.switchTo().defaultContent();
    }

    @BeforeTest
    public void setup(){
        Reporter.log("Executing Setup...");
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        String url="https://v1.training-support.net/selenium/javascript-alerts";
        driver.get(url);
    }

    @Test
    public void simpleAlertTestCase(){
        Reporter.log("Executing Simple Alert Testcase");
        WebElement simpleAlert = driver.findElement(By.id("simple"));
        simpleAlert.click();
        Alert alert = driver.switchTo().alert();
        String alertMessage=alert.getText();
        System.out.println(alertMessage);
        alert.accept();
        Assert.assertEquals(alertMessage, "This is a JavaScript Alert!");
    }

    @Test
    public void confirmAlertTestCase(){
        Reporter.log("Executing Confirmation Alert Testcase");
        WebElement confirmAlert = driver.findElement(By.id("confirm"));
        confirmAlert.click();
        Alert alert = driver.switchTo().alert();
        String alertMessage=alert.getText();
        System.out.println(alertMessage);
        alert.accept();
        Assert.assertEquals(alertMessage, "This is a JavaScript Confirmation!");
    }

    @Test
    public void promptAlertTestCase(){
        Reporter.log("Executing Prompt Alert Testcase");
        WebElement promptAlert = driver.findElement(By.id("prompt"));
        promptAlert.click();
        Alert alert = driver.switchTo().alert();
        String alertMessage=alert.getText();
        System.out.println(alertMessage);
        alert.sendKeys("Ok");
        alert.accept();
        Assert.assertEquals(alertMessage, "This is a JavaScript Prompt!");
    }

    @AfterTest
    public void cleanup(){
        Reporter.log("Executing Cleanup...");
        driver.close();
    }
}
