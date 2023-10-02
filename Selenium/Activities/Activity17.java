package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

public class Activity17 {
    public static void main(String[] args) throws InterruptedException {
        //Setup GekoDriver
        WebDriverManager.firefoxdriver().setup();

        //Create driver Object for Firefox Browser
        FirefoxDriver driver = new FirefoxDriver();

        //Set Implicit wait of 5 Secs
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
        //Open the url
        driver.get("https://v1.training-support.net/selenium/selects");

        //Get the Title
        String title = driver.getTitle();
        System.out.print("Title of the Page is : " + title + "\n");

        //Get the Handle of Dropdown
        WebElement dropDown = driver.findElement(By.xpath("//select[@id='single-select']"));
        Select dropDownHandle = new Select(dropDown);

        //Select 2nd Option by Visible Text
        Thread.sleep(2000);
        dropDownHandle.selectByVisibleText("Option 2");

        //Select 2nd Option by Value
        Thread.sleep(5000);
        dropDownHandle.selectByValue("4");

        //Get the Options from the Dropdown into a List and Print the items
        List<WebElement> items = dropDownHandle.getOptions();
        for (WebElement item : items){
            System.out.println(item.getText());
        }

        //Wait for 5 Seconds and Close the Browser
        Thread.sleep(5000);
        driver.quit();
    }
}
