Feature: Homepage

  As a website visitor  
  I want to view and navigate the homepage  
  So that I can browse the product catalog and go to important parts of the web shop

  @Smoke
  Scenario: Load homepage successfully
    Given the user opens the web shop home page
    Then the homepage title should be "Demo Web Shop"
    And main categories like "Books", "Computers", "Electronics", "Apparel & Shoes", etc should be visible

  Scenario: Navigate to “Books” category from homepage
    Given the user is on the homepage
    When the user clicks on the "Books" category link
    Then the Books category page should be displayed

  Scenario: Search box is present on homepage
    Given the user is on the homepage
    Then the search textbox should be visible
    And the search button should be visible
