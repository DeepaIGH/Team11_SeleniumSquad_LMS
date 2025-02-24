Feature: Edit popup feature

  Background: 
    Given User enters the LMS url "https://feb-ui-hackathon-bbfd38d67ea9.herokuapp.com/login"
    And enters username "sdetnumpyninja@gmail.com" and password "Feb@2025" and select role as Admin
    When user clicks login button
    Then User click on Edit Popup and and on Mangae class Page 
    
    
    Scenario: Check if the fields are updated with valid data 
    When Update the fields with valid data and click save
    Then Admin gets message "class details updated Successfully " and see the updated values in data tableAdmin should see batch name field is disabled
    
    
    Scenario: Check if the fields are updated with invalid values      
    When Update the fields with invalid values and click save
    Then Admin should get Error message 
    
    
   
    
    Scenario: Validate invalid values in the text fields
    
    When Admin enters only numbers or special char in the text fields
    Then Admin should get Error message 
    
    Scenario: Validate Cancel button on Edit popup 
    
    When Admin clicks Cancel button on edit popup
    Then Admin can see the class details popup disappears and can see nothing changed for particular Class

    