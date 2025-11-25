Feature: End-to-End Ecommerce Purchase Flow
  As a registered user
  I want to login and purchase a product successfully
  So that I can complete an end-to-end ecommerce transaction

  @E2E @Regression @Smoke
  Scenario: Complete end-to-end ecommerce purchase flow
    Given user launches the Demo Web Shop application

    # ------------------ LOGIN ------------------
    And user navigates to Login page
    When user enters valid email and valid password
    And user clicks on Login button
    Then user should be logged in successfully

    # ------------------ SEARCH PRODUCT ------------------
    When user enters "computer" in search box
    And user clicks on Search button
    Then search results related to "computer" should be displayed

    # ------------------ SELECT PRODUCT ------------------
    When user selects the first product from search results
    Then product details page should be displayed
    And product name, price, description should be visible

    # ------------------ ADD TO CART ------------------
    When user enters quantity "1"
    And user clicks on Add to Cart button
    Then a success message should be displayed saying "The product has been added to your shopping cart"

    # ------------------ NAVIGATE TO CART ------------------
    When user navigates to Shopping Cart page
    Then the selected product should appear in cart with correct quantity and price

    # ------------------ ACCEPT TERMS & CHECKOUT ------------------
    When user checks the Terms of Service checkbox
    And user clicks on Checkout button
    Then user should be redirected to Checkout page

    # ------------------ BILLING ADDRESS ------------------
    When user fills the Billing Address details
      | FirstName | LastName | Email                | Country | City       | Address1    | Zip    | Phone      |
      | Shruti    | Patil    | shruti@test.com      | India   | Pune       | Test Add 1  | 411001 | 9876543210 |
    And user clicks on Continue button for Billing Address

    # ------------------ SHIPPING ADDRESS ------------------
    Then Shipping Address section should appear
    When user selects same address for shipping
    And user clicks Continue for Shipping Address

    # ------------------ SHIPPING METHOD ------------------
    Then Shipping Method section should appear
    When user selects "Ground" shipping method
    And user clicks Continue for Shipping Method

    # ------------------ PAYMENT METHOD ------------------
    Then Payment Method section should appear
    When user selects "Check / Money Order" payment method
    And user clicks Continue for Payment Method

    # ------------------ PAYMENT INFORMATION ------------------
    Then Payment Information section should appear
    When user clicks Continue for Payment Information

    # ------------------ CONFIRM ORDER ------------------
    Then Confirm Order page should be displayed
    When user clicks on Confirm button

    # ------------------ ORDER SUCCESS ------------------
    Then order should be placed successfully
    And Thank You page should be displayed
    And user should see the order number
