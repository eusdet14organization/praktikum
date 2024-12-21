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

  Scenario: The user can register by entering the correct data
    And The user click on the "Mein Konto" in the main menu
    And The user click on the Register button
    When The user enters correct personal data
    And The user clicks the Register button
    Then The user sees a message about successful registration

  Scenario: The user can register by entering the correct data
    And The user click on the "Mein Konto" in the main menu
    And The user click on the Register button
    And The user enters correct personal data
    And The user clicks the Register button
    And The user sees a message about successful registration
    When The user clicks the "Weiter" button to access their account
    Then The user account page opens
