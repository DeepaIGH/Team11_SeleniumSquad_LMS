Feature: Manage Program - Pagination

  Background: 
    Given Admin is on program page after reaching home

  Scenario: Verify pagination when there are no records
    Given Admin is on home page after Login
    When Admin clicks "Program" on the navigation bar
    Then Admin should not see any pagination icons and message "No records found"
