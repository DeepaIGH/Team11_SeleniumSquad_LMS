Feature: Add New Batch
@tag1
Scenario: Verify sub menu displayed in batch menu bar
Given  Admin is on the Dashboard Page
When Admin clicks "Batch" on the navigation bar
Then Admin should see sub menu in menu bar as "Add New Batch"
@tag2
Scenario: Validate Admin is able to click on the Add new Batch Option
Given  Admin is on the Dashboard Page
When Admin clicks on "Add New batch" under the "batch" menu bar
Then Admin should see the Batch Details pop up window

#FEATURE Add New Batch details pop up
@tag3
Scenario: Validate all the fields exist in pop up 
Given  Admin is on the Batch Details Pop Up Window
When Admin checks all the fields are enabled
Then The pop up should include the fields Batch Name,Number of classes and Description as text box,SProgram Name as drop down. Status as radio button

@tag4
Scenario: Validate batchname prefix selected program name
Given Admin is on the Batch Details Pop Up Window
When Admin selects program name present in the dropdown
Then  Admin should see selected program name in the batch name prefix box
@tag5
Scenario: Validate batch name suffix box should accept only numbers
Given  Admin is on the Batch Details Pop Up Window
When Admin enters alphabets in batch name suffix box
Then Admin should get error message below the text box of respective field
@tag6
Scenario: Validate batch name prefix box is not editable
Given  Admin is on the Batch Details Pop Up Window
When Admin enters alphabets in batch name prefix box
Then Batch Name should not be editable
@tag7
Scenario: Validate input data only for mandatory fields
Given  Admin is on the Batch Details Pop Up Window
When Admin enters the data only in the mandatory fields and clicks save button
Then Admin should get a successful message
@tag8
Scenario: validate input data missing for mandatory fields
Given  Admin is on the Batch Details Pop Up Window
When Admin leaves blank one of the mandatory fields
Then Admin should get a error message on the respective mandatory field

@tag10
Scenario: validate cancel button in Batch details pop up
Given  Admin is on the Batch Details Pop Up Window
When Admin enters the valid data in all the mandatory fields and click cancel button 
Then Admin can see the batch details popup closes without creating any batch
@tag11
Scenario: validate close icon on the batch details pop up
Given  Admin is on the Batch Details Pop Up Window
When Admin clicks on the close icon
Then batch details pop up closes