package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    private By username = By.id("user-name");
    private By password = By.id("password");
    private By loginButton = By.id("login-button");
    private By DashboardVisibility = By.className("title");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }
    public boolean loginToApplication(String userName, String Password){
        driver.findElement(username).sendKeys(userName);
        driver.findElement(password).sendKeys(Password);
        driver.findElement(loginButton).click();
        return driver.findElement(DashboardVisibility).isDisplayed();
    }
}
