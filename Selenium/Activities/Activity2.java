package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity2 {
    public static void main(String[] args) {

        // Setup Firefox webdriver
        WebDriverManager.firefoxdriver().setup();

        // Instantiate the webdriver
        WebDriver driver = new FirefoxDriver();

        // Launch the Application URL and print the title of homepage
        driver.get("https://v1.training-support.net/selenium/login-form");
        String homeTitle=driver.getTitle();
        System.out.println("Title of the Home Page is : " + homeTitle);

        // get the username textbox and type admin
        WebElement userTextbox=driver.findElement(By.name("Username"));
        userTextbox.sendKeys("admin");

        // get the password textbox and type password
        WebElement passTextbox=driver.findElement(By.id("password"));
        passTextbox.sendKeys("password");

        // get the Submit Button and click on it
        WebElement submitButton=driver.findElement(By.cssSelector("button.ui.button"));
        submitButton.click();

        // CLose the Browser
        driver.close();
    }
}
