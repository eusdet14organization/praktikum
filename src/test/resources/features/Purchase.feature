Feature: Make a purchase following all purchase steps

  Background:
    Given The user is logged

    Scenario: As logged user make complete purchase
      And The user moves the cursor over the navigation menu
      And The user click on the "Composite"
      And The user should be redirected on the "Composite page"
      And The user clicks on the button buy
      And The user should see the success adding the product on the cart
      And The user clicks on the image of the Shopping Cart.
      And The user clicks on the button Check out
      And The user should be redirected on the "Billing page"
      #And The user filling out the address form
      And The user selects an invoicing address with the "Andy"
      And The user clicks on the button next step on the shipping cart
      And The user clicks on the button next step on the payment method cart
      And The user clicks on the button next step on the confirmation cart
      Then The user should see the success text on the top of the page
      And The user should see the success text in the middle on the page
      And The order conformation button is displayed



