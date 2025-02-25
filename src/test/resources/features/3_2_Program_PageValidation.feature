@ProgramFeature2
Feature: Manage Program Page validation
  @tag:2_1
  Scenario: Verify heading in manage program
    Given Admin is on home page after Login
    #When Admin clicks <Program> on the navigation bar
    Then Admin should see the heading as "Manage Program"
  @tag:2_2  
	Scenario Outline:  Verify column header name of data table
    Then Admin Should see the data table with column header names "<colHeaderName>" at "<postition>"
    Examples: 
      | colHeaderName       | postition |
			| Program Name        | 2         |
			| Program Description | 3         |
			| Program Status      | 4         |
			| Edit / Delete       | 5         |
	@tag:2_3 
	Scenario: Verify the Multiple Delete button state 
  	Then Admin should see a Delete button in left top is disabled
  	@tag:2_4
  	Scenario: Verify the Search button 
  Then Admin should see Search bar with text as "Search..."
  @tag:2_5 
  Scenario: Verify checkbox default state beside Program Name column header
  Then Admin should see checkbox default state as unchecked beside Program Name column header 
  @tag:2_6 
  Scenario: Verify Sort icon in manage program
  Then Admin should see the sort arrow icon beside to each column header except Edit and Delete 
  @tag:2_7 
  Scenario: Verify edit and delete icon in manage program
  Then Admin should see the Edit and Delete buttons on each row of the data table
  @tag:2_8 
  Scenario: Verify pagination icons below data table in manage program
  Then Admin should see the text as "Showing x to y of z entries" along with Pagination icon below the table.
  #(x- starting record number on that page y-ending record number on that page z-Total number of records)
  @tag:2_9 
  Scenario: Verify footer message in manage program
  Then Admin should see the footer as "In total there are z programs." z- Total number of records"