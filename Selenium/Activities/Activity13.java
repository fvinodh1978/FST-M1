package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

public class Activity13 {
    public static void main(String[] args) throws InterruptedException {
        // Setup GekoDriver
        WebDriverManager.firefoxdriver().setup();

        // Create driver Object for Firefox Browser
        WebDriver driver = new FirefoxDriver();

        // Set Explicit wait of 5 Secs
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000));

        // Open the url
        driver.get("https://v1.training-support.net/selenium/tables");

        // Get the Title
        String title = driver.getTitle();
        System.out.print("Title of the Page is : " + title + "\n");

        // Get the number of Rows and Columns in the first table
        List<WebElement> table1Rows = driver.findElements(By.xpath("//table[@class='ui celled striped table']/tbody/tr"));
        List<WebElement> table1Columns = driver.findElements(By.xpath("//table[@class='ui celled striped table']/tbody/tr[1]/td"));
        System.out.println("First Table : Number of Rows : " + table1Rows.size() + ", Number of Columns : " + table1Columns.size());

        // Print the content of 3rd row cell values
        List<WebElement> thirdRow = driver.findElements(By.xpath("//table[@class='ui celled striped table']/tbody/tr[3]/td"));
        int cellCount=0;
        for (WebElement field : thirdRow){
            System.out.printf("Value of %d th Cell is : %s, ",cellCount  , field.getText());
            cellCount++;
        }

        // Get the value of 2nd row 3rd column
        WebElement sendRowThirdColumn = driver.findElement(By.xpath("//table[@class='ui celled striped table']/tbody/tr[2]/td[3]"));
        System.out.printf("\nValue of 2nd Row 3rd Column is : %s ", sendRowThirdColumn.getText());

        // Wait for 5 Seconds and Close the Browser
        Thread.sleep(5000);
        driver.close();
    }
}
