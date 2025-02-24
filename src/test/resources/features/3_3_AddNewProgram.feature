@ProgramFeature3
Feature: Add New Program
  @tag:3_1
  Scenario: Verify add New Program
    Given Admin is on Program page
    When Admin clicks on <Add New Program> under the <Program> menu bar
    Then Admin should see pop up window for program details
  @tag:3_2
  Scenario: Verify title of the pop up window
 Then Admin should see window title as "Program Details"
   @tag:3_3
 Scenario: Verify mandatory fields with red asterisk mark 
 Then Admin should see red asterik mark  beside <mandatory fields> Name Description status
  @tag:3_4
 Scenario: Verify enter program name
 When Admin enters the Name in the text box
 Then Admin can see the text entered in name text box
  @tag:3_5
 Scenario: Verify enter program Description
 When Admin enters the Description in the text box
 Then Admin can see the text entered Description in text box
  #@tag:3_6
 #Scenario Outline: Verify select Status
 #When Admin selects the status of the program by clicking on the "<radio button>"
 #Then Admin can see status selected
  #Examples: 
      #| radio button | 
#			| Active       | 
#			| Inactive     | 
  @tag:3_7
 Scenario: Verify cancel button
 When Admin clicks Cancel button
 Then Admin can see Program Details form disappear 
 @tag:3_8
 Scenario: Verify empty form submission
  Given Admin is on program details form
 When Admin clicks save button without entering mandatory 
 Then Admin gets message <field> is required
 @tag:3_9
 Scenario Outline: Verify Admin is able to save the program details
 When Admin enter valid details for mandatory fields from excel "<Sheetname>" and <RowNumber> and Clicks on Save button
  Then Admin gets message "Successful Program created"
  Examples:
  | Sheetname | RowNumber |
  | program   |   1       |
  
 @tag:3_10
 Scenario: Verify close window with "X" 
 When Admin Click on close(X) button
 Then Admin can see Program Details form disappear
