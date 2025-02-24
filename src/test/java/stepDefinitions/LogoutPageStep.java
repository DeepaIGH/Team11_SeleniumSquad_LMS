package stepDefinitions;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import driverFactory.DriverFactory;
import io.cucumber.java.en.*;
import pages.HomePage;
import pages.LogoutPage;
import utils.ConfigReader;
import utils.LoggerLoad;

public class LogoutPageStep {
	WebDriver driver = DriverFactory.getdriver();
	LogoutPage logout=new LogoutPage(DriverFactory.getdriver());
	
	@Given("Admin is logged into the application")
	public void admin_is_logged_into_the_application() {
		try {
			Assert.assertEquals(logout.checkLogin(), true);
			LoggerLoad.info("Admin is logged into the application!");
		}
		catch(Exception e) {
			LoggerLoad.error("Admin failed to logging into the application!\n"+e);
		}
	}

	@Given("Admin is in home page")
	public void admin_is_in_home_page() {
		try {
		    Assert.assertTrue(logout.checkHomePage(),"Admin is in Home page!");
		    LoggerLoad.info("LMS -Learning management system title is displayed! Admin lands on the home page.");
			}
			catch(NoSuchElementException e) {
				LoggerLoad.error("Admin is not able to see the home page.");
			}
	}

	@When("Admin clicks on the logout in the menu bar")
	public void admin_clicks_on_the_logout_in_the_menu_bar() {
		try {
	    logout.clickLogoutBtn();
	    LoggerLoad.info("Admin clicks on the logout in the menu bar.");
		}
		catch(NoSuchElementException e) {
			LoggerLoad.error("Admin is not able to click logout in the menu bar.");
		}
	}

	@Then("Admin should be redirected to login page")
	public void admin_should_be_redirected_to_login_page() {
		try {
			Assert.assertEquals(logout.checkLoginPage(), true);
			LoggerLoad.info("Admin is on Login Page!");
		}
		catch(Exception e) {
			LoggerLoad.error("Admin failed to land on the Login page!\n"+e);
		}
	}

	@Given("Admin is in login page")
	public void admin_is_in_login_page() {
		try {
			logout.clickLogoutBtn();
			Assert.assertEquals(logout.checkLoginPage(), true);
			LoggerLoad.info("Admin is on Login Page!");
		}
		catch(Exception e) {
			LoggerLoad.error("Admin failed to land on the Login page!\n"+e);
		}
	}

	@When("Admin clicks  browser back button")
	public void admin_clicks_browser_back_button() {
	    logout.getBackButton();
	}

	@Then("Admin should receive error message")
	public void admin_should_receive_error_message() {
		Assert.assertTrue(false);
		LoggerLoad.error("No error message displayed on the page!");
	}

}
