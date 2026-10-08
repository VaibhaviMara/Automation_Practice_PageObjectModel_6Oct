package BaseClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.PropertyReader;

import java.time.Duration;


public class baseClass {
    private static WebDriver driver;
    protected PropertyReader reader;
    protected WebDriverWait wait;
    public static WebDriver getDriver(){
        return driver;
    }
    @BeforeMethod
    public void setup(){
        reader = new PropertyReader();
        ChromeOptions options = new ChromeOptions();

        // 2. Completely block the Chrome Password Leak Detection feature
        options.addArguments("--disable-features=PasswordLeakDetection,SafeBrowsingPasswordProtection");

        // 2. Prevent Chrome from syncing or checking data against a Google profile
        options.addArguments("--disable-sync");

        // 3. Turn off Password Manager services entirely using Experimental Preferences
        java.util.Map<String, Object> prefs = new java.util.HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("profile.password_manager_leak_detection", false); // Extra check for modern Chrome
        options.setExperimentalOption("prefs", prefs);
        driver = new ChromeDriver(options);
        int implicitWait = reader.getIntProperty("implicitWait");
        int pageloadTimeout = reader.getIntProperty("pageloadTimeout");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(pageloadTimeout));
        driver.manage().window().maximize();
        String url = reader.getStringProperty("url");
        driver.get(url);
        wait = new WebDriverWait(driver,Duration.ofSeconds(15));


    }

    public void acceptAlerts() {
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            driver.switchTo().alert().dismiss();
        } catch (Exception e) {
            System.out.println("Alert not present, no action performed.");
        }
    }

    @AfterMethod
    public void tearDown(){
        if(driver != null){
            driver.quit();
        }
    }

}
