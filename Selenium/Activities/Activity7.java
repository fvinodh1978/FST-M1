package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class Activity7 {
    public static void main(String[] args) throws InterruptedException {
        //Setup GekoDriver
        WebDriverManager.firefoxdriver().setup();

        //Create driver Object for Firefox Browser
        WebDriver driver = new FirefoxDriver();

        //Set Implicit wait of 5 Secs
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
        //Open the url
        driver.get("https://v1.training-support.net/selenium/drag-drop");

        //Get the Title
        String title = driver.getTitle();
        System.out.print("Title of the Page is : " + title + "\n");

        //Get the Webelement of source and destination
        WebElement ball = driver.findElement(By.id("draggable"));
        WebElement zone1 = driver.findElement(By.id("droppable"));
        WebElement zone2 = driver.findElement(By.id("dropzone2"));

        //Build the action for drag and drop to zone1
        Actions builder = new Actions(driver);
        builder.clickAndHold(ball)
                .moveToElement(zone1)
                .release()
                .build()
                .perform();

        //Verify if the Ball is dropped to Drop Zone1 --Verify if the P tag changes to Dropped
        WebElement zone1StatusEleement = driver.findElement(By.xpath("//div[@id='droppable']/p"));
        if(zone1StatusEleement.getText().contains("Dropped!")){
            System.out.println("Ball is Dropped to DropZone1");
        }else{
            System.out.println("Ball is Not Dropped!");
        }

        //Build the action for drag and drop to zone1
        builder = new Actions(driver);
        builder.clickAndHold(ball)
                .moveToElement(zone2)
                .release()
                .build()
                .perform();

        //Verify if the Ball is dropped to Drop Zone1 --Verify if the P tag changes to Dropped
        WebElement zone2StatusEleement = driver.findElement(By.xpath("//div[@id='dropzone2']/p"));
        if(zone2StatusEleement.getText().contains("Dropped!")){
            System.out.print("Ball is Dropped to DropZone2");
        }else{
            System.out.print("Ball is Not Dropped!");
        }

        //Wait for 5 Seconds and Close the Browser
        Thread.sleep(5000);
        driver.quit();
    }
}
