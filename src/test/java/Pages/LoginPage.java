package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.openqa.selenium.WebElement;



public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;

    By loginImageLocator = By.className("login-website-logo");
    By loginHeadingLocator = By.className("sign-in-heading");
    By usernameLocator = By.id("usernameInput");
    By passwordLocator = By.id("passwordInput");
    By loginButtonLocator = By.className("login-button");
    By errorMessageLocator = By.className("error-message");
    public  LoginPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver,Duration.ofSeconds(10));
    }

    public void enterUserName(String username){
        driver.findElement(usernameLocator).sendKeys(username);

    }
    public void enterPassword(String password){
        driver.findElement(passwordLocator).sendKeys(password);

    }
    public void clickOnLoginButton(){
        driver.findElement(loginButtonLocator).click();

    }

    public void loginToApplication(String username,String password){
        enterUserName(username);
        enterPassword(password);
        clickOnLoginButton();

    }
    public String getErrorMessage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessageLocator));
        WebElement errormessageEl = driver.findElement(errorMessageLocator);
        return errormessageEl.getText();
    }





}
