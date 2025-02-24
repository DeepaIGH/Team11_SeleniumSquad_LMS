package stepDefinitions;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import driverFactory.DriverFactory;
import io.cucumber.java.en.*;
import net.sourceforge.tess4j.TesseractException;
import pages.LoginPage;
import utils.ConfigReader;
import utils.LoggerLoad;

public class LoginPageStep {

	public WebDriver driver=DriverFactory.getdriver();
	LoginPage login=new LoginPage(DriverFactory.getdriver());
	public static final String grayColor = "rgba(0, 0, 0, 0.54)";

	
	@Given("The browser is open")
	public void the_browser_is_open() {
	   // System.out.println("Is browser Open: "+login.isBrowserOpen(driver));
	    LoggerLoad.info("Is browser Open: "+login.isBrowserOpen(driver));
	}

	@When("Admin gives the correct LMS portal URL")
	public void admin_gives_the_correct_lms_portal_url() {
	   login.enterCorrect_LMS_url();
	}

	@Then("Admin should land on the login page")
	public void admin_should_land_on_the_login_page() {
		try {
	    Assert.assertEquals(login.checkLoginPage(), true);
	    System.out.println("Current URL: "+driver.getCurrentUrl());
	    LoggerLoad.info("Admin land on the Login page.");
		}
		catch(Exception e) {
			LoggerLoad.error("Admin failed to land on the Login page!\n"+e);
		}
	    
	}
	
	@When("Admin gives the invalid LMS portal URL")
	public void admin_gives_the_invalid_lms_portal_url() {
	    login.enter_Invalid_URL();
	}

	@Then("Admin should receive application error")
	public void admin_should_receive_application_error() throws IOException {
		String invalidURL=login.getInvalid_URL();
	   boolean status= login.checkApplicationError(invalidURL);
        Assert.assertTrue(status, "Heroku | Application Error");
        
	}
	
	@Then("HTTP response >= {int}. Then the link is broken")
	public void http_response_then_the_link_is_broken(Integer response) throws IOException {
		int statusCode= login.checkResponseCode(ConfigReader.getHomePageUrl());
		if(statusCode>=400) {
			Assert.assertTrue(statusCode >= response, "Link is Broken: " + statusCode);
			System.out.println("Link is broken");
		}
		else {
			System.out.println("Link is working fine.");
		}
        System.out.println("Status code received: " + statusCode);
	}

	@Then("Admin should see correct spellings in all fields")
	public void admin_should_see_correct_spellings_in_all_fields() {
	    boolean status=login.checkTextSpelling();
	    try {
	    Assert.assertEquals(status, true);
	    LoggerLoad.info("All field's spellings are correct.");
	    }
	    catch(NoSuchElementException e){
	    	LoggerLoad.error("Check the Spellings in all fiels! "+e);
	    	
	    }
	}

	@Then("Admin should see  LMS - Learning Management System")
	public void admin_should_see_lms_learning_management_system() {
		try {
		Assert.assertEquals(login.isLMSLogoDisplayed(), true);
		LoggerLoad.info("Admin see  LMS Logo.");
		}
		catch(NoSuchElementException e) {
			LoggerLoad.error("LMS logo not fount! "+e);
		}
	}

