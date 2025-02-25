Feature: Manage Program - Edit Program

  Background: Admin is on program page after reaching home

  Scenario: Verify Edit option
    Given Admin is on Program page
    When Admin clicks on Edit option for particular program
    Then Admin lands on Program details form

  Scenario: Verify title of the pop up window
    Given Admin is on Program page
    When Admin clicks on Edit option for particular program
    Then Admin should see window title as "Program Details"

  Scenario: Verify mandatory fields with red asterisk mark
    Given Admin is on Program page
    When Admin clicks on Edit option for particular program
    Then Admin should see red asterisk mark beside mandatory field "Name"

  Scenario: Verify edit Program Name
    Given Admin is on Program page
    When Admin edits the program name and click on save button
    Then Updated program name is seen by the Admin

  Scenario: Verify edit Description
    Given Admin is on Program page
    When Admin edits the description text and click on save button
    Then Admin can see the description is updated

  Scenario: Verify edit Status
    Given Admin is on Program page
    When Admin can change the status of the program and click on save button	Status
    Then updated can be viewed by the Admin

  Scenario: Verify Admin is able to click Save
    Given Admin is on Program page
    When Admin click on save button
    Then Admin can see the updated program details

  Scenario: Verify Admin is able to click Cancel
    Given Admin is on Program page
    When Admin click on cancel button
    Then Admin can see the Program details form disappears

  Scenario: Verify edited Program details
    Given Admin is on Program page
    When Admin searches with newly updated "Program Name"
    Then Admin verifies that the details are correctly updated.

  Scenario: Verify close the window with "X"
    Given Admin is on Program page
    When Admin Click on "X" button
    Then Admin can see program details form disappear
