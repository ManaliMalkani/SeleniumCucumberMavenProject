@LoginDeviceManagerApp

Feature: Login feature
  Description: Login flows

  Background: Home page of DeviceManager.com
    Given Login form in login page

  Scenario: User is able to Login
    Given user enters user name and password
    When User clicks on Login Button
    Then user is navigated to DeviceManager Home page


  Scenario:  User is not able to Login if user enters wrong username
    Given user enters user wrong userName and password
    When User clicks on Login Button
    Then user is not navigated to DeviceManager Home page

  Scenario:  User is not able to Login if user enters wrong password
    Given user enters user wrong password and username
    When User clicks on Login Button
    Then user is not navigated to DeviceManager Home page

  Scenario:  User is not able to Logout successfully if user click on Logout Button
    Given user enters user name and password
    And User clicks on Login Button
    And user is navigated to DeviceManager Home page
    #When user click on Logout Button
    #Then user is navigated to login page
    #Then user is navigated to DeviceManager Home page

