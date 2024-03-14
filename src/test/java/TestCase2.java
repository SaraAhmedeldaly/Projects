
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

import java.time.Duration;
import java.util.List;

public class TestCase2 {

    WebDriver driver;

    @BeforeTest
    public void OpenURL() {
        driver = new ChromeDriver();
        driver.navigate().to("https://www.saucedemo.com/");

    }
    @Test
    public void CheckFeilds (){

        WebElement userNameTxt= driver.findElement(By.id("user-name"));
        WebElement PassTxt= driver.findElement(By.id("password"));
        WebElement LgnBtn=driver.findElement(By.id("login-button"));

        userNameTxt.clear();
        userNameTxt.sendKeys("standard_user");
        PassTxt.clear();
        PassTxt.sendKeys("secret_sauce");

        LgnBtn.click();

        driver.navigate().to("https://www.saucedemo.com/inventory.html");

        List <WebElement> links =driver.findElements(By.className("inventory_item"));

        Assert.assertEquals(6, links.size());
        System.out.println(links);
    }


    @Test
    public void closeDriver() {
        driver.close();
    }

}