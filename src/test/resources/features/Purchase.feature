@ignored
Feature: Make a purchase following all purchase steps

  Background:
    Given The user is logged by "eMail" and "password"


    Scenario Outline: As logged user make complete purchase
      When The user enters the name or part the name of the '<Product>' in the search field  auf Top Menu.
      And The user clicks on the button Add to Cart on Product Card <Amount> times
      And The user clicks on the image of the Shopping Cart.
      And The user clicks on the button Check out
      And The user selects an invoicing address with the "selectUserAndy"
      And The user clicks on the button next step on the shipping cart
      And The user clicks on the button next step on the payment method cart
      And The user clicks on the button next step on the confirmation cart
      And The order conformation button is displayed

      Examples:
        | Product                                    |Amount|
        | Kaiser Nano Komposite Compules 20 X 0,3g   |   1  |


  Scenario:As logged user make complete purchase adding a specified quantity of multiple products to your cart from search results and view it in cart.
    When The user searches for and adds several products to the cart
      | Product                                                  |Amount|
      | Kaiser Flowable Composite Light 2 X 2g Syringe-Spritze   |   3  |
      | Nord Liner 2.5 gr                                        |   2  |
    And The user clicks on the image of the Shopping Cart.
    And The user clicks on the button Check out
    And The user selects an invoicing address with the "selectUser1Address"
    And The user clicks on the button next step on the shipping cart
    And The user clicks on the button next step on the payment method cart
    And The user clicks on the button next step on the confirmation cart
    And The order conformation button is displayed


    Scenario Outline: As logged user make complete purchase with adding a new shipping address
      When The user enters the name or part the name of the '<Product>' in the search field  auf Top Menu.
      And The user clicks on the button Add to Cart on Product Card <Amount> times
      And The user clicks on the image of the Shopping Cart.
      And The user clicks on the button Check out
      And The user selects a new invoicing address with the "newAddress"
      And The user fill out a new shipping address
      And The user clicks on the button next step on the shipping cart
      And The user clicks on the button next step on the payment method cart
      And The user clicks on the button next step on the confirmation cart
      And The order conformation button is displayed

      Examples:
        | Product               |Amount|
        | Nord Liner 2.5 gr     |   1  |


      Scenario Outline: As logged user make complete purchase with adding a new shipping address without city field
        When The user enters the name or part the name of the '<Product>' in the search field  auf Top Menu.
        And The user clicks on the button Add to Cart on Product Card <Amount> times
        And The user clicks on the image of the Shopping Cart.
        And The user clicks on the button Check out
        And The user selects a new invoicing address with the "newAddress"
        And The user fill out a mew shipping address without city name
       Then The user should see a required filed error message

        Examples:
          | Product                                    |Amount|
          | Kaiser Nano Komposite Compules 20 X 0,3g   |   1  |