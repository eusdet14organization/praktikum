Feature: Navigation Bar
  This feature contains scenarios that check that all navigation bar items and menu items in the "Restorative Produkte" section are opened. Possibility to open every product on the website

  Background:
    Given The user is on the main page
  @ignored
  Scenario Outline: Verify that the user can also click all links in the main navigation bar
    When The user moves the mouse on the '<name menu>' in the main menu and clicks
    Then The user should be redirected to the '<correct page>' and page have '<correct title>'
    Examples:
      | name menu  | correct page | correct title     |
      | Startseite | base_url     | baseUrlTitle      |
      | Catalog    | catalogUrl   | catalogUrlTitle   |
      | e-IFU      | eIFUUrl      | eIFUUrlTitle      |
      | Über Uns   | aboutUsUrl   | aboutUsUrlTitle   |
      | Mein Konto | myAccountUrl | myAccountUrlTitle |
      | Kontakt    | contactUsUrl | contactUsUrlTitle |

  Scenario: Verify that the user  can select the menu item recovery products
    When The user moves mouse to the "Restorative Producte" in the main menu
    Then The user must see a submenu appearing

    #Сценарий для проверки подменю
@ignored
  Scenario: Verify that the user can also click all links in the navigation bar of "Restorative Produkte"
    And The user click on the "Restorative Produkte" in the main menu
@ignored
  Scenario: The user can open each product in each menu item with a product in the navigation bar ‘Restorative Produkte’
    And The user click on the "Restorative Produkte" in the main menu