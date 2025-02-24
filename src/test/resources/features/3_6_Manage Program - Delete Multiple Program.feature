Feature: Manage Program - Delete Multiple Program

  Background: 
    Given Admin is on program page after reaching home

  Scenario: Verify Admin is able to select multiple programs
    Given Admin creates multiple programs with name containing "NavyaMultiple"
    When Admin searches "NavyaMultiple" and selects more than one program by clicking on the checkbox
    Then Programs get selected

  Scenario: Verify Admin is able to delete Multiple programs
    Given Admin is on Program page and selects multiple programs "NavyaMultiple"
    When Admin clicks on the delete button on the left top of the program page
    Then Admin lands on Confirmation form

  Scenario: Verify Admin is able to click 'No'
    Given Admin is on Confirmation form for multiple programs "NavyaMultiple"
    When Admin clicks on "No" button
    Then Admin can see Programs are still selected and not deleted

  Scenario: Verify Admin is able to close the window with "X"
    Given Admin is on Confirmation form for multiple programs "NavyaMultiple"
    When Admin clicks on "X" button
    Then Admin can see Confirmation form disappears

  Scenario: Verify Admin is able to click 'Yes'
    Given Admin is on Confirmation form for multiple programs "NavyaMultiple"
    When Admin clicks on "Yes" button
    Then Admin can see "Successful  program deleted" message

  Scenario: Verify Admin is able to deleted program
    Given Admin is on Program page
    When Admin Searches for "NavyaMultiple"
    Then There should be zero results.
