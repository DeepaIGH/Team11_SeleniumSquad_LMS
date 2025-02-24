Feature: Manage Program - Search bar

  Background: 
    Given Admin is on program page after reaching home

  Scenario: Verify Admin is able to search results found for program name
    Given Admin is on Program page
    When Admin enter the program to search By program name "NavyaMultipleNWMbj"
    Then Admin should able to see Program name, description, and status for searched program name "NavyaMultipleNWMbj"

  Scenario: Verify Admin is able to search results found for program description
    Given Admin is on Program page
    When Admin enter the program to search By program description "description"
    Then Admin should able to see Program name, description, and status for searched program description "description"

  Scenario: Verify Admin is able to search results not found
    Given Admin is on Program page
    When Admin enter the program to search By program name that does not exist "dummy text"
    Then There should be zero results.

  Scenario: Verify Admin is able to search with partial program name
    Given Admin is on Program page
    When Admin enter the program to search By partial name of program "Multiple"
    Then Admin should able to see Program name, description, and status for searched program name "Multiple"
