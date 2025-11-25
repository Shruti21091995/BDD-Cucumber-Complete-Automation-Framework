@Regression
Feature: Search Products

  As a user  
  I want to search for products  
  So that I can find things I want to buy

  Scenario: Search with a valid product name
    Given the user is on the homepage
    When the user types "computer" in the search box
    And clicks on the search button
    Then the search results page should display products related to "https://demowebshop.tricentis.com/search?q=laptop"

  Scenario: Search with partial keyword
    Given the user is on the homepage
    When the user types "lap" in the search box
    Then the auto-suggestion list (if any) should show "laptop" or similar items

  Scenario: Search with no matching product
    Given the user is on the homepage
    When the user searches for "someRandomNonExistingProductXYZ"
    Then the user should see "No products were found that matched your criteria." (or equivalent)

  Scenario: Search with special characters
    Given the user is on the homepage
    When the user searches for "@@@###"
    Then either no results or a validation message should appear "No products were found that matched your criteria."
