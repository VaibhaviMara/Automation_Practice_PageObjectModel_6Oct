package Test;

import BaseClass.baseClass;
import PageObjectModel.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends baseClass {

    @Test
    public void executeLogin(){
        LoginPage loginPage = new LoginPage(getDriver());
        String myUser = reader.getStringProperty("username_standard");
        String myPass = reader.getStringProperty("password");
        Assert.assertTrue(loginPage.loginToApplication(myUser,myPass),"Login Failed, Appropriate Page is not loaded");

    }
}
