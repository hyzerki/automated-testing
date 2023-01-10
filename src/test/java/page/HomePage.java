package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends AbstractPage{
    private final String BASE_URL = "https://outcast.by/";

    private final By buttonCartLocator = By.xpath("//a[@href='/cart']");
    private final By buttonAvailableItemsLocator = By.xpath("//div/a/div/button[@tabindex='0']");
    private final By linkToWhereBuyPageLocator = By.xpath("//a[starts-with(@href, '/whereBuy')]");

    @Override
    public HomePage openPage() {
        driver.navigate().to(BASE_URL);
        return this;
    }
    public HomePage openCart() {
        WebElement buttonShowCart = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until((ExpectedConditions.elementToBeClickable(buttonCartLocator)));
        buttonShowCart.click();
        return this;
    }
    public ProductPage openAvailableItem(){
        WebElement buttonAvailableItems = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until((ExpectedConditions.elementToBeClickable(buttonAvailableItemsLocator)));
        buttonAvailableItems.click();
        return new ProductPage(driver);
    }

    public HomePage(WebDriver driver)
    {
        super(driver);
    }
}
