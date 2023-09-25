package activities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity6 {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setup(){
        WebDriverManager.firefoxdriver().setup();
        driver= new FirefoxDriver();
        String url = "https://v1.training-support.net/selenium/login-form";
        driver.get(url);
    }

    @Test
    @Parameters({"username", "password"})
    public void parameterTest(String user, String pass) throws InterruptedException {
        WebElement userInput = driver.findElement(By.id("username"));
        WebElement passwordInput = driver.findElement(By.id("password"));
//        WebElement submitButton = driver.findElement(By.cssSelector("button.ui.button"));
        WebElement submitButton = driver.findElement(By.xpath("//button[text()='Log in']"));
        userInput.sendKeys(user);
        passwordInput.sendKeys(pass);
        Thread.sleep(5000);
        submitButton.click();
        //Assert Message
        String loginMessage = driver.findElement(By.id("action-confirmation")).getText();
        Assert.assertEquals(loginMessage, "Welcome Back, admin");
    }

    @AfterClass
    public void cleanup(){
        driver.close();
    }
}
