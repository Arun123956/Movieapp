package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class HomePage {
    WebDriver driver;
    By headingLocator = By.className("home-movie-heading");
    By playButtonLocator = By.className("home-movie-play-button");
    By contactUsLocator = By.tagName("p");

    public HomePage(WebDriver driver){
        this.driver = driver;

    }
    public List<WebElement> getHeadings(){
        return driver.findElements(headingLocator);
    }
    public List<WebElement> getPlayButton(){
        return driver.findElements(playButtonLocator);
    }
    public WebElement getContactUs(){
        return driver.findElement(contactUsLocator);
    }



}
