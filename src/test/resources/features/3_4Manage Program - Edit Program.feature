Feature: Manage Program - Edit Program

  Background: Admin is on program page after reaching home

  Scenario: Verify Edit option
    Given Create a program "GeethanjaliABCN" on program page
    When Admin search the program "GeethanjaliABCN" and clicks on edit button for a program
    Then Admin lands on Program details form

  Scenario: Verify title of the pop up window
    Given Admin is on Program page
    When Admin search the program "GeethanjaliABCN" and clicks on edit button for a program
    Then Admin should see window title as "Program Details"

  Scenario: Verify mandatory fields with red asterisk mark
    Given Admin is on Program page
    When Admin search the program "GeethanjaliABCN" and clicks on edit button for a program
    Then Admin should see red asterisk mark beside mandatory fields

  Scenario: Verify edit Description
    Given Admin is on Program page and open a edit modal for "GeethanjaliABCN"
    When Admin edits the description text "GeethanjaliABCN" and click on save button
    Then Admin can see the description is updated to "GeethanjaliABCN"

  Scenario: Verify edit Status
    Given Admin is on Program page and open a edit modal for "GeethanjaliABCN"
    When Admin can change the status of the program and click on save button Status
    Then updated can be viewed by the Admin "Inactive"

  Scenario: Verify Admin is able to click Save
    Given Admin is on Program page and open a edit modal for "GeethanjaliABCN"
    When Admin click on save button
    Then Admin can see the updated program details "GeethanjaliABCN"

  Scenario: Verify Admin is able to click Cancel
    Given Admin is on Program page and open a edit modal for "GeethanjaliABCN"
    When Admin click on cancel button
    Then Admin can see the Program details form disappears

  Scenario: Verify close the window with "X"
    Given Admin is on Program page and open a edit modal for "GeethanjaliABCN"
    When Admin Click on X button
    Then Admin can see program details form disappear

  Scenario: Verify edit Program Name
    Given Admin is on Program page
    When Admin edits the program name to "GeethanjaliABCN" and click on save button
    Then Updated program name "GeethanjaliABCN" is seen by the Admin

  Scenario: Verify edited Program details
    Given Admin is on Program page
    When Admin searches with newly updated "GeethanjaliABCN"
    Then Admin verifies that the details are correctly updated to "GeethanjaliABCN"
