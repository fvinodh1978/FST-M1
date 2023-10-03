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

public class Activity5 {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setup() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/jobs");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void navigateToJobs() {
        WebElement jobsLink = driver.findElement(By.id("menu-item-24"));

        // Click the Job Link
        jobsLink.click();

        WebElement jobsHeader = driver.findElement(By.xpath("//span[@class='site-title']/a"));
        String expectedJobsHeader="Alchemy Jobs";
        String jobsHeaderText= jobsHeader.getText();
        Assertions.assertEquals(expectedJobsHeader, jobsHeaderText.trim());
    }

    @AfterClass
    public void cleanup() {
        driver.quit();
    }
}
