package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity11 {
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

        // Check if checkbox is Selected
        WebElement checkBox = driver.findElement(By.cssSelector("input.willDisappear"));
        System.out.println("Checkbox is Checked : " + checkBox.isSelected());

        // Select the Check Box
        checkBox.click();

        // Check if checkbox is Selected
        System.out.println("Checkbox is Checked : " + checkBox.isSelected());

        //Wait for 5 Seconds and Close the Browser
        Thread.sleep(5000);
        driver.close();
    }
}
