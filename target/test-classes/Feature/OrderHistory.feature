Feature: My Account / Order History

  As a logged-in user  
  I want to view my past orders  
  So that I can check order status or details

  Scenario: See order history in My Account
    Given the user is logged in  
    When the user navigates to “My account” → “Orders”  
    Then all their past orders should be listed  
    And each order should show: order number, date, status, total

  Scenario: View details of a single order
    Given the user is on the Orders list page  
    When the user clicks on a specific order  
    Then order detail page should show product list, quantities, prices, billing and shipping info
