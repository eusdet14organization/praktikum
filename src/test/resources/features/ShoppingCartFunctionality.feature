
Feature:ShoppingCartFunctionality

  Background:
    Given The user is on the main page

    Scenario:
      When The user clicks on the image of the Shopping Cart.
      Then The user goes to the Cart page.

  Scenario:
    When The user clicks on the number next to the shopping cart image.
    Then The user goes to the Cart page.

  Scenario:
    When The user clicks on the word "Warenkorb" in the top menu of the page.
    Then The user goes to the Cart page.

  Scenario:
    When The user clicks on the word "Warenkorb" in the bottom menu of the page.
    Then The user goes to the Cart page.