import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;
import java.util.List;

public class Activity7 {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setup() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/jobs");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void applyJobs() throws InterruptedException {

        WebElement postJobsLink = driver.findElement(By.id("menu-item-26"));

        // Click the Job Link
        postJobsLink.click();

        WebElement email = driver.findElement(By.id("create_account_email"));
        email.sendKeys("vfrankli2@in.ibm.com");

        WebElement jobTitle = driver.findElement(By.id("job_title"));
        jobTitle.sendKeys("Data Analyst1");

        WebElement location = driver.findElement(By.id("job_location"));
        location.sendKeys("USA");

        WebElement jobType = driver.findElement(By.xpath("//select[@id='job_type']"));
        Select dropDownHandle = new Select(jobType);
        dropDownHandle.selectByVisibleText("Part Time");

        Set<String> myHandles = driver.getWindowHandles();
        for (String myHandle : myHandles) {
            driver.switchTo().window(myHandle);
            System.out.println(myHandle);
            Thread.sleep(2000);
        }
        WebElement myIframe = driver.findElement(By.xpath("//iframe[@id='job_description_ifr']"));
        System.out.println(myIframe.getAttribute("title"));
        driver.switchTo().frame(myIframe);

        Set<String> myHandles1 = driver.getWindowHandles();
        for (String myHandle1 : myHandles1) {
            System.out.println(myHandle1);
            Thread.sleep(2000);
        }

        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//body[@id='tinymce']/p"))));

//        WebElement paragraph = driver.findElement(By.xpath("//body[@id='tinymce']/p"));
        WebElement paragraph = driver.findElement(By.xpath("//body[@id='tinymce']/p"));
        JavascriptExecutor js = (JavascriptExecutor)driver;
//        js.executeScript("document.getElementsById('tinymce').innerHTML = 'Unix System Administrator';", description);

        js.executeScript("arguments[0].textContent = arguments[1];", paragraph, "This is a test");

        driver.switchTo().defaultContent();

        WebElement application = driver.findElement(By.id("application"));
        application.sendKeys("f.vinodhfranklin1@gmail.com");

        WebElement companyName = driver.findElement(By.xpath("//input[@id='company_name']"));
        companyName.sendKeys("IBM");

        WebElement companySite = driver.findElement(By.xpath("//input[@id='company_website']"));
        companySite.sendKeys("www.ibm.com");

        WebElement previewButton = driver.findElement(By.xpath("//input[@name='submit_job']"));
        previewButton.click();

        WebElement submitButton = driver.findElement(By.xpath("//input[@id='job_preview_submit_button']"));
        submitButton.click();

        WebElement jobsList = driver.findElement(By.xpath("//li[@id='menu-item-24']/a"));
        jobsList.click();

        WebElement searchText = driver.findElement(By.xpath("//input[@id='search_keywords']"));
        searchText.sendKeys("Data Analyst1");

        WebElement searchLocation = driver.findElement(By.xpath("//input[@id='search_location']"));
        searchLocation.sendKeys("USA");

        List<WebElement> jobListings = driver.findElements(By.xpath("//ul[@class='job_listings']/li"));
        int jobCount = jobListings.size();

        Assertions.assertEquals(1 , jobCount);
    }

    @AfterClass
    public void cleanup() {
        driver.quit();
    }
}
