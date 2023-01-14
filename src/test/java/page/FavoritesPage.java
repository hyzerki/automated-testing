package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import waits.CustomConditions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class FavoritesPage extends AbstractPage{
    private final String BASE_URL = "https://clans.by/favorites";
    private final By favoritesListItemLocator = By.xpath("//div[@class=\"cart__row\"]");
    private final By removeFromFavoritesLocator = By.xpath("//a[@class=\"cart__remove-item\"]/i");

    @Override
    protected AbstractPage openPage() {
        driver.navigate().to(BASE_URL);
        return this;
    }

    public int getFavoritesListSize(){
        Duration previousImplicitlyWaitDuration = driver.manage().timeouts().getImplicitWaitTimeout();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        List<WebElement> favoritesList = driver.findElements(favoritesListItemLocator);
        driver.manage().timeouts().implicitlyWait(previousImplicitlyWaitDuration);
        return favoritesList.size();
    }

    public FavoritesPage removeItemFromFavorites(){
        WebElement removeButton = new WebDriverWait(driver, Duration.ofSeconds(10))
              .until(ExpectedConditions.elementToBeClickable(removeFromFavoritesLocator));
        removeButton.click();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(CustomConditions.jQueryAJAXsCompleted());
        return this;
    }

    public FavoritesPage(WebDriver driver){
        super(driver);
    }
}
