package OurPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import OurPages.MainPage;
public class MainPage {
    WebDriver driver;

    String mainPageURL = "https://www.levelset.com/";

    By getPaid = By.xpath("//a[contains(text(),'Get paid')]");


    public MainPage(WebDriver driver) {

        this.driver = driver;
    }

    public void navigateToMainPage() {
        driver.get(mainPageURL);

    }

    public void clickGetPaid() {
        driver.findElement(getPaid).click();
    }



}

