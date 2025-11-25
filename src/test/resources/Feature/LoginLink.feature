Feature: Login Link Functionality
  As a user of the ecommerce application
  I want to click the Login link
  So that I can navigate to the Login page and sign into my account

  @Smoke @Login
  Scenario: Verify Login link is visible and clickable
    Given User is on the home page
    When User clicks the Login link
    Then User should be navigated to the Login page
 
  # @Regression @Login
 # Scenario: Verify Login link is displayed on all major pages
  #  Given User is on the home page
  #  Then Login link should be visible
  #  When User navigates to the product listing page
  #  Then Login link should be visible
  #  When User navigates to the cart page
   # Then Login link should be visible

  @Regression @Login
  Scenario: Verify Login link text is correct
    Given User is on the home page
    Then Login link text should be "Login"
