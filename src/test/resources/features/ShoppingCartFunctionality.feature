Feature:ShoppingCartFunctionality

  Background:
    Given The user is on the main page


  Scenario: Go to the cart via the Cart image on the Home page
    When The user clicks on the image of the Shopping Cart.
    Then The user goes to the Cart page.


  Scenario:Go to the cart via the number next the Cart image on the Home page
    When The user clicks on the number next to the shopping cart image.
    Then The user goes to the Cart page.


  Scenario:Go to the cart via the word "Warenkorb" in the top menu of the Home page
    When The user clicks on the word Warenkorb in the top menu of the page.
    Then The user goes to the Cart page.


  Scenario:Go to the cart via the word "Warenkorb" in the bottom menu of the Home page
    When The user clicks on the word "Warenkorb" in the bottom menu of the page.
    Then The user goes to the Cart page.



  Scenario Outline:Adding products to cart from search results
    And The user records the number of items in the cart.
    When The user enters the name or part the name of the '<Product>' in the search field  auf Top Menu.
    And The user clicks on the button Add to Cart on Product Card <Amount> times
    Then The user checks the amount product in the cart using the information in the main menu.

    Examples:
      | Product                                    |Amount|
      | Kaiser Nano Komposite Compules 20 X 0,3g   |   3  |
      | Nord Gel 4 X 1,2 ml                        |   2  |
      | Terra Root Cem Viscous 8 g Kartusche       |   5  |
      | One Patient Bleaching Kit                  |   1  |



    Scenario:Adding a specified quantity of multiple products to your cart from search results
      And The user records the number of items in the cart.
      When The user searches for and adds several products to the cart
        | Product                                    |Amount|
        | Kaiser Nano Komposite Compules 20 X 0,3g   |   3  |
        | Nord Gel 4 X 1,2 ml                        |   2  |
        | Terra Root Cem Viscous 8 g Kartusche       |   5  |
      Then The user checks the amount product in the cart using the information in the main menu.



  Scenario Outline:Adding products to cart from search results and view it in cart.
    When The user enters the name or part the name of the '<Product>' in the search field  auf Top Menu.
    And The user clicks on the button Add to Cart on Product Card <Amount> times
    And The user clicks on the image of the Shopping Cart.
    Then The user checks the name '<Product>' and <Amount>  in the cart.

    Examples:
      | Product                                    |Amount|
      | Kaiser Nano Komposite Compules 20 X 0,3g   |   3  |
      | Nord Gel 4 X 1,2 ml                        |   2  |
      | Terra Root Cem Viscous 8 g Kartusche       |   5  |
      | One Patient Bleaching Kit                  |   1  |


  Scenario:Adding a specified quantity of multiple products to your cart from search results and view it in cart.
    When The user searches for and adds several products to the cart
      | Product                                    |Amount|
      | Kaiser Nano Komposite Compules 20 X 0,3g   |   3  |
      | Nord Gel 4 X 1,2 ml                        |   2  |
      | Terra Root Cem Viscous 8 g Kartusche       |   5  |
    And The user clicks on the image of the Shopping Cart.
    Then The user checks the amount and product in the cart.
      | Kaiser Nano Komposite Compules 20 X 0,3g   |   3  |
      | Nord Gel 4 X 1,2 ml                        |   2  |
      | Terra Root Cem Viscous 8 g Kartusche       |   5  |


  Scenario Outline:Changing the amount of product in the cart.
    When The user enters the name or part the name of the '<Product>' in the search field  auf Top Menu.
    And The user clicks on the button Add to Cart on Product Card <Amount> times
    And The user clicks on the image of the Shopping Cart.
    And The user change the amount of a product in the cart to '<NewAmount>'.
    Then The user checks the name '<Product>' and <NewAmount>  in the cart.

    Examples:
      | Product                                    |Amount|NewAmount|
      | Kaiser Nano Komposite Compules 20 X 0,3g   |   3  |   5     |
      | Nord Gel 4 X 1,2 ml                        |   2  |  12     |
      | Terra Root Cem Viscous 8 g Kartusche       |   5  |   1     |
      | One Patient Bleaching Kit                  |   1  |  90     |



  Scenario Outline:Adding products to cart from product card
    And The user records the number of items in the cart.
    When The user enters the name or part the name of the '<Product>' in the search field  auf Top Menu.
    And The user go to product card.
    Then The user selects the required '<Amount>' of product
    And The user clicks on the button Add to Cart.
    Then The user checks the amount product in the cart using the information in the main menu.

    Examples:
      | Product                                    |Amount|
      | Kaiser Nano Komposite Compules 20 X 0,3g   |   3  |
      | Nord Gel 4 X 1,2 ml                        |   50 |
      | Terra Root Cem Viscous 8 g Kartusche       |   5  |
      | One Patient Bleaching Kit                  |   1  |



  Scenario Outline:Adding products to cart from product card and view it in cart.
    And The user records the number of items in the cart.
    When The user enters the name or part the name of the '<Product>' in the search field  auf Top Menu.
    And The user go to product card.
    Then The user selects the required '<Amount>' of product
    And The user clicks on the button Add to Cart.
    And The user clicks on the image of the Shopping Cart.
    Then The user checks the name '<Product>' and <Amount>  in the cart.

    Examples:
      | Product                                    |Amount|
      | Kaiser Nano Komposite Compules 20 X 0,3g   |   3  |
      | Nord Gel 4 X 1,2 ml                        |   50 |
      | Terra Root Cem Viscous 8 g Kartusche       |   5  |
      | One Patient Bleaching Kit                  |   1  |


  Scenario:Adding a specified quantity of multiple products to your cart  from product card and view it in cart.
    When The user searches for and adds several products to the cart from product card.
      | Product                                    |Amount|
      | Kaiser Nano Komposite Compules 20 X 0,3g   |  42  |
      | Nord Gel 4 X 1,2 ml                        |  15  |
      | Terra Root Cem Viscous 8 g Kartusche       |  70  |
    And The user clicks on the image of the Shopping Cart.
    Then The user checks the amount and product in the cart.
      | Kaiser Nano Komposite Compules 20 X 0,3g   |  42  |
      | Nord Gel 4 X 1,2 ml                        |  15  |
      | Terra Root Cem Viscous 8 g Kartusche       |  70  |




  Scenario:Adding a specified quantity of multiple products to your cart from search results and view it in cart.
    And The user records the number of items in the cart.
    When The user searches for and adds several products to the cart
      | Product                                    |Amount|
      | Kaiser Nano Komposite Compules 20 X 0,3g   |   3  |
      | Nord Gel 4 X 1,2 ml                        |   2  |
      | Terra Root Cem Viscous 8 g Kartusche       |   5  |
    And The user clicks on the image of the Shopping Cart.
    When The user removes an product from the cart.
      | Nord Gel 4 X 1,2 ml                        |   2  |
    Then The user checks the amount and product in the cart.
      | Kaiser Nano Komposite Compules 20 X 0,3g   |   3  |
      | Terra Root Cem Viscous 8 g Kartusche       |   5  |