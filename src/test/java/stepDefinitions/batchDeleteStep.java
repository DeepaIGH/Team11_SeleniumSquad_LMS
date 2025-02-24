package stepDefinitions;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import utils.LoggerLoad;

import io.cucumber.java.en.*;
import pages.BatchPage;
import pages.TestLoginPage;
import driverFactory.DriverFactory;
import utils.ConfigReader;

public class batchDeleteStep {

	@Given("Admin is on the Batch home page")
	public void admin_is_on_the_batch_home_page() {
	    
	}

	@When("Admin clicks the delete Icon on any row")
	public void admin_clicks_the_delete_icon_on_any_row() {
	    
	}

	@Then("Admin should see the confirm alert box with yes and no button")
	public void admin_should_see_the_confirm_alert_box_with_yes_and_no_button() {
	    
	}

	@When("Admin clicks on the delete icon and click yes buttton")
	public void admin_clicks_on_the_delete_icon_and_click_yes_buttton() {
	    
	}

	@Then("Admin should see the successfull message and the batch should be deleted")
	public void admin_should_see_the_successfull_message_and_the_batch_should_be_deleted() {
	   
	}

	@When("Admin clicks on the delete icon and click no button")
	public void admin_clicks_on_the_delete_icon_and_click_no_button() {
	    
	}

	@Then("Admin should see the alert box closed and the batch is not deleted")
	public void admin_should_see_the_alert_box_closed_and_the_batch_is_not_deleted() {
	   
	}

	@Then("Admin should see the alert box closed")
	public void admin_should_see_the_alert_box_closed() {
	    
	}

	@When("Admin clicks on the delete icon under the Manage batch header")
	public void admin_clicks_on_the_delete_icon_under_the_manage_batch_header() {
	    
	}

	@Then("The respective row in the table should be deleted")
	public void the_respective_row_in_the_table_should_be_deleted() {
	   
	}

}
