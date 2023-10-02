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
import java.util.List;
import java.util.Set;

public class Activity21 {
    public static void main(String[] args) throws InterruptedException {

        // Setup the Webdriver
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver= new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(1000));

        // Launch the URL and get the title
        driver.get("https://v1.training-support.net/selenium/tab-opener");
        String pageTitle = driver.getTitle();
        System.out.println(" Title of the Page is : " + pageTitle);

        // Click on Multitab launcher Button
        WebElement tabLauncher = driver.findElement(By.id("launcher"));
        String homeWindow = driver.getWindowHandle();
        System.out.println("Home Window : " + homeWindow);
        tabLauncher.click();
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        Set<String> openWindows = driver.getWindowHandles();
        System.out.println("Open Windows : " + openWindows);
        for (String openWindow : openWindows){
            if(!(openWindow.equals(homeWindow))){
                driver.switchTo().window(openWindow);
            }
        }

        // Print the Current Window and the title of the page
        System.out.println("Current Window is :" + driver.getWindowHandle());
        System.out.println("Current Page title : " + driver.getTitle());


        // Click on Multitab launcher Button
        tabLauncher = driver.findElement(By.id("actionButton"));
        homeWindow = driver.getWindowHandle();
        System.out.println("Home Window : " + homeWindow);
        tabLauncher.click();
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        openWindows = driver.getWindowHandles();
        System.out.println("Open Windows : " + openWindows);
        for (String openWindow : openWindows){
            if(!(openWindow.equals(homeWindow))){
                driver.switchTo().window(openWindow);
            }
        }

        // Print the Current Window and the title of the page
        System.out.println("Current Window is :" + driver.getWindowHandle());
        System.out.println("Current Page title : " + driver.getTitle());

        // Wait for 3 Seconds and close the browser
        Thread.sleep(3000);
        driver.quit();

    }
}
