
@batch1
Feature: Batch Page Navigation  
  
Background: Admin is on the home page after Login 

Scenario: Verify Admin Navigate to Batch page successfully
Given  Admin is on the home Page after Login
When  Admin Clicks on the Batch menu from the header
Then Admin should be in the Manage Batch Page

#Feature: Batch Page Validation
Scenario:  Validate Title in Batch Page
Given  Admin is on the home Page after Login
When Admin Clicks on the Batch menu from the header
Then Admin should see the LMS-Learning Management System Title

Scenario:  Validate "heading" in the Batch Page
Given  Admin is on the home Page after Login
When Admin Clicks on the Batch menu from the header
Then Admin should see the Manage Batch Heading

Scenario:  Validate disabled "Delete Icon" under the header in the Batch Page
Given  Admin is on the home Page after Login
When Admin Clicks on the Batch menu from the header
Then Admin should see the disabled Delete Icon under the header

Scenario:  Validate edit icon in each data rows
Given  Admin is on the home Page after Login
When Admin Clicks on the Batch menu from the header
Then Admin should see the edit icon in each row

Scenario:  validate delete icon in each data rows
Given  Admin is on the home Page after Login
When Admin Clicks on the Batch menu from the header
Then Admin should see the delete icon in each row

Scenario:  validate checkbox in each data rows
Given  Admin is on the home Page after Login
When Admin Clicks on the Batch menu from the header
Then Admin should see the checkbox in each row

Scenario:  Validate "Checkbox" in the Datatable header row
Given  Admin is on the home Page after Login
When Admin Clicks on the Batch menu from the header
Then Admin should see the checkbox  in the datatable header row
