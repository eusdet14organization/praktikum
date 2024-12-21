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

  Scenario: Alarm message is displayed to the user when attempting to register with empty all mandatory fields
    And The user click on the "Mein Konto" in the main menu
    And The user click on the Register button
    When The user clicks the Register button
    Then The user should see an error message against all mandatory fields

  Scenario: Alarm message is displayed to the user when attempting to register with empty first name field
    And The user click on the "Mein Konto" in the main menu
    And The user click on the Register button
    When The user fills in all fields except first name
    And The user clicks the Register button
    Then The user should see an error message next to the incorrectly filled in first name field

  Scenario: Alarm message is displayed to the user when attempting to register with empty last name field
    And The user click on the "Mein Konto" in the main menu
    And The user click on the Register button
    When The user fills in all fields except last name
    And The user clicks the Register button
    Then The user should see an error message next to the incorrectly filled in last name field

  Scenario: Alarm message is displayed to the user when attempting to register with empty email field
    And The user click on the "Mein Konto" in the main menu
    And The user click on the Register button
    When The user fills in all fields except email field
    And The user clicks the Register button
    Then The user should see an error message next to the incorrectly filled in email field

  Scenario: Alarm message is displayed to the user when attempting to register with empty password field
    And The user click on the "Mein Konto" in the main menu
    And The user click on the Register button
    When The user fills in all fields except password field
    And The user clicks the Register button
    Then The user should see an error message next to the incorrectly filled in password field

  Scenario: Alarm message is displayed to the user when attempting to register with empty confirm password field
    And The user click on the "Mein Konto" in the main menu
    And The user click on the Register button
    When The user fills in all fields except confirm password field
    And The user clicks the Register button
    Then The user should see an error message next to the incorrectly filled in confirm password field

#Spaces, пробелы
  Scenario: Alarm message is displayed to the user when attempting to register with incorrect data in the user first name
    And The user click on the "Mein Konto" in the main menu
    And The user click on the Register button

#1(2)-character name, имя из 1 или 2 символов
  Scenario: Alarm message is displayed to the user when attempting to register with incorrect data in the user first name
    And The user click on the "Mein Konto" in the main menu
    And The user click on the Register button

#Very long name, 256 characters, имя из 256 символов
  Scenario: Alarm message is displayed to the user when attempting to register with incorrect data in the user first name
    And The user click on the "Mein Konto" in the main menu
    And The user click on the Register button

#Contains special characters: @, #, $, %, !, <, >., спец символы
  Scenario: Alarm message is displayed to the user when attempting to register with incorrect data in the user first name
    And The user click on the "Mein Konto" in the main menu
    And The user click on the Register button

#The name contains only digits, имя из цифр
  Scenario: Alarm message is displayed to the user when attempting to register with incorrect data in the user first name
    And The user click on the "Mein Konto" in the main menu
    And The user click on the Register button

#Use of prohibited words (e.g. ‘admin’, ‘test’)., запрещенные слова
  Scenario: Alarm message is displayed to the user when attempting to register with incorrect data in the user first name
    And The user click on the "Mein Konto" in the main menu
    And The user click on the Register button

#Use of Unicode characters such as 😊, ©, 漢字,
  Scenario: Alarm message is displayed to the user when attempting to register with incorrect data in the user first name
    And The user click on the "Mein Konto" in the main menu
    And The user click on the Register button

#Missing @ symbol
  Scenario: Alarm message is displayed to the user when attempting to register with incorrect data in the email field
    And The user click on the "Mein Konto" in the main menu
    And The user click on the Register button

#Missing domain: userexample.com.
  Scenario: Alarm message is displayed to the user when attempting to register with incorrect data in the email field
    And The user click on the "Mein Konto" in the main menu
    And The user click on the Register button

#Use of spaces
  Scenario: Alarm message is displayed to the user when attempting to register with incorrect data in the email field
    And The user click on the "Mein Konto" in the main menu
    And The user click on the Register button

#Incorrect domain suffixes: user@example.invalid.
  Scenario: Alarm message is displayed to the user when attempting to register with incorrect data in the email field
    And The user click on the "Mein Konto" in the main menu
    And The user click on the Register button

#Missing dots: user..name@example.com.
  Scenario: Alarm message is displayed to the user when attempting to register with incorrect data in the email field
    And The user click on the "Mein Konto" in the main menu
    And The user click on the Register button

#Use of characters not supported in email: user!@example.com.
  Scenario: Alarm message is displayed to the user when attempting to register with incorrect data in the email field
    And The user click on the "Mein Konto" in the main menu
    And The user click on the Register button

#Very long email (exceeds standard limits - usually 320 characters).
  Scenario: Alarm message is displayed to the user when attempting to register with incorrect data in the email field
    And The user click on the "Mein Konto" in the main menu
    And The user click on the Register button

#Lack of local part: @example.com.
  Scenario: Alarm message is displayed to the user when attempting to register with incorrect data in the email field
    And The user click on the "Mein Konto" in the main menu
    And The user click on the Register button

#Domain parts in the wrong order: com.example@user
  Scenario: Alarm message is displayed to the user when attempting to register with incorrect data in the email field
    And The user click on the "Mein Konto" in the main menu
    And The user click on the Register button

#The password is shorter than the minimum allowed length (e.g. less than 8 characters).
  Scenario: Alarm message is displayed to the user when attempting to register with incorrect data in the password field
    And The user click on the "Mein Konto" in the main menu
    And The user click on the Register button

#Contains only letters (does not include numbers or special characters).
  Scenario: Alarm message is displayed to the user when attempting to register with incorrect data in the password field
    And The user click on the "Mein Konto" in the main menu
    And The user click on the Register button

#Contains only digits: 12345678.
  Scenario: Alarm message is displayed to the user when attempting to register with incorrect data in the password field
    And The user click on the "Mein Konto" in the main menu
    And The user click on the Register button

#Very simple password: password, 1234abcd.
  Scenario: Alarm message is displayed to the user when attempting to register with incorrect data in the password field
    And The user click on the "Mein Konto" in the main menu
    And The user click on the Register button

#Repeats the username or email.
  Scenario: Alarm message is displayed to the user when attempting to register with incorrect data in the password field
    And The user click on the "Mein Konto" in the main menu
    And The user click on the Register button

#The password is too long (exceeds the maximum limit, e.g. 128 characters).
  Scenario: Alarm message is displayed to the user when attempting to register with incorrect data in the password field
    And The user click on the "Mein Konto" in the main menu
    And The user click on the Register button

#Includes spaces: pass word.
  Scenario: Alarm message is displayed to the user when attempting to register with incorrect data in the password field
    And The user click on the "Mein Konto" in the main menu
    And The user click on the Register button

