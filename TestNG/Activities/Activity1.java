package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity1 {
    WebDriver driver;
    WebDriverWait wait;

    // Function to Setup the test
    @BeforeMethod
    public void setup(){
        //Executing Setup
        System.out.println("Executing Setup...");

        // Initialise Driver
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String serviceUrl="https://v1.training-support.net";
        driver.get(serviceUrl);
    }

    @Test
    public void verify_title(){
        // Get the Title of the Home Page
        String homeTitle = driver.getTitle();
        String expectedHomeTitle="Training Support";
        System.out.println("Title of Home Page : " + homeTitle);
        Reporter.log("Getting Title");

        // Click About US Link
        WebElement aboutUs = driver.findElement(By.id("about-link"));
        aboutUs.click();

        // Get the Title of the About US Page
        String aboutUsTitle = driver.getTitle();
        String expectedAboutUsTitle="About Training Support";
        System.out.println("Title of About US Page : " + aboutUsTitle);

        // Assert Homepage Title and About US Page Title
        Assertions.assertNotNull(aboutUsTitle);
        Assertions.assertEquals(homeTitle, expectedHomeTitle);
        Assertions.assertSame(expectedHomeTitle, expectedHomeTitle);
    }

    // Function to cleanup the test
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
