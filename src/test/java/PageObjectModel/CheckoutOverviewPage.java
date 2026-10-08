package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOverviewPage {
    private WebDriver driver;
    private By CheckoutOverviewTitle = By.className("title");


    public CheckoutOverviewPage(WebDriver driver){
        this.driver = driver;
    }
    public String CheckoutOverviewVerifyDetailsTitle(){
        return driver.findElement(CheckoutOverviewTitle).getText();
    }

}
