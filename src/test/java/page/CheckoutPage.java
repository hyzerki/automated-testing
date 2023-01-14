package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage extends AbstractPage{
    private final By nameErrorLocator = By.xpath("//div[@class=\"error\"][text()=\"Введите имя\"]");
    private final By emailErrorLocator = By.xpath("//div[@class=\"error\"][text()=\"Введите email\"]");
    private final By phoneErrorLocator = By.xpath("//div[@class=\"error\"][text()=\"Введите телефон\"]");
    private final By buttonSubmitCheckoutLocator = By.xpath("//button[@class=\"cart-result__btn\"][text()=\"Готово\"]");

    private final String BASE_URL = "";
    @Override
    protected AbstractPage openPage() {
        driver.navigate().to(BASE_URL);
        return this;
    }

    public String getNameError(){
        WebElement nameError = driver.findElement(nameErrorLocator);
        return nameError.getText();
    }

    public String getEmailError(){
        WebElement emailError = driver.findElement(emailErrorLocator);
        return emailError.getText();
    }

    public String getPhoneError(){
        WebElement phoneError = driver.findElement(phoneErrorLocator);
        return phoneError.getText();
    }

    public CheckoutPage submitCheckout(){
        WebElement buttonSubmitCheckout = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(buttonSubmitCheckoutLocator));
        buttonSubmitCheckout.click();
        return this;
    }

    public CheckoutPage(WebDriver driver){super(driver);}
}
