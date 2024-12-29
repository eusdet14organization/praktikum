
Feature: Make a purchase following all purchase steps

  Background:
    Given The user is logged

    Scenario Outline: As logged user make complete purchase
      When The user enters the name or part the name of the '<Product>' in the search field  auf Top Menu.
      And The user clicks on the button Add to Cart on Product Card <Amount> times
      And The user clicks on the image of the Shopping Cart.
      And The user clicks on the button Check out
      And The user selects an invoicing address with the "selectUserAndy"
      And The user clicks on the button next step on the shipping cart
      And The user clicks on the button next step on the payment method cart
      And The user clicks on the button next step on the confirmation cart
      Then The user should see the success text on the top of the page
      And The order conformation button is displayed

      Examples:
        | Product                                    |Amount|
        | Kaiser Nano Komposite Compules 20 X 0,3g   |   1  |



