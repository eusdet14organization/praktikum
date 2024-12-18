@Ignore
Feature: Registration Form
  This feature file contains scenarios to validate the functionality of the registration form on the website.

  Background:
    Given The user is on the main page

Feature: Registration Page Accessibility

  Scenario: Verify that clicking "Register" opens the registration form page
    And The user click on the "Mein Konto" in the main menu
    When The user click on the "Registierung" button
    Then The user should be redirected to the registration page
    And The name of registration form should be displayed
    And The form should include the following fields:
      | Field Name        |
      | Username          |
      | Email             |
      | Password          |
      | Confirm Password  |
    And The form should include a "Registierung" button


