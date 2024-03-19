package OurPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import OurPages.MainPage;
import java.time.Duration;

public class Secondpage {

    public Secondpage(WebDriver driver1){
        this.driver=driver1;
    }

    WebDriverWait wait;
    WebDriver driver;
    By DocNameLocator = By.xpath("//div[@class='left' and contains(text(),'Release a Lien')]");
    By price = By.xpath("//div[3]/div/div/div[3]/div/div[2]/div[1]/div[2]/div/div[4]/div[1]/div[2]");

    private WebElement DocumentNameThatSelected(){
        wait=new WebDriverWait(driver, Duration.ofSeconds(30));

        wait.until(ExpectedConditions.presenceOfElementLocated(DocNameLocator));

        return driver.findElement(DocNameLocator);
    }

    public String getdocumentname(){

        return DocumentNameThatSelected().getText();


    }

    public String getPriceText() {
        WebElement priceElement = driver.findElement(price);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOf(priceElement));

        return priceElement.getText();
    }
}
