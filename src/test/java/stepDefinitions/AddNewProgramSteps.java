package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import driverFactory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AddNewProgramPage;
import pages.ProgramNavigPage;
import utils.ConfigReader;
import utils.LoggerLoad;

public class AddNewProgramSteps {
	public WebDriver driver = DriverFactory.getdriver();
	AddNewProgramPage addNewProgramObj = new AddNewProgramPage(driver);
	ProgramNavigPage programobj = new ProgramNavigPage(driver);//calls the constr in ProgramPageNavi
	

	@When("Admin clicks on <Add New Program> under the <Program> menu bar")
	public void admin_clicks_on_add_new_program_under_the_program_menu_bar() {
		addNewProgramObj.clickaddNewBtn();
		LoggerLoad.info("Admin clicks on <Add New Program>");
	}

	@Then("Admin should see pop up window for program details")
	public void admin_should_see_pop_up_window_for_program_details() {
		Assert.assertTrue(addNewProgramObj.isPopupWndwDisplayed());
		LoggerLoad.info("Admin should see pop up window for program details");
	}
	
	@Then("Admin should see red asterik mark  beside <mandatory fields> Name Description status")
	public void admin_should_see_red_asterik_mark_beside_mandatory_fields_name_description_status() {
		Assert.assertTrue(addNewProgramObj.validateAsterikMark());
		LoggerLoad.info("Admin should see red asterik mark  beside <mandatory fields>");
	}
	@When("Admin clicks save button without entering mandatory")
	public void admin_clicks_save_button_without_entering_mandatory() {
		addNewProgramObj.clickSaveBtn();
		LoggerLoad.info("Admin clicks save button without entering mandatory");
	}
	@Then("Admin gets message <field> is required")
	public void admin_gets_message_field_is_required() {
		Assert.assertTrue(addNewProgramObj.validateFieldsRequired());
		LoggerLoad.info("Admin gets message <field> is required");
	}
	@When("Admin enters the Name in the text box")
	public void admin_enters_the_name_in_the_text_box() throws Exception {
		addNewProgramObj.enterNameinTxtBox();
		LoggerLoad.info("Admin enters the Name in the text box");
	}
	@Then("Admin can see the text entered in name text box")
	public void admin_can_see_the_text_entered_in_name_text_box() throws Exception {
		Assert.assertTrue(addNewProgramObj.verifyEnteredPrgmName());
		LoggerLoad.info("Admin can see the text entered in name text box");
	}
	@When("Admin enters the Description in the text box")
	public void admin_enters_the_description_in_the_text_box() throws Exception {
		addNewProgramObj.enterDescipinTxtBox();
		LoggerLoad.info("Admin enters the Description in the text box");
	}
	@Then("Admin can see the text entered Description in text box")
	public void admin_can_see_the_text_entered_description_in_text_box() throws Exception {
		Assert.assertTrue(addNewProgramObj.verifyEnteredDescripName());
		LoggerLoad.info("Admin can see the text entered Description in text box");
	}
	@When("Admin clicks Cancel button")
	public void admin_clicks_cancel_button() throws InterruptedException {
		addNewProgramObj.clickCancelBtn();
		LoggerLoad.info("Admin clicks Cancel button");
		}
	@Then("Admin can see Program Details form disappear")
	public void admin_can_see_program_details_form_disappear() {
		//Assert.assertFalse(addNewProgramObj.isPopupWndwDisplayed());
		String programpageUrl = programobj.getCurrentUrl();
		Assert.assertEquals(programpageUrl, ConfigReader.getManageProgramUrl());
		LoggerLoad.info("Admin can see Program Details form disappear");
	}
	@Given("Admin is on program details form")
	public void admin_is_on_program_details_form()  {
		programobj.clickProgramButton();
		addNewProgramObj.clickaddNewBtn();
		LoggerLoad.info("Admin is on program details form");
	}
	@When("Admin Click on close\\(X) button")
	public void admin_click_on_close_x_button() {
		addNewProgramObj.clickCloseBtn();
		LoggerLoad.info("Admin Click on close button");
	}
	@When("Admin enter valid details for mandatory fields from excel {string} and {int} and Clicks on Save button")
	public void admin_enter_valid_details_for_mandatory_fields_from_excel_and_and_clicks_on_save_button(String sheetname, Integer rownumber) throws Exception {
		addNewProgramObj.enterProgramDetails(sheetname,rownumber);
		LoggerLoad.info("Admin valid details for mandatory fields from excel");
	}
	@Then("Admin gets message {string}")
	public void admin_gets_message(String expecSuccessMsg) {
		//Assert.assertEquals(actualMsg, expecSuccessMsg);
	}
}
