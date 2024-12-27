@ignored
Feature: Language Switcher
  As a user, I want to switch the website language between English and German using the Language Switcher.

  Background:
    Given The user is on the main page

  Scenario: Language availability
    When I hover the mouse over the Language switcher
    Then I see a choose of two languages with country flags: English and German

  Scenario Outline:Switch language
    When The user click on '<language>' in the top menu
    Then The user should see the menu item in the '<correct language>'
    Examples:
      | language | correct language |
      | DE       | Startseite       |
      | EN       | Home page        |


  Scenario Outline: Verify language persistence after reload
    When The user switch the '<language>' to
    And The user reload the Page
    Then the website should display content '<Text>' in
    Examples:
      | language | Text       |
      | DE       | Startseite |
      | En       | Home page  |

  Scenario: Verify language persistence after navigation
    When The user switch the language to German
    And The user moves the cursor over the navigation menu
    And The user click on the "Composite"
    Then the website should display content in German







