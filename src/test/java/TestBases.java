import OurPages.MainPage;
import OurPages.Secondpage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import OurPages.MainPage;
public class TestBases {
    WebDriver driver;

    Secondpage secondpage;

    MainPage mainPage;


    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        mainPage = new MainPage(driver);

        secondpage = new Secondpage(driver);

    }

    @Test
    public void TryYourTestCase() {
        mainPage.navigateToMainPage();

        mainPage.clickGetPaid();

        secondpage.getdocumentname();

        Assert.assertEquals(secondpage.getPriceText(), "$149");

        Assert.assertTrue(secondpage.getdocumentname().equals("Release a Lien"));

    }


    @AfterTest
    public void closeDown() {

        driver.quit();
    }
}
