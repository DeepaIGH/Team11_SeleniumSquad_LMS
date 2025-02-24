package stepDefinitions;

import java.util.Arrays;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import driverFactory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.TestClassPage;
import utils.Helper;


public class testClassStep {
	
	public WebDriver driver= DriverFactory.getdriver();
	TestClassPage testclasspage  = new TestClassPage(driver);
	

	@When("Admin clicks the Class Navigation bar in the Header class page")
	public void admin_clicks_the_class_navigation_bar_in_the_header_class_page() {
	testclasspage.btnClass();
	    
	}
	@Then("Admin should see the {string} Title for ClassPage")
	public void admin_should_see_the_title_for_class_page(String string) {
		String actualTitle = testclasspage.getManageClassTitle();
		String expectedTitle = "LMS - Learning Management System";
	    Assert.assertEquals( expectedTitle, actualTitle);
			
	}
	
	@When("Admin is on the Manage class page of class page")
	public void admin_is_on_the_manage_class_page_of_class_page() {
		String actualText = testclasspage.mngClassTxt();
	     String expectedText = "Manage Class";
	    Assert.assertEquals( expectedText, actualText);
	    
	}

	@Then("Admin should land on the Manage class page")
	public void admin_should_land_on_the_manage_class_page() {
	    String actualText = testclasspage.mngClassTxt();
	     String expectedText = "Manage Class";
	    Assert.assertEquals( expectedText, actualText);
	}
	
	
    @Then("Admin should see the {string} Header")
    public void admin_should_see_the_header(String string) {
	 String actualText = testclasspage.mngClassTxt();
    String expectedText = "Manage Class";
   Assert.assertEquals( expectedText, actualText);
	}

	@Then("Admin should see the Search Bar in Manage class page")
	public void admin_should_see_the_search_bar_in_manage_class_page() {
		Assert.assertTrue(testclasspage.classSearchbarField());
	    
	}
	@Then("Admin should see the datatable heading like Batchname, class topic, class description, status, class Date, staff name, Edit\\/Delete")
	public void admin_should_see_the_datatable_heading_like_batchname_class_topic_class_description_status_class_date_staff_name_edit_delete() {  
		
		List<String> expectedHeaders = Arrays.asList(
			    "batch name",  
			    "class topic", 
			    "class description", 
			    "status", 
			    "class date", 
			    "staff name", 
			    "edit/delete"  // Ensuring correct format
			);

			List<String> actualHeaders = testclasspage.getActualClassColumnHeaders();			

			// Assertion
//			Assert.assertEquals(normalizedActualHeaders, normalizedExpectedHeaders, "Class column headers do not match!");
	}


	@Then("Admin should see the {string} and enabled pagination controls under the data table classpage")
	public void admin_should_see_the_and_enabled_pagination_controls_under_the_data_table_classpage(String string) {
		Assert.assertTrue(testclasspage.isClassPaginatorTextVisibleOrNot());
	}
	@Then("Admin should see the Sort icon of all the field in the datatable class page")
	public void admin_should_see_the_sort_icon_of_all_the_field_in_the_datatable_class_page() {
		Assert.assertTrue(testclasspage.isSortIconPresentInHeadersClasspage());
	}
	    
	

	@Then("Admin should see the Delete button under the Manage class page header.")
	public void admin_should_see_the_delete_button_under_the_manage_class_page_header() {
		Assert.assertTrue(testclasspage.isClassPageDeleteIconIsDisplyed());
	    
	}
	@Then("Admin should see Total no of classes in below of the data table.")
	public void admin_should_see_total_no_of_classes_in_below_of_the_data_table() {
		Assert.assertTrue(testclasspage.isClassPageTotalEntryIconIsDisplyed());
	    
	}
	@When("Admin clicks add new class under the class menu bar.")
	public void admin_clicks_add_new_class_under_the_class_menu_bar() {
		testclasspage.getClickOnAddNewBtn();
	}
	@Then("Admin should see a popup open for class Page details with empty form along with <SAVE> and <CANCEL> button and Close\\(X) Icon on the top right corner of the window")
	public void admin_should_see_a_popup_open_for_class_page_details_with_empty_form_along_with_save_and_cancel_button_and_close_x_icon_on_the_top_right_corner_of_the_window() {
	    
		boolean elementsDisplayed = Helper.areElementsDisplayed(testclasspage.getPopup(),testclasspage.getSaveButton(),testclasspage.getCancelButton(),testclasspage.getCloseButton());
		  Assert.assertTrue(elementsDisplayed,"***Popup and Save,Cancel,Close Buttons are displayed***");
		  Assert.assertTrue(testclasspage.arePopupFieldsEmpty(), "Some popup fields are not empty");
	}
	
	

