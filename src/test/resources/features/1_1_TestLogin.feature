
@tag
Feature: Test login functionality
  @tag1
  Scenario: login feature
    Given User enters the LMS url "https://feb-ui-hackathon-bbfd38d67ea9.herokuapp.com/login"
    And enters username "sdetnumpyninja@gmail.com" and password "Feb@2025" and select role as Admin
    When user clicks login button
    Then user lands on Homepage
   
