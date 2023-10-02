package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity3 {
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
        WebElement userTextbox=driver.findElement(By.xpath("//input[@id= 'username']"));
        userTextbox.sendKeys("admin");

        // get the password textbox and type password
        WebElement passTextbox=driver.findElement(By.xpath("//input[@name= 'Password']"));
        passTextbox.sendKeys("password");

        // get the Submit Button and click on it
        WebElement submitButton=driver.findElement(By.xpath("//button[text()= 'Log in']"));
        submitButton.click();

        // Get the confirmation Text
        WebElement confirmation=driver.findElement(By.xpath("//div[@id= 'action-confirmation']"));
        System.out.println("Confirmation Page : " + confirmation.getText());

        // CLose the Browser
        driver.close();
    }
}
