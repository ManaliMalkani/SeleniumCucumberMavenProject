package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(id = "textfield-Username")
    private WebElement userName;

    @FindBy(id = "textfield-Password")
    private WebElement password;

    @FindBy(id = "btn-login")
    private WebElement loginButton;

    @FindBy(xpath = "//h2[text()='Device manager']")
    private WebElement deviceManagerTitle;

    public void fillUserNameData(String username) {
        userName.isEnabled();
        userName.clear();
        userName.sendKeys(username);
    }

    public void fillPasswordData(String userPassword) {
        password.isEnabled();
        password.clear();
        password.sendKeys(userPassword);
    }


    public void clickLoginButton() {
        loginButton.isEnabled();
        loginButton.click();
    }

    public boolean LoginPageIsDisplayed() {
        deviceManagerTitle.isDisplayed();
        return true;
    }
}
