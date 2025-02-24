@ProgramFeature1
Feature: Navigation to Program page and Menu Bar Validations
Background: Admin gives the correct LMS portal URL

  @tag:1_1
  Scenario: Verify that Admin is able to navigate to Program page
    Given Admin is on home page after Login
    When Admin clicks <Program> on the navigation bar
    Then Admin should be navigated to Program page
      @tag:1_2
  Scenario: Verify Logout displayed in menu bar
    Then Admin should see Logout in menu bar
      @tag:1_3
	Scenario:Verify heading in menu bar
		Then Admin should see the heading "LMS - Learning Management System"
  #Scenario: Verify other pages name displayed in menu bar
  #	Then Admin should see the page names as in order "Home Program Batch Class Logout"
    @tag:1_3
  Scenario Outline:  Verify other pages name displayed in menu bar
    Then Admin Should see the page names in order "<ButtonIds>" in "<order>"
    Examples: 
      | ButtonIds  | order |
			| Home       | 1     |
			| Program    | 2     |
			| Batch      | 3     |
			| Class      | 4     |
			| Logout     | 5     |
		  @tag:1_4
			
  Scenario: Verify sub menu displayed in program menu bar
  	Then Admin should see sub menu in menu bar as "Add New Program"
  	