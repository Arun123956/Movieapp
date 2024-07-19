import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import Pages.LoginPage;

public class LoginPageTest {
    public WebDriver driver;
    LoginPage loginPage;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\arunk\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech");
        loginPage = new LoginPage(driver);
    }
    @Test
    public void testLoginPageUI(){
        WebElement imagedisplayed = driver.findElement(By.className("login-website-logo"));
        Assert.assertTrue(imagedisplayed.isDisplayed(),"image is not displayed");
        WebElement headingtext = driver.findElement(By.className("sign-in-heading"));
        Assert.assertTrue(headingtext.isDisplayed(),"heading is not displayed");
        WebElement usernametext = driver.findElement(By.id("usernameInput"));
        Assert.assertTrue(usernametext.isDisplayed(),"username is not displayed");
        WebElement passwordtext = driver.findElement(By.id("passwordInput"));
        Assert.assertTrue(passwordtext.isDisplayed(),"password name is not displayed");
        WebElement loginbutton = driver.findElement(By.className("login-button"));
        Assert.assertTrue(loginbutton.isDisplayed(),"loginbutton is not displayed");





    }
    @Test(priority = 1)
    public void testLoginWithEmptyInputs(){
        loginPage.clickOnLoginButton();
        String errorMessage = loginPage.getErrorMessage();
        Assert.assertEquals(errorMessage,"*Username or password is invalid","don't to match");
    }
    @Test(priority = 2)
    public void testLoginWithEmptyUser(){
        loginPage.loginToApplication("","rahul@2021");

        String errorMessage = loginPage.getErrorMessage();
        Assert.assertEquals(errorMessage,"*Username or password is invalid","Error text with empty input fields does not match");

    }
    @Test(priority = 3)
    public void testLoginWithEmptyPassword(){
        loginPage.loginToApplication("rahul","");
        String errorMessage = loginPage.getErrorMessage();

        Assert.assertEquals(errorMessage,"*Username or password is invalid","don't not match");

    }
    @Test(priority = 4)
    public void testLoginWithInvalidCredentials(){
        loginPage.loginToApplication("rahul","rahul@2022");
        String errorMessage = loginPage.getErrorMessage();
        Assert.assertEquals(errorMessage,"*username and password didn't match","don't not match");

    }
    @Test(priority = 5)
    public void testLoginWithValidCredentials(){
        loginPage.loginToApplication("rahul","rahul@2021");
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        String expectedUrl = "https://qamoviesapp.ccbp.tech/";
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl,expectedUrl,"urls do not match");


    }
    @AfterMethod
    public void tearDown(){

    }

}
