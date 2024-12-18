Feature: Localization and Language Switching
As a user
I want to change the website language
So that I can view content in English or German and ensure language persistence

Background:
Given The user is on the main page

  Scenario Outline: Verify availability of two Languages
    Then I should see options to '<Language>'.
    Examples:
      | Language |
      | German   |
      | English  |


