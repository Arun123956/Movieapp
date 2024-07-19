import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.chrome.ChromeDriver;
import Pages.LoginPage;
import org.testng.annotations.Test;



import java.time.Duration;
import java.util.List;

public class SearchPageTest {
    public WebDriver driver;
    LoginPage loginPage;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\arunk\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech");
        loginPage = new LoginPage(driver);

        loginPage.loginToApplication("rahul","rahul@2021");
        String expectedurl = "https://qamoviesapp.ccbp.tech/";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(expectedurl));
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedurl,currentUrl,"urls do not much");
    }
    @Test
    public void testSearchFunctionality(){





    }
    @Test
    public void testSearchFunctionalityWithInvalidMovieName(){

    }
}
