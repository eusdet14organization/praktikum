Feature: Registration Form
  This feature file contains scenarios to validate the functionality of the registration form on the website.

  Background:
    Given The user is on the main page

  Scenario: Registration Page Accessibility
  Verify that clicking "Register" opens the registration form page
  Open the account login page through the main menu
    And The user click on the "Mein Konto" in the main menu
    When The user click on the Register button
    Then The user should be redirected to the registration page
    And The name of registration form should be displayed
    And The form should include the following fields
      | Vorname :             |
      | Nachname :            |
      | E-Mail :              |
      | Passwort :            |
    And The form should include a Register button

  Scenario: Registration Page Accessibility
  Verify that clicking "Register" opens the registration form page
  Open the account login page via the "Hallo Konto" menu item
    And The user click on the "Hallo Konto" menu item
    When The user click on the Register button
    Then The user should be redirected to the registration page
    And The name of registration form should be displayed
    And The form should include the following fields
      | Vorname :             |
      | Nachname :            |
      | E-Mail :              |
      | Passwort :            |
    And The form should include a Register button

  Scenario: Registration Page Accessibility
  Verify that clicking "Register" opens the registration form page
  Open the account login page via the "Mein Konto" menu item in the footer
    And The user click on the "Mein Konto" menu item in the footer
    When The user click on the Register button
    Then The user should be redirected to the registration page
    And The name of registration form should be displayed
    And The form should include the following fields
      | Vorname :             |
      | Nachname :            |
      | E-Mail :              |
      | Passwort :            |
    And The form should include a Register button