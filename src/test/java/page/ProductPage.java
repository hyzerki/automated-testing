package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ProductPage extends AbstractPage{

    private final String BASE_URL = "https://outcast.by/";

    private final By buttonAvailableSizeLocator = By.xpath("//input");
    private final By buttonAddToCartLocator = By.xpath("//button[@tabindex='0']");
    private final By buttonCheckoutLocator = By.xpath("//a[@href='/cart']/button[@tabindex='0']");
    private final By buttonContinueShoppingLocator = By.xpath("//button[@tabindex='0']/span[text()='Продолжить покупки']");

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
    public HomePage continueShopping(){
        WebElement buttonContinueShopping = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until((ExpectedConditions.elementToBeClickable(buttonContinueShoppingLocator)));
        buttonContinueShopping.click();
        return new HomePage(driver);
    }

    public ProductPage(WebDriver driver)
    {
        super(driver);
    }
}
