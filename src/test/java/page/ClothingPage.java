package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ClothingPage extends AbstractPage{
    private final String BASE_URL = "https://clans.by/clothing/";
    private final By firstItemLocator = By.xpath("//*[@id=\"eFiltr_results\"]/div[1]/div[1]/form/div[1]/a/img");

    public ClothingPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public ClothingPage openPage() {
        driver.navigate().to(BASE_URL);
        return this;
    }

    public ProductPage openAvailableItem(){
        WebElement buttonAvailableItems = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until((ExpectedConditions.elementToBeClickable(firstItemLocator)));
        buttonAvailableItems.click();
        return new ProductPage(driver);
    }
}
