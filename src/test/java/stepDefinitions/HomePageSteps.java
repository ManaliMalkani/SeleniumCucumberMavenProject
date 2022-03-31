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
    public void user_does_not_have_record_present_in_the_device_manager_app() throws InterruptedException {
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
    public void user_has_records_present_in_the_device_manager_app() throws InterruptedException {
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

    @When("user click on Device Manager Header to sort the list in descending order")
    public void user_click_on_device_manager_header_to_sort_the_list_in_descending_order() {
        homePage.setDeviceNameHeaderInDescending();
    }
    @Then("Devices are sorted in descending order")
    public void devices_are_sorted_in_descending_order() {
        Assert.assertTrue(homePage.checkSortingForDeviceNameInDescendingOrder());
    }

    @Given("user has existing one record")
    public void user_has_existing_one_record() {
        homePage.clickAddNewButton();
        homePage.clickOSTypeDropdown();
        homePage.setDeviceNameTextBox("Mi");
        homePage.selectValueFromOSTypeDropdown("WindowsPhone");
        homePage.setCountryCodeTextBox("India");
        homePage.clickSaveButton();
    }
    @When("user select the particular record")
    public void user_select_the_particular_record() {
        homePage.selectParticularRecord("Mi","WindowsPhone","India");
    }
    @When("user click on Delete Selected Record Button")
    public void user_click_on_delete_selected_record_button() {
        homePage.clickDeleteSelectedButton();
    }

    @Then("record is deleted successfully and record is not visible in the Device Manager app")
    public void record_is_deleted_successfully_and_record_is_not_visible_in_the_device_manager_app() throws InterruptedException {
        Assert.assertTrue(homePage.verifyRecordDeletion("Mi","WindowsPhone","India"));
    }

    @Given("user has existing records")
    public void user_has_existing_records() throws InterruptedException {
        Assert.assertTrue(homePage.checkRecordsPresentInDeviceManagerApp());
    }
    @When("user select all record")
    public void user_select_all_record() {
        homePage.clickSelectAllCheckbox();
    }
    @Then("all records are deleted successfully and no record is not visible in the Device Manager app")
    public void all_records_are_deleted_successfully_and_no_record_is_not_visible_in_the_device_manager_app() throws InterruptedException {
        Assert.assertFalse(homePage.checkRecordsPresentInDeviceManagerApp());
    }







}