	@Then("Admin should see few input fields and their respective text boxes in the class details window")
	public void admin_should_see_few_input_fields_and_their_respective_text_boxes_in_the_class_details_window() {
		Assert.assertTrue(testclasspage.getInputfields().size() > 0, "Input fields are not found");
	}
	
	@Then("Admin is redirected to class page")
	public void admin_is_redirected_to_class_page() {
		String actualText = testclasspage.mngClassTxt();
	     String expectedText = "Manage Class";
	    Assert.assertEquals( expectedText, actualText);
	}

	@When("Admin clicks on any page link on Manage Class page")
	public void admin_clicks_on_any_page_link_on_manage_class_page() {
		
		testclasspage.clickonBatchLink();
	}

	@Then("Admin is redirected to which page link they clicked.")
	public void admin_is_redirected_to_which_page_link_they_clicked() {
		String actualTitle = testclasspage.getManageClassTitle();
		String expectedTitle = "LMS - Learning Management System";
	    Assert.assertEquals( expectedTitle, actualTitle);
	}
	

	@When("Admin clicks on Logout link on Manage class page")
	public void admin_clicks_on_logout_link_on_manage_class_page() {
		testclasspage.classClickOnlogoutBtn();
	}

	@Then("Admin is redirected to Login page")
	public void admin_is_redirected_to_login_page() {
		
	    
	}

	///-------------Search By Text ----------------//

	@When("Admin enter the Batch Name in search textbox of Class apge")
	public void admin_enter_the_batch_name_in_search_textbox_of_class_apge() {
		testclasspage.getSearchbar().clear();		
		 testclasspage.getSearchbar().sendKeys("Micro service-01");
		 
	    
	}
	@Then("Admin should see Class details are searched by Batch Name")
	public void admin_should_see_class_details_are_searched_by_batch_name() {
		int pagecount = testclasspage.getSearchResultsCount();
		  Assert.assertTrue( pagecount>0,"**********Test failed: Expected total records greater than 0 , but got****** " + pagecount);
	}

	@When("Admin enter the Class topic in search textbox of Class apge")
	public void admin_enter_the_class_topic_in_search_textbox_of_class_apge() {
		testclasspage.getSearchbar().clear();		
		 testclasspage.getSearchbar().sendKeys("playwright");
	}

	@Then("Admin should see Class details are searched by Class topic")
	public void admin_should_see_class_details_are_searched_by_class_topic() {
		int pagecount = testclasspage.getSearchResultsCount();
		  Assert.assertTrue( pagecount>0,"**********Test failed: Expected total records greater than 0 , but got****** " + pagecount);
		  testclasspage.getSearchbar().clear();
	}

	@When("Admin enter the Staff Name in search textbox of Class apge")
	public void admin_enter_the_staff_name_in_search_textbox_of_class_apge() {
		testclasspage.getSearchbar().clear();		
		 testclasspage.getSearchbar().sendKeys("Saranya M");
		 
	}

	@Then("Admin should see Class details are searched by Staff name")
	public void admin_should_see_class_details_are_searched_by_staff_name() {
		int pagecount = testclasspage.getSearchResultsCount();
		  Assert.assertTrue( pagecount>0,"**********Test failed: Expected total records greater than 0 , but got****** " + pagecount);testclasspage.btnClass();
		  testclasspage.getSearchbar().clear();
	}
	
	//----------Delete alert-------------/
	@When("Admin clicks any checkbox in the data table class page")
	public void admin_clicks_any_checkbox_in_the_data_table_class_page() {
		testclasspage.getClickOnBatchNameCheckbox();
	}

	@Then("Admin should see common delete option enabled under header Manage class")
	public void admin_should_see_common_delete_option_enabled_under_header_manage_class() {
		testclasspage.getisMultiDeleteEnabled();
	}

	@Given("Admin is on Confirm Deletion alert on Class Page")
	public void admin_is_on_confirm_deletion_alert_on_class_page() {
		testclasspage.btnClass();
		
	}

