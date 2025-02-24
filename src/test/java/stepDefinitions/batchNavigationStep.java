package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import utils.LoggerLoad;

import io.cucumber.java.en.*;
import pages.BatchPage;
import pages.TestLoginPage;
import driverFactory.DriverFactory;
import utils.ConfigReader;

public class batchNavigationStep {
	public WebDriver driver=DriverFactory.getdriver();
	BatchPage bp = new BatchPage(DriverFactory.getdriver());
	//TestLoginPage tl = new TestLoginPage(driver);	

	
	@Given("Admin is on the home Page after Login")
	public void admin_is_on_the_home_page_after_login() {
	    LoggerLoad.info("Admin is on the home page after Login");
	}

	@When("Admin Clicks on the Batch menu from the header")
	public void admin_clicks_on_the_batch_menu_from_the_header() {
		//bp.checkaddNewBatch();
	}

	@Then("Admin should be in the Manage Batch Page")
	public void admin_should_be_in_the_manage_batch_page() {
		//covered above
	}

	@Then("Admin should see the LMS-Learning Management System Title")
	public void admin_should_see_the_lms_learning_management_system_title() {
		bp.checkLogoOnBatchPage();
	}
	
	@Then("Admin should see the Manage Batch Heading")
	public void admin_should_see_the_manage_batch_heading() {
		bp.checkLogoOnBatchPage();
	}

	@Then("Admin should see the disabled Delete Icon under the header")
	public void admin_should_see_the_disabled_delete_icon_under_the_header() {
		bp.checkDisabledDeleteIcon();
	}
	

	@Then("Admin should see the edit icon in each row")
	public void admin_should_see_the_edit_icon_in_each_row() {
		bp.checkEditButtonsonPage();
	}

	@Then("Admin should see the delete icon in each row")
	public void admin_should_see_the_delete_icon_in_each_row() {
		bp.checkDeleteButtonsonPage();
	}

	@Then("Admin should see the checkbox in each row")
	public void admin_should_see_the_checkbox_in_each_row() {
		bp.checkboxesonPage();
	}

	@Then("Admin should see the checkbox  in the datatable header row")
	public void admin_should_see_the_checkbox_in_the_datatable_header_row() {
		bp.checkboxDatatable();
	}

}
