import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;


public class TestCase1 {

    private WebDriver driver;

    @Test
    public void TryOne() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);

        driver.get("https://www.saucedemo.com/");
        login("standard_user", "secret_sauce");

        String[] products = {"Sauce Labs Backpack", "Sauce Labs Bolt T-Shirt"};
        for (String product : products) {
            addToCart(product);
        }

        driver.get("https://www.saucedemo.com/cart.html");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        for (String product : products) {
            String itemLocatorFormat = "//div[@class='inventory_item_name' and contains(text(),'%s')]";
            By itemByLocator = By.xpath(String.format(itemLocatorFormat, product));

            try {
                wait.until(ExpectedConditions.visibilityOfElementLocated(itemByLocator));
            } catch (TimeoutException e) {
                System.out.println("Element not existed for product: " + product);
            }
        }
    }

    private void login(String username, String password) {
        By usernameLocator = By.id("user-name");
        WebElement user = driver.findElement(usernameLocator);
        user.sendKeys(username);

        By passwordLocator = By.id("password");
        WebElement pass = driver.findElement(passwordLocator);
        pass.sendKeys(password);

        By loginButtonLocator = By.id("login-button");
        WebElement login = driver.findElement(loginButtonLocator);
        login.click();
    }

    private void addToCart(String productName) {
        String locatorFormat = "add-to-cart-%s";
        String locator = String.format(locatorFormat, productName.toLowerCase().replace(" ", "-").trim());
        driver.findElement(By.name(locator)).click();
    }
}
