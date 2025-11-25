Feature: Product Details Page

  As a user  
  I want to view detailed information about a product  
  So that I can decide to add to cart or continue browsing

  Scenario: View the product details for a specific product
    Given the user is on the Books category page
    When the user clicks on a product named "Fiction"
    Then the product details page should show:
      | Field         |
      | Product name  |
      | Price         |
      | Description   |
      | Availability (stock) |
      | "Add to cart" button |
      | Quantity selector |

  Scenario: Change quantity and add to cart
    Given the user is on the Books category page
    When the user clicks on a product named "Fiction"
    And the user sets quantity to "2"
    And clicks on Add to cart button
    Then the product should be added to the cart with quantity 2
    And a confirmation message (e.g. "The product has been added to your shopping cart") should appear

  Scenario: Try to add zero quantity
    Given the user is on the Books category page
    When the user clicks on a product named "Fiction"
    And the user sets quantity to "0"
    And clicks on Add to cart button
    Then an error or validation message should show (if website restricts zero quantity)
