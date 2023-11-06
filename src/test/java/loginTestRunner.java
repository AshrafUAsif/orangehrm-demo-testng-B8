import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class loginTestRunner extends Setup{ // Inherits Setup class's driver.
// This is called --> Executable Script
    LoginPage loginPage;


    @Test(priority = 1)
    public void doLoginWithWrongCreds(){
        loginPage = new LoginPage(driver);
        loginPage.doLogin("Admin","Wrongpass");
        String textActual = driver.findElement(By.className("oxd-alert-content-text")).getText();
        String textExpected="Invalid credentials";
        //Assert.assertTrue(textActual.contains(textExpected));
        Assert.assertEquals(textActual, textExpected);
    }
    @Test(priority = 2)
    public void doLogin(){
        loginPage = new LoginPage(driver);
        loginPage.doLogin("Admin", "admin123");
        Assert.assertTrue(driver.findElement(By.className("oxd-userdropdown-img")).isDisplayed());
    }

    @Test(priority = 3)
    public void logout() throws InterruptedException {
        loginPage = new LoginPage(driver);
        loginPage.doLogout();
        String textActual = driver.findElement(By.className("orangehrm-login-title")).getText();
        String textExpected ="Login";
        Assert.assertEquals(textActual, textExpected);

    }
}
