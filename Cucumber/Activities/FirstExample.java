package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class FirstExample extends BaseClass {

    @Given("^User is on the homepage$")
    public void openHomepage(){
        driver.get("https://v1.training-support.net");
    }

    @When("User clicks the About Us Link")
    public void clickLink(){
        WebElement aboutLink = driver.findElement(By.id("about-link"));
        aboutLink.click();
    }

    @Then("User is Taken to About Page")
    public void verifyAboutPage(){
        Assertions.assertEquals("About Training Support", driver.getTitle());
    }

    @Then("Close the Browser")
    public void closeBrowser(){
        driver.quit();
    }

}
