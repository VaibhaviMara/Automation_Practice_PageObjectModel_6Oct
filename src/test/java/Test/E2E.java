package Test;

import BaseClass.baseClass;
import PageObjectModel.CartCheckoutPage;
import PageObjectModel.CheckOutInformationPage;
import PageObjectModel.LoginPage;
import PageObjectModel.ProductsPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class E2E extends baseClass {
    @Test
    public void loginAndAddItemsToCart(){
        LoginPage loginpage = new LoginPage(getDriver());
        String myuser = reader.getStringProperty("username_standard");
        String mypassword = reader.getStringProperty("password");
        Assert.assertTrue(loginpage.loginToApplication(myuser, mypassword),"Login Failed, Page load was unsuccessfull");
        ProductsPage productsPage = new ProductsPage(getDriver());
        productsPage.productsAddition();
        String itemsinCartCount = productsPage.verifyCountOfItemsInCart();
        Assert.assertEquals(itemsinCartCount, "4", "Expected 4 items in cart but received" + itemsinCartCount);
        productsPage.productsRemoval();
        itemsinCartCount = productsPage.verifyCountOfItemsInCart();
        Assert.assertEquals(itemsinCartCount,"2","Expected 2 items in cart after removal but received " + itemsinCartCount);
        CartCheckoutPage cartCheckoutPage = new CartCheckoutPage(getDriver());
        cartCheckoutPage.yourCart();
        productsPage.productsAddition();
        cartCheckoutPage.checkoutCart();
        List<String> actualItemsInCart = cartCheckoutPage.getAllItemsInCart();
        List<String> expectedItems  = new ArrayList<>();
        expectedItems.add("Sauce Labs Backpack");
        expectedItems.add("Sauce Labs Bike Light");
        expectedItems.add("Sauce Labs Bolt T-Shirt");
        expectedItems.add("Sauce Labs Fleece Jacket");
        java.util.Collections.sort(actualItemsInCart);
        java.util.Collections.sort(expectedItems);
        Assert.assertEquals(actualItemsInCart,expectedItems,"The items displayed in cart do not match the expected 4 times");
        cartCheckoutPage.checkoutButton();
        CheckOutInformationPage checkOutInformationPage = new CheckOutInformationPage(getDriver());
        String actualHeaderTitle =  checkOutInformationPage.CheckoutDetailsTitleVerification();
        Assert.assertEquals(actualHeaderTitle,"Checkout: Your Information");
        checkOutInformationPage.PersonalInformation(reader.getStringProperty("firstName"), reader.getStringProperty("lastName"), reader.getStringProperty("zipcode") );
    }
}
