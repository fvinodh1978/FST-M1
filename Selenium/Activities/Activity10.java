package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity10 {
    public static void main(String[] args) throws InterruptedException {
        //Setup GekoDriver
        WebDriverManager.firefoxdriver().setup();

        //Create driver Object for Firefox Browser
        WebDriver driver = new FirefoxDriver();

        //Set Explicit wait of 5 Secs
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000));

        //Open the url
        driver.get("https://v1.training-support.net/selenium/dynamic-controls");

        //Get the Title
        String title = driver.getTitle();
        System.out.print("Title of the Page is : " + title + "\n");

        // Check if checkbox is visible
        WebElement checkBox = driver.findElement(By.cssSelector("input.willDisappear"));
        System.out.println("Checkbox is Visible : " + checkBox.isDisplayed());

        // Find and cick the Remove checkbox button and verify if checkbox is displayed
        WebElement removeButton = driver.findElement(By.id("toggleCheckbox"));
        removeButton.click();

        System.out.println("Checkbox is Visible : " + checkBox.isDisplayed());

        //Wait for 5 Seconds and Close the Browser
        Thread.sleep(5000);
        driver.close();
    }
}
