package stepDefinitions;


import DataProviders.ConfigFileReader;
import Managers.FileReaderManager;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utilities.TestContext;
import utilities.Wait;

import java.util.concurrent.TimeUnit;

public class LoginSteps {

    TestContext testContext;
    LoginPage loginPage;
    HomePage homePage;




    public LoginSteps(TestContext context) {

        testContext = context;
        loginPage = testContext.getPageObjectManager().getLoginPage();
        homePage = testContext.getPageObjectManager().getHomePage();
    }

    @Given("Login form in login page")
    public void loginFormInLoginPage() {
        Assert.assertTrue(loginPage.LoginPageIsDisplayed());
    }



    @When("user enters user name and password")
    public void user_enters_user_name_and_password() {
        loginPage.fillUserNameData(FileReaderManager.getInstance().getConfigFileReader().getUserName());
        loginPage.fillPasswordData(FileReaderManager.getInstance().getConfigFileReader().getPassword());
    }

    @When("User clicks on Login Button")
    public void user_clicks_on_Login_Button() {
        loginPage.clickLoginButton();
    }

    @Then("user is navigated to DeviceManager Home page")
    public void user_is_navigated_to_DeviceManager_Home_page() {
        homePage.defaultHomePageIsDisplayed();
    }

    @Given("user enters user wrong userName and password")
    public void user_enters_user_wrong_user_name_and_password() {
        loginPage.fillUserNameData("sdjfhsf");
        loginPage.fillPasswordData(FileReaderManager.getInstance().getConfigFileReader().getPassword());
    }

    @Given("user enters user wrong password and username")
    public void user_enters_user_wrong_password_and_username() {
        loginPage.fillUserNameData(FileReaderManager.getInstance().getConfigFileReader().getUserName());
        loginPage.fillPasswordData("dsczcd");
    }

    @Then("user is not navigated to DeviceManager Home page")
    public void user_is_not_navigated_to_device_manager_home_page() {
        Assert.assertTrue(loginPage.LoginPageIsDisplayed());
    }

    @When("user click on Logout Button")
    public void user_click_on_logout_button() {
        homePage.clickLogoutButton();
    }
    @Then("user is navigated to login page")
    public void user_is_navigated_to_login_page() {
        Assert.assertTrue(homePage.defaultHomePageIsDisplayed());
    }







}
