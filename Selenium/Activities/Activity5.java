package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity5 {
    public static void main(String[] args) {

        // Setup Firefox Driver
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        // Launch the URL and get the title
        driver.get("https://v1.training-support.net/selenium/input-events");
        String pageTitle= driver.getTitle();
        System.out.println(pageTitle);

        // Build Left click action and execute it
        Actions myActions = new Actions(driver);
        myActions.click()
                .build()
                .perform();

        // Print the text on active side of dice
        WebElement dice = driver.findElement(By.className("active"));
        String diceText = dice.getText();
        System.out.println("Dice text, With left click : " + diceText);

        // Build double click action and execute it
        myActions.doubleClick()
                .build()
                .perform();

        // Print the text on active side of dice
        dice = driver.findElement(By.className("active"));
        diceText = dice.getText();
        System.out.println("Dice text, With double click : " + diceText);

        // Build Right click action and execute it
        myActions.contextClick()
                .build()
                .perform();

        // Print the text on active side of dice
        dice = driver.findElement(By.className("active"));
        diceText = dice.getText();
        System.out.println("Dice text, With right click  : " + diceText);

        // Close the Browser
        driver.close();
    }
}
