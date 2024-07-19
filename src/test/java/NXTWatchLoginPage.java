import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;


public class NXTWatchLoginPage {
    public WebDriver driver;
    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\arunk\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qanxtwatch.ccbp.tech/login");


    }
    @Test(priority = 1)
    public void testLoginWithEmptyInputs(){
        WebElement Loginbutton = driver.findElement(By.xpath("//button[@id='loginButton']"));
        Loginbutton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("p")));
        WebElement errormessage = driver.findElement(By.tagName("p"));
        String acutalerror = errormessage.getText();
        String expectederror = "*Username or password is invalid";
        Assert.assertEquals(acutalerror,expectederror,"do not match");



    }
    @Test(priority = 2)
    public void testLoginWithEmptyUser(){
        WebElement enterpassword = driver.findElement(By.xpath("//input[@id='passwordInput']"));
        enterpassword.sendKeys("rahul@2021");
        WebElement Loginbutton = driver.findElement(By.xpath("//button[@id='loginButton']"));
        Loginbutton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("p")));
        WebElement errormessage = driver.findElement(By.tagName("p"));
        String acutalerror = errormessage.getText();
        String expectederror = "*Username or password is invalid";
        Assert.assertEquals(acutalerror,expectederror,"do not match");


    }
    @Test(priority = 3)
    public void testLoginWithEmptyPassword(){
        WebElement enterusername = driver.findElement(By.xpath("//input[@id='userNameInput']"));
        enterusername.sendKeys("rahul");
        WebElement Loginbutton = driver.findElement(By.xpath("//button[@id='loginButton']"));
        Loginbutton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("p")));
        WebElement errormessage = driver.findElement(By.tagName("p"));
        String acutalerror = errormessage.getText();
        String expectederror = "*Username or password is invalid";
        Assert.assertEquals(acutalerror,expectederror,"do not match");
    }
    @Test(priority = 4)
    public void testLoginWithInvalidCredentials(){
        WebElement enterusername = driver.findElement(By.xpath("//input[@id='userNameInput']"));
        enterusername.sendKeys("rahul");
        WebElement enterpassword = driver.findElement(By.xpath("//input[@id='passwordInput']"));
        enterpassword.sendKeys("rahul2021");
        WebElement Loginbutton = driver.findElement(By.xpath("//button[@id='loginButton']"));
        Loginbutton.click();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("p")));
        WebElement errprmessage = driver.findElement(By.tagName("p"));
        String acutualerror  = errprmessage.getText();
        String expectederroer = "*username and password didn't match";
        if(expectederroer.equals(acutualerror)){
            System.out.print("error message is matched here");
        }
        else {
            System.out.println("error message is doesn't matched");
        }



    }
    @Test(priority = 5)
    public void testLoginWithValidCredentials(){
        WebElement enterusername = driver.findElement(By.xpath("//input[@id='userNameInput']"));
        enterusername.sendKeys("rahul");
        WebElement enterpassword = driver.findElement(By.xpath("//input[@id='passwordInput']"));
        enterpassword.sendKeys("rahul@2021");
        WebElement click = driver.findElement(By.id("showPassword"));
        click.click();
        WebElement Loginbutton = driver.findElement(By.xpath("//button[@id='loginButton']"));
        Loginbutton.click();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        String expectedUrl = "https://qanxtwatch.ccbp.tech/";
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
        String currentUrl = driver.getCurrentUrl();

    }
    @AfterMethod
    public void tearDown(){


    }
}
