package pages;

import config.EmployeeModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DashboardPage {

    @FindBy(className = "oxd-main-menu-item--name")
    public List<WebElement> menuItems;

    @FindBy(className = "oxd-button")
    List<WebElement> buttons;

    @FindBy(className = "oxd-input")
    List<WebElement> formTextFields;

    @FindBy(xpath = "//body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/input[1]")
    WebElement empIdField;

    @FindBy(css = ".oxd-switch-input.oxd-switch-input--active.--label-right")
    WebElement btnSwitch;

    public DashboardPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void createUser(EmployeeModel model) {

        buttons.get(2).click(); //Click add button
        formTextFields.get(1).sendKeys(model.getFirstname());
        formTextFields.get(3).sendKeys(model.getLastname());
        empIdField.clear();
        btnSwitch.click(); //Toggle switch
        formTextFields.get(5).sendKeys(model.getUsername());
        formTextFields.get(6).sendKeys(model.getPassword());
        formTextFields.get(7).sendKeys(model.getPassword()); // Confirm Password
        buttons.get(1).click(); //Save data
    }
}
