package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LoginPage {
// This is called --> Test Step Script

    @FindBy(name = "username")
    WebElement txtUsername;

    @FindBy(name = "password")
    WebElement txtPassword;

    @FindBy(tagName = "button")
    WebElement btnLogin;

    @FindBy(className = "oxd-userdropdown-name")
    WebElement btnUserProfile;

     @FindBy(className = "oxd-userdropdown-link")
     List<WebElement> linkSubItems;

    // Page Object model এর সাপোর্টার হিসেবে এই PageFactory use হয়
    // এক পেইজ থেকে অন্য পেইজে ডাটা পাঠাতে এই PageFactory কাজ করে
    //Creating Test Factory
    public  LoginPage(WebDriver driver){ // (pass through as parameter)
        PageFactory.initElements(driver, this);

    }
    public void doLogin(String username, String password){
        txtUsername.sendKeys(username);
        txtPassword.sendKeys(password);
        btnLogin.click();
    }

    public void doLogout() throws InterruptedException {
        Thread.sleep(2000);
        btnUserProfile.click();
        Thread.sleep(4000);
        linkSubItems.get(3).click();
    }
}
