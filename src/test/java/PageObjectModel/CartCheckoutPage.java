package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CartCheckoutPage {
    private WebDriver driver;
    private By CartButton = By.className("shopping_cart_link");
    private By YourCart = By.xpath("//span[.='Your Cart']");
    private By ContinueShopping = By.id("continue-shopping");
    private By checkOutButton = By.id("checkout");
    private By cartItemNames = By.className("inventory_item_name");

    public CartCheckoutPage(WebDriver driver) {
        this.driver = driver;
    }
    public void yourCart(){
        driver.findElement(CartButton).click();
        driver.findElement(YourCart).getText();
        List<WebElement> removeButtons = driver.findElements(By.xpath("//button[text()='Remove']"));
        for(WebElement button: removeButtons){
            button.click();
        }
        driver.findElement(ContinueShopping).click();
    }
    public void checkoutCart(){
        driver.findElement(CartButton).click();
        driver.findElement(YourCart).getText();
    }
    public List<String> getAllItemsInCart(){
        List<WebElement> elements = driver.findElements(cartItemNames);
        List<String> textList = new ArrayList<>();
        for(WebElement element : elements){
            textList.add(element.getText().trim());
        }
        return textList;
    }
    public void checkoutButton(){
        driver.findElement(checkOutButton).click();
    }
}
