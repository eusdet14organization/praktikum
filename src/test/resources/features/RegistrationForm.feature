@ignored
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
      | Vorname :  |
      | Nachname : |
      | E-Mail :   |
      | Passwort : |
    And The form should include a Register button

  Scenario: Registration Page Accessibility
  Verify that clicking "Register" opens the registration form page
  Open the account login page via the "Hallo Konto" menu item
    And The user click on the "Hallo Konto" menu item
    When The user click on the Register button
    Then The user should be redirected to the registration page
    And The name of registration form should be displayed
    And The form should include the following fields
      | Vorname :  |
      | Nachname : |
      | E-Mail :   |
      | Passwort : |
    And The form should include a Register button

  Scenario: Registration Page Accessibility
  Verify that clicking "Register" opens the registration form page
  Open the account login page via the "Mein Konto" menu item in the footer
    And The user click on the "Mein Konto" menu item in the footer
    When The user click on the Register button
    Then The user should be redirected to the registration page
    And The name of registration form should be displayed
    And The form should include the following fields
      | Vorname :  |
      | Nachname : |
      | E-Mail :   |
      | Passwort : |
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

  Scenario: Alarm messages is displayed to the user when attempting to register with empty all mandatory fields
    And The user click on the "Mein Konto" in the main menu
    And The user click on the Register button
    When The user clicks the Register button
    Then The user should see an alarm messages against all mandatory fields

#Empty first name field
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
      | incorrect data                                                                                                                                                                                                                          |
      |                                                                                                                                                                                                                                         |
      | SP                                                                                                                                                                                                                                      |
      | A                                                                                                                                                                                                                                       |
      | d                                                                                                                                                                                                                                       |
      | Ab                                                                                                                                                                                                                                      |
      | ABCD                                                                                                                                                                                                                                    |
      | Jsdfhasfdhaushfuahsufhasufhuahfuhsdufhasufhuashdfagiojdfpfigaruhvahrgviohruchrucghuafhgahcsuohfgurhguhsfhui                                                                                                                             |
      | Sdfhasfdhaushfuahsufhasufhuahfuhsdufhasufhuashdfagiojdfpfigaruhvahrgviohruchrucghuafhgahcsuohfgurhguhsfhuisdfhuhsfhsdifhsudfhskdfggadgaysfdtfaxttdxrxtawretxafbfexabdxafdyxafydfaxtysfdxbyafxafbdxfasbdxfabdxbadxbtafdtwfaxtyfwxtyafwty |
      | Erick@                                                                                                                                                                                                                                  |
      | Stepan#                                                                                                                                                                                                                                 |
      | Nicolaus$                                                                                                                                                                                                                               |
      | Gambi%                                                                                                                                                                                                                                  |
      | Rudy!                                                                                                                                                                                                                                   |
      | Stefani<                                                                                                                                                                                                                                |
      | Rock>                                                                                                                                                                                                                                   |
      | Maria12343842                                                                                                                                                                                                                           |
      | 343842                                                                                                                                                                                                                                  |
      | admin                                                                                                                                                                                                                                   |
      | test                                                                                                                                                                                                                                    |
      | 😊                                                                                                                                                                                                                                      |
      | ©                                                                                                                                                                                                                                       |
      | 漢字                                                                                                                                                                                                                                      |

  Scenario Outline: Alarm message is displayed to the user when attempting to register with incorrect data in the user last name
    And The user click on the "Mein Konto" in the main menu
    And The user click on the Register button
    When The user tries to enter '<incorrect data>' in the last name field
    And The user clicks the Register button
    Then The user should see an alarm message next to the incorrectly filled in last name field
    Examples:
      | incorrect data                                                                                                                                                                                                                          |
      |                                                                                                                                                                                                                                         |
      | SP                                                                                                                                                                                                                                      |
      | A                                                                                                                                                                                                                                       |
      | d                                                                                                                                                                                                                                       |
      | Ab                                                                                                                                                                                                                                      |
      | ABCD                                                                                                                                                                                                                                    |
      | Jsdfhasfdhaushfuahsufhasufhuahfuhsdufhasufhuashdfagiojdfpfigaruhvahrgviohruchrucghuafhgahcsuohfgurhguhsfhui                                                                                                                             |
      | Sdfhasfdhaushfuahsufhasufhuahfuhsdufhasufhuashdfagiojdfpfigaruhvahrgviohruchrucghuafhgahcsuohfgurhguhsfhuisdfhuhsfhsdifhsudfhskdfggadgaysfdtfaxttdxrxtawretxafbfexabdxafdyxafydfaxtysfdxbyafxafbdxfasbdxfabdxbadxbtafdtwfaxtyfwxtyafwty |
      | Erick@                                                                                                                                                                                                                                  |
      | Stepan#                                                                                                                                                                                                                                 |
      | Nicolaus$                                                                                                                                                                                                                               |
      | Gambi%                                                                                                                                                                                                                                  |
      | Rudy!                                                                                                                                                                                                                                   |
      | Stefani<                                                                                                                                                                                                                                |
      | Rock>                                                                                                                                                                                                                                   |
      | Maria12343842                                                                                                                                                                                                                           |
      | 343842                                                                                                                                                                                                                                  |
      | admin                                                                                                                                                                                                                                   |
      | test                                                                                                                                                                                                                                    |
      | 😊                                                                                                                                                                                                                                      |
      | ©                                                                                                                                                                                                                                       |
      | 漢字                                                                                                                                                                                                                                      |

