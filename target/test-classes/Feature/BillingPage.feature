Feature: Complete Checkout Flow
  The user should be able to complete the full checkout process from billing to order confirmation


  # ==========================================================
  # Complete End-to-End Checkout
  # ==========================================================
  Scenario: User completes full checkout process
    Given the user is on the checkout page
    
    # Step 1: Billing Address
    When the user selects an existing billing address "New Address"
    And the user enters billing address details:
      | FirstName | John                     |
      | LastName  | Doe                      |
      | Email     | john.doe@example.com     |
      | Country   | India            |
      | City      | New York                 |
      | Address   | 123, 5th Avenue          |
      | Postal    | 10001                    |
      | Mobile    | 1234567890               |
    And the user clicks on Billing Continue
    Then the billing address should be submitted successfully
    
    # Step 2: Shipping Address
    And the user clicks on Shipping Address Continue
    Then the shipping address should be submitted successfully
    
    # Step 3: Shipping Method
    And the user selects shipping method "Ground"
    And the user clicks on Shipping Method Continue
    Then the shipping method should be submitted successfully
    
    # Step 4: Payment Method
    And the user selects payment method "Check / Money Order"
    And the user clicks on Payment Method Continue
    Then the payment method should be submitted successfully
    
    # Step 5: Payment Info
    And the user clicks on Payment Info Continue
    Then the payment information should be submitted successfully
    
    # Step 6: Confirm Order
    And the user clicks on Confirm Order
    Then the order should be placed successfully
