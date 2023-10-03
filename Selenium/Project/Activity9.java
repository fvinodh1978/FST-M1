import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Activity9 {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setup() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/jobs/wp-admin");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
    }

    @Test
    public void createJobListing() throws InterruptedException {

        WebElement userTextBox = driver.findElement(By.id("user_login"));
        WebElement userPassBox = driver.findElement(By.id("user_pass"));
        WebElement submitButton = driver.findElement(By.id("wp-submit"));

        userTextBox.sendKeys("root");
        userPassBox.sendKeys("pa$$w0rd");
        submitButton.click();

        WebElement jobListings = driver.findElement(By.xpath("//li[@id='menu-posts-job_listing']/a/div[3]"));
        jobListings.click();

        WebElement jobsCount = driver.findElement(By.xpath("//a[@class='current']/span"));

        String numJobsB4Add=jobsCount.getText();

        int oldJobs = Integer.parseInt(numJobsB4Add.substring(numJobsB4Add.indexOf("(")+1, numJobsB4Add.indexOf(")")));
        System.out.println("Number of Jobs before Add : " + oldJobs);

        WebElement addNew = driver.findElement(By.xpath("//div[@id='wpbody-content']/div[4]/a"));
        addNew.click();

        Thread.sleep(2000);

        WebElement modal = driver.findElement(By.xpath("//button[@aria-label='Close dialog']"));
        modal.click();

        WebElement jobPosition = driver.findElement(By.xpath("//textarea[@id='post-title-0']"));
        jobPosition.sendKeys("Data Analyst");

        WebElement jobLocation = driver.findElement(By.id("_job_location"));
        jobLocation.sendKeys("USA");

        WebElement companyName = driver.findElement(By.id("_company_name"));
        companyName.sendKeys("IBM");

        WebElement publishButton = driver.findElement(By.xpath("//div[@class='edit-post-header__settings']/button[2]"));
        publishButton.click();

        WebElement publishConfirmButton = driver.findElement(By.xpath("//div[@class='editor-post-publish-panel']/div/div/button"));
        publishConfirmButton.click();
        Thread.sleep(2000);
        driver.navigate().back();

        WebElement jobListingsConfirm = driver.findElement(By.xpath("//li[@id='menu-posts-job_listing']/a/div[3]"));
        jobListingsConfirm.click();

        WebElement newjobsText = driver.findElement(By.xpath("//a[@class='current']/span"));
        String newJobsCountText=newjobsText.getText();
        int newJobsCount = Integer.parseInt(newJobsCountText.substring(newJobsCountText.indexOf("(")+1, newJobsCountText.indexOf(")")));
        System.out.println("Number of Jobs After Add : " + newJobsCount);

        Assertions.assertEquals(oldJobs+1, newJobsCount);
        Thread.sleep(2000);
    }

    @AfterClass
    public void cleanup() {
        driver.quit();
    }
}
