package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity20 {
    public static void main(String[] args) throws InterruptedException {

        // Setup the Webdriver
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver= new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(1000));

        // Launch the URL and get the title
        driver.get("https://v1.training-support.net/selenium/javascript-alerts");
        String title = driver.getTitle();
        System.out.print("Title of the Page is : " + title + "\n");

        // find and click the confirm button
        WebElement confirmButton = driver.findElement(By.id("prompt"));
        confirmButton.click();

        // Wait till the alert shows up
        wait.until(ExpectedConditions.alertIsPresent());

        // Switch focus to alert and print the alert message
        Alert confirmAlert = driver.switchTo().alert();
        System.out.println("Confirmation Alert Message : " + confirmAlert.getText());

        Thread.sleep(2000);
        confirmAlert.sendKeys("Awesome");
        // Wait for 1 Second and click accept
        Thread.sleep(1000);

        // Click Ok and close Alert
        confirmAlert.accept();

        // Wait for 3 Seconds and close the browser
        Thread.sleep(3000);
        driver.close();

    }
}
