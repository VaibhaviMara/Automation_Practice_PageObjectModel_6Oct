package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutInformationPage {
    private WebDriver driver;
    private By CheckoutInfoTitleVerification = By.className("title");
    private By firstName = By.id("first-name");
    private By lastName = By.id("last-name");
    private By ZipCode = By.id("postal-code");
    private By continueButton = By .id("continue");


    public CheckOutInformationPage(WebDriver driver){
        this.driver = driver;
    }
    public String CheckoutDetailsTitleVerification(){
        return driver.findElement(CheckoutInfoTitleVerification).getText();
    }
    public void PersonalInformation(String firstname, String lastname, String zipcode){
        driver.findElement(firstName).sendKeys(firstname);
        driver.findElement(lastName).sendKeys(lastname);
        driver.findElement(ZipCode).sendKeys(zipcode);
        driver.findElement(continueButton).click();
    }
}
