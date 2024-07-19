import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Set;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class window {
    public static void main(String[]args){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\arunk\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://rahulnxttrendz.ccbp.tech/login");
        driver.navigate().refresh();
        driver.navigate().back();
        driver.navigate().forward();
        WebElement usernameEl = driver.findElement(By.id("username"));
        String username = usernameEl.getTagName();
        System.out.println(username);
        String tittle = driver.getTitle();
        System.out.println(tittle);
        String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);
        String pagesource = driver.getPageSource();
        System.out.println(pagesource);
        String cssvalue = usernameEl.getCssValue("font-size");
        System.out.println(cssvalue);
        String text = usernameEl.getText();
        System.out.println(text);
        String gerattribute = usernameEl.getAttribute("class");
        System.out.println(gerattribute);
        Dimension elementsize = usernameEl.getSize();
        int width = elementsize.getWidth();
        int birdth = elementsize.getHeight();
        System.out.println("Element width and height:");
        System.out.println("Element width: " + width);
        System.out.println("Element height: " + birdth);
        usernameEl.sendKeys("rahul");
        usernameEl.clear();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("login-button")));

        WebElement button = driver.findElement(By.className("login-button"));
        Dimension elementsize1 = button.getSize();
        int width1 = elementsize1.getWidth();
        int height1 = elementsize1.getHeight();
        System.out.println("Element width and height: " + elementsize1);
        System.out.println("Element width : " + width1);
        System.out.println("Element height : " + height1);
        button.click();
        String tagname = button.getTagName();
        System.out.println(tagname);
        String cssvale = button.getCssValue("font-size");
        System.out.println(cssvale);
        String text0 = button.getText();
        System.out.println(text0);
        String getattributee = button.getAttribute("class");
        System.out.println(getattributee);






    }
}
