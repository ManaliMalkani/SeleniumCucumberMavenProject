package stepDefinitions;

import PageObjects.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import utilities.TestContext;

import java.text.ParseException;

public class HomePageSteps {

    TestContext testContext;
    HomePage homePage;

    public HomePageSteps(TestContext context) {

        testContext = context;
        homePage = testContext.getPageObjectManager().getHomePage();
    }

    @Given("user does not have record present in the Device Manager app")
    public void user_does_not_have_record_present_in_the_device_manager_app() {
        homePage.deleteAllRecordsPresentInDevice();
    }


    @Given("user click on Add New Device Button")
    public void user_click_on_add_new_device_button() {
        homePage.clickAddNewButton();
    }
    @When("user enters {string}, {string} and {string}")
    public void user_enters_and(String deviceName, String OSType, String CountryCode) {
        homePage.clickOSTypeDropdown();
        homePage.setDeviceNameTextBox(deviceName);
        homePage.selectValueFromOSTypeDropdown(OSType);
        homePage.setCountryCodeTextBox(CountryCode);
    }
    @And("user click on save button")
    public void user_click_on_save_button() {
        homePage.clickSaveButton();
    }

    @Then("device {string}, {string} and {string} is added in the device manager app")
    public void device_and_is_added_in_the_device_manager_app(String deviceName, String OSType, String CountryCode) throws ParseException {
        homePage.addedDeviceRecordVerification(deviceName,OSType,CountryCode);
    }

    @Given("user has records present in the Device Manager app")
    public void user_has_records_present_in_the_device_manager_app() {
        Assert.assertTrue(homePage.checkRecordsPresentInDeviceManagerApp());
    }


    @Given("user click on Device Manager Header")
    public void user_click_on_device_manager_header() {
        homePage.setDeviceNameHeaderInAscending();
    }

    @Then("Devices are sorted in ascending order")
    public void devices_are_sorted_in_ascending_order() {
        Assert.assertTrue(homePage.checkSortingForDeviceNameInAscendingOrder());
    }



}
