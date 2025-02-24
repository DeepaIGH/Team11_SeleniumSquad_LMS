package stepDefinitions;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pages.ProgramPagePart2;
public class SortingProgram {

	public ProgramPagePart2 pp = new ProgramPagePart2();

	@When("Admin clicks on Arrow next to program Name")
	public void admin_clicks_on_arrow_next_to_program_name() {
		pp.clickElement(pp.ProgramNameHeaderIcon);

		System.out.println("Inside Step-Admin clicks on Arrow next to program Name");
	}

	@Then("Admin See the Program Name is sorted in {string} order")
	public void admin_see_the_program_name_is_sorted_in_ascending_order_descending_order(String sortType) {
		if(sortType.equals("Ascending")) {
			Assert.assertTrue(pp.getAttributeForElement(pp.ProgramNameHeaderIcon, "class").contains("pi-sort-amount-up-alt"));
		}
		else if (sortType.equals("Descending")) {
			Assert.assertTrue(pp.getAttributeForElement(pp.ProgramNameHeaderIcon, "class").contains("pi-sort-amount-down"));
		}

		System.out.println("Inside Step-Admin See the Program Name is sorted in Ascending order\\/Descending order");
	}

	@When("Admin clicks on Arrow next to Program Description")
	public void admin_clicks_on_arrow_next_to_program_description() {
		pp.clickElement(pp.programDescriptionHeader);

		System.out.println("Inside Step-Admin clicks on Arrow next to Program Description");
	}

	@Then("Admin See the program Description is sorted in {string} order")
	public void admin_see_the_program_description_is_sortedin_ascending_order_descending_order(String sortType) {
		if(sortType.equals("Ascending")) {
			Assert.assertTrue(pp.getAttributeForElement(pp.programDescriptionHeaderIcon, "class").contains("pi-sort-amount-up-alt"));
		}
		else if (sortType.equals("Descending")) {
			Assert.assertTrue(pp.getAttributeForElement(pp.programDescriptionHeaderIcon, "class").contains("pi-sort-amount-down"));
		} 
		System.out.println("Inside Step-Admin See the program Description is sortedin Ascending order\\\\/Descending order");
	}

	@When("Admin clicks on Arrow next to Program status")
	public void admin_clicks_on_arrow_next_to_program_status() {
		pp.clickElement(pp.programStatusHeader);

		System.out.println("Inside Step-Admin clicks on Arrow next to Program status");
	}

	@Then("Use See the  Program Status is sorted in {string} order")
	public void use_see_the_program_status_is_sorted_in_ascending_order_descending_order(String sortType) {
		if(sortType.equals("Ascending")) {

			Assert.assertTrue(pp.getAttributeForElement(pp.programStatusHeaderIcon, "class").contains("pi-sort-amount-up-alt"));
		}
		else if (sortType.equals("Descending")) {
			Assert.assertTrue(pp.getAttributeForElement(pp.programStatusHeaderIcon, "class").contains("pi-sort-amount-down"));
		} 
		System.out.println("Inside Step-Use See the  Program Status is sorted in Ascending order\\\\/Descending order");
	}





}