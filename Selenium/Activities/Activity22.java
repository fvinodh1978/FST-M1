package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class Activity22 {
    public static void main(String[] args) throws InterruptedException {

        // Setup the Webdriver
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver= new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(1000));

        // Launch the URL and get the title
        driver.get("https://v1.training-support.net/selenium/popups");
        String pageTitle = driver.getTitle();
        System.out.println(" Title of the Page is : " + pageTitle);

        // Locate the Sign In Button
        WebElement signInButton = driver.findElement(By.cssSelector("button.ui.huge.inverted.orange.button"));

        // Build Actions to hover over the sign in button
        Actions builder = new Actions(driver);
        builder.moveToElement(signInButton).build().perform();

        // Print the tool tip Message
        System.out.println(signInButton.getAttribute("data-tooltip"));

        // CLick the SignIn Button
        signInButton.click();

        // Location the username and password Text Box and click Submit
        WebElement userTextBox = driver.findElement(By.id("username"));
        WebElement passTextBox = driver.findElement(By.id("password"));
        userTextBox.sendKeys("admin");
        passTextBox.sendKeys("password");

        WebElement loginInButton = driver.findElement(By.xpath("//button[text()='Log in']"));
        loginInButton.click();

        // Locate the Login Confirmation Message
        WebElement confirmationMessage = driver.findElement(By.id("action-confirmation"));
        System.out.println("Login Confirmation Message is : "+ confirmationMessage.getText());

        // Wait for 3 Seconds and close the browser
        Thread.sleep(3000);
        driver.quit();

    }
}
