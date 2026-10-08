package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {
    private WebDriver driver;
    private By saucelabsBackPack = By.id("add-to-cart-sauce-labs-backpack");
    private By saucelabsLightBike = By.id("add-to-cart-sauce-labs-bike-light");
    private By sauceLabsBoltTshirt = By.id("add-to-cart-sauce-labs-bolt-t-shirt");
    private By sauceLabsFleeceJacket = By.id("add-to-cart-sauce-labs-fleece-jacket");
    private By itemsInCartCount = By.className("shopping_cart_badge");
    private By removeSaucelabsBackPack = By.id("remove-sauce-labs-backpack");
    private By removeSauceLabsLightBike = By.id("remove-sauce-labs-bike-light");

    public ProductsPage(WebDriver driver){
        this.driver = driver;
    }
    public void productsAddition(){
        driver.findElement(saucelabsBackPack).click();
        driver.findElement(sauceLabsBoltTshirt).click();
        driver.findElement(saucelabsLightBike).click();
        driver.findElement(sauceLabsFleeceJacket).click();
    }
    public String verifyCountOfItemsInCart(){
        return driver.findElement(itemsInCartCount).getText();
    }
    public void productsRemoval(){
        driver.findElement(removeSaucelabsBackPack).click();
        driver.findElement(removeSauceLabsLightBike).click();
    }
}
