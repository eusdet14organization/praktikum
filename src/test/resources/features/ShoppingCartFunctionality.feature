Feature:ShoppingCartFunctionality

  Background:
    Given The user is on the main page

  @ignored
  Scenario: Go to the cart via the Cart image on the Home page
    When The user clicks on the image of the Shopping Cart.
    Then The user goes to the Cart page.

  @ignored
  Scenario:Go to the cart via the number next the Cart image on the Home page
    When The user clicks on the number next to the shopping cart image.
    Then The user goes to the Cart page.

  @ignored
  Scenario:Go to the cart via the word "Warenkorb" in the top menu of the Home page
    When The user clicks on the word Warenkorb in the top menu of the page.
    Then The user goes to the Cart page.

  @ignored
  Scenario:Go to the cart via the word "Warenkorb" in the bottom menu of the Home page
    When The user clicks on the word "Warenkorb" in the bottom menu of the page.
    Then The user goes to the Cart page.

  @ignored
  Scenario Outline:Adding a product to the cart from search results
    And The user records the number of items in the cart.
    When The user enters the name or part the name of the '<Product>' in the search field  auf Top Menu.
    And The user clicks on the button Add to Cart on Product Card
    And The user sees a "messageAddProductToCart" at the top of the page.
    Then The user checks amount Product in Cart

    Examples:
      | Product                   |
      | One Patient Bleaching Kit |

  @ignored
  Scenario Outline:Adding multiple product to cart from search results
    And The user records the number of items in the cart.
    When The user enters the name or part the name of the '<Product>' in the search field  auf Top Menu.
    And The user clicks on the button Add to Cart on Product Card <Amount> times
    Then The user checks amount Product in Cart

    Examples:
      | Product                                    |Amount|
      | Kaiser Nano Komposite Compules 20 X 0,3g   |   3  |
      | Nord Gel 4 X 1,2 ml                        |   2  |
      | Terra Root Cem Viscous 8 g Kartusche       |   5  |

  @ignored
    Scenario:Add a specified quantity of multiple items to your cart from search results
      And The user records the number of items in the cart.
      When The user searches for and adds several products to the cart
        | Product                                    |Amount|
        | Kaiser Nano Komposite Compules 20 X 0,3g   |   3  |
        | Nord Gel 4 X 1,2 ml                        |   2  |
        | Terra Root Cem Viscous 8 g Kartusche       |   5  |
      Then The user checks amount Product in Cart
