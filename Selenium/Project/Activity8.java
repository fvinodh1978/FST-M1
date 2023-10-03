import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.junit.jupiter.api.Assertions;

import java.time.Duration;
import java.util.Set;

public class Activity8 {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setup() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/jobs/wp-admin");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void verifyLogin() throws InterruptedException {

        WebElement userTextBox = driver.findElement(By.id("user_login"));
        WebElement userPassBox = driver.findElement(By.id("user_pass"));
        WebElement submitButton = driver.findElement(By.id("wp-submit"));

        userTextBox.sendKeys("root");
        userPassBox.sendKeys("pa$$w0rd");
        submitButton.click();

        WebElement loginMsg = driver.findElement(By.xpath("//li[@id='wp-admin-bar-my-account']/a/span"));
        Assertions.assertEquals("root", loginMsg.getText());

    }

    @AfterClass
    public void cleanup() {
        driver.quit();
    }
}
