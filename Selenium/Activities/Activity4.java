package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4 {
    public static void main(String[] args) {

        // Setup Firefox webdriver
        WebDriverManager.firefoxdriver().setup();

        // Instantiate the webdriver
        WebDriver driver = new FirefoxDriver();

        // Launch the Application URL and print the title of homepage
        driver.get("https://v1.training-support.net/selenium/target-practice");
        String homeTitle=driver.getTitle();
        System.out.println("Title of the Home Page is : " + homeTitle);

        // Find and get the header3 text
        WebElement header3=driver.findElement(By.xpath("//h3[@id='third-header']"));
        String header3Text= header3.getText();
        System.out.println("Header3 text : " + header3Text);

        // Find and get the header5 color
        WebElement header5=driver.findElement(By.xpath("//h5[text()='Fifth header']"));
        String header5Color= header5.getCssValue("color");
        System.out.println("Header5 Color : " + header5Color);

        // Find and get the Text of Violet Button
        WebElement violetButton=driver.findElement(By.xpath("//button[text()='Violet']"));
        String violetButtonClasses= violetButton.getAttribute("class");
        System.out.println("Violet Button Class : " + violetButtonClasses);

        // Find and get the Text of Grey Button
        WebElement greyButton=driver.findElement(By.xpath("//button[text()='Grey']"));
        String greyButtonColor= greyButton.getText();
        System.out.println("Grey Button Color : " + greyButtonColor);

        // CLose the Browser
        driver.close();
    }
}
