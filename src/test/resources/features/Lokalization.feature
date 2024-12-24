Feature: Language Switcher
  As a user, I want to switch the website language between English and German using the Language Switcher.

  Background:
    Given The user is on the main page


  Scenario: Language availability
    When I hover the mouse over the Language switcher
    Then I see a choose of two languages with country flags: English and German

#    Scenario:
#      When The user move the cursor over the '<language>' icon
#      Then The tooltip <name> is displayed below the '<language>' button
#      Examples:
#        | language | name |
#        | DE       |
#problem
#  Scenario: Tooltip for English language
#    When I move the cursor over the English language icon
#    Then the Tooltip 'En' is displayed below the English  language button
#
#  Scenario: Tooltip for German language
#    When I move the cursor over the German language icon
#    Then the Tooltip 'DE' is displayed below the German button

  Scenario Outline:Switch language
    When The user click on '<language>' in the top menu
    Then The user should see the menu item in the '<correct language>'
    Examples:
      | language | correct language |
      | DE       | Startseite       |
      | EN       | Home page        |


  Scenario Outline: Verify language persistence after reload
    When The user switch the '<language>' to:
    And The user reload the Page
    Then the website should display content '<Text>' in:
    Examples:
      | language | Text       |
      | DE       | Startseite |
      | En       | Home page  |

  Scenario: Verify language persistence after navigation
    When The user switch the language to German
    And The user navigate to another page
    Then the website should display content in German







