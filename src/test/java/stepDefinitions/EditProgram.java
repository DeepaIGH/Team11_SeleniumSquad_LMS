package stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ProgramPagePart2;

public class EditProgram {
	public ProgramPagePart2 pp = new ProgramPagePart2();

	@When("Admin search the program {string} and clicks on edit button for a program")
	public void admin_search_the_program_and_clicks_on_edit_button_for_a_program(String programName) {
		pp.searchProgram(programName);
		pp.clickElement(pp.editProgramButton);
	}

	@Then("Admin lands on Program details form")
	public void admin_lands_on_program_details_form() {
		Assert.assertTrue(pp.validateElementDisplayed(pp.editProgramDialog));
		Assert.assertEquals(pp.getTextForElement(pp.dialogBoxTitle),"Program Details");
	}

	@Then("Admin should see window title as {string}")
	public void admin_should_see_window_title_as(String programDetails) {
		Assert.assertEquals(pp.getTextForElement(pp.dialogBoxTitle),"Program Details");
	}

	@Then("Admin should see red asterisk mark beside mandatory fields")
	public void admin_should_see_red_asterisk_mark_beside_mandatory_field(String string) {
		Assert.assertEquals(pp.getTextForElement(pp.astrickForNameField),"*");
		Assert.assertEquals(pp.getTextForElement(pp.astrickForDescriptionField),"*");
		Assert.assertEquals(pp.getTextForElement(pp.astrickForStatusField),"*");
		Assert.assertEquals(pp.getAttributeForElement(pp.astrickForNameField, "style"), "color: red !important;");
		Assert.assertEquals(pp.getAttributeForElement(pp.astrickForDescriptionField, "style"), "color: red !important;");
		Assert.assertEquals(pp.getAttributeForElement(pp.astrickForStatusField, "style"), "color: red !important;");
	}

	@Given("Admin is on Program page and open a edit modal for {string}")
	public void admin_is_on_program_page_and_open_a_edit_modal_for(String programName) {
		pp.searchProgram(programName);
		pp.clickElement(pp.editProgramButton);
	}

	@When("Admin edits the description text {string} and click on save button")
	public void admin_edits_the_description_text_and_click_on_save_button(String programName) {
		pp.updateProgramDescription(programName);
	}

	@Then("Admin can see the description is updated to {string}")
	public void admin_can_see_the_description_is_updated(String updatedName) {
		Assert.assertEquals(pp.getTextForElement(pp.programDescriptionCells), updatedName + " descripton updated");
	}

	@When("Admin can change the status of the program and click on save button Status")
	public void admin_can_change_the_status_of_the_program_and_click_on_save_button_status() {
		pp.clickElementByPosition(pp.editRadioButtons, 2);
	}

	@Then("updated can be viewed by the Admin {string}")
	public void updated_can_be_viewed_by_the_admin(String statusValue) {
		Assert.assertEquals(pp.getTextForElement(pp.programStatusCells), statusValue );
	}

	@When("Admin click on save button")
	public void admin_click_on_save_button() {
		pp.clickElement(pp.saveButtonOnEditDialog);
	}

	@Then("Admin can see the updated program details {string}")
	public void admin_can_see_the_updated_program_details(String programName) {
		Assert.assertEquals(pp.getTextForElement(pp.programNameCells), programName);
		Assert.assertEquals(pp.getTextForElement(pp.programDescriptionCells), programName + " descripton updated");
	}

	@When("Admin click on cancel button")
	public void admin_click_on_cancel_button() {
		pp.clickElement(pp.cancelButtononEditDialog);
	}

	@Then("Admin can see the Program details form disappears")
	public void admin_can_see_the_program_details_form_disappears() {
		Assert.assertFalse(pp.validateElementDisplayed(pp.editProgramDialog));
	}

	@When("Admin Click on X button")
	public void admin_click_on_button(String string) {
		pp.clickElement(pp.dialogBoxclose);
	}

	@Then("Admin can see program details form disappear")
	public void admin_can_see_program_details_form_disappear() {
		Assert.assertFalse(pp.validateElementDisplayed(pp.editProgramDialog));
	}

	@When("Admin edits the program name to {string} and click on save button")
	public void admin_edits_the_program_name_to_and_click_on_save_button(String programName) {
		pp.updateProgramName(programName);
	}

	@Then("Updated program name {string} is seen by the Admin")
	public void updated_program_name_is_seen_by_the_admin(String programName) {
		Assert.assertEquals(pp.getTextForElement(pp.programNameCells), programName + " updated");
	}

	@When("Admin searches with newly updated {string}")
	public void admin_searches_with_newly_updated(String programName) {
		pp.searchProgram(programName + " updated");
	}

	@Then("Admin verifies that the details are correctly updated to {string}")
	public void admin_verifies_that_the_details_are_correctly_updated(String programName) {
		Assert.assertEquals(pp.getTextForElement(pp.programNameCells), programName + " updated");
	}



}
