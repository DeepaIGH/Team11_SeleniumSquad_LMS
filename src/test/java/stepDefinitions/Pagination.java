package stepDefinitions;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ProgramPagePart2;
public class Pagination {

	public ProgramPagePart2 pp = new ProgramPagePart2();

	@When("Admin clicks Next page link on the program table")
	public void admin_clicks_next_page_link_on_the_program_table() {
		pp.clickElement(pp.nextPageButton);
		System.out.println("Inside Step-Admin clicks Next page link on the program table"); 
	}

	@Then("Admin should see the Pagination has {string} active link")
	public void admin_should_see_the_pagination_has_active_link(String pageNumber) {
		Assert.assertEquals(pp.getTextForElement(pp.activePageNumberButton), pageNumber);
		System.out.println("Inside Step-Admin should see the Pagination has {string} active link"); 
	}

	@When("Admin clicks Last page link")
	public void admin_clicks_last_page_link() {
		pp.clickElement(pp.lastPageButton);
		System.out.println("Inside Step-Admin clicks Last page link"); 
	}

	@Then("Admin should see the last page record on the table with Next page link are disabled")
	public void admin_should_see_the_last_page_record_on_the_table_with_next_page_link_are_disabled() throws InterruptedException {
		Thread.sleep(1000);
		Assert.assertTrue(pp.getAttributeForElement(pp.nextPageButton, "class").contains("p-disabled"));
		Assert.assertTrue(pp.getAttributeForElement(pp.lastPageButton, "class").contains("p-disabled"));
		System.out.println("Inside Step-Admin should see the last page record on the table with Next page link are disabled"); 
	}

	@Given("Admin is on last page of Program page table")
	public void admin_is_on_last_page_of_program_page_table() throws InterruptedException {
		pp.clickElement(pp.lastPageButton);
		Thread.sleep(1000);
		String lastPageNumber = pp.getLastPageNumber();
		Assert.assertEquals(pp.getTextForElement(pp.activePageNumberButton), lastPageNumber);
		System.out.println("Inside Step-Admin is on last page of Program page table"); 
	}

	@When("Admin clicks Previous page link")
	public void admin_clicks_previous_page_link() throws InterruptedException {
		pp.clickElement(pp.nextPageButton);
		Thread.sleep(1000);
		pp.clickElement(pp.prevPageButton);
		System.out.println("Inside Step-Admin clicks Previous page link"); 
	}

	@Then("Admin should see the previous page record on the table with pagination has previous page link")
	public void admin_should_see_the_previous_page_record_on_the_table_with_pagination_has_previous_page_link() {
		Assert.assertEquals(pp.getTextForElement(pp.activePageNumberButton), 1);
		System.out.println("Inside Step-Admin should see the previous page record on the table with pagination has previous page link"); 
	}

	@When("Admin clicks First page link")
	public void admin_clicks_first_page_link() throws InterruptedException {
		pp.clickElement(pp.nextPageButton);
		Thread.sleep(1000);
		pp.clickElement(pp.firstPageButton);
		System.out.println("Inside Step-Admin clicks First page link"); 
	}

	@Then("Admin should see the very first page record on the table with Previous page link are disabled")
	public void admin_should_see_the_very_first_page_record_on_the_table_with_previous_page_link_are_disabled() {
		Assert.assertEquals(pp.getTextForElement(pp.activePageNumberButton), 1);
		Assert.assertTrue(pp.getAttributeForElement(pp.prevPageButton, "class").contains("p-disabled"));
		Assert.assertTrue(pp.getAttributeForElement(pp.firstPageButton, "class").contains("p-disabled"));
		System.out.println("Inside Step-Admin should see the very first page record on the table with Previous page link are disabled"); 
	}


}