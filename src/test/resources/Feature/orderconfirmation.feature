Feature: Order Confirmation Page
  After placing an order, the user should see the confirmation message and be able to view order details.


  Background:
    Given the user has successfully placed an order


  # ==========================================================
  # 1. Validate Order Confirmation Message
  # ==========================================================
  Scenario: User sees order confirmation message
    When the user is on the order confirmation page
    Then the confirmation message should be displayed


  # ==========================================================
  # 2. Navigate to Order Details Page
  # ==========================================================
  Scenario: User navigates to order details page
    When the user clicks on the Order Details button
    Then the order details page should open successfully
