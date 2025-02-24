Feature: Class Page Validation

#Background: 
     #
    #Given User enters the LMS url "https://feb-ui-hackathon-bbfd38d67ea9.herokuapp.com/login"
    #And enters username "sdetnumpyninja@gmail.com" and password "Feb@2025" and select role as Admin
    #When user clicks login button
    
   @tag151
    Scenario: Validating the class manage page
    When Admin clicks the Class Navigation bar in the Header class page
    Then Admin should land on the Manage class page
    
  @tag152
    Scenario: Validating the Title in the Manage class page 
    When  Admin is on the Manage class page of class page
    Then Admin should see the "LMS-Learning Management System" Title for ClassPage 
    
  @tag153
   Scenario: Validating the Header in the Manage class page  
    When  Admin is on the Manage class page of class page
    Then Admin should see the "Mange Class" Header

   @tag154
    Scenario: Validating Search bar in class page   
    When  Admin is on the Manage class page of class page
    Then Admin should see the Search Bar in Manage class page 
    
    @tag155(Failing)
    Scenario: Validating the data table headers in the class page
    When  Admin is on the Manage class page of class page
    Then Admin should see the datatable heading like Batchname, class topic, class description, status, class Date, staff name, Edit/Delete
    
    @tag156
    Scenario: Validating the text and pagination icon in the class page
     When  Admin is on the Manage class page of class page   
     Then Admin should see the " showing x to y of  z entries" and enabled pagination controls under the data table classpage
    
    @tag157
    Scenario: Validate the sort icon of all the field in datatable class page
    When  Admin is on the Manage class page of class page
    Then Admin should see the Sort icon of all the field in the datatable class page
    
    @tag158
    Scenario: Validating the Delete button under the Manage class 
    When  Admin is on the Manage class page of class page
    Then Admin should see the Delete button under the Manage class page header.
    
    @tag159
    Scenario: Validate the total no of classes in manage class page
    When  Admin is on the Manage class page of class page    
    Then Admin should see Total no of classes in below of the data table.
    
    @tag160
    Scenario: Class link on navigation bar
    When  Admin is on the Manage class page of class page
    Then Admin is redirected to class page
    
    
    @tag161 
    Scenario: Class link to other page on navigation bar
    Given Admin is on the Manage class page of class page
    When Admin clicks on any page link on Manage Class page
    Then Admin is redirected to which page link they clicked.
    
    @tag163
    Scenario: Search class by Batch Name
    Given Admin is on the Manage class page of class page
    When Admin enter the Batch Name in search textbox of Class apge
    Then Admin should see Class details are searched by Batch Name
    
    @tag164
    Scenario: Search class by Class topic
    Given Admin is on the Manage class page of class page
    When Admin enter the Class topic in search textbox of Class apge
    Then Admin should see Class details are searched by Class topic
    

    @tag165
     Scenario: Verify Last page link(>>)
    Given Admin is on the Manage class page of class page
    When Admin clicks Last page link
    Then Admin should see the next page record on the table  with Pagination has next active link enabled
    
     @tag166
    Scenario: Verify Next page link(>)
    GivenAdmin is on Manage class page  of Class Page
    When Admin clicks Next page link on the class table 
    Then Admin should see the last page record on the table with Next page link are disabled
    
    
    
    @tag167
    Scenario: Validate Common Delete button enabled after clicking on any checkbox
    Given Admin is on the Manage class page of class page
    When Admin clicks any checkbox in the data table class page
    Then Admin should see common delete option enabled under header Manage class
    
    
    @tag168popupValidation
    Scenario: Validate Class Details Popup window
    Given  Admin is on the Manage class page of class page
    When Admin clicks add new class under the class menu bar.
    Then Admin should see a popup open for class Page details with empty form along with <SAVE> and <CANCEL> button and Close(X) Icon on the top right corner of the window


    @tag169InputfieldsWithTextboxes
    Scenario: Validate input fields and their text boxes in Class details form
    Given  Admin is on the Manage class page of class page
    When Admin clicks add new class under the class menu bar.
    Then Admin should see few input fields and their respective text boxes in the class details window

    @tag170
    Scenario: Validate row level edit icon
    Given Admin is on the Manage class page of class page
    When Admin clicks on the edit icon Manage Class 
    Then A new pop up with class details appears Manage Class 
    
     @tag171
    Scenario: Check disabled  batch name
    Given Admin is on the Manage class page of class page
    When Admin clicks on the edit icon Manage Class 
    Then Admin should see batch name field is disabled Manage Class 
    
    @tag172
    Scenario: Check disabled class topic
    Given Admin is on the Manage class page of class page
    When Admin clicks on the edit icon Manage Class
    Then Admin should see class topic field is disabled
    
    
    @tag173Defect 
    Scenario: Search class by Staff Name
    Given Admin is on the Manage class page of class page
    When Admin enter the Staff Name in search textbox of Class apge
    Then Admin should see Class details are searched by Staff name
       
    
    
    
    @tag174
    Scenario: Logout link on navigation bar
    Given Admin is on the Manage class page of class page
    When Admin clicks on Logout link on Manage class page
    Then Admin is redirected to Login page
    
    


    #Scenario: Validate row level delete icon
    #Given Admin is on Manage Class Page
    #When Admin clicks the delete icon
    #Then Admin should see a alert open with heading "Confirm" along with  <YES> and <NO> button for deletion
    #
    #Scenario: Click Yes on deletion window
    #Given Admin is on Confirm Deletion alert
    #When Admin clicks yes option
    #Then Admin gets a message "Successful Class Deleted" alert and do not see that Class in the data table
    #
    #Scenario: Click No on deletion window
    #Given Admin is on Confirm Deletion alert
    #When Admin clicks  No option
    #Then Admin can see the deletion alert disappears without deleting
    #
    #Scenario: Validate Close(X) icon on Confirm Deletion alert
    #Given Admin is on Confirm Deletion alert
    #When Admin clicks on close button
    #Then Admin can see the deletion alert disappears without any changes
    #
      
    
    
    
    