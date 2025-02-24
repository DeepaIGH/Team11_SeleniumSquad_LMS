package stepDefinitions;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ProgramPagePart2;

public class Searchbar {
	public ProgramPagePart2 pp = new ProgramPagePart2();

	@When("Admin enter the program to search By program name {string}")
	public void admin_enter_the_program_to_search_by_program_name(String searchString) {
		pp.searchProgram(searchString);

		System.out.println("Inside Step-Admin enter the program to search By program name");
	}

	@Then("Admin should able to see Program name, description, and status for searched program name {string}")
	public void admin_should_able_to_see_program_name_description_and_status_for_searched_program_name(String searchString) {
		Assert.assertTrue(pp.getTextForElement(pp.programNameCells).contains(searchString));
		System.out.println("Inside Step-Admin should able to see Program name, description, and status for searched program name");
	}

	@When("Admin enter the program to search By program description {string}")
	public void admin_enter_the_program_to_search_by_program_description(String searchString) {
		pp.searchProgram(searchString);
		System.out.println("Inside Step-Admin enter the program to search By program description");
	}

	@Then("Admin should able to see Program name, description, and status for searched program description {string}")
	public void admin_should_able_to_see_program_name_description_and_status_for_searched_program_description(String searchString) {
		Assert.assertTrue(pp.getTextForElement(pp.programDescriptionCells).contains(searchString));
		System.out.println("Inside Step-Admin should able to see Program name, description, and status for searched program description");
	}

	@When("Admin enter the program to search By program name that does not exist {string}")
	public void admin_enter_the_program_to_search_by_program_name_that_does_not_exist(String searchString) {
		pp.searchProgram("XYZ");
		System.out.println("Inside Step-Admin enter the program to search By program namethat does not exist");
	}

	@When("Admin enter the program to search By partial name of program {string}")
	public void admin_enter_the_program_to_search_by_partial_name_of_program(String searchString) {
		pp.searchProgram(searchString);
		System.out.println("Inside Step-Admin enter the program to search By partial name of program");
	}

}

