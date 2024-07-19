import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class NXTWaveHomePage {
    public WebDriver driver;
    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\arunk\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qanxtwatch.ccbp.tech/login");
        WebElement enterusername = driver.findElement(By.xpath("//input[@id='userNameInput']"));
        enterusername.sendKeys("rahul");
        WebElement enterpassword = driver.findElement(By.xpath("//input[@id='passwordInput']"));
        enterpassword.sendKeys("rahul@2021");
        WebElement click = driver.findElement(By.id("showPassword"));
        click.click();
        WebElement Loginbutton = driver.findElement(By.xpath("//button[@id='loginButton']"));
        Loginbutton.click();
    }
    @Test(priority = 1)
    public void testClickOnHome(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Home")));

        WebElement clickHome = driver.findElement(By.partialLinkText("Home"));
        clickHome.click();

    }
    @Test(priority = 2)
    public void testClickONTreding(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Tren")));
        WebElement clickTrending = driver.findElement(By.partialLinkText("Tren"));
        clickTrending.click();



    }
    @Test(priority = 3)
    public void testClickONGaming(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Gaming")));
        WebElement clickTrending = driver.findElement(By.linkText("Gaming"));
        clickTrending.click();
        String expectedUrl ="https://qanxtwatch.ccbp.tech/gaming";
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
        String currentUrl = driver.getCurrentUrl();
        if(expectedUrl.equals(currentUrl)){
            System.out.println("url is match ");
        }
        else {
            System.out.println("url is not match");
        }
    }
    @Test(priority = 4)
    public void testClickOnSaveVideos(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Saved videos")));
        WebElement clickTrending = driver.findElement(By.linkText("Saved videos"));
        clickTrending.click();
        String expectedUrl = "https://qanxtwatch.ccbp.tech/saved-videos";
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
        String currentUrl = driver.getCurrentUrl();
        if(expectedUrl.equals(currentUrl)){
            System.out.println("url is match");
        }else {
            System.out.println("url is not match");
        }
    }
    @Test
    public void testSearchFunction(){
        


    }
    @Test(priority = 5)
    public void testLogoutFunctionality(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='desktopLogoutButton']")));
        WebElement logout = driver.findElement(By.xpath("//button[@id='desktopLogoutButton']"));
        logout.click();
        WebElement conform =driver.findElement(By.id("desktopConfirmButton"));
        conform.click();

    }
    @AfterMethod
    public void tearDown(){

    }
}
