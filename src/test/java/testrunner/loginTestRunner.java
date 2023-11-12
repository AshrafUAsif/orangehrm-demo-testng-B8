package testrunner;

import config.Setup;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.Utils;

import java.io.IOException;

public class loginTestRunner extends Setup { // Inherits config.Setup class's driver.
// This is called --> Executable Script
    LoginPage loginPage;


    @Test(priority = 1, enabled = false)
    public void doLoginWithWrongCreds(){
        loginPage = new LoginPage(driver);
        loginPage.doLogin("Admin","Wrongpass");
        String textActual = driver.findElement(By.className("oxd-alert-content-text")).getText();
        String textExpected="Invalid credentials";
        //Assert.assertTrue(textActual.contains(textExpected));
        Assert.assertEquals(textActual, textExpected);
    }
    @Test(priority = 2)
    public void doLogin() throws InterruptedException, IOException, ParseException {
        Thread.sleep(2000);
        loginPage = new LoginPage(driver);
        JSONArray jsonArray = Utils.readJSONList("./src/test/resources/employees.json");
        JSONObject empObj = (JSONObject) jsonArray.get(0);

        if(System.getProperty("userName")!=null && (System.getProperty("password")!=null)){
            loginPage.doLogin(System.getProperty("userName"),System.getProperty("password"));
        }
        else{
            loginPage.doLogin(empObj.get("userName").toString(), empObj.get("password").toString());
        }

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
