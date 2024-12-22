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
    Then The user should see an alarm messages against all mandatory fields

  Scenario: Alarm message is displayed to the user when attempting to register with empty first name field
    And The user click on the "Mein Konto" in the main menu
    And The user click on the Register button
    When The user fills in all fields except first name
    And The user clicks the Register button
    Then The user should see an alarm message next to the incorrectly filled in first name field

  Scenario: Alarm message is displayed to the user when attempting to register with empty last name field
    And The user click on the "Mein Konto" in the main menu
    And The user click on the Register button
    When The user fills in all fields except last name
    And The user clicks the Register button
    Then The user should see an alarm message next to the incorrectly filled in last name field

  Scenario: Alarm message is displayed to the user when attempting to register with empty email field
    And The user click on the "Mein Konto" in the main menu
    And The user click on the Register button
    When The user fills in all fields except email field
    And The user clicks the Register button
    Then The user should see an alarm message next to the incorrectly filled in email field

  Scenario: Alarm message is displayed to the user when attempting to register with empty password field
    And The user click on the "Mein Konto" in the main menu
    And The user click on the Register button
    When The user fills in all fields except password field
    And The user clicks the Register button
    Then The user should see an alarm message next to the incorrectly filled in password field

  Scenario: Alarm message is displayed to the user when attempting to register with empty confirm password field
    And The user click on the "Mein Konto" in the main menu
    And The user click on the Register button
    When The user fills in all fields except confirm password field
    And The user clicks the Register button
    Then The user should see an alarm message next to the incorrectly filled in confirm password field

#Space
#1(2)-character name
#Very long name, 128 or 256 characters
#Contains special characters: @, #, $, %, !, <, >
#The name contains only digits or have digits
#Use of prohibited words (e.g. ‘admin’, ‘test’)
#Use of Unicode characters such as 😊, ©, 漢字
  Scenario Outline: Alarm message is displayed to the user when attempting to register with incorrect data in the user first name
    And The user click on the "Mein Konto" in the main menu
    And The user click on the Register button
    When The user tries to enter '<incorrect data>' in the first name field
    And The user clicks the Register button
    Then The user should see an alarm message next to the incorrectly filled in first name field
    Examples:
      | incorrect data                   |
      | |
      |A|
      |d|
      |Ab|
      |ABCD|
      |Jsdfhasfdhaushfuahsufhasufhuahfuhsdufhasufhuashdfagiojdfpfigaruhvahrgviohruchrucghuafhgahcsuohfgurhguhsfhui|
      |Sdfhasfdhaushfuahsufhasufhuahfuhsdufhasufhuashdfagiojdfpfigaruhvahrgviohruchrucghuafhgahcsuohfgurhguhsfhuisdfhuhsfhsdifhsudfhskdfggadgaysfdtfaxttdxrxtawretxafbfexabdxafdyxafydfaxtysfdxbyafxafbdxfasbdxfabdxbadxbtafdtwfaxtyfwxtyafwty|
      |Erick@|
      |Stepan#|
      |Nicolaus$|
      |Gambi%|
      |Rudy!|
      |Stefani<|
      |Rock>|
      |Maria12343842|
      |343842|
      |admin|
      |test|
      |😊|
      |©|
      |漢字|

  Scenario Outline: Alarm message is displayed to the user when attempting to register with incorrect data in the user last name
    And The user click on the "Mein Konto" in the main menu
    And The user click on the Register button
    When The user tries to enter '<incorrect data>' in the last name field
    And The user clicks the Register button
    Then The user should see an alarm message next to the incorrectly filled in last name field
    Examples:
      | incorrect data                   |
      | |
      |A|
      |d|
      |Ab|
      |ABCD|
      |Jsdfhasfdhaushfuahsufhasufhuahfuhsdufhasufhuashdfagiojdfpfigaruhvahrgviohruchrucghuafhgahcsuohfgurhguhsfhui|
      |Sdfhasfdhaushfuahsufhasufhuahfuhsdufhasufhuashdfagiojdfpfigaruhvahrgviohruchrucghuafhgahcsuohfgurhguhsfhuisdfhuhsfhsdifhsudfhskdfggadgaysfdtfaxttdxrxtawretxafbfexabdxafdyxafydfaxtysfdxbyafxafbdxfasbdxfabdxbadxbtafdtwfaxtyfwxtyafwty|
      |Erick@|
      |Stepan#|
      |Nicolaus$|
      |Gambi%|
      |Rudy!|
      |Stefani<|
      |Rock>|
      |Maria12343842|
      |343842|
      |admin|
      |test|
      |😊|
      |©|
      |漢字|

#Missing @ symbol
#Missing domain
#Use of spaces
#Incorrect domain suffixes
#Missing dots
#Use of characters not supported in email
#Very long email (usually 320 characters)
#Lack of local part
#Domain parts in the wrong order
  Scenario Outline: Alarm message is displayed to the user when attempting to register with incorrect data in the email field
    And The user click on the "Mein Konto" in the main menu
    And The user click on the Register button
    When The user tries to enter '<incorrect data>' in the email field
    And The user clicks the Register button
    Then The user should see an alarm message next to the incorrectly filled in email field
    Examples:
      | incorrect data                   |
      |andy.rodrigestestgmail.com|
      |andy.rodrigestest@|
      |andy rodrigestest@gmail.com|
      |andy.rodrigestest@gmail.grass|
      |andy..rodrigestest@gmail.com|
      |andy.rodrigestest!@gmail.com|
      |abcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghij@gmail.com|
      |com.gmail@rodrigestest.andy|

#The password is shorter than the minimum allowed length (e.g. less than 8 characters).
#Contains only letters (does not include numbers or special characters)
#Contains only digits
#Very simple password
#The password is too long (exceeds the maximum limit, e.g. 128 characters)
#Includes spaces
  Scenario Outline: Alarm message is displayed to the user when attempting to register with incorrect data in the password field
    And The user click on the "Mein Konto" in the main menu
    And The user click on the Register button
    When The user tries to enter '<incorrect data>' in the password field
    And The user clicks the Register button
    Then The user should see an alarm message next to the incorrectly filled in password field
    Examples:
      | incorrect data                   |
      |gh|
      |ghj3|
      |ghj34n|
      |ghj34ns|
      |ghjokrnd|
      |12345678|
      |qwerty|
      |password1234|
      |aBcDeFgHiJkLmNoPqRsTuVwXyZ0123456789!@#$%^&*()_-+=<>?/~/abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890[]{};:'",.<>|
      |AgkfRI45 fg90gndd|

#Different values in the ‘Password’ field and the ‘Repeat password’ field
#Partial match
#Different registers
#Special characters
#Adding extra spaces
  Scenario Outline: Alarm message is displayed to the user when attempting to register with incorrect data in the confirm password field
    And The user click on the "Mein Konto" in the main menu
    And The user click on the Register button
    When The User has entered a '<valid password>' and '<incorrect data>' in confirmation password field
    And The user clicks the Register button
    Then The user should see an alarm message next to the incorrectly filled in confirm password field
    Examples:
      |valid password| incorrect data                   |
      |password|123456987Test6978|
      |password|123456987Tests|
      |password|123456987test|
      |password!|123456987Test@|
      |password| 123456987Test|
