Feature: Navigation Bar
  This feature contains scenarios that check that all navigation bar items and menu items in the "Restorative Produkte" section are opened. Possibility to open every product on the website

  Background:
    Given The user is on the main page

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
      | Kontakt    | contactUrl   | contactUrlTitle   |

  Scenario: Checking that the user can see all submenu items
    When The user moves mouse to the "Restorative Producte" in the main menu
    Then The user must see a submenu appearing

  Scenario Outline: Verify that the user can select the menu item recovery products
    When The user moves mouse to the "Restorative Producte" in the main menu
    And The user selects a '<name DropMenu>' item
    Then The user should be redirected to the '<correct page>' and page have '<correct title>'
    Examples:
      | name DropMenu         | correct page           | correct title               |
      | Composite             | compositeUrl           | compositeUrlTitle           |
      | Bleaching             | bleachingUrl           | bleachingUrlTitle           |
      | Befestigungscomposite | fixingCompositeUrl     | fixingCompositeUrlTitle     |
      | Prophy Materials      | preventionMaterialsUrl | preventionMaterialsUrlTitle |
      | Liners                | linersUrl              | linersUrlTitle              |
      | Etching               | etchingUrl             | etchingUrlTitle             |
      | Bonding               | gluingUrl              | gluingUrlTitle              |

  Scenario Outline: Verify that the user can also click all links in the left navigation bar of "Restorative Produkte"
    And The User selects "Restorative Produkte" in the main menu
    And The user should be redirected to the Restorative Produkte page and this page have correct title
    When The user select a '<name LeftMenu>' item
    Then The user should be redirected to the '<correct page>' and page have '<correct title>'
    Examples:
      | name LeftMenu         | correct page           | correct title               |
      | Composite             | compositeUrl           | compositeUrlTitle           |
      | Bleaching             | bleachingUrl           | bleachingUrlTitle           |
      | Befestigungscomposite | fixingCompositeUrl     | fixingCompositeUrlTitle     |
      | Prophy Materials      | preventionMaterialsUrl | preventionMaterialsUrlTitle |
      | Liners                | linersUrl              | linersUrlTitle              |
      | Etching               | etchingUrl             | etchingUrlTitle             |
      | Bonding               | gluingUrl              | gluingUrlTitle              |

  Scenario Outline: Verify that the user can also click all links in the center navigation bar with picture of "Restorative Produkte"
    And The User selects "Restorative Produkte" in the main menu
    And The user should be redirected to the Restorative Produkte page and this page have correct title
    When The user chooses a '<name CenterMenu>' item
    Then The user should be redirected to the '<correct page>' and page have '<correct title>'
    Examples:
      | name CenterMenu       | correct page           | correct title               |
      | Composite             | compositeUrl           | compositeUrlTitle           |
      | Bleaching             | bleachingUrl           | bleachingUrlTitle           |
      | Befestigungscomposite | fixingCompositeUrl     | fixingCompositeUrlTitle     |
      | Prophy Materials      | preventionMaterialsUrl | preventionMaterialsUrlTitle |
      | Liners                | linersUrl              | linersUrlTitle              |
      | Etching               | etchingUrl             | etchingUrlTitle             |
      | Bonding               | gluingUrl              | gluingUrlTitle              |

  Scenario Outline: The user can open each product in each menu item with a product in the navigation bar ‘Restorative Produkte’
    And The User selects "Restorative Produkte" in the main menu
    And The user select a '<name LeftMenu>' item
    Then The user can opens the card of each product in this section
    Examples:
      | name LeftMenu         |
      | Composite             |
      | Bleaching             |
      | Befestigungscomposite |
      | Prophy Materials      |
      | Liners                |
      | Etching               |
      | Bonding               |