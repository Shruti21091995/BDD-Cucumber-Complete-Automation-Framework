@Smoke @Regression
Feature: User Login

  As a registered user  
  I want to login  
  So that I can access my account and place orders
@smoke
  Scenario: Successful login with valid credentials
    Given the user is on the login page
    When the user enters a email "shruti@gmail.com" and valid password "shruti@123"
    And clicks on "Log in"
    Then the user should be logged in
@smoke
  Scenario: Login with invalid password
    Given the user is on the login page
    When the user enters a correct email "shruti@gmail.com" but wrong password "shrutipatil@123"
    And clicks on "Log in"
    Then an error message "Login was unsuccessful. Please correct the errors and try again." should display
@smoke
  Scenario: Login with invalid email
    Given the user is on the login page
    When the user enters an unregistered email "shrut@gmail.com" and any password "shruti@123"
    And clicks "Log in"
    Then the error "No customer account found" or the standard login failure message should display
@smoke
  Scenario: Login with empty fields
    Given the user is on the login page
    When the user leaves email or password blank
    And clicks "Log in"
    Then validation errors should be shown (e.g. “Email is required”, “Password is required”)

@Regression
    Scenario Outline: Successful login with valid credentials
  Given the user is on the login page
    When the user enters a email "<username>"  and valid password "<password>"
    And clicks on "Log in"
    Then the user should be logged in

  Examples:
    | username       | password | expectedMessage        |
    | shruti@gmail.com| shruti@123 | Login Successful       |
    | anirudhpatil@gmail.com| anirudh@123 | Valid credentials    |