package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity16 {
    public static void main(String[] args) throws InterruptedException {
        // Initialise Webdriver
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/dynamic-attributes");

        // Initialise Wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(2000));

        // Print the Page Title
        String pageTitle = driver.getTitle();
        System.out.println("Title of the Page is : " + pageTitle);

        // Username/Password Textbox and Enter the username/password
        WebElement userTextBox= driver.findElement(By.xpath("//input[contains(@class, '-username')]"));
        WebElement passwordTextBox= driver.findElement(By.xpath("//input[contains(@class, '-password')]"));
        WebElement confirmPasswordTextBox= driver.findElement(By.xpath("//label[text()='Confirm Password']/parent::div/input"));
        WebElement emailTextBox= driver.findElement(By.xpath("//input[starts-with(@name, 'email-')]"));
        userTextBox.sendKeys("admin");
        passwordTextBox.sendKeys("password");
        confirmPasswordTextBox.sendKeys("password");
        emailTextBox.sendKeys("f.vinodhfranklin@gmail.com");

        // Click on Login Button
        WebElement signUp = driver.findElement(By.xpath("//button[text()='Sign Up']"));
        signUp.click();

        // Wait for the Confirmation Message
        WebElement confirmationText = driver.findElement(By.xpath("//div[@id='action-confirmation']"));
        wait.until(ExpectedConditions.textToBePresentInElement(confirmationText, "Thank you for registering, admin"));

        // Print the Confirmation Message
        System.out.println("Conformation Message : "+confirmationText.getText());

        // Wait for 5 Seconds and Close the Browser
        Thread.sleep(5000);
        driver.quit();
    }
}
