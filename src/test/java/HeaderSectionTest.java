import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import Pages.LoginPage;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.util.List;

import java.time.Duration;

public class HeaderSectionTest {
    public WebDriver driver;
    LoginPage loginPage;
    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\arunk\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech");
        loginPage = new LoginPage(driver);
        loginPage.loginToApplication("rahul","rahul@2021");
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        String expectedUrl = "https://qamoviesapp.ccbp.tech/";
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl,expectedUrl,"urls do not match");


    }
    @Test
    public void testWebsiteLogoDisplayed(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[alt='website logo']")));
        WebElement websitelogo = driver.findElement(By.cssSelector("img[alt='website logo']"));
        Assert.assertTrue(websitelogo.isDisplayed(),"Website logo is not displayed");

    }
    @Test
    public void testNavBarElements(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("nav a")));
       List<WebElement> navbar = driver.findElements(By.cssSelector("nav a"));
       Assert.assertTrue(navbar.size()>0,"Navbar elements are not displayed");
       for(WebElement element : navbar){
           System.out.println(element.getText());
           Assert.assertTrue(element.isDisplayed(),"Navbar element is not displayed");
       }



    }
    @Test(priority = 1)
    public void headerSectionFunctionalities(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Ho")));

        WebElement clickhome = driver.findElement(By.partialLinkText("Ho"));
        clickhome.click();
        String expectedUrl = "https://qamoviesapp.ccbp.tech/";
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,currentUrl,"url do not match");

    }
    @Test(priority = 2)
    public void testNavigationToPopularPage(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Popular")));
        WebElement clickpopular = driver.findElement(By.linkText("Popular"));
        clickpopular.click();
        String expectedUrl = "https://qamoviesapp.ccbp.tech/popular";
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,currentUrl,"url do not match");

    }

    @AfterMethod
    public void tearDown(){


    }


}
