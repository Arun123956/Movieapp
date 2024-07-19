import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import Pages.LoginPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import java.util.List;
import Pages.PopularPage;

import java.time.Duration;

public class PopularPageTest {
    public WebDriver driver;
    LoginPage loginPage;
    PopularPage popularPage;
    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\arunk\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech");
        loginPage = new LoginPage(driver);
        popularPage = new PopularPage(driver);
        loginPage.loginToApplication("rahul","rahul@2021");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String expectedurl = "https://qamoviesapp.ccbp.tech/";
        wait.until(ExpectedConditions.urlToBe(expectedurl));
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedurl,currentUrl,"urls do not much");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Popular")));
        WebElement clickpopular = driver.findElement(By.linkText("Popular"));
        clickpopular.click();




    }

    @Test
    public void testMovieDisplayed(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("movie-icon-item")));
        List<WebElement> moviesitem = popularPage.getMovies();
        if(moviesitem.size()>0){
            System.out.println("movies are displayed");
        }else {
            System.out.println("movies are not displayed");
        }

    }
}
