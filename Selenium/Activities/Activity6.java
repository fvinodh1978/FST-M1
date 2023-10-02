package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity6 {
    public static void main(String[] args) {

        // Setup Firefox Driver
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        // Launch the URL and get the title
        driver.get("https://v1.training-support.net/selenium/input-events");
        String pageTitle= driver.getTitle();
        System.out.println(pageTitle);

        // Initialize Actions
        Actions myActions = new Actions(driver);

        // Build and Execute send Capital letter V
        myActions
                .sendKeys("V")
                .build()
                .perform();

        // Build actions to select and copy
        myActions
                .keyDown(Keys.CONTROL)
                .sendKeys("a")
                .sendKeys("c")
                .keyUp(Keys.CONTROL)
                .build()
                .perform();

        // Close the Browser
        driver.close();
    }
}
