@HomePageDeviceManagerApp

Feature: HomePage feature
  Description: Home Page flows

  Background: Home page of DeviceManager.com
    Given Login form in login page
    And user enters user name and password
    And User clicks on Login Button
    And user is navigated to DeviceManager Home page


  Scenario Outline: User is able to add device
    Given user click on Add New Device Button
    When user enters "<DeviceName>", "<OSType>" and "<CountryCode>"
    And user click on save button
    Then device "<DeviceName>", "<OSType>" and "<CountryCode>" is added in the device manager app

    Examples:
      |  DeviceName | |  OSType  | |  CountryCode |
      |  Samsung    | |  Android | |  CZ          |
      |  OnePlus    | |  Android | |  CZ          |
      |  Apple xs   | |  iPhone  | |  UK          |

  Scenario: User is able to list all the devices by sorting the name in ascending order
    Given user has records present in the Device Manager app
    When user click on Device Manager Header
    Then Devices are sorted in ascending order

  Scenario: User is able to list all the devices by sorting the name in descending order
    Given user has records present in the Device Manager app
    When user click on Device Manager Header to sort the list in descending order
    Then Devices are sorted in descending order

  Scenario: User is able to delete particular record from device Manager app
    Given user has existing one record
    When user select the particular record
    And user click on Delete Selected Record Button
    Then record is deleted successfully and record is not visible in the Device Manager app

  Scenario: User is able to delete all record from device Manager app
    Given user has existing records
    When user select all record
    And user click on Delete Selected Record Button
    Then all records are deleted successfully and no record is not visible in the Device Manager app




