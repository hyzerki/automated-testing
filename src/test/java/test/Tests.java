package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.CartPage;
import page.ClothingPage;
import test.CommonConditions;

public class Tests extends CommonConditions {

    @Test
    public void addProductToCart() {
        String sum = new ClothingPage(driver)
                .openPage()
                .openAvailableItem()
                .choseAvailableSize()
                .addProductToCart()
                .checkout()
                .getOrderSum();
        Assert.assertNotEquals("0",sum);
    }

    @Test
    public void inputInvalidDataToProductAmountInCart(){
        int amount = new ClothingPage(driver)
                .openPage()
                .openAvailableItem()
                .choseAvailableSize()
                .addProductToCart()
                .checkout()
                .inputInvalidProductAmount()
                .getCountOfFirstProduct();
        Assert.assertEquals(amount,1);
    }



    @Test
    public void deleteProductFromCart(){
        String emptyMessage = new ClothingPage(driver)
                .openPage()
                .openAvailableItem()
                .choseAvailableSize()
                .addProductToCart()
                .checkout()
                .deleteItem()
                .ensureEmptyCart();
        Assert.assertEquals(emptyMessage, "Корзина пуста.");
    }


    @Test
    public void incrementProductAmountInCart(){
        int amount = new ClothingPage(driver)
                .openPage()
                .openAvailableItem()
                .choseAvailableSize()
                .addProductToCart()
                .checkout()
                .increaseCountOfItem()
                .getCountOfFirstProduct();
        Assert.assertEquals(amount,2);
    }

    @Test
    public void decrementProductAmountInCart(){
        String emptyMessage = new ClothingPage(driver)
                .openPage()
                .openAvailableItem()
                .choseAvailableSize()
                .addProductToCart()
                .checkout()
                .reduceCountOfItem()
                .ensureEmptyCart();
        Assert.assertEquals(emptyMessage, "Корзина пуста.");
    }


    @Test
    public void addSameProductToCartTwice(){
        int productAmount = new ClothingPage(driver)
                .openPage()
                .openAvailableItem()
                .choseAvailableSize()
                .addProductToCart()
                .continueShopping()
                .addProductToCart()
                .checkout()
                .getCountOfFirstProduct();
        Assert.assertEquals(productAmount, 2);
    }



    @Test
    public void addProductToFavorites(){
        int favoriteProductAmount = new ClothingPage(driver)
                .openPage()
                .openAvailableItem()
                .addToFavorites()
                .goToFavoritesPage()
                .getFavoritesListSize();
        Assert.assertNotEquals(favoriteProductAmount, 0);
    }



    @Test
    public void removeProductFromFavorites(){
        int favoriteProductAmount = new ClothingPage(driver)
                .openPage()
                .openAvailableItem()
                .addToFavorites()
                .goToFavoritesPage()
                .removeItemFromFavorites()
                .getFavoritesListSize();
        Assert.assertEquals(favoriteProductAmount, 0);
    }



    @Test
    public void checkoutWithoutName(){
        String nameError = new ClothingPage(driver)
                .openPage()
                .openAvailableItem()
                .choseAvailableSize()
                .addProductToCart()
                .checkout()
                .proceedToCheckout()
                .submitCheckout()
                .getNameError();
        Assert.assertEquals(nameError, "Введите имя");
    }

    @Test
    public void checkoutWithoutEmail(){
        String emailError = new ClothingPage(driver)
                .openPage()
                .openAvailableItem()
                .choseAvailableSize()
                .addProductToCart()
                .checkout()
                .proceedToCheckout()
                .submitCheckout()
                .getEmailError();
        Assert.assertEquals(emailError, "Введите email");
    }
    @Test
    public void checkoutWithoutPhone(){
        String phoneError = new ClothingPage(driver)
                .openPage()
                .openAvailableItem()
                .choseAvailableSize()
                .addProductToCart()
                .checkout()
                .proceedToCheckout()
                .submitCheckout()
                .getPhoneError();
        Assert.assertEquals(phoneError, "Введите телефон");
    }

}