	@When("Admin clicks <YES> button on the alert Class Page")
	public void admin_clicks_yes_button_on_the_alert_class_page() {
		testclasspage.clickOndeleteBtn();
	}

	@Then("Admin should land on Manage class page and can see the selected class is deleted from the data table")
	public void admin_should_land_on_manage_class_page_and_can_see_the_selected_class_is_deleted_from_the_data_table() {
	    
	}

	@Given("Admin is on Confirm Deletion alert Class Page")
	public void admin_is_on_confirm_deletion_alert_class_page() {
		testclasspage.btnClass();
	}

	@When("Admin clicks <No> button on the alert Class Page")
	public void admin_clicks_no_button_on_the_alert_class_page() {
		testclasspage.clickOndeleteBtn();
	}

	@Then("Admin should land on Manage class page and can see the selected class is not deleted from the data table")
	public void admin_should_land_on_manage_class_page_and_can_see_the_selected_class_is_not_deleted_from_the_data_table() {
		String actualText = testclasspage.mngClassTxt();
	     String expectedText = "Manage Class";
	    Assert.assertEquals( expectedText, actualText);
	}

	@Then("Admin should land on Manage class page and can see the selected class are deleted from the data table")
	public void admin_should_land_on_manage_class_page_and_can_see_the_selected_class_are_deleted_from_the_data_table() {
	    
	}

	@Then("Admin should land on Manage Class page and can see the selected class are not deleted from the data table")
	public void admin_should_land_on_manage_class_page_and_can_see_the_selected_class_are_not_deleted_from_the_data_table() {
	    
	}

//--------------Add new Class----------//
	@Given("Admin is on the Class Popup window")
	public void admin_is_on_the_class_popup_window() throws InterruptedException {
	    
	    testclasspage.btnClass();
	    testclasspage.getClickOnAddNewBtn();
	}

	@When("Admin enters mandatory fields using {string} in the form and clicks on save button")
	public void admin_enters_mandatory_fields_using_in_the_form_and_clicks_on_save_button(String TestCaseName)
			throws InterruptedException {
		testclasspage.getCreateClass(TestCaseName);

	}

	@Then("Admin gets message Class added Successfully")
	public void admin_gets_message_class_added_successfully() {
		Assert.assertTrue(testclasspage.isSuccessMessageDisplayed(), "*****Success message not displayed******");
		
	}
	@When("Admin selects class date in date picker Page class")
	public void admin_selects_class_date_in_date_picker_page_class() {
		testclasspage.getClickOnAddNewBtn();
	}

	@Then("Admin should see no of class value is added automatically on Page popup")
	public void admin_should_see_no_of_class_value_is_added_automatically_on_page_popup() {
	    
	}
	
//--------------Edit Class-------//
	@Given("Admin is on the Manage Class page")
	public void admin_is_on_the_manage_class_page() {
		 testclasspage.btnClass();
	}

	@When("Admin clicks on the edit icon Manage Class")
	public void admin_clicks_on_the_edit_icon_manage_class() {
		  		testclasspage.getClickOnFirstEditIcon();
			}
	

   @Then("A new pop up with class details appears Manage Class")
	public void a_new_pop_up_with_class_details_appears_manage_class() {
Assert.assertTrue(testclasspage.verifyPopUpIsVisible());
      
   		
	}
	
	@Then("Admin should see batch name field is disabled Manage Class")
	public void admin_should_see_batch_name_field_is_disabled_manage_class() {
	    Assert.assertEquals(testclasspage.verifyBatchNamaeFieldIsDiosabled(),true);
	}
	@Then("Admin should see class topic field is disabled")
	public void admin_should_see_class_topic_field_is_disabled() {
		 Assert.assertEquals(testclasspage.verifyClassTopiceFieldIsDisabled(),false);
	}
	
	@Then("User click on Edit Popup and and on Mangae class Page")
	public void user_click_on_edit_popup_and_and_on_mangae_class_page() {
		testclasspage.clickonClassPageLinkDb();
		testclasspage.clickonClassPageLinkClassPG();
		testclasspage.getClickOnFirstEditIcon();
	}


	@When("Update the fields with valid data and click save")
	public void update_the_fields_with_valid_data_and_click_save() {
		
		testclasspage.updateEditopopup();
		testclasspage.clickonSaveBtn();
	    
	}

