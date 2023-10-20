package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertsTestSteps  {

    Alert alert;
    WebDriver driver;
    WebDriverWait wait;
    @Given("User is on the page")
    public void launchUrl(){
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "NULL");
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofMillis(3000));
        driver.get("https://v1.training-support.net/selenium/javascript-alerts");
    }

    @When("User clicks the Simple Alert button")
    public void clickSimpleAlert(){
        WebElement simpleAlert = driver.findElement(By.id("simple"));
        simpleAlert.click();
    }

    @When("User clicks the Confirm Alert button")
    public void clickConfirmAlert(){
        WebElement confirmAlert = driver.findElement(By.id("confirm"));
        confirmAlert.click();
    }

    @When("User clicks the Prompt Alert button")
    public void clickPromptAlert(){
        WebElement promptAlert = driver.findElement(By.id("prompt"));
        promptAlert.click();
    }
    @Then("Alert opens")
    public void checkSimpleAlert(){
        alert = driver.switchTo().alert();
    }

    @And("Read the text from it and print it")
    public void getAlertText(){
        String alertText=alert.getText();
        System.out.println("Alert Text : " + alertText);
    }

    @And("Write a custom message in it")
    public void writeToPromptAlert(){
        alert.sendKeys("This is Prompt Alert");
    }

    @And("Close the alert")
    public void closeAlert(){
        alert.accept();
    }

    @And("Close the alert with Cancel")
    public void closeAlertWithCancel(){
        alert.dismiss();
    }

    @And("Close Alert Browser")
    public void closeBrowser() throws InterruptedException {
        driver.close();
        Thread.sleep(5000);
    }
}
