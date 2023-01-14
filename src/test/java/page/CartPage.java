package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import waits.CustomConditions;

import java.time.Duration;

public class CartPage extends AbstractPage{
    private final String BASE_URL = "https://clans.by/cart/";
    private final By textOrderSumLocator = By.xpath("/html/body/div[3]/div/div[2]/div/div[2]/div");
    private final By inputFirstItemCountLocator = By.xpath("/html/body/div[3]/div/div[1]/div[2]/div[5]/input");
    private final By buttonIncreaseCountLocator = By.xpath("/html/body/div[3]/div/div[1]/div[2]/div[5]/a[2]");
    private final By buttonReduceCountLocator = By.xpath("/html/body/div[3]/div/div[1]/div[2]/div[5]/a[1]");
    private final By buttonDeleteItemFromCartLocator = By.xpath("/html/body/div[3]/div/div[1]/div[2]/div[7]/a/i");
    private final By emptyCartLocator = By.xpath("//div[text()=\"Корзина пуста.\"]");
    private final By buttonProceedToCheckoutLocator = By.xpath("//a[@class=\"cart-result__btn\"][text()=\"Перейти к оформлению\"]");

    @Override
    public CartPage openPage() {
        driver.navigate().to(BASE_URL);
        return this;
    }

    public String getOrderSum(){
        WebElement textOrderSum = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until((ExpectedConditions.elementToBeClickable(textOrderSumLocator)));
        String orderSum = textOrderSum.getText();
        return orderSum.trim().substring(0, orderSum.length()-4);
    }

    public int getCountOfFirstProduct(){
        WebElement inputFirstItemCount = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until((ExpectedConditions.elementToBeClickable(inputFirstItemCountLocator)));
        return Integer.parseInt(inputFirstItemCount.getAttribute("value"));
    }

    public CartPage reduceCountOfItem(){
        WebElement reduceButton = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until((ExpectedConditions.elementToBeClickable(buttonReduceCountLocator)));
        reduceButton.click();
        return this;
    }

    public CartPage increaseCountOfItem(){
        WebElement increaseButton = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until((ExpectedConditions.elementToBeClickable(buttonIncreaseCountLocator)));
        increaseButton.click();
        return this;
    }

    public CartPage deleteItem(){
        WebElement deleteButton = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until((ExpectedConditions.elementToBeClickable(buttonDeleteItemFromCartLocator)));
        deleteButton.click();
        return this;
    }

    public String ensureEmptyCart(){
        WebElement emptyCart = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(emptyCartLocator));
        return emptyCart.getText();
    }

    public CartPage inputInvalidProductAmount(){
        WebElement amountInput = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(inputFirstItemCountLocator));
        amountInput.sendKeys("zxc\n");
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(CustomConditions.jQueryAJAXsCompleted());
        return this;
    }

    public CheckoutPage proceedToCheckout(){
        WebElement buttonProceedToCheckout = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(buttonProceedToCheckoutLocator));
        buttonProceedToCheckout.click();
        return new CheckoutPage(driver);
    }

    public CartPage(WebDriver driver)
    {
        super(driver);
    }
}
