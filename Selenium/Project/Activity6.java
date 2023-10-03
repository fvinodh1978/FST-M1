import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity6 {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setup() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/jobs");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
    }

    @Test
    public void applyJobs() throws InterruptedException {

        WebElement jobsLink = driver.findElement(By.id("menu-item-24"));

        // Click the Job Link
        jobsLink.click();

        WebElement searchJob = driver.findElement(By.xpath("//input[@id='search_keywords']"));
        searchJob.sendKeys("Banking");

        WebElement searchButton = driver.findElement(By.xpath("//input[@type='submit']"));
        searchButton.click();

        WebElement jobName = driver.findElement(By.xpath("//div[@class='job_listings']/ul/li[1]/a"));
        jobName.click();

        WebElement applyButton = driver.findElement(By.xpath("//input[@class='application_button button']"));
        applyButton.click();

        WebElement confirmMsg = driver.findElement(By.xpath("//a[@class='job_application_email']"));
        String email = confirmMsg.getText();

        System.out.println("Email Id is : " + email);
    }

    @AfterClass
    public void cleanup() {
        driver.quit();
    }
}
