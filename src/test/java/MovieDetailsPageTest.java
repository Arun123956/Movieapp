import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.time.Duration;

public class MovieDetailsPageTest {
    public WebDriver driver;
    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\arunk\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech");
        WebElement username = driver.findElement(By.id("usernameInput"));
        username.sendKeys("rahul");
        WebElement password = driver.findElement(By.id("passwordInput"));
        password.sendKeys("rahul@2021");
        WebElement button = driver.findElement(By.className("login-button"));
        button.click();
    }
    @Test
    public void testMovieDetailsFromHomePage(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Ho")));
        WebElement clickhome = driver.findElement(By.partialLinkText("Ho"));
        clickhome.click();
        String expectedUrl = "https://qamoviesapp.ccbp.tech/";
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,currentUrl,"url do not match");
        WebElement clickonmovie = driver.findElement(By.className("react-slick-item"));
        clickonmovie.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("movie-title")));
        WebElement tittle = driver.findElement(By.className("movie-title"));
        Assert.assertTrue(tittle.isDisplayed(),"do not match");
        WebElement description = driver.findElement(By.className("movie-overview"));
        Assert.assertTrue(description.isDisplayed(),"do not match");


    }
    @Test
    public void testMovieDetailsFromPopularPage(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Popular")));
        WebElement clickpopular = driver.findElement(By.linkText("Popular"));
        clickpopular.click();
        WebDriverWait wait1 = new WebDriverWait(driver,Duration.ofSeconds(5));
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.className("link-item")));
        WebElement click = driver.findElement(By.className("link-item"));
        click.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("movie-title")));
        WebElement tittle = driver.findElement(By.className("movie-title"));
        Assert.assertTrue(tittle.isDisplayed(),"do not match");
        WebElement description = driver.findElement(By.className("movie-overview"));
        Assert.assertTrue(description.isDisplayed(),"do not match");



    }




}