#Empty email field
  Scenario Outline: Alarm message is displayed to the user when attempting to register with empty email field
    And The user click on the "Mein Konto" in the main menu
    And The user click on the Register button
    When The user tries to enter '<incorrect data>' in the Email field
    And The user clicks the Register button
    Then The user should see an '<alarm message>' v1 next to the incorrectly filled in email field
    Examples:
      | incorrect data | alarm message              |
      |                | messageRequiredAdressField |
      | SP             | messageRequiredAdressField |

#Missing @ symbol
#Missing domain
#Use of spaces
#Lack of local part
  Scenario Outline: Alarm message is displayed to the user when attempting to register with incorrect data in the email field
    And The user click on the "Mein Konto" in the main menu
    And The user click on the Register button
    When The user tries to enter '<incorrect data>' in the email field
    Then The user should see an '<alarm message>' v1 next to the incorrectly filled in email field
    Examples:
      | incorrect data              | alarm message         |
      | andy.rodrigestest.gmail.com | massageIncorrectEmail |
      | andy.rodrigestest@          | massageIncorrectEmail |
      | andy rodrigestest@gmail.com | massageIncorrectEmail |
      | @gmail.com                  | massageIncorrectEmail |

#Incorrect domain suffixes - проходит регистрация
#Use of characters not supported in email - проходит регистрация
#Very long email (usually 320 characters)
#Domain parts in the wrong order
  Scenario Outline: Alarm message is displayed to the user when attempting to register with incorrect data in the email field
    And The user click on the "Mein Konto" in the main menu
    And The user click on the Register button
    When The user tries to enter '<incorrect data>' in the Email field
    And The user clicks the Register button
    Then The user should see an '<alarm message>' v2 next to the incorrectly filled in email field
    Examples:
      | incorrect data                                                                                                                                                                                                                                                                                                                                                                     | alarm message        |
      | andy.rodrigestest@gmail.grassssss                                                                                                                                                                                                                                                                                                                                                  | messageIncorrectMail |
      | andy.rodrigestest!!!!@gmail.com                                                                                                                                                                                                                                                                                                                                                    | messageIncorrectMail |
      | abcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghijabcdefghij@gmail.com | messageIncorrectMail |
      | com.gmail@rodrigestest.andy                                                                                                                                                                                                                                                                                                                                                        | messageIncorrectMail |

#Missing dots
  Scenario Outline: Alarm message is displayed to the user when attempting to register with incorrect data in the email field
    And The user click on the "Mein Konto" in the main menu
    And The user click on the Register button
    When The user tries to enter '<incorrect data>' in the Email field
    And The user clicks the Register button
    Then The user should see an '<alarm message>' v2 next to the incorrectly filled in email field
    Examples:
      | incorrect data               | alarm message         |
      | andy..rodrigestest@gmail.com | massageIncorrectEmail |
      | andy.rodrigestest@gmailcom   | massageIncorrectEmail |

#Empty password field
#The password is shorter than the minimum allowed length (less than 6 characters).
#Contains only letters (does not include numbers or special characters) - проходит регистрация
#Contains only digits - проходит регистрация
#Very simple password - проходит регистрация
#The password is too long (exceeds the maximum limit, e.g. 128 characters) - проходит регистрация
#Includes spaces - проходит регистрация
  Scenario Outline: Alarm message is displayed to the user when attempting to register with incorrect data in the password field
    And The user click on the "Mein Konto" in the main menu
    And The user click on the Register button
    When The user tries to enter '<incorrect data>' in the password field
    And The user clicks the Register button
    Then The user should see an '<alarm message>' next to the incorrectly filled in password field
    Examples:
      | incorrect data                                                                                                                                               | alarm message                 |
      |                                                                                                                                                              | messageRequiredPasswordField  |
      | SP                                                                                                                                                           | messageRequiredPasswordField  |
      | gh                                                                                                                                                           | messageIncorrectPasswordField |
      | ghj32                                                                                                                                                        | messageIncorrectPasswordField |
      | ghjokr                                                                                                                                                       | messageIncorrectPasswordField |
      | 12345678                                                                                                                                                     | messageIncorrectPasswordField |
      | qwerty                                                                                                                                                       | messageIncorrectPasswordField |
      | password1234                                                                                                                                                 | messageIncorrectPasswordField |
      | aBcDeFgHiJkLmNoPqRsTuVwXyZ0123456789!@#$%^&*()_-+=<>?/~/abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890[]{};sASDFGH.sadadadadasdadasdadasdada | messageIncorrectPasswordField |
      | AgkfRI45 fg90gndd                                                                                                                                            | messageIncorrectPasswordField |

#Empty confirm password field
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
    Then The user should see an '<alarm message>' next to the incorrectly filled in confirm password field
    Examples:
      | valid password | incorrect data    | alarm message                        |
      | password       |                   | messageRequiredPasswordField         |
      | password       | 123456987Test6978 | messageIncorrectConfirmPasswordField |
      | password       | 123456987Tests    | messageIncorrectConfirmPasswordField |
      | password       | 123456987test     | messageIncorrectConfirmPasswordField |
      | password!      | 123456987Test@    | messageIncorrectConfirmPasswordField |
      | password       | 123456987 Test    | messageIncorrectConfirmPasswordField |
