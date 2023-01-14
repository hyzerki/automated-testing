package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ProductPage extends AbstractPage{
    private final String BASE_URL = "https://clans.by/";
    private final By buttonAvailableSizeLocator = By.xpath("/html/body/div[3]/div[1]/div[3]/form/div[1]/label[1]/span");
    private final By buttonAddToCartLocator = By.xpath("/html/body/div[3]/div[1]/div[3]/form/div[3]/button");
    private final By buttonCheckoutLocator = By.xpath("//a[text()=\"Перейти в корзину\"]");
    private final By buttonContinueShoppingLocator = By.xpath("//a[text()=\"Продолжить покупки\"]");
    private final By buttonAddToFavoritesLocator = By.xpath("/html/body/div[3]/div[1]/div[1]/div[1]/button");
    private final By buttonOpenFavoritesPageLocator = By.xpath("//a[@href=\"favorites\"]");

    @Override
    public AbstractPage openPage() {
        driver.navigate().to(BASE_URL);
        return this;
    }

    public ProductPage choseAvailableSize() {
        driver.findElement(buttonAvailableSizeLocator).click();
        return this;
    }

    public ProductPage addProductToCart(){
        WebElement addToCartButton = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until((ExpectedConditions.elementToBeClickable(buttonAddToCartLocator)));
        addToCartButton.click();
        return this;
    }

    public CartPage checkout(){
        WebElement addToCartButton = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until((ExpectedConditions.elementToBeClickable(buttonCheckoutLocator)));
        addToCartButton.click();
        return new CartPage(driver);
    }

    public ProductPage continueShopping(){
        WebElement buttonContinueShopping = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until((ExpectedConditions.elementToBeClickable(buttonContinueShoppingLocator)));
        buttonContinueShopping.click();
        return this;
    }

    public ProductPage addToFavorites(){
        WebElement buttonAddToFavorites = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until((ExpectedConditions.elementToBeClickable(buttonAddToFavoritesLocator)));
        buttonAddToFavorites.click();
        return this;
    }

    public FavoritesPage goToFavoritesPage(){
        WebElement buttonOpenFavoritesPage = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until((ExpectedConditions.elementToBeClickable(buttonOpenFavoritesPageLocator)));
        buttonOpenFavoritesPage.click();
        return new FavoritesPage(driver);
    }

    public ProductPage(WebDriver driver)
    {
        super(driver);
    }
}
