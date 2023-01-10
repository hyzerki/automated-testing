package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage extends AbstractPage{

    private final String BASE_URL = "https://outcast.by/cart";

    private final By textOrderSumLocator = By.xpath("//tbody[@class='MuiTableBody-root']/tr/td[3]");
    private final By linkToHomePageLocator = By.xpath("//a[@href='/']");
    private final By inputFirstItemCountLocator = By.xpath("//th/div/div/div/input[@type='text']");
    private final By rowsOfProductsTableLocator = By.xpath("//tr[@class='MuiTableRow-root']");
    private final By buttonIncreaseCountLocator = By.xpath("//button[@tabindex='0']/span/h4[text()='+']");
    private final By buttonReduceCountLocator = By.xpath("//button[@tabindex='0']/span/h4[text()='-']");
    private final By buttonDeleteItemFromCartLocator = By.xpath("//*[local-name()='svg' and @class='MuiSvgIcon-root icon']");
    private final By buttonConfirmDeleteItemLocator = By.xpath("//button[@tabindex='0']/span[text()='Ok']");
    private final By buttonConfirmOrderDetailsLocator = By.xpath("//button[@tabindex='0']/span[text()='Далее']");
    private final By inputLocalDeliveryLocator = By.xpath("//label[1]/span/span/input");
    private final By inputGlobalDeliveryLocator = By.xpath("//label[2]/span/span/input");
    private final By textAlertLocator = By.xpath("//div/p[@id='alert-dialog-description']");
    private final By buttonPaymentLocator = By.xpath("//button/span[text()='Перейти к оплате']");




    @Override
    public CartPage openPage() {
        driver.navigate().to(BASE_URL);
        return this;
    }
    public String getOrderSum(){
        WebElement textOrderSum = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until((ExpectedConditions.elementToBeClickable(textOrderSumLocator)));
        return textOrderSum.getText();
    }
    public HomePage openHomePage(){
        WebElement linkToHomePage = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until((ExpectedConditions.elementToBeClickable(linkToHomePageLocator)));
        linkToHomePage.click();
        return new HomePage(driver);
    }
    public int getCountOfFirstProduct(){
        WebElement inputFirstItemCount = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until((ExpectedConditions.elementToBeClickable(inputFirstItemCountLocator)));
        return Integer.parseInt(inputFirstItemCount.getAttribute("value"));
    }
    public int getCountOfItems(){
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until((ExpectedConditions.elementToBeClickable(rowsOfProductsTableLocator)));
        int count = driver.findElements(rowsOfProductsTableLocator).size();
        return count;
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
        WebElement confirmDeleteButton = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until((ExpectedConditions.elementToBeClickable(buttonConfirmDeleteItemLocator)));
        confirmDeleteButton.click();

        return this;
    }
    public CartPage confirmOrderDetails()
    {
        WebElement confirmButton = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until((ExpectedConditions.elementToBeClickable(buttonConfirmOrderDetailsLocator)));
        confirmButton.click();
        return this;
    }
    public CartPage choseLocalDelivery(){
        WebElement inputLocalDelivery = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until((ExpectedConditions.elementToBeClickable(inputLocalDeliveryLocator)));
        inputLocalDelivery.click();
        return this;
    }
    public CartPage choseGlobalDelivery(){
        WebElement inputGlobalDelivery = driver.findElement(inputGlobalDeliveryLocator);
        inputGlobalDelivery.click();
        return this;
    }
    public CartPage confirm3DSecure(){
        WebElement confirmInput = driver.findElement((By.xpath("//input")));
        confirmInput.click();
        return this;
    }
    public CartPage payment(){
        WebElement paymentButton = driver.findElement(buttonPaymentLocator);
        paymentButton.click();
        return this;
    }
    public String getTextAlert(){
        WebElement alertBox = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until((ExpectedConditions.elementToBeClickable(textAlertLocator)));
        return alertBox.getText();
    }



    public CartPage(WebDriver driver)
    {
        super(driver);
    }
}
