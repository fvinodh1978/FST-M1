package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity9 {
    public static void main(String[] args) throws InterruptedException {
        //Setup GekoDriver
        WebDriverManager.firefoxdriver().setup();

        //Create driver Object for Firefox Browser
        WebDriver driver = new FirefoxDriver();

        //Set Explicit wait of 5 Secs
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000));

        //Open the url
        driver.get("https://v1.training-support.net/selenium/ajax");

        //Get the Title
        String title = driver.getTitle();
        System.out.print("Title of the Page is : " + title + "\n");

        // Get the change Button and Click on it
        WebElement changeButton = driver.findElement(By.cssSelector("button.ui.violet.button"));
        changeButton.click();

        WebElement dynamicText = driver.findElement(By.tagName("h1"));

        // Wait till the Hello! appears and print it
        wait.until(ExpectedConditions.textToBePresentInElement(dynamicText, "HELLO!"));
        System.out.println("Dynamic Text : " + dynamicText.getText());

        // Wait till the I'm Late! appears and print it
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.tagName("h3"), "I'm late!"));

        WebElement lateText = driver.findElement(By.tagName("h3"));
        System.out.println("Dynamic Text : " + lateText.getText());

        //Wait for 5 Seconds and Close the Browser
        Thread.sleep(5000);
        driver.close();
    }
}
