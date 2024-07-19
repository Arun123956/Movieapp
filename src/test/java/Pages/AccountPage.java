package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountPage {
    WebDriver driver;
    By accountTitle = By.cssSelector(".account-title");
    By accountDetails = By.cssSelector(".account-details");
    By logoutButton = By.cssSelector(".logout-button");
    public AccountPage(WebDriver driver) {
        this.driver = driver;
    }

    // Methods to interact with elements
    public WebElement getAccountTitle() {
        return driver.findElement(accountTitle);
    }

    public WebElement getAccountDetails() {
        return driver.findElement(accountDetails);
    }

    public WebElement getLogoutButton() {
        return driver.findElement(logoutButton);
    }

    public void clickLogoutButton() {
        getLogoutButton().click();
    }



}
