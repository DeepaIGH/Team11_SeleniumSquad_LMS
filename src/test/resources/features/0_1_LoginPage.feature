@LoginPageVerifivation
Feature: Login Page Verification

  Background: 
    Given Admin gives the correct LMS portal URL

  @loginPage1
  Scenario: Verify Admin is able to land on login page
  Given The browser is open
  When Admin gives the correct LMS portal URL
  Then Admin should land on the login page
  
  	@loginPage2
  Scenario: Verify admin is able to land on homepage with invalid URL
  Given The browser is open
  When Admin gives the invalid LMS portal URL
  Then Admin should receive application error
  
  @loginPage3
  Scenario: Verify for broken link
  Given The browser is open
  When Admin gives the correct LMS portal URL
  Then HTTP response >= 400. Then the link is broken
  
  @loginPage4
  Scenario: Verify the text spelling in the page
  Given The browser is open
  When Admin gives the correct LMS portal URL
  Then Admin should see correct spellings in all fields
  
  @loginPage5
  Scenario: Verify application name
  Given The browser is open
  When Admin gives the correct LMS portal URL
  Then Admin should see  LMS - Learning Management System
  
  @loginPage6
  Scenario: Verify company name
  Given The browser is open
  When Admin gives the correct LMS portal URL
  Then Admin should see company name below the app name
  
  
  @loginPage7
  Scenario: Validate sign in content
  Given The browser is open
  When Admin gives the correct LMS portal URL
  Then Admin should see "Please login to LMS application"
  
  @loginPage8
  Scenario: Verify text field is present
  	Given The browser is open
  	When Admin gives the correct LMS portal URL
  	Then Admin should see two text field
  
  	@loginPage9
  Scenario: Verify text on the first field
  	Given The browser is open
  	When Admin gives the correct LMS portal URL
  	Then Admin should "User" in the first text field
  
  	@loginPage10
  Scenario: Verify dropdown is present
  	Given The browser is open
  	When Admin gives the correct LMS portal URL
  	Then Admin should see one dropdown
  
  	@loginPage11
  Scenario: Verify asterisk next to USER text
  	Given The browser is open
  	When Admin gives the correct LMS portal URL
  	Then Admin should see asterisk mark symbol next to text for mandatory fields
  
  	@loginPage12
  Scenario: Verify text on the second field
  	Given The browser is open
  	When Admin gives the correct LMS portal URL
  	Then Admin should "Password" in the second text field
  
  	@loginPage13
  Scenario: Verify asterisk mark symbol next to password text
  	Given The browser is open
  	When Admin gives the correct LMS portal URL
  	Then Admin should see asterisk mark symbol next to password text
  
  	@loginPage14
  Scenario: Verify placeholder in dropdown to select role
  	Given The browser is open
  	When Admin gives the correct LMS portal URL
  	Then Admin should see "Select the role" placeholder in dropdown
  
  	@loginPage15
  Scenario: Verify dropdown option to select role
  	Given The browser is open
  	When Admin gives the correct LMS portal URL
  	Then Admin should see "Admin , Staff , Student" options in dropdown
  
  	@loginPage16
  Scenario: Verify the alignment input field for the login
  	Given The browser is open
  	When Admin gives the correct LMS portal URL
  	Then Admin should see input field on the centre of the page
  
  	@loginPage17
  Scenario: verify Login button is present
  	Given The browser is open
  	When Admin gives the correct LMS portal URL
  	Then Admin should see login button
  
  	@loginPage18
  Scenario: Verify input descriptive text in user field
  	Given The browser is open
  	When Admin gives the correct LMS portal URL
  	Then Admin should see user in gray color
  	@loginPage19
  Scenario: Verify input descriptive text in password field
  	Given The browser is open
  	When Admin gives the correct LMS portal URL
  	Then Admin should see password in gray color
  
  @loginPage20
  Scenario: Validate login with valid data in all field
    Given Admin is on login Page
    When Admin enter valid data in all field and clicks login button
    Then Admin should land on home page

  @loginPage21 @bug
  Scenario: Validate login with invalid data
    Given Admin is on login Page
    When Admin enter invalid data and clicks login button
    Then Error message "Invalid username and password Please try again"

  @loginPage22 @bug
  Scenario: Validate login credentials with null user name
    Given Admin is on login Page	
    When Admin enter value only in password and clicks login button 	
    Then Error message" Please enter your user name"


  @loginPage23 @bug
  Scenario: Validate login credentials with null password
    Given Admin is on login Page	
    When Admin enter value only in user name and clicks login button 	
    Then Error message" Please enter your password "


  @loginPage24
  Scenario: verify login button action through keyboard
    Given Admin is on login Page	
    When Admin enter valid credentials  and clicks login button through keyboard	
    Then Admin should land on home page


  @loginPage25
  Scenario: verify login button action through mouse
    Given Admin is on login Page	
    When Admin enter valid credentials  and clicks login button through mouse	
    Then Admin should land on home page
#
