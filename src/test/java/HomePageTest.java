import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import java.util.List;
import Pages.HomePage;
import Pages.LoginPage;

import java.time.Duration;


public class HomePageTest {
    public WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;
    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\arunk\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech");
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        loginPage.loginToApplication("rahul","rahul@2021");

    }
    @Test(priority = 1)
    public void testHeadingText(){
        List<WebElement> headings = homePage.getHeadings();
        for(WebElement heading : headings){
            System.out.println(heading.getText());
        }

    }
    @Test(priority = 2)
    public void testPlayButtonDisplayed(){
        List<WebElement> playButtons = homePage.getPlayButton();
        for(WebElement button : playButtons){
            Assert.assertTrue(button.isDisplayed(),"Play button is bot displayed");
        }
    }
    @Test(priority = 3)
    public void testContactUsSection(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("p")));
        WebElement contactus = homePage.getContactUs();
        Assert.assertTrue(contactus.isDisplayed(),"Contact us section is not displayed");
    }
    @AfterMethod
    public void tearDown(){

    }
}
