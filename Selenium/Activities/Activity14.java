package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.List;

public class Activity14 {
    public static void main(String[] args) throws InterruptedException {
        //Setup GekoDriver
        WebDriverManager.firefoxdriver().setup();

        //Create driver Object for Firefox Browser
        FirefoxDriver driver = new FirefoxDriver();

        //Set Implicit wait of 5 Secs
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
        //Open the url
        driver.get("https://v1.training-support.net/selenium/tables");

        //Get the Title
        String title = driver.getTitle();
        System.out.print("Title of the Page is : " + title + "\n");

        List<WebElement> tableRows = driver.findElements(By.xpath("//table[@id='sortableTable']/tbody/tr"));
        System.out.printf("Number of Records of Sortable Table : %d",  tableRows.size());

        List<WebElement> tableCols = driver.findElements(By.xpath("//table[@id='sortableTable']/tbody/tr[1]/td"));
        System.out.printf("\nNumber of Columns of Sortable Table : %d\n",tableCols.size());

        WebElement cell = driver.findElement(By.xpath("//table[@id='sortableTable']/tbody/tr[2]/td[2]"));
        System.out.println(cell.getText());

        WebElement tableheader = driver.findElement(By.xpath("//table[@id='sortableTable']/thead/tr/th[1]"));
        tableheader.click();

        WebElement cell21 = driver.findElement(By.xpath("//table[@id='sortableTable']/tbody/tr[2]/td[2]"));
        System.out.println(cell21.getText());

        List<WebElement> tablefotter = driver.findElements(By.xpath("//table[@id='sortableTable']/tfoot/tr/th"));
        for (int i=0; i<tablefotter.size(); i++){
            System.out.println(tablefotter.get(i).getText());
        }

        //Wait for 5 Seconds and Close the Browser
        Thread.sleep(5000);
        driver.quit();

    }
}
