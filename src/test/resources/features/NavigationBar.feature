Feature: Navigation Bar
  This feature contains scenarios that check that all navigation bar items and menu items in the "Restorative Produkte" section are opened. Possibility to open every product on the website

  Background:
    Given The user is on the main page

  Scenario: Verify that the user can also click all links in the main navigation bar
    And The user click on the "Mein Konto" in the main menu

  Scenario: Verify that the user can also click all links in the navigation bar of "Restorative Produkte"
    And The user click on the "Restorative Produkte" in the main menu

  Scenario: The user can open each product in each menu item with a product in the navigation bar ‘Restorative Produkte’
    And The user click on the "Restorative Produkte" in the main menu