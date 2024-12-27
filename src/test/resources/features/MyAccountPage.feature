@ignored
Feature: Login Form

  Background:
    Given The user is on the main page

    Scenario: User is logged
      Verify that the user has successfully logged
      Open the account login page through the main menu
      And The user click on the "Hallo Konto" menu item
      And The user should see the title on the Log in page
      And The user filling out the login form
      And The user click on Log in button
      Then The user has successfully logged