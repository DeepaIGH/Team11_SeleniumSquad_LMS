package stepDefinitions;
import org.testng.Assert;

import driverFactory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ProgramPagePart2;
import pages.TestLoginPage;


public class DeleteProgramStep {
	TestLoginPage tl = new TestLoginPage();
	public ProgramPagePart2 pp = new ProgramPagePart2();
	

	@Given("Admin is on program page after reaching home")
	public void admin_is_on_program_page_after_reaching_home() throws InterruptedException {
		//tl.openUrl();
		tl.loginUsingValues("sdetnumpyninja@gmail.com", "Feb@2025");
		pp.clickOnProgramPageLink();		
		System.out.println("Inside Step-Admin is on program page after reaching home");
	}

	@Given("Admin is on Program page")
	public void admin_is_on_program_page() {
		Assert.assertTrue(pp.validateElementDisplayed(pp.programPageTitle));
		Assert.assertEquals(pp.getTextForElement(pp.programPageTitle), "Manage Program");
		System.out.println("Inside Step-Admin is on Program page");
	}
	
	@Given("Create a program {string} on program page")
	public void create_program_on_program_page(String programName) throws InterruptedException {
		pp.createProgram(programName);
		System.out.println("Create program on program page");
	}

	@When("Admin clicks on delete button for a program")
	public void admin_clicks_on_delete_button_for_a_program() {
		pp.clickElement(pp.deleteButtons);
		System.out.println("Inside Step-Admin clicks on delete button for a program");
	}
	
	@When("Admin search the program {string} and clicks on delete button for a program")
	public void search_the_program_and_click_on_delete_button(String programName) {
		pp.searchProgram(programName);
		pp.clickElement(pp.deleteButtons);
	}

	@Then("Admin will get confirm deletion popup")
	public void admin_will_get_confirm_deletion_popup() {
		Assert.assertTrue(pp.validateElementDisplayed(pp.confirmationDialogBox));
		Assert.assertTrue(pp.validateElementDisplayed(pp.deleteModelInfoIcon));
		Assert.assertEquals(pp.getTextForElement(pp.dialogBoxTitle),"Confirm");
		// Assert.assertEquals(pp.getTextForElement(pp.dialogwarningMessage),"Are you sure you want to delete PhythonPlayWright");
		System.out.println("Inside Step-Admin will get confirm deletion popup");
	}

	@Given("Admin is on Confirm deletion form for {string}")
	public void admin_is_on_confirm_deletion_form_for_givenName(String programName) throws InterruptedException {
		Thread.sleep(1000);
		pp.searchProgram(programName);
		Thread.sleep(1000);
		pp.clickElement(pp.deleteButtons);
		Thread.sleep(1000);
		Assert.assertTrue(pp.validateElementDisplayed(pp.confirmationDialogBox));
		Assert.assertTrue(pp.validateElementDisplayed(pp.deleteModelInfoIcon));
		Assert.assertEquals(pp.getTextForElement(pp.dialogBoxTitle),"Confirm");
		// Assert.assertEquals(pp.getTextForElement(pp.dialogwarningMessage),"Are you sure you want to delete PhythonPlayWright");
		System.out.println("Inside Step-Admin is on Confirm deletion form");
	}

	@When("Admin clicks on {string} button")
	public void admin_clicks_on_button(String string) {

		if(string.equals("Yes")) {
			System.out.println("Into Yes");
			pp.clickElement(pp.dialogBoxYesButton);
		}
		else if(string.equals("No")) {
			pp.clickElement(pp.dialogBoxNoButton);
		}
		else if(string.equals("X")) {
			pp.clickElement(pp.dialogBoxclose);
		}
		else {
			System.err.println("Button name is not defined " + string);
		}
		System.out.println("Inside Step-Admin clicks on {string} button");
	}

	@Then("Admin can see {string} message")
	public void admin_can_see_message(String string) {
		Assert.assertTrue(pp.validateElementDisplayed(pp.successAlert));
		System.out.println("Inside Step-Admin can see {string} message");
	}

	@When("Admin Searches for {string}")
	public void admin_searches_for(String programName) {
		pp.searchProgram(programName);
		System.out.println("Inside Step-Admin Searches for {string}");
	}

	@Then("There should be zero results.")
	public void there_should_be_zero_results() throws InterruptedException {
		Thread.sleep(1000);
		Assert.assertFalse(pp.validateElementDisplayed(pp.programTableRows));
		Assert.assertEquals(pp.getTextForElement(pp.currentDisplayedCount),"Showing 0 to 0 of 0 entries"); 
		System.out.println("Inside Step-There should be zero results.");
	}

	@Given("Admin is on Program Confirm Deletion Page after selecting a program to delete")
	public void admin_is_on_program_confirm_deletion_page_after_selecting_a_program_to_delete() throws InterruptedException {
		pp.clickElement(pp.deleteButtons);
		Thread.sleep(1000);
		Assert.assertTrue(pp.validateElementDisplayed(pp.confirmationDialogBox));
		Assert.assertTrue(pp.validateElementDisplayed(pp.deleteModelInfoIcon));
		Assert.assertEquals(pp.getTextForElement(pp.dialogBoxTitle),"Confirm");
		System.out.println("Inside Step-Admin is on Program Confirm Deletion Page after selecting a program to delete");
	}

	@Then("Admin can see Confirmation form disappears")
	public void admin_can_see_confirmation_form_disappears() {
		Assert.assertFalse(pp.validateElementDisplayed(pp.successAlert));
		System.out.println("Inside Step-Admin can see Confirmation form disappears");
	}

}