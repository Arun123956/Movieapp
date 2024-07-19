import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import java.util.List;

import java.time.Duration;

public class NXTTrendzLoginTest {
    public WebDriver driver;
    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","C:\\\\Users\\\\arunk\\\\Downloads\\\\chromedriver-win32\\\\chromedriver-win32\\\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://rahulnxttrendz.ccbp.tech/login");
    }
    @Test(priority = 1)
    public void testLoginWithCerdentails(){
        WebElement enterusername = driver.findElement(By.xpath("//input[@id='username']"));
        enterusername.sendKeys("rahul");
        WebElement enterpassword = driver.findElement(By.xpath("//input[@id='password']"));
        enterpassword.sendKeys("rahul@2021");
        WebElement click = driver.findElement(By.xpath("//button[@class='login-button']"));
        click.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String expectedUrl = "https://rahulnxttrendz.ccbp.tech/";
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
        String currentUrl = driver.getCurrentUrl();
        if(expectedUrl.equals(currentUrl)){
            System.out.println("url is matched");
        }else {
            System.out.println("url is doesn't match");
        }




    }
    @Test(priority = 2)
    public void testShopNowButton(){
        WebElement enterusername = driver.findElement(By.xpath("//input[@id='username']"));
        enterusername.sendKeys("rahul");
        WebElement enterpassword = driver.findElement(By.xpath("//input[@id='password']"));
        enterpassword.sendKeys("rahul@2021");
        WebElement click = driver.findElement(By.xpath("//button[@class='login-button']"));
        click.click();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        String expectedUrl = "https://rahulnxttrendz.ccbp.tech/";
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
        String currentUrl = driver.getCurrentUrl();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='shop-now-button']")));
        WebElement clickonshopnowbutton = driver.findElement(By.xpath("//button[@class='shop-now-button']"));
        clickonshopnowbutton.click();
        String expectedUrl1 = "https://rahulnxttrendz.ccbp.tech/products";
        wait.until(ExpectedConditions.urlToBe(expectedUrl1));
        String currentUrl1 = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl1,currentUrl1,"urls do not matched");








    }
    @Test(priority = 3)
    public void testListOfItems(){
        WebElement enterusername = driver.findElement(By.xpath("//input[@id='username']"));
        enterusername.sendKeys("rahul");
        WebElement enterpassword = driver.findElement(By.xpath("//input[@id='password']"));
        enterpassword.sendKeys("rahul@2021");
        WebElement click = driver.findElement(By.xpath("//button[@class='login-button']"));
        click.click();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        String expectedUrl = "https://rahulnxttrendz.ccbp.tech/";
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
        String currentUrl = driver.getCurrentUrl();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='shop-now-button']")));
        WebElement clickonshopnowbutton = driver.findElement(By.xpath("//button[@class='shop-now-button']"));
        clickonshopnowbutton.click();
        String expectedUrl1 = "https://rahulnxttrendz.ccbp.tech/products";
        wait.until(ExpectedConditions.urlToBe(expectedUrl1));
        String currentUrl1 = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl1,currentUrl1,"urls do not matched");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='product-item']")));
        List<WebElement> countitem = driver.findElements(By.xpath("//li[@class='product-item']"));
        if(countitem.size()>0){
            System.out.println("products are displayed in aorder: " + countitem.size());
        }else {
            System.out.println("products are not displayed");
        }

    }
    @Test(priority = 4)
    public void testClickOnItem(){

        WebElement enterusername = driver.findElement(By.xpath("//input[@id='username']"));
        enterusername.sendKeys("rahul");
        WebElement enterpassword = driver.findElement(By.xpath("//input[@id='password']"));
        enterpassword.sendKeys("rahul@2021");
        WebElement click = driver.findElement(By.xpath("//button[@class='login-button']"));
        click.click();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        String expectedUrl = "https://rahulnxttrendz.ccbp.tech/";
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
        String currentUrl = driver.getCurrentUrl();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='shop-now-button']")));
        WebElement clickonshopnowbutton = driver.findElement(By.xpath("//button[@class='shop-now-button']"));
        clickonshopnowbutton.click();
        String expectedUrl1 = "https://rahulnxttrendz.ccbp.tech/products";
        wait.until(ExpectedConditions.urlToBe(expectedUrl1));
        String currentUrl1 = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl1,currentUrl1,"urls do not matched");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='product-item']")));
        List<WebElement> countitem = driver.findElements(By.xpath("//li[@class='product-item']"));
        if(countitem.size()>0){
            System.out.println("products are displayed in aorder: " + countitem.size());
        }else {
            System.out.println("products are not displayed");
        }
        WebElement clcikonitem = driver.findElement(By.xpath("//h1[text()='Lightweight Tripod']"));
        String acutaltittle = clcikonitem.getText();
        clcikonitem.click();
        String expectedtittle = "Lightweight Tripod";
        Assert.assertEquals(expectedtittle,acutaltittle,"both are doesn't match");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'Lightweight Tripod')]")));
        WebElement description = driver.findElement(By.xpath("//p[contains(text(),'Lightweight Tripod')]"));
        String acutauldes = description.getText();
        String expecteddes = "Capture vivid, professional-style photographs with help from this Lightweight Tripod. The tripod makes it easy to achieve reliable stability and score just the right angle when going after that award-winning shot. The handy tripod accommodates a wide range of digital, video, and still cameras.";
        if(expecteddes.equals(acutauldes)){
            System.out.println("description is matched");
        }else {
            System.out.println("description is don't matched");
        }

    }


}
