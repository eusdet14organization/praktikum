Feature: Language Switcher
  As a user, I want to switch the website language between English and German using the Language Switcher.

  Background:
    Given The user is on the main page

#  Scenario: Hover over Language Switcher
#    When I hover the mouse over the Language switcher
#    Then I see a choose of two languages with country flags: English and German

#  Scenario: Tooltip for English language
#    When I move the cursor over the English language icon
#    Then the Tooltip "En" is displayed below the English  language button

#  Scenario: Tooltip for German language
#    When I move the cursor over the German language icon
#    Then the Tooltip 'DE' is displayed below the German button

#  Scenario: Switch to German language
#    When I click on the German language icon
#    Then all text on the site is displayed in German

#  Scenario: Switch to English language
#    When I click on the English language icon
#    Then all text on the site is displayed in English

    When I click on the German language icon
    Then all texts on the website should be displayed in German
    When I reload the page
    Then all texts on the website should still be displayed in German


