package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.List;

public class Activity18 {
    public static void main(String[] args) throws InterruptedException {

        // Initialise Webdriver
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/selects");

        // Launch the GUI and Get the Title
        String title = driver.getTitle();
        System.out.print("Title of the Page is : " + title + "\n");

        // Get the Multi Select Options
        WebElement optionSelect = driver.findElement(By.id("multi-select"));
        Select multiSelect = new Select(optionSelect);

        // Select items
        multiSelect.selectByVisibleText("Javascript");
        multiSelect.selectByIndex(4);
        multiSelect.selectByIndex(5);
        multiSelect.selectByIndex(6);
        multiSelect.selectByValue("node");

        // Deselect item @ 5th index
        multiSelect.deselectByIndex(5);

        //Wait for 3 Seconds and Close the Browser
        Thread.sleep(3000);
        driver.quit();
    }
}