	@Then("Admin gets message {string} and see the updated values in data tableAdmin should see batch name field is disabled")
	public void admin_gets_message_and_see_the_updated_values_in_data_table_admin_should_see_batch_name_field_is_disabled(String string) {
		Assert.assertTrue(testclasspage.isSuccessMessageDisplayed());

	}
//	@Given("Admin is on the Edit Class Popup window")
//	public void admin_is_on_the_edit_class_popup_window() {
//		testclasspage.btnClass();
//		testclasspage.getClickOnFirstEditIcon();
//	}

	@When("Update the fields with invalid values and click save")
	public void update_the_fields_with_invalid_values_and_click_save() {		
		testclasspage.updateInvaliddataEditopopup();
		testclasspage.clickonSaveBtn();
	}

	@Then("Admin should get Error message")
	public void admin_should_get_error_message() {
		Assert.assertTrue(testclasspage.areErrorMessagesDisplayed(), "Error messages are not displayed for invalid input while updating Class Details."); 
	    
	}
	@When("Admin enters only numbers or special char in the text fields")
	public void admin_enters_only_numbers_or_special_char_in_the_text_fields() {
		testclasspage.updateInvaliddataEditopopup();
		testclasspage.clickonSaveBtn();
	}
	
	@When("Admin clicks Cancel button on edit popup")
	public void admin_clicks_cancel_button_on_edit_popup() {
		testclasspage.classEditCloseIcon();
	}

	@Then("Admin can see the class details popup disappears and can see nothing changed for particular Class")
	public void admin_can_see_the_class_details_popup_disappears_and_can_see_nothing_changed_for_particular_class() {
		String actualTitle = testclasspage.getManageClassTitle();
		String expectedTitle = "LMS - Learning Management System";
	    Assert.assertEquals( expectedTitle, actualTitle);
	}


	@When("Update the mandatory fields with valid values and click save on Class page")
	public void update_the_mandatory_fields_with_valid_values_and_click_save_on_class_page() {
	    
	}

	@Then("Admin gets message {string} and see the updated values in data table")
	public void admin_gets_message_and_see_the_updated_values_in_data_table(String string) {
	   
	}
	
///	-------------sorting--------
	@Given("Admin is on the Manage Class Page to verify sorting")
	public void admin_is_on_the_manage_class_page_to_verify_sorting() throws InterruptedException {
		  
		testclasspage.clickonClassPageLinkDb();		  
		testclasspage.clickonClassPageLinkClassPG();
	}

	@When("Admin clicks on the columnname {string}")
	public void admin_clicks_on_the_columnname(String columnname) throws InterruptedException {
		 
	}

	@Then("Admin should see the column sorted by columnname {string}")
	public void admin_should_see_the_column_sorted_by_columnname(String string) {
	
	}
	
//---------------pagination---------------
//	@Given("Admin is on Manage class page of Class Page")
//	public void admin_is_on_manage_class_page_of_class_page() {
//		testclasspage.btnClass();		  
//		testclasspage.btnClass();
//	}

//	@When("Admin clicks Last page link")
//	public void admin_clicks_last_page_link() {
//		testclasspage.clickondoubleNext();
//	}
//
//	@Then("Admin should see the next page record on the table  with Pagination has next active link enabled")
//	public void admin_should_see_the_next_page_record_on_the_table_with_pagination_has_next_active_link_enabled() {
//	    
//	}
//
//	@When("Admin clicks Next page link on the class table")
//	public void admin_clicks_next_page_link_on_the_class_table() {
//		testclasspage.clickNextLink();
//	}
//
//	@Given("Admin is on last page of class table  of Class Page")
//	public void admin_is_on_last_page_of_class_table_of_class_page() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}

//	@When("Admin clicks First page link")
//	public void admin_clicks_first_page_link() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
//	@Then("Admin should see the previous page record on the table with pagination has previous page link enabled")
//	public void admin_should_see_the_previous_page_record_on_the_table_with_pagination_has_previous_page_link_enabled() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
//	@Given("Admin is on Previous class page  of Class Page")
//	public void admin_is_on_previous_class_page_of_class_page() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
//	@When("Admin clicks Start page link")
//	public void admin_clicks_start_page_link() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//







	
}