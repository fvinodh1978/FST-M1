package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity19 {
    public static void main(String[] args) throws InterruptedException {

        // Setup the Webdriver
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver= new FirefoxDriver();

        // Launch the URL and get the title
        driver.get("https://v1.training-support.net/selenium/javascript-alerts");
        String title = driver.getTitle();
        System.out.print("Title of the Page is : " + title + "\n");

        // find and click the confirm button
        WebElement confirmButton = driver.findElement(By.id("confirm"));
        confirmButton.click();

        // Switch focus to alert and print the alert message
        Alert confirmAlert = driver.switchTo().alert();
        System.out.println("Confirmation Alert Message : " + confirmAlert.getText());

        // Wait for 1 Second and click accept
        Thread.sleep(1000);

        // Click Ok and close Alert
        confirmAlert.accept();

        // Wait for 2 Seconds and Click the confirm button
        Thread.sleep(2000);
        confirmButton.click();
        confirmAlert= driver.switchTo().alert();

        // Wait for 1 Second and click dismiss
        Thread.sleep(1000);
        confirmAlert.dismiss();

        // Wait for 3 Seconds and close the browser
        Thread.sleep(3000);
        driver.close();

    }
}
