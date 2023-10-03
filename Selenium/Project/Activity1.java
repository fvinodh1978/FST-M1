import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.junit.jupiter.api.Assertions;

import java.time.Duration;

public class Activity1 {
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
    public void verifyTitle() {
        String title = driver.getTitle();
        String expectedTitle="Alchemy Jobs – Job Board Application";
        Assertions.assertEquals(expectedTitle, title);
    }

    @AfterClass
    public void cleanup() {
        driver.quit();
    }
}
