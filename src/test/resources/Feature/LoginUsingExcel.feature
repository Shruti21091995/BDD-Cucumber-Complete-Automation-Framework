Feature: Login with multiple Excel inputs

  Scenario: Login using Excel data
    Given user launches the browser
    When user enters username and password from Excel
    Then user should be logged in successfully
