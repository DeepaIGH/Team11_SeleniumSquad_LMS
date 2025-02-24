Feature: Manage Program - Pagination

  Background: 
    Given Admin is logged in to LMS Portal with >=5 records in program list

  Scenario: Verify pagination when there are less than 5 records
    Given Admin is on home page after Login
    When Admin clicks "Program" on the navigation bar
    Then Admin should see pagination icons disabled
