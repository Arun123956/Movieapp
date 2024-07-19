package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.WebDriver;


public class PopularPage {
    WebDriver driver;

    By moviesDisplayedLocator = By.className("movie-icon-item");


    public PopularPage(WebDriver driver){
        this.driver = driver;


    }

    public  List<WebElement> getMovies(){
        return driver.findElements(moviesDisplayedLocator);

    }


}

