Feature: Shopping Cart

  As a user  
  I want to manage items in my shopping cart  
  So that I can prepare my order before checkout

  Scenario: View cart contents
    Given the user added at one product to the cart "Laptop"
    When the user navigates to the Shopping Cart page
    Then the product(s) should be listed with:
      | Column         |
      | Product name   |
      | Unit price     |
      | Quantity        |
      | Subtotal        |

  Scenario: Update quantity in cart
    Given the user is on the Shopping Cart page
    And there is a product in the cart with quantity 1
    When the user changes quantity to 3
    And clicks on the Update shopping cart button
    Then the cart should update the quantity to 3
    And the subtotal and total should recalculate accordingly

  Scenario: Remove product from cart
    Given the user is on the Shopping Cart page
    And a product exists in the cart
    When the user clicks Remove next to the product
    Then the product should be removed
    And the cart should reflect that removal

  Scenario: Agree to terms of service before checkout
    Given the user is on the Shopping Cart page
    When the user does not check the I agree with the terms of service checkbox
    And clicks on the Checkout button
    Then the user should see a validation error Please accept the terms of service or similar

  Scenario: Successfully proceed to checkout with terms accepted
    Given the user is on the Shopping Cart page
    When the user checks the I agree with the terms of service checkbox
    And clicks on the Checkout button
    Then the user should be navigated to the billing page

