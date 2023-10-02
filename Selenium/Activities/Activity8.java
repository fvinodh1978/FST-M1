package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity8 {
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

        // Check if the Dynamic Checkbox is displayed
        WebElement checkBox = driver.findElement(By.id("dynamicCheckbox"));
        System.out.println("Dynamic Checkbox Exists : " + checkBox.isDisplayed());

        // Click the toggle Button
        WebElement toggleButton = driver.findElement(By.id("toggleCheckbox"));
        toggleButton.click();

        // Wait till the checkbox disappears
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("dynamicCheckbox")));

        // Check if the Dynamic Checkbox is disappeared
        System.out.println("Dynamic Checkbox Exists : " + checkBox.isDisplayed());

        // Click the toggle Button Again
        toggleButton.click();

        // Check if the Dynamic Checkbox is disappeared
        System.out.println("Dynamic Checkbox Exists : " + checkBox.isDisplayed());

        //Wait for 5 Seconds and Close the Browser
        Thread.sleep(5000);
        driver.close();
    }
}
