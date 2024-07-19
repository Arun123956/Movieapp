import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.testng.Assert;

public class LoginTestPage1 {
    public static void main(String[]args){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\arunk\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.in/");
        WebElement entervalue  = driver.findElement(By.id("twotabsearchtextbox"));
        entervalue.sendKeys("iphone");
        WebElement submit = driver.findElement(By.id("nav-search-submit-button"));
        submit.submit();
        WebElement click = driver.findElement(By.linkText("Apple iPhone 13 (128GB) - Blue"));
        click.click();
        WebElement choose = driver.findElement(By.xpath("//span[starts-with(@class,'a-color-price')]"));
        choose.click();





    }
}
