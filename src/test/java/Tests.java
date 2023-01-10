import org.testng.Assert;
import org.testng.annotations.Test;
import page.CartPage;
import page.HomePage;

public class Tests extends CommonConditions {
    @Test
    public void addProductToCart() {
        String sum=new HomePage(driver)
                .openPage()
                .openAvailableItem()
                //.choseAvailableSize()
                .addProductToCart()
                .checkout()
                .getOrderSum();
        Assert.assertNotEquals("0",sum);


    }
    @Test
    public void addSameProductToCartTwice() {
        int count = new HomePage(driver)
                .openPage()
                .openAvailableItem()
                //.choseAvailableSize()
                .addProductToCart()
                .continueShopping()
                .openAvailableItem()
                //.choseAvailableSize()
                .addProductToCart()
                .checkout()
                .getCountOfFirstProduct();
        Assert.assertEquals(count,2);

    }
    @Test
    public void checkCartAfterPageReload() {
        CartPage cartPage = new HomePage(driver)
                .openPage()
                .openAvailableItem()
                //.choseAvailableSize()
                .addProductToCart()
                .checkout();
        driver.navigate().refresh();
        int count = cartPage.getCountOfItems();
        Assert.assertEquals(count-1,0);
    }
    @Test
    public void increaseCountOfProduct() {
        int count = new HomePage(driver)
                .openPage()
                .openAvailableItem()
                //.choseAvailableSize()
                .addProductToCart()
                .checkout()
                .increaseCountOfItem()
                .getCountOfFirstProduct();
        Assert.assertEquals(count,2);
    }

    @Test
    public void reduceCountOfProduct() {
        int count = new HomePage(driver).openPage()
                .openAvailableItem()
                //.choseAvailableSize()
                .addProductToCart()
                .checkout()
                .reduceCountOfItem()
                .getCountOfFirstProduct();
        Assert.assertNotEquals(count,0);
    }
    @Test
    public void deleteItemFromCart() {
        int count = new HomePage(driver).openPage()
                .openAvailableItem()
                //.choseAvailableSize()
                .addProductToCart()
                .checkout()
                .deleteItem()
                .getCountOfItems();
        Assert.assertEquals(count-1,0);
    }

    @Test
    public void createOrderWithEmptyCart(){
        String alertMessage = new CartPage(driver)
                .openPage()
                .confirmOrderDetails()
                .choseGlobalDelivery()
                .confirmOrderDetails()
                .confirm3DSecure()
                .confirmOrderDetails()
                .payment()
                .getTextAlert();
        Assert.assertEquals(alertMessage,"Корзина пуста");

    }
    @Test
    public void createOrderWithoutDeliveryOptions(){
        String alertMessage=new HomePage(driver)
                .openPage()
                .openAvailableItem()
                //.choseAvailableSize()
                .addProductToCart()
                .checkout()
                .confirmOrderDetails()
                .confirmOrderDetails()
                .confirm3DSecure()
                .confirmOrderDetails()
                .payment()
                .getTextAlert();
        Assert.assertEquals(alertMessage,"Пожалуйста, выберете тип доставки");

    }
    @Test
    public void createOrderWithout3DSecureConfirm(){
        String alertMessage=new HomePage(driver)
                .openPage()
                .openAvailableItem()
                //.choseAvailableSize()
                .addProductToCart()
                .checkout()
                .confirmOrderDetails()
                .choseGlobalDelivery()
                .confirmOrderDetails()
                .confirmOrderDetails()
                .payment()
                .getTextAlert();
        Assert.assertEquals(alertMessage,"Пожалуйста, выберете тип оплаты");

    }
    @Test
    public void createOrderWithoutClientDetails(){
        String alertMessage=new HomePage(driver)
                .openPage()
                .openAvailableItem()
                //.choseAvailableSize()
                .addProductToCart()
                .checkout()
                .confirmOrderDetails()
                .choseGlobalDelivery()
                .confirmOrderDetails()
                .confirm3DSecure()
                .confirmOrderDetails()
                .payment()
                .getTextAlert();
        Assert.assertTrue(alertMessage.matches(".*Пожалуйста, заполните.*"));

    }
}