package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity7 {

    WebDriver driver;
    WebDriverWait wait;

    @DataProvider(name = "Authentication")
    public static Object[][] credentials() {
        return new Object[][]{
                { "admin", "password" }
        };
    }

    @BeforeClass
    public void setup() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/login-form");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test(dataProvider = "Authentication")
    public void loginTest(String userName, String password) throws InterruptedException {

        // Get the webelements userNameField, passwordField and submitButton
        WebElement userNameField = driver.findElement(By.xpath("//input[@id='username']"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement submitButton = driver.findElement(By.xpath("//button[text()= 'Log in']"));

        // Clear the Username and Password Text field
        userNameField.clear();
        passwordField.clear();

        // Type the Username and Password in the respective Text fields
        userNameField.sendKeys(userName);
        passwordField.sendKeys(password);

        // Submit the login form
        submitButton.click();

        // Wait for the Success/Failure message to showup
        Thread.sleep(5000);
    }

    @AfterClass
    public void cleanup() {
        driver.quit();
    }

}
