package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class WhereBuyPage extends AbstractPage{
    private final String BASE_URL = "https://outcast.by/whereBuy";

    private final By linkToGoogleMapsLocator = By.xpath("//a[starts-with(@href, 'https://maps')]");
    @Override
    public WhereBuyPage openPage() {
        driver.navigate().to(BASE_URL);
        return this;
    }
    public GoogleMapsPage openGoogleMapsFromWidget(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
        WebElement linkToGoogleMaps = driver.findElement(linkToGoogleMapsLocator);
        linkToGoogleMaps.click();
        return new GoogleMapsPage(driver);
    }

    public WhereBuyPage(WebDriver driver)
    {
        super(driver);
    }
}
