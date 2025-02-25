Feature: Manage Program - Pagination

  Background: 
    Given Admin is on program page after reaching home

  Scenario: Verify Admin is able to click Next page link
    Given Admin is on Program page
    When Admin clicks Next page link on the program table
    Then Admin should see the Pagination has "2" active link

  Scenario: Verify Admin is able to click Last page link
    Given Admin is on Program page
    When Admin clicks Last page link
    Then Admin should see the last page record on the table with Next page link are disabled

  Scenario: Verify Admin is able to click Previous page link
    Given Admin is on last page of Program page table
    When Admin clicks Previous page link
    Then Admin should see the previous page record on the table with pagination has previous page link

  Scenario: Verify Admin is able to click  First page link
    Given	 Admin is on Previous Program page
    When Admin clicks First page link
    Then Admin should see the very first page record on the table with Previous page link are disabled
