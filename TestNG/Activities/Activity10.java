package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Activity10 {

    // Setup the Driver
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setup() {
        System.out.println("Initialise Driver");
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://v1.training-support.net/selenium/simple-form");

    }

    @Test(dataProvider = "users")
    public void printUsers(List<Object> user) throws IOException, InterruptedException {

        // Retrieve the data from the datasource
        String firstName = user.get(1).toString();
        String lastName = user.get(2).toString();
        String email = user.get(3).toString();
        String phone = user.get(4).toString();

        System.out.println(phone);

        // Get the test box and Enter the First Name
        WebElement firstNameTextBox = driver.findElement(By.id("firstName"));
        firstNameTextBox.clear();
        firstNameTextBox.sendKeys(firstName);

        // Get the test box and Enter the Last Name
        WebElement lastNameTextBox = driver.findElement(By.id("lastName"));
        lastNameTextBox.clear();
        lastNameTextBox.sendKeys(lastName);

        // Get the test box and Enter the email
        WebElement emailTextBox = driver.findElement(By.id("email"));
        emailTextBox.clear();
        emailTextBox.sendKeys(email);

        // Get the test box and Enter the Phone Number
        WebElement phoneNumberTextBox = driver.findElement(By.id("number"));
        phoneNumberTextBox.clear();
        phoneNumberTextBox.sendKeys(phone);

        // Get the submit button and click
        WebElement submitButton = driver.findElement(By.xpath("//input[@type='submit']"));
//        WebElement submitButton = driver.findElement(By.cssSelector("input[class='green']"));
        submitButton.click();

        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
        Thread.sleep(2000);
    }

    @AfterClass
    public void cleanup() {
        driver.quit();
    }

    public List<List<Object>> readExcel(String file) throws IOException {
        List<List<Object>> excelData = new ArrayList<>();
        FileInputStream fis = new FileInputStream(new File(file));
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet("users");
        for (Row row : sheet) {
            List<Object> rowData = new ArrayList<>();
            for (Cell cell : row) {
                switch (cell.getCellType()) {
                    case STRING -> rowData.add(cell.getStringCellValue());
                    case NUMERIC -> rowData.add(cell.getNumericCellValue());
                    case BOOLEAN -> rowData.add(cell.getBooleanCellValue());
                    default -> System.out.println("Invalid Data Type");
                }
            }
            excelData.add(rowData);
        }
        return excelData;
    }

    @DataProvider(name = "users")
    public Object[][] getUsers() throws IOException {
        String file = "C:\\Users\\054544744\\IdeaProjects\\FST_TestNG_Project\\src\\main\\resources\\Users.xlsx";
        List<List<Object>> data = readExcel(file);
        return new Object[][]{
                {data.get(1)},{data.get(2)},{data.get(3)}
        };
    }
}
