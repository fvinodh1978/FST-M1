package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity1 {
    public static void main(String[] args) {
        // Setup Firefox Driver
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        // Open the URL and get the title
        driver.get("https://v1.training-support.net");
        String title = driver.getTitle();
        System.out.println("Title of the Home Page is : " + title);

        // Get the aboutus Link and click on it and print the title
        WebElement aboutUsLink= driver.findElement(By.id("about-link"));
        aboutUsLink.click();
        String aboutUsTitle=driver.getTitle();
        System.out.println("Title of the AboutUs Page is : " + aboutUsTitle);

        // Close the Browser
        driver.close();

    }
}
