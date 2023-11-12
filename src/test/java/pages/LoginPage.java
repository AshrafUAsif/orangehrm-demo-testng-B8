package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LoginPage {
// This is called --> Test Step Script

    @FindBy(css = "input[placeholder='Username']")
    WebElement txtUsername;

    @FindBy(xpath = "//input[@placeholder='Password']")
    WebElement txtPassword;

    @FindBy(tagName = "button")
    WebElement btnLogin;


    @FindBy(className = "oxd-userdropdown-name")
    WebElement btnUserProfile;

    @FindBy(className = "oxd-userdropdown-link")
    List<WebElement> linkSubItems;

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public void doLogin(String userName, String password){
        txtUsername.sendKeys(userName);
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
