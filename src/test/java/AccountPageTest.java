import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.Assert;
import Pages.AccountPage;

public class AccountPageTest {
    public WebDriver driver;
    AccountPage accountPage;
    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\arunk\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech");
        accountPage = new AccountPage(driver);
        WebElement username = driver.findElement(By.id("usernameInput"));
        username.sendKeys("rahul");
        WebElement password = driver.findElement(By.id("passwordInput"));
        password.sendKeys("rahul@2021");
        WebElement button = driver.findElement(By.className("login-button"));
        button.click();

    }
    @Test
    public void testAccountPageUI(){
        WebElement title = accountPage.getAccountTitle();
        WebElement details = accountPage.getAccountDetails();
        WebElement logoutButton = accountPage.getLogoutButton();

        Assert.assertTrue(title.isDisplayed(), "Account title is not displayed");
        Assert.assertTrue(details.isDisplayed(), "Account details are not displayed");
        Assert.assertTrue(logoutButton.isDisplayed(), "Logout button is not displayed");
    }
    @Test void testLogoutFunctionality(){
        accountPage.clickLogoutButton();

        WebElement loginButton = driver.findElement(By.cssSelector(".login-button"));
        Assert.assertTrue(loginButton.isDisplayed(), "Login button is not displayed after logout");
    }
}
