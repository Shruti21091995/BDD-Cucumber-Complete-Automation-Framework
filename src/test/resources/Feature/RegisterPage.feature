@Regression
Feature: User Registration

  As a new user  
  I want to register on Demo Web Shop  
  So that I can make purchases and save my account

  Scenario: Successful registration with valid details
    Given the user is on the registration page
    When the user provides valid details:
      | FirstName | LastName | Email                     | Password    | ConfirmPassword |
      | smita     | patil      | smita.patil.new@gmail.com | Abc@12345   | Abc@12345        |
    And clicks on the "Register" button
    Then registration should be successful
    
  Scenario: Registration with existing email
    Given the user is on the registration page
    When the user enters an email that is already registered as below:
      | FirstName | LastName | Email               | Password    | ConfirmPassword |
      | aniruddha      | patil     | kalpana.patil@gmail.com | Abc@12345   | Abc@12345        |
    And gives other valid details
    And clicks on "Register"
    Then the error message "The specified email already exists" should be displayed

  Scenario: Registration with invalid email format
    Given the user is on the registration page
    When the user enters "gmail.com" in the email field
    And fills other valid fields
    Then validation message "Wrong email" (or similar) should appear

  Scenario: Registration with mismatched password and confirmation
    Given the user is on the registration page
    When the user enters a password "shruti@123" and confirmation "shruti@124"
    And other required details correctly
    And clicks "Register"
    Then an error "The password and confirmation password do not match." should display

  Scenario: Registration with missing mandatory fields
    Given the user is on the registration page
    When the user leaves FirstName or LastName or Email or Password empty
    And clicks "Register"
    Then appropriate validation messages should be shown for each required field
