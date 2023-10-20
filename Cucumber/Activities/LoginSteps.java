package stepDefinitions;

import io.cucumber.java.ParameterType;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class LoginSteps extends BaseClass{
    @Given("User is on Login page")
    public void loginPage() {
        //Setup instances
        WebDriverManager.firefoxdriver().setup();
        driver=new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofMillis(3000));
        //Open browser
        driver.get("https://v1.training-support.net/selenium/login-form");
    }

    @When("User enters username and password")
    public void enterCredentials() {
        //Enter username
        driver.findElement(By.id("username")).sendKeys("admin");
        //Enter password
        driver.findElement(By.id("password")).sendKeys("password");
        //Click Login
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    @ParameterType(value = ".+")
    public String username(String... s) {
        if (s.length > 0) {
            return s[0];
        }
        return null;
    }

    @ParameterType(value = ".+")
    public String password(String... s) {
        if (s.length > 0) {
            return s[0];
        }
        return null;
    }

    @When("User enters {string} and {string}")
    public void user_enters_and(String username, String password) throws Throwable {
        //Enter username from Feature file
        driver.findElement(By.id("username")).sendKeys(username);
        //Enter password from Feature file
        driver.findElement(By.id("password")).sendKeys(password);
        //Click Login
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    @Then("Read the page title and confirmation message")
    public void readTitleAndHeading() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("action-confirmation")));

        //Read the page title and heading
        String pageTitle = driver.getTitle();
        String confirmMessage = driver.findElement(By.id("action-confirmation")).getText();

        //Print the page title and heading
        System.out.println("Page title is: " + pageTitle);
        System.out.println("Login message is: " + confirmMessage);

        //Assertion
        Assert.assertEquals(confirmMessage, "Welcome Back, admin");
    }

    @And("Close the GUI Browser")
    public void closeBrowser() {
        //Close browser
        driver.close();
    }

}