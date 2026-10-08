package Test;

import BaseClass.baseClass;
import PageObjectModel.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductsTest extends baseClass {

    @Test
    public void addProductsToCart(){
        ProductsPage productsPage = new ProductsPage(getDriver());
        productsPage.productsAddition();
        String itemCountInCart = productsPage.verifyCountOfItemsInCart();
        Assert.assertEquals(itemCountInCart, "4","Expected 4 items in cart but received " + itemCountInCart);
    }
}
