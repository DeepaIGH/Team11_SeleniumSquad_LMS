Feature: Sort Icon


  Background: 
   
     
    Given User enters the LMS url "https://feb-ui-hackathon-bbfd38d67ea9.herokuapp.com/login"
    And enters username "sdetnumpyninja@gmail.com" and password "Feb@2025" and select role as Admin
    When user clicks login button

#
  #Scenario Outline: Verify class details are sorted by different columns
    #When Admin clicks on the columnname "<columnName>"
    #Then Admin should see the column sorted by columnname "<columnName>"
#
    #Examples: 
      #| columnName        |
      #| Batch Name        |
      #| Class Topic       |
      #| Class Description |
      #| Status            |
      #| Class Date        |
      #| Staff Name        |
      
      
      #Scenario: Verify Last page link(>>)
    #Given Admin is on Manage class page of Class Page
    #When Admin clicks Last page link
    #Then Admin should see the next page record on the table  with Pagination has next active link enabled
    #
    
    #
    #Scenario: Verify Next page link(>)
    #GivenAdmin is on Manage class page  of Class Page
    #When Admin clicks Next page link on the class table 
    #Then Admin should see the last page record on the table with Next page link are disabled
    #
    #Scenario: Verify First page link(<)
    #Given Admin is on last page of class table  of Class Page
    #When Admin clicks First page link
    #Then Admin should see the previous page record on the table with pagination has previous page link enabled
    #
    #Scenario: Verify Start page link(<<)
    #Given Admin is on Previous class page  of Class Page
    #When Admin clicks Start page link
    #Then Admin should see the very first page record on the table with Previous page link are disabled
   #
  #
