package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity5 {
    WebDriver driver;


    @BeforeClass(alwaysRun = true)
    public void setup(){
        WebDriverManager.firefoxdriver().setup();
        String url = "https://v1.training-support.net/selenium/target-practice";
        driver = new FirefoxDriver();
        driver.get(url);
    }
    @Test(groups={"HeaderTests", "ButtonTests"})
    public void testTitle() {
        String expectedTitle="Target Practice";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @Test(groups="HeaderTests")
    public void testHeader3(){
        String expectedText="Third header";
        WebElement header3 = driver.findElement(By.xpath("//div[@class='column']/h3"));
        String actualText = header3.getText();
        Assert.assertEquals(actualText, expectedText);
    }

    @Test(groups="HeaderTests")
    public void testHeader5(){
        String expectedColor="Third header";
        WebElement header5 = driver.findElement(By.cssSelector("h5.ui.green.header"));
        String color = header5.getCssValue("color");
        Assert.assertEquals(color, "rgb(33, 186, 69)");
    }

    @Test(groups="ButtonTests")
    public void testOliveButton(){
        String expectedText="Olive";
        WebElement buttonOlive = driver.findElement(By.cssSelector("button.ui.olive.button"));
        String actualText = buttonOlive.getText();
        Assert.assertEquals(actualText, expectedText);
    }

    @Test(groups="ButtonTests")
    public void testBrownButton(){
        String expectedText="Brown";
        WebElement buttonBrown = driver.findElement(By.className("brown"));
        String color = buttonBrown.getCssValue("box-shadow");
        System.out.println(color);
        Assert.assertEquals("rgba(34, 36, 38, 0.15) 0px 0px 0px 0px inset", color);
    }
    @AfterClass(alwaysRun = true)
    public void cleanup(){
        driver.close();
    }
}
