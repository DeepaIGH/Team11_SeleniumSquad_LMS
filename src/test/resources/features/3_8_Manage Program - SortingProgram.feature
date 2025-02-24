Feature: Manage Program-Sorting Program

  Background: 
    Given Admin is on program page after reaching home

  Scenario: Verify sorting of  Program name in Ascending order
    Given Admin is on Program page
    When Admin clicks on Arrow next to program Name
    Then Admin See the Program Name is sorted in "Ascending" order

  Scenario: Verify sorting of  Program name in Descending order
    Given Admin is on Program page
    When Admin clicks on Arrow next to program Name
    And Admin clicks on Arrow next to program Name
    Then Admin See the Program Name is sorted in "Descending" order

  Scenario: Verify sorting of  Program Description in  Ascending order
    Given Admin is on Program page
    When Admin clicks on Arrow next to Program Description
    Then Admin See the program Description is sorted in "Ascending" order

  Scenario: Verify sorting of  Program Description in Descending order
    Given Admin is on Program page
    When Admin clicks on Arrow next to Program Description
    And Admin clicks on Arrow next to Program Description
    Then Admin See the program Description is sorted in "Descending" order

  Scenario: Verify sorting of   Program status in Ascending order
    Given Admin is on Program page
    When Admin clicks on Arrow next to Program status
    Then Use See the  Program Status is sorted in "Ascending" order

  Scenario: Verify sorting of   Program status in Descending order
    Given Admin is on Program page
    When Admin clicks on Arrow next to Program status
    And Admin clicks on Arrow next to Program status
    Then Use See the  Program Status is sorted in "Descending" order
