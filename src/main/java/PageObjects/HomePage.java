package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.CommonFunctions;
import utilities.Wait;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class HomePage {

    private final WebDriver webDriver;

    public HomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(id = "btn-logout")
    private WebElement logoutButton;

    @FindBy(id = "btn-delete-device")
    private WebElement deleteSelectedButton;

    @FindBy(id = "btn-add-device")
    private WebElement addNew;

    @FindBy(xpath = "//i[text()='arrow_drop_down']")
    private WebElement osTypeDropdown;

    @FindBy(id = "textfield-Devicename")
    private WebElement deviceNameTextBox;

    @FindBy(xpath = "//li[@class='mdl-menu__item']")
    private List<WebElement> osTypeDropdownValues;

    @FindBy(id = "textfield-Countrycode")
    private WebElement countryCodeTextBox;

    @FindBy(id = "btn-save-device")
    private WebElement saveButton;

    @FindBy(xpath = "//table//tbody//tr")
    private List<WebElement> deviceRecords;

    @FindBy(xpath = "//table//thead//tr//th[2]")
    private WebElement deviceNameHeader;

    @FindBy(xpath = "//table//thead//tr//th[1]//label//span[2]//span")
    private WebElement selectAllCheckbox;

    public boolean defaultHomePageIsDisplayed() {
        logoutButton.isDisplayed();
        deleteSelectedButton.isDisplayed();
        addNew.isDisplayed();
        return true;
    }

    public void clickLogoutButton() {
        Wait.untilElementIsClickable(webDriver, logoutButton, 8L);
        logoutButton.isEnabled();
        logoutButton.click();
    }

    public void clickAddNewButton() {
        CommonFunctions.javaScriptExecutorFunction(webDriver, addNew);
    }

    public void clickOSTypeDropdown() {
        Wait.untilElementIsClickable(webDriver, osTypeDropdown, 10L);
        osTypeDropdown.isEnabled();
        osTypeDropdown.click();
    }

    public void setDeviceNameTextBox(String deviceName) {
        deviceNameTextBox.sendKeys(deviceName);
    }

    public void selectValueFromOSTypeDropdown(String osType) {
        for (int i = 0; i <= osTypeDropdownValues.size() - 1; i++) {
            if (osTypeDropdownValues.get(i).getText().contains(osType)) {
                CommonFunctions.javaScriptExecutorFunction(webDriver, osTypeDropdownValues.get(i));
                break;

            }
        }
    }

    public void setCountryCodeTextBox(String countryCode) {
        countryCodeTextBox.sendKeys(countryCode);

    }

    public void clickSaveButton() {
        saveButton.isEnabled();
        saveButton.click();
    }

    public void addedDeviceRecordVerification(String deviceName, String osType, String countryCode) throws ParseException {

        for (int i = 1; i <= deviceRecords.size(); i++) {
            System.out.println("inside the loop");
            String deviceNameXpath = "//table//tbody//tr[" + i + "]//td[2]";
            String osTypeXpath = "//table//tbody//tr[" + i + "]//td[5]";
            String countryCodeXpath = "//table//tbody//tr[" + i + "]//td[3]";
            String dateXpath = "//table//tbody//tr[" + i + "]//td[4]";
            WebElement deviceNameElement = webDriver.findElement(By.xpath(deviceNameXpath));
            WebElement osTypeElement = webDriver.findElement(By.xpath(osTypeXpath));
            WebElement countryCodeElement = webDriver.findElement(By.xpath(countryCodeXpath));
            WebElement dateElement = webDriver.findElement(By.xpath(dateXpath));
            String deviceDt = dateElement.getText();
            String deviceDate = deviceDt.replace(".", "-");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate date = LocalDate.parse(deviceDate, formatter);

            Calendar calendar = Calendar.getInstance();
            DateTimeFormatter formatterCurrent = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate currentDate = LocalDate.parse(deviceDate, formatterCurrent);
            //SimpleDateFormat formatterCurrent = new SimpleDateFormat("dd-MM-yyyy");
            //Date currentDate=formatterCurrent.parse(deviceDate);
            if (date.compareTo(currentDate) == 0) {
                if (((deviceNameElement.getText().equals(deviceName)) && (osTypeElement.getText().equals(osType)) && countryCodeElement.getText().equals(countryCode))) {
                    System.out.println("Record is present");
                    break;
                }
            }
        }
    }

    public void setDeviceNameHeaderInAscending() {
        Wait.untilElementIsClickable(webDriver, deviceNameHeader, 10L);
        String classAttributeValue = deviceNameHeader.getAttribute("class");
        if (classAttributeValue.contains("ascending")) {
            System.out.println("Record is already in Ascending order");
        } else
            deviceNameHeader.click();

    }

    public void setDeviceNameHeaderInDescending() {
        Wait.untilElementIsClickable(webDriver, deviceNameHeader, 10L);
        String classAttributeValue = deviceNameHeader.getAttribute("class");
        deviceNameHeader.click();
        if (classAttributeValue.contains("descending")) {
            System.out.println("Record is already in descending order");
        } else
            deviceNameHeader.click();

    }

    public void clickDeleteSelectedButton() {
        deleteSelectedButton.isEnabled();
        deleteSelectedButton.click();
    }

    public void clickSelectAllCheckbox() {
        selectAllCheckbox.isEnabled();
        selectAllCheckbox.click();
    }

    public boolean checkRecordsPresentInDeviceManagerApp() {
        int size = deviceRecords.size();
        boolean flag = false;
        if (size > 0)
            flag = true;
        return flag;

    }

    public void deleteAllRecordsPresentInDevice() {
        if (checkRecordsPresentInDeviceManagerApp() == true) {
            clickSelectAllCheckbox();
            clickDeleteSelectedButton();
        }
    }

    public boolean checkSortingForDeviceNameInAscendingOrder() {
        ArrayList<String> deviceName=new ArrayList<String>();
        for (int i = 1; i <= deviceRecords.size(); i++) {
            String deviceNameXpath = "//table//tbody//tr[" + i + "]//td[2]";
            WebElement deviceNameElement = webDriver.findElement(By.xpath(deviceNameXpath));
            deviceName.add(deviceNameElement.getText());
        }
            return CommonFunctions.checkSortingInAscending(deviceName);
        }



    public boolean checkSortingForDeviceNameInDescendingOrder() {
        ArrayList<String> deviceName=new ArrayList<String>();
        for (int i = 1; i <= deviceRecords.size(); i++) {
            String deviceNameXpath = "//table//tbody//tr[" + i + "]//td[2]";
            WebElement deviceNameElement = webDriver.findElement(By.xpath(deviceNameXpath));
            deviceName.add(deviceNameElement.getText());
        }
        return CommonFunctions.checkSortingInDescending(deviceName);
    }

}