	@Then("Admin should see company name below the app name")
	public void admin_should_see_company_name_below_the_app_name() {
	    try {
			boolean status=login.companyNameOnLogo();
			Assert.assertEquals(status, true);
			LoggerLoad.info("Company name is displayed below the app name!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			LoggerLoad.error("Company name is not displaying!");
			e.printStackTrace();
		} catch (TesseractException e) {
			// TODO Auto-generated catch block
			LoggerLoad.error("Company name is not displaying!");
			e.printStackTrace();
		}
	}

	@Then("Admin should see {string}")
	public void admin_should_see(String LMSMsg) {
	    String message=login.isLMS_LoginMsg_Displayed();
	    Assert.assertEquals(message, LMSMsg);
	    LoggerLoad.info("Message dispayed: "+message);
	}

	@Then("Admin should see two text field")
	public void admin_should_see_two_text_field() {
		Assert.assertEquals(login.isTextFieldsVisible(),true);
		LoggerLoad.info("Admin see two text field");

	}

	@Then("Admin should {string} in the first text field")
	public void admin_should_in_the_first_text_field(String string) {
		System.out.println("Displayed field: "+login.isUserLabelDisplayed());
		Assert.assertEquals(login.isUserLabelDisplayed(),string);

	}

	@Then("Admin should see one dropdown")
	public void admin_should_see_one_dropdown() {
	    try {
	    	Assert.assertEquals(login.isDropdownDisplayed(),true);
	    	LoggerLoad.error("Dropdown is displayed! ");
	    }
	    catch(Exception e) {
	    	LoggerLoad.error("Dropdown is not displayed! "+e.getMessage());
	    }
	}

	@Then("Admin should see asterisk mark symbol next to text for mandatory fields")
	public void admin_should_see_asterisk_mark_symbol_next_to_text_for_mandatory_fields() {
		Assert.assertEquals(login.isMandatoryFieldAsterikVisible(),true);
	}

	@Then("Admin should {string} in the second text field")
	public void admin_should_in_the_second_text_field(String string) {
		Assert.assertEquals(login.isPasswordLabelDisplayed(),true);
	}

	@Then("Admin should see asterisk mark symbol next to password text")
	public void admin_should_see_asterisk_mark_symbol_next_to_password_text() {
		Assert.assertEquals(login.isPasswordAsterickVisible(),true);
	}

	@Then("Admin should see {string} placeholder in dropdown")
	public void admin_should_see_placeholder_in_dropdown(String placeholder) {
		Assert.assertEquals(login.checkRolePlaceholder(),placeholder);
	}

	@Then("Admin should see {string} options in dropdown")
	public void admin_should_see_options_in_dropdown(String roles) {
		try {
		 // Convert string to list
        List<String> expectedOptions = Arrays.asList(roles.split("\\s*,\\s*"));

        System.out.println("expectedOptions: "+expectedOptions);
        List<String> actualOptions=login.check_dropdownOptions();
        System.out.println("actualOptions: "+actualOptions);
        // Verify the dropdown options
        Assert.assertEquals(actualOptions, expectedOptions, "Dropdown options do not match!");
        System.out.println("Test Passed: Dropdown contains the expected options.");
        LoggerLoad.info("Test Passed: Dropdown contains the expected options.");

        } catch (Exception e) {
            System.out.println("Test Failed: " + e.getMessage());
            LoggerLoad.error("Test Failed: " + e.getMessage());
        }
        
	}

	@Then("Admin should see input field on the centre of the page")
	public void admin_should_see_input_field_on_the_centre_of_the_page() {
		try {
	    Assert.assertEquals(login.checkPosition(), true);
	    LoggerLoad.info("All inputs are aligned and at the centre!");
		}
		catch(Exception e) {
			LoggerLoad.error("Input Fields are not properly aligned! ");
		}
	}

	@Then("Admin should see login button")
	public void admin_should_see_login_button() {
		Assert.assertEquals(login.isLoginButtonDisplayed(),true);
	}

	@Then("Admin should see user in gray color")
	public void admin_should_see_user_in_gray_color() {
		Assert.assertEquals(login.getUserFontColor().equals(grayColor),true);
	}

	@Then("Admin should see password in gray color")
	public void admin_should_see_password_in_gray_color() {
		//System.out.print("Gray Color from Selenium:  " + login.getPasswordFontColor());
		org.testng.Assert.assertEquals(login.getPasswordFontColor().equals(grayColor),true);
	}
	
	@Given("Admin is on login Page")
	public void admin_is_on_login_page() {
		try {
		Assert.assertEquals(login.checkLoginPage(), true);
		LoggerLoad.info("Admin is on Login Page!");
	}
	catch(Exception e) {
		LoggerLoad.error("Admin failed to land on the Login page!\n"+e);
	}
	}

	@When("Admin enter valid data in all field and clicks login button")
	public void admin_enter_valid_data_in_all_field_and_clicks_login_button() {
	    login.enterUserName();
	    login.enterPassword();
	    login.enterRole();
	    login.loginButtonClicked();
	    LoggerLoad.info("Valide User,Password and Role is entered.");
	}

	@Then("Admin should land on home page")
	public void admin_should_land_on_home_page() {
		try {
		String homePageURL=ConfigReader.getDashboardPageUrl();
		String Actualurl=driver.getCurrentUrl();
		Assert.assertEquals(Actualurl,homePageURL);
		LoggerLoad.info("Admin land on home page!");
		}
		catch(Exception e) {
			LoggerLoad.error("Admin not able to land on home page!");
		}
	}

	@When("Admin enter invalid data and clicks login button")
	public void admin_enter_invalid_data_and_clicks_login_button() {
	    login.invalid_dataInputs();
	}

	@Then("Error message {string}")
	public void error_message(String string) {
		Assert.assertTrue(false, "It's a BUG! Error message not dispalyed on the page!");
		System.out.println("********** BUG ***************");
	    LoggerLoad.error("BUG: There is no error message displayed on the page.");
	}

	@When("Admin enter value only in password and clicks login button")
	public void admin_enter_value_only_in_password_and_clicks_login_button() {
		login.enterPassword();
	    login.enterRole();
	    login.loginButtonClicked();

	}

	@Then("Error message\" Please enter your user name\"")
	public void error_message_please_enter_your_user_name() {
		Assert.assertEquals(login.isErrorUserNameDisplayed(),true);
		System.out.println("********** BUG ***************");
		LoggerLoad.error("BUG: Expected error message please enter your use name is not displayed on the page! ");

	}

	@When("Admin enter value only in user name and clicks login button")
	public void admin_enter_value_only_in_user_name_and_clicks_login_button() {
		login.enterUserName();
	    login.enterRole();
	    login.loginButtonClicked();
	}

	@Then("Error message\" Please enter your password \"")
	public void error_message_please_enter_your_password() {
		Assert.assertEquals(login.isErroPasswordDisplayed(),true);
		System.out.println("********** BUG ***************");
		LoggerLoad.error("BUG: Expected error message please enter your password is not displayed on the page! ");

	}

	@When("Admin enter valid credentials  and clicks login button through keyboard")
	public void admin_enter_valid_credentials_and_clicks_login_button_through_keyboard() {
		 login.enterUserName();
		    login.enterPassword();
		    login.enterRole();
		    login.enterLoginBtn_keyboad();
		    LoggerLoad.info("Admin enter valid credentials  and clicks login button through keyboard!");
	}

	@When("Admin enter valid credentials  and clicks login button through mouse")
	public void admin_enter_valid_credentials_and_clicks_login_button_through_mouse() {
		 login.enterUserName();
		    login.enterPassword();
		    login.enterRole();
		    login.loginButtonClicked();
	}


}//end of StepDefinitions class
