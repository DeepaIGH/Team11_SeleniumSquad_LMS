package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import driverFactory.DriverFactory;
import io.cucumber.java.en.Then;
import pages.ProgramPageValidation;
import utils.LoggerLoad;

public class ProgramPageValidSteps {
	public WebDriver driver = DriverFactory.getdriver();
	ProgramPageValidation prgmValidObj = new ProgramPageValidation(driver);
	@Then("Admin should see the heading as {string}")
	public void admin_should_see_the_heading_as(String expectedHeading) {
		String actualHeading =prgmValidObj.getheading();
		Assert.assertEquals(actualHeading,expectedHeading);
		LoggerLoad.info("Admin see the heading as Manage program");
	}
	@Then("Admin should see a Delete button in left top is disabled")
	public void admin_should_see_a_delete_button_in_left_top_is_disabled() {
		Boolean delBtnPresent = prgmValidObj.ValidateDeleteBtn();
		Assert.assertTrue(delBtnPresent);
		LoggerLoad.info("Admin see a Delete button in left top is disabled");
	}
	@Then("Admin Should see the data table with column header names {string} at {string}")
	public void admin_should_see_the_data_table_with_column_header_names_at(String colHeader, String position) {
		String actualHeader= prgmValidObj.validateColHeadernamesinOrder(colHeader,position);
		Assert.assertEquals(actualHeader, colHeader);
		LoggerLoad.info("Admin see the data table with column header names");
	}
	@Then("Admin should see Search bar with text as {string}")
	public void admin_should_see_search_bar_with_text_as(String expsearchBar) {
		//prgmValidObj.validateSearchBar();
		Assert.assertEquals(prgmValidObj.validateSearchBar(), expsearchBar);
		LoggerLoad.info("Admin see Search bar with text as search..");
	}
	@Then("Admin should see checkbox default state as unchecked beside Program Name column header")
	public void admin_should_see_checkbox_default_state_as_unchecked_beside_program_name_column_header() {
		Assert.assertTrue(prgmValidObj.validateCheckBox());
		LoggerLoad.info("Admin see the checkbox default state as unchecked beside Program Name column header");
	}
	@Then("Admin should see the sort arrow icon beside to each column header except Edit and Delete")
	public void admin_should_see_the_sort_arrow_icon_beside_to_each_column_header_except_edit_and_delete() {
		Assert.assertTrue(prgmValidObj.validateSortIcons());
		LoggerLoad.info("Admin see the sort arrow icon beside to each column header except Edit and Delete");
	}
	@Then("Admin should see the Edit and Delete buttons on each row of the data table")
	public void admin_should_see_the_edit_and_delete_buttons_on_each_row_of_the_data_table() {
		Assert.assertTrue(prgmValidObj.validateEditDelIcons());
		LoggerLoad.info("Admin see the Edit and Delete buttons on each row of the data table");
	}
	@Then("Admin should see the text as {string} along with Pagination icon below the table.")
	public void admin_should_see_the_text_as_along_with_pagination_icon_below_the_table(String ExpecPaginationText) throws InterruptedException {
		prgmValidObj.validatePaginationTextandIcons();
		LoggerLoad.info("Admin see he text along with Pagination icon below the table");
	}
	@Then("Admin should see the footer as {string} z- Total number of records\"")
	public void admin_should_see_the_footer_as_z_total_number_of_records(String ExpecFooter) {
		Assert.assertEquals(prgmValidObj.getTotalProgramCountFromFooter(),ExpecFooter);
		LoggerLoad.info("Admin see the footer string");
	}
}
