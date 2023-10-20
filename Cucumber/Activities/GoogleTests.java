package stepDefinitions;

import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GoogleTests extends BaseClass{

//    @BeforeAll
    public static void setup(){
        WebDriverManager.firefoxdriver().setup();
        driver=new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofMillis(3000));
    }
    @Given("User is on Google Home Page")
    public void launchUrl() {
        driver.get("https://www.google.com");
    }

    @When("User types in Cheese and hits ENTER")
    public void searchWord() {
        WebElement searchField = driver.findElement(By.xpath("//textarea[@id='APjFqb']"));
        searchField.sendKeys("Cheese", Keys.RETURN);
    }

    @And("Show how many search results were shown")
    public void getResultCount() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='result-stats']")));
        WebElement result= driver.findElement(By.xpath("//div[@id='result-stats']"));
        System.out.println("Number of results found: " + result.getText());
    }
    @And("Close the browser")
    public void closeBrowser() {
        driver.close();
    }
}